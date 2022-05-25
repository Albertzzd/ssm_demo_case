package com.itcase.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect//切面
@Component //交由spring管理
public class TimeConsumeAdvice {


    @Pointcut("execution(* com.itcase.impl.*.query*(..))")
    public void pt(){}

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object o = pjp.proceed();
        long endTime = System.currentTimeMillis();
        String methodName = pjp.getSignature().getName();
        System.out.println(methodName+"执行了"+(endTime-startTime)+"毫秒");
        return o;
    }
}
