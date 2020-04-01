package com.shiyifan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class myuser {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
