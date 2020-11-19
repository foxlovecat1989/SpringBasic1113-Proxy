
package com.mycompany.springbasic1113.Proxy.dyn;

public class CalcImpl implements Calc {
    Calc calc;

    public CalcImpl(Calc calc) {
        this.calc = calc;
    }
    
    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public int sub(int x, int y) {
        return x - y;
    }
    
}
