package observer;

import java.util.*;
import container.*;
import commands.*;

public class ObserverCommandTests extends junit.framework.TestCase{

    public void testUnNombreAvecDeuxObservateurs() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = (Nombre) ctx.getBean("nombre1");
        assertEquals(1,nombre.getValeur());

        nombre.setValeur(33);
        NombreObserver obs = ctx.getBean("observateur1");
        assertEquals(nombre, obs.getSource());

        obs = ctx.getBean("observateur2");
        assertEquals(nombre, obs.getSource());
    }

    public void testUnNombreAvecUneCommandePlus() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre =  ctx.getBean("nombre1");
        assertEquals(1,nombre.getValeur());
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());

        // si la valeur du nombre est Paire alors +1
        CommandNombre cmd = ctx.getBean("commandePlus1");
        assertTrue(nombre.getValeur()%2!=0);
        cmd.execute(nombre,resultat);
        assertEquals(1,resultat.getValeur());
        nombre.setValeur(2);
        cmd.execute(nombre,resultat);
        assertEquals(2,resultat.getValeur());

    }

    public void testUnNombreAvecUneMacroCommande() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = (Nombre) ctx.getBean("nombre1");
        assertEquals(1,nombre.getValeur());
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());

        // 
        Command<Nombre,Resultat> cmd = (Command<Nombre,Resultat>)ctx.getBean("macroPlus");
        cmd.execute(nombre,resultat);// 5*Plus1
        assertEquals(6,resultat.getValeur());
        assertEquals(1,nombre.getValeur());

    }

    public void testUnNombreAvecInvoker() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = (Nombre) ctx.getBean("nombre1");
        assertEquals(1,nombre.getValeur());
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());
     
        Invoker invoker = (Invoker)ctx.getBean("invoker");
        invoker.execute(nombre,resultat);
        assertEquals(10,resultat.getValeur());
 

    }
    
    public void testUnNombreAvecInvokerAuResultatAletatoire() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = (Nombre) ctx.getBean("nombre1");
        assertEquals(1,nombre.getValeur());
        Resultat resultat = new Resultat();
        resultat.setValeur(nombre.getValeur());
     
        Invoker invoker = (Invoker)ctx.getBean("invokerPeutEtre");
        invoker.execute(nombre,resultat);
        System.out.println("resultat: " + resultat.getValeur());
        resultat.setValeur(nombre.getValeur());
        invoker.execute(nombre,resultat);
        System.out.println("resultat: " + resultat.getValeur());
        resultat.setValeur(nombre.getValeur());
        invoker.execute(nombre,resultat);
        System.out.println("resultat: " + resultat.getValeur());
        resultat.setValeur(nombre.getValeur());
        invoker.execute(nombre,resultat);
        System.out.println("resultat: " + resultat.getValeur());
 

    }

    public void testUnNombreAvecInvokerEtUneException() throws Exception {

        ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
        Nombre nombre = (Nombre) ctx.getBean("nombre1000");

        assertEquals(1000,nombre.getValeur()); // doit(devrait) 
                                               // engendrer une exception ...
        Resultat resultat = new Resultat();
        resultat.setValeur(1);

        Invoker invoker = (Invoker)ctx.getBean("invoker");

        try{
            invoker.execute(nombre,resultat);
            fail("une exception devrait être levée ...");
        }catch(RuntimeException exc){
        }
        // une exception a eu lieu alors le résultat doit être négatif
        assertTrue(resultat.getValeur() <0);

    }

  
}

