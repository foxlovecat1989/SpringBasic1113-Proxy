package com.mycompany.springbasic1113.aop;

import java.util.Arrays;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
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
    public void before(JoinPoint joinpoint){
         
        // 獲取方法名稱
        String methodName = joinpoint.getSignature().getName();
        
        // 獲取方法參數
        Object[] args = joinpoint.getArgs();
        
        System.out.printf("before -> Method: %s, Args: %s\n", methodName, Arrays.toString(args));
    }
    
    // 後置通知(Advice)
    // 無論是否有例外發生都會被執行, 因後置通知作用在 finally 中...
    @After(value = "cut()")
    public void after(){
        System.out.println("After...");
    }
    
    // 返回通知(Advice)
    // 獲取返回值
    @AfterReturning(value = "cut()", returning = "result")
    public void afterReturning(Object result){
        System.out.printf("AfterReturning -> result = %s\n", result);
    }
}
