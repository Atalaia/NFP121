package state;

import java.util.*;
import container.*;

public class StateTests extends junit.framework.TestCase{

   public void testAvecInjection() throws Exception{
     ApplicationContext ctx = Factory.createApplicationContext("./state/README.TXT");
     Lampe led = ctx.getBean("led");
     
     assertTrue(led.getEtat() instanceof EtatEteint);
     led.clignoter(); // aucun effet,
     assertTrue(led.getEtat() instanceof EtatEteint);
     led.allumer();
     assertTrue(led.getEtat() instanceof EtatAllume);
     led.clignoter();
     assertTrue(led.getEtat() instanceof EtatClignotant);
     led.clignoter();
     assertTrue(led.getEtat() instanceof EtatAllume);
     
   }
   
   
   public void testSansInjection() throws Exception{
     Lampe led = new Lampe();
     // EtatEteint eteinte = new EtatEteint();
     // eteinte.setLampe(led);
     // EtatAllume allume = new EtatAllume();
     // allume.setLampe(led);
     // EtatClignotant clignotant = new EtatClignotant();
     // clignotant.setLampe(led);
     // lampe.setEtat(eteinte);
     
     assertTrue(led.getEtat() instanceof EtatEteint);
     led.clignoter(); // aucun effet,
     assertTrue(led.getEtat() instanceof EtatEteint);
     led.allumer();
     assertTrue(led.getEtat() instanceof EtatAllume);
     led.clignoter();
     assertTrue(led.getEtat() instanceof EtatClignotant);
     led.clignoter();
     assertTrue(led.getEtat() instanceof EtatAllume);
     
     
   }

 
}

