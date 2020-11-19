package com.mycompany.springbasic1113.Proxy.dyn;

public class DynProxyDemo {
    public static void main(String[] args) {
        DynProxy dynProxy = new DynProxy(new CalcImpl());
       Object object = dynProxy.getProxy();
       if(object instanceof Calc){
           Calc calc = (Calc)object;
           int result1 = calc.add(2, 3);
           System.out.println(result1);
           int result2 = calc.sub(2, 3);
           System.out.println(result2);
       }
    }
}
