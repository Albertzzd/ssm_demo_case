package com.itcase.controller;

import com.itcase.Exception.BusinessException;
import com.itcase.Exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {


    //专门处理业务功能导致的异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        //发送对应消息传递给用户，提醒规范操作
        return new Result(ex.getCode(),ex.getMessage());
    }

    //专门处理系统异常
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //发送固定消息传递给用户，安抚用户
        //发送特定消息给运维人员，提醒维护
        //记录日志
        return new Result(ex.getCode(),ex.getMessage());
    }

    //处理其他未知异常
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex){
        //发送固定消息传递给用户，安抚用户
        //发送特定消息给编程人员，提醒维护
        //记录日志
        return new Result(Code.SYSTEM_UNKNOW_ERR,"服务器正在维护,请稍后访问");
    }
}
