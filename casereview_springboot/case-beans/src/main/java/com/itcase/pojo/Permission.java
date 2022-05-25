package com.itcase.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Permission {
    private Integer id;
    private String name; // 权限名称
    private String keyword; // 权限关键字，用于权限控制
    private String description; // 描述
    //一个权限对应多个角色 ToDO: = new HashSet<>();
    private Set<Role> roles;
}
