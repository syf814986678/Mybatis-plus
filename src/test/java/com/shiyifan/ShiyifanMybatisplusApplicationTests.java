package com.shiyifan;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyifan.mapper.UserMapper;
import com.shiyifan.pojo.myuser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ShiyifanMybatisplusApplicationTests {
    //继承了baseMapper的父类的所有方法
    //但是我们也可以自己写扩展方法
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        //查询全部用户
        //参数是一个wrapper条件构造器，这里我们先不用
        List<myuser> users = userMapper.selectList(null);
        for (myuser user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void insert(){
        //帮我们自动生成ID
        int insert = userMapper.insert(new myuser(null, "施一帆", 3, "123@qq.com",null,null,null,null));
        //受影响的行数insert
        System.out.println(insert);
}
    @Test
    public void update(){
        myuser myuser = new myuser();
        myuser.setId(3L);
        myuser.setEmail("1234567689@vip.com");
        int i = userMapper.updateById(myuser);
        System.out.println(i);

    }
    @Test
    public void optimisticLocker(){
        myuser myuser1 = userMapper.selectById(1L);
        myuser1.setName("syf1");
        myuser1.setAge(20);

        myuser myuser2 = userMapper.selectById(1L);
        myuser2.setName("syf2");
        myuser2.setAge(30);

        userMapper.updateById(myuser2);
        userMapper.updateById(myuser1);
        //由于乐观锁，更新myuser1没有生效
        //使用自旋锁尝试多次提交
    }
    //测试批量查询
    @Test
    public void selectbybatchid(){
        List<myuser> myusers = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        for (myuser myuser : myusers) {
            System.out.println(myuser);
        }
    }
    //条件查询 map
    @Test
    public void selectbymap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "施一帆");
        map.put("email", "2@vip.com");
        List<myuser> myusers = userMapper.selectByMap(map);
        for (myuser myuser : myusers) {
            System.out.println(myuser);

        }
    }
    //分页插件
    @Test
    public void testpage(){
        //参数1：当前页
        //参数2：页面大小
        Page<myuser> page = new Page<>(2,2);
        userMapper.selectPage(page,null);
        for (myuser record : page.getRecords()) {
            System.out.println(record);
        }
        System.out.println(page.getTotal());

    }
    //测试删除
    @Test
    public void deletebyid(){
        userMapper.deleteById(1L);

    }
    //测试批量删除
    @Test
    public void deletebybatchid(){
        userMapper.deleteBatchIds(Arrays.asList(1245579841061974017L,1245600896400932865L));
    }
    //测试MAP删除
    @Test
    public void deletebymap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "施一帆");
        userMapper.deleteByMap(map);
    }
    //测试逻辑删除时更新修改时间
    @Test
    public void logicdeletebyupdatetime(){
        myuser myuser = new myuser();
        myuser.setId(1L);
        userMapper.deleteByIdWithFill(myuser);
    }
}
