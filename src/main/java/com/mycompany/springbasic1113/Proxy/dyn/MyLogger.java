package com.mycompany.springbasic1113.Proxy.dyn;

import java.util.Arrays;

public class MyLogger {
   
    public static void before(Class cls, String methodName, Object[] args){
        System.out.printf("Before: %s: %s - args[] %s", cls, methodName, Arrays.toString(args));
    }
    
    public static void after(Class cls, String methodname, Object result){
        System.out.printf("After: %s: %s - result: %s", cls, methodname, result);
    }
}
