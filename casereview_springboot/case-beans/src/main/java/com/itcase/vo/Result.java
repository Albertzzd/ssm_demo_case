package com.itcase.vo;

import lombok.Data;

//统一定义响应格式
@Data
public class Result {
    private Integer code; //定义响应码
    private String msg; //定义返回消息
    private Object data; //定义返回数据

    //构造器
    public Result(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result(Integer code,String msg,Object obj){
        this.code = code;
        this.msg = msg;
        this.data = obj;
    }
}
