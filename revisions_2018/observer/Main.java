package observer;
import container.*;

import commands.Invoker;

public class Main{
  public static void main(String[] args){
      ApplicationContext ctx = Factory.createApplicationContext("./observer/README.TXT");
      
      Nombre nombre = ctx.getBean("nombre1");
      Resultat resultat = new Resultat();
      Invoker<Nombre,Resultat> invoker = ctx.getBean("invoker");
      invoker.execute(nombre,resultat);
      System.out.println("resultat.getValeur(): " + resultat.getValeur());
    }
}
