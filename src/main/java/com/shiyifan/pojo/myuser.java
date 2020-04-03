package com.shiyifan.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class myuser {
    @TableId(type = IdType.ID_WORKER)//默认全局唯一ID
    //IdType.AUTO自增需要数据库设置id为identity

    private Long id;//对应数据库中的主键(uuid,自增id,雪花算法,redis,zookeeper)
    private String name;
    private Integer age;
    private String email;
    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version//乐观锁
    private Integer version;
    @TableLogic//逻辑删除
    private Integer deleted;
}
