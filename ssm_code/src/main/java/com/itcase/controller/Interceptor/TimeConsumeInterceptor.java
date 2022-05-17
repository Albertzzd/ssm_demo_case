package com.itcase.controller.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    //定义拦截器类，实现HandlerInterceptor接口
    @Component  //当前类必须受Spring容器控制
public class TimeConsumeInterceptor implements HandlerInterceptor {
        long beginTime;//开始时间
        long endTime;//结束时间

        //原始方法调用前增强的功能
        /**
         * @param  request      请求对象
         * @param  response     响应对象
         * @param  handler      处理器方法的封装(方法对象)
         * @return              true:表示资源放行 、 false:资源禁止访问
         * @throws Exception
         */
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            System.out.println("preHandle... 开始计时");
            beginTime = System.currentTimeMillis();
            return true;//返回值类型可以拦截控制的执行。 true放行，false终止
        }

        //原始方法调用后执行增强的功能
        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            System.out.println("postHandle... 结束计时");
            endTime = System.currentTimeMillis();
            //强制转换为：HandlerMethod （反射中的Method对象再次包装）
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取controller方法的名字
            String methodName = handlerMethod.getMethod().getName();
            System.out.println(methodName+"方法执行，耗时：" + (endTime - beginTime) + "毫秒");
        }
}
