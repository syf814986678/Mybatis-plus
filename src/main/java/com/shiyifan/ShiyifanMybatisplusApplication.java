package com.shiyifan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper文件夹
@MapperScan("com.shiyifan.mapper")
public class ShiyifanMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyifanMybatisplusApplication.class, args);
    }

}
