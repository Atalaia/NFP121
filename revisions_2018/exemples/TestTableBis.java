package exemples;

import container.*;

public class TestTableBis{
  public static void main(){
      ApplicationContext container = 
          Factory.createApplicationContext("./exemples/README.TXT");
      Table table = container.getBean("table");

      table.ajouter(3);
      table.ajouter(3);
      System.out.println("table.taille(): " + table.taille());
    }
}
