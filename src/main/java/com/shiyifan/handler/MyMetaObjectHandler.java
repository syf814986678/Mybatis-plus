package com.shiyifan.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
//填充处理器
//填充处理器
//填充处理器
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //插入填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.warn("start insert fill");
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
       // this.setFieldValByName("createTime", new Date(), metaObject);

    }
    //更新填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.warn("start update fill");
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
