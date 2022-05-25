package com.itcase.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Role {
    private Integer id;
    private String name;
    private String keyword;
    private String description;

    //一个角色对应多个权限 TODO：为什么使用Set 是否添加= new HashSet<>();
    private Set<Permission> permissions;
}
