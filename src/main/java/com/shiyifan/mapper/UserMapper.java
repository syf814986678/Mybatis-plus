package com.shiyifan.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiyifan.pojo.myuser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//在使用Mybatis-Plus后 只需要继承基本接口BaseMapper


@Repository//代表持久层
public interface UserMapper extends BaseMapper<myuser> { //myuser为数据库中表的名字，并支持驼峰转换
    //所有CRUD操作编写完成
    //不需要像以前的Mybatis一样配置一大堆文件
    @Select("select * from myuser where deleted=1")
    List<myuser>selectalldeleted();
    //让逻辑删除中能够更新修改时间
    int deleteByIdWithFill(myuser entity);

}
