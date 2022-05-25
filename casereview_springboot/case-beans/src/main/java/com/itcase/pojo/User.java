package com.itcase.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private String createTime;
    private String updateTime;
    private String remark;

    //一个用户对应多个角色 TODO 是否添加 = new ArrayList<>();
    private List<Role> roleList;

}
