package com.itcase.controller;

//状态码
public class Code {
    public static final Integer SAVE_OK = 20011; //保存成功
    public static final Integer DELETE_OK = 20021;//删除成功
    public static final Integer UPDATE_OK = 20031;//修改成功
    public static final Integer GET_OK = 20041;//查询成功

    public static final Integer SAVE_ERR = 50010;//保存失败
    public static final Integer DELETE_ERR = 50020;//删除失败
    public static final Integer UPDATE_ERR = 50030;//修改失败
    public static final Integer GET_ERR = 50040;//查询失败


    public static final Integer SYSTEM_ERR = 50001;//系统异常
    public static final Integer SYSTEM_TIMEOUT_ERR = 50002;//系统访问超时
    public static final Integer SYSTEM_UNKNOW_ERR = 59999;//服务器异常

    public static final Integer BUSINESS_ERR = 60001; //业务异常
}
