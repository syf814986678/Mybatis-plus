package com.shiyifan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiyifan.pojo.myuser;
import org.springframework.stereotype.Repository;

//在使用Mybatis-Plus后 只需要继承基本接口BaseMapper


@Repository//代表持久层
public interface UserMapper extends BaseMapper<myuser> { //myuser为数据库中表的名字，并支持驼峰转换
    //所有CRUD操作编写完成
    //不需要像以前的Mybatis一样配置一大堆文件

}
