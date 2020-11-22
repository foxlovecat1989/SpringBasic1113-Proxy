package com.mycompany.springbasic1113.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order
public class LogAspect {
    
    @Pointcut(value = "execution(* com.mycompany.springbasic1113.aop.*.* (..) )")
    public void cut(){
    }
    // 前置通知(Advice)
    // @Before(value = "execution(public int com.mycompany.springbasic1113.aop.CalcImpl.add(int, int))") // 切入點表達式
    // @Before(value = "execution(public int com.mycompany.springbasic1113.aop.CalcImpl.*(int, int))")
    // @Before(value = "execution(public int com.mycompany.springbasic1113.aop.*.*(int, int))")
    //@Before(value = "execution(* *.*(..))")
    @Before(value = "cut()") // 切入點參照
    public void before(){
        System.out.println("before...");
    }
}
