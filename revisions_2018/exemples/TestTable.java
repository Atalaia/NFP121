package exemples;

import java.util.*;

public class TestTable{
  public static void main(){
      Table table = new Table();
      //table.setCollection(new HashSet<Integer>());
      table.setCollection(new ArrayList<Integer>());
      
      table.ajouter(3);
      table.ajouter(3);
      System.out.println("table.taille(): " + table.taille());
    }
}
