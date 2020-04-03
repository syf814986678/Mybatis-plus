package com.shiyifan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiyifan.mapper.UserMapper;
import com.shiyifan.pojo.myuser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;
    //查询name不为空的，并且邮箱不为空，年龄大于等于12的用户
    @Test
    void contextLoads() {

        QueryWrapper<myuser> Wrapper = new QueryWrapper<>();
        Wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);//ge大于，le小于
        List<myuser> myusers = userMapper.selectList(Wrapper);
        for (myuser myuser : myusers) {
            System.out.println(myuser);
        }
    }
    //查询version为1
    @Test
    void test(){
        QueryWrapper<myuser> wrapper = new QueryWrapper<>();
        wrapper.eq("version", "1");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("name"));
        }
//        myuser myuser = userMapper.selectOne(wrapper);
//        System.out.println(myuser);
    }
    //查询年龄在20-30之间的数量
    @Test
    void test2(){
        QueryWrapper<myuser> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30);
        Integer integer = userMapper.selectCount(wrapper);
        System.out.println(integer);
    }
    //模糊查询名字包含o/不包含o
    @Test
    void test3(){
        QueryWrapper<myuser> wrapper = new QueryWrapper<>();
        wrapper.like("name", "o");
//        wrapper.notLike("name", "o");
        //likeRight\likeLeft
        //o%       \%o
        List<myuser> myusers = userMapper.selectList(wrapper);
        for (myuser myuser : myusers) {
            System.out.println(myuser);
        }
    }
    //连接查询
    @Test
    void test4(){
        QueryWrapper<myuser> wrapper = new QueryWrapper<>();
        //id在子查询中查询
        wrapper.inSql("id", "select id from myuser where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        for (Object object : objects) {
            System.out.println(object);

        }

    }



    @Test
    public void selectalldeleted(){
        List<myuser> selectalldeleted = userMapper.selectalldeleted();
        for (myuser myuser : selectalldeleted) {
            System.out.println(myuser);
        }
    }
}
