package command;

import java.util.*;
import container.*;

public class CommandTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./command/README.TXT");
        Invoker invoker = ctx.getBean("invoker");

        invoker.on();
        invoker.off();     
        invoker.on();
        invoker.off(); 
        invoker.on();
        invoker.off();
        
        Projecteur projecteur = ctx.getBean("projecteurDeLAmphi");
        Command cmd = ctx.getBean("cmdProjecteur");
        cmd.execute();
        assertEquals("projecteur allumé",projecteur.getStatus());
    }
}

