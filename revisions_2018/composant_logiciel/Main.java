package composant_logiciel;

import container.*;
import java.util.concurrent.*;

public class Main{
  public static void main(String[] args) throws Exception{
      ApplicationContext ctx = Factory.createApplicationContext("./composant_logiciel/README.TXT");
      
      Nombre nombre = ctx.getBean("nombre1");
      Composant<Nombre> composant1 = ctx.getBean("composant1");
      System.out.println("envoi du nombre: " + nombre.getValeur());
      composant1.getIn().offer(nombre);
      Nombre nombre1 = composant1.getOut().take();
      System.out.println("réception du nombre: " + nombre1.getValeur());
      
      Composants<Nombre> composants = ctx.getBean("trois_composants");
      System.out.println("envoi du nombre: " + nombre1.getValeur());
      composants.getIn().offer(nombre1);
      
      Nombre nombreRecu = composants.getOut().take();
      System.out.println("réception du nombre: " + nombreRecu.getValeur());
      
      composants.stop();
      composant1.stop();
 
    }
}