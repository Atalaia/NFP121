package composant_logiciel;

import java.util.concurrent.*;

public class Trace implements Command<Object>{
 
   public void execute(Object object){
     System.out.println("commande Trace: " + object.toString());
   }
    
   public void undo(Object object){}
   
}