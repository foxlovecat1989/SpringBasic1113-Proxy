package com.mycompany.springbasic1113.Proxy.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

public class DynProxy {
    Object object;

    public DynProxy(Object object) {
        this.object = object;
    }
    
    public Object getProxy(){
        
        // 獲取當前類別的類加載器, 用來加載代理物件所屬的類別
        ClassLoader classLoader = object.getClass().getClassLoader();
        
        // 獲取當前物件所實作的介面
        Class[] interfaces = object.getClass().getInterfaces();
        
        // 處理者 （Handler）
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                
                // 公用程式
                MyLogger.before(object.getClass(), method.getName(), args);
                
                // 代理調用目標物件的方法
                Object result = method.invoke(object, args);
                
                // 公用程式
                MyLogger.after(object.getClass(), method.getName(), result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
