package exemples;

import java.util.*;
import container.*;

public class ExemplesTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{

        ApplicationContext ctx = Factory.createApplicationContext("./exemples/README.TXT");
        A a = ctx.getBean("a");
        

    }

    public void testSansInjection(){
        I i = new B();
        A a = new A();
        a.setI(i);

    }
}

