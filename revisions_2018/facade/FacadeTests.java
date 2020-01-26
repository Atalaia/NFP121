package facade;



import java.util.*;
import container.*;

public class FacadeTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./facade/README.TXT");

        FacadeI facade = ctx.getBean("facade1");
        assertEquals(5,facade.methode1() + facade.methode2());
        
        Client1 client1 = ctx.getBean("client1");
        assertEquals(5,client1.resultat());
    }
}

