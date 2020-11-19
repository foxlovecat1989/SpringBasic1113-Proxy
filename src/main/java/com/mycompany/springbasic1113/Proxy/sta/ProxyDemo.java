package com.mycompany.springbasic1113.Proxy.sta;

interface Subject {
    void doRequest();
}

class RealSubject implements Subject{

    @Override
    public void doRequest() {
        System.out.println("Run BusinessCode..."); // 業務程式
    }
    
}
class Proxy implements Subject{
    private Subject s;

    public Proxy(Subject s) {
        this.s = s;
    }
    @Override
    public void doRequest() {
        System.out.println("Before...");    // 公用程式
        s.doRequest();                    // 調用指定的業務程式
        System.out.println("After...");     // 公用程式
    }

}
public class ProxyDemo {
    public static void main(String[] args) {
        Subject s = new RealSubject();
        s.doRequest();
        
    }
}
