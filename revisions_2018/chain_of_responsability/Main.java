package chain_of_responsability;

import container.*;

public class Main{
  public static void main(String[] args){
      ApplicationContext ctx = Factory.createApplicationContext("./chain_of_responsability/README.TXT");
      
      Nombre nombre = ctx.getBean("nombre1");
      System.out.println("envoi du nombre: " + nombre.getValeur());
      
      Invoker<Nombre> invoker = ctx.getBean("invoker");
      invoker.envoyer(nombre);
      System.out.println("nombre.getValeur(): " + nombre.getValeur());
    }
}