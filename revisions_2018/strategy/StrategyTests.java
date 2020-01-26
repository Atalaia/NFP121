package strategy;

import java.util.*;
import container.*;

public class StrategyTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{

     ApplicationContext ctx = Factory.createApplicationContext("./strategy/README.TXT");
     Context context = ctx.getBean("context1");
     assertEquals("10 + 5 != 15 ??? ",15,context.executeStrategy(10, 5));

     context = ctx.getBean("context2");
     assertEquals("10 - 5 != 5 ??? ",5,context.executeStrategy(10, 5));
 	
     context = ctx.getBean("context3");
     assertEquals("10 * 5 != 50 ??? ", 50, context.executeStrategy(10, 5));
   }

 
}

