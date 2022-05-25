package com.itcase.vo;

import lombok.Data;

import java.util.List;

@Data
public class AddUser {
    private Integer id; //添加用户到数据库之后，返回该用户的id
    private String username;//用户名称
    private String password;//密码
    private String email; //邮箱
    private String remark; //备注
    //此用户对应多个角色
    private List<String> roles;
}
