package com.shiyifan;

import com.shiyifan.mapper.UserMapper;
import com.shiyifan.pojo.myuser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
