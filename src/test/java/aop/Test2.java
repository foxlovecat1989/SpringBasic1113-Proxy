package aop;

import com.mycompany.springbasic1113.aop.Bmi;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void t1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
        Bmi bmi = ctx.getBean("bmiImpl", Bmi.class);
        System.out.println(bmi.calc(170.0, 60.0));
        ctx.close();
    }
    
}
