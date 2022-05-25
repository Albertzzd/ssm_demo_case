package com.itcase.Exception;

import com.itcase.exception.BusinessException;
import com.itcase.exception.SystemException;
import com.itcase.vo.Code;
import com.itcase.vo.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component//交由Spring管理
@RestControllerAdvice //将异常返回至前端+统一controller层来处理通知
public class ExceptionControllerHandler  {

    //处理业务异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        //发送对应信息给用户，提醒用户规范操作
        return new Result(ex.getCode(),ex.getMessage());

    }


    //处理系统异常

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //发送对应信息给用户，安抚用户
        //提醒运维人员维护
        //记录日志
        return new Result(ex.getCode(),ex.getMessage());

    }

    //处理其他异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //发送对应信息给用户，安抚用户
        //提醒运维人员维护
        //记录日志
        return new Result(Code.SYSTEM_UNKNOW_ERR,ex.getMessage());

    }
}
