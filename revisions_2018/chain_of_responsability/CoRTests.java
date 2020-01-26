package chain_of_responsability;

import java.util.*;
import container.*;

public class CoRTests extends junit.framework.TestCase{

    public void testAvecInjection() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./chain_of_responsability/README.TXT");
        Nombre nombre = ctx.getBean("nombre1");
        System.out.println("envoi du nombre: " + nombre.getValeur());

        Invoker<Nombre> invoker = ctx.getBean("invoker");
        invoker.envoyer(nombre);
        System.out.println("nombre.getValeur(): " + nombre.getValeur());
        assertEquals("nombre.getValeur() ??? ",17,nombre.getValeur());
    }
}

