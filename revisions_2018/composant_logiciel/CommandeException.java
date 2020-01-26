package composant_logiciel;

public class CommandeException implements Command<Object>{
    
   public void execute(Object o){
       System.out.println("exception ! " + o);
   }
    
   public void undo(Object o){
        
   }
   
}
