package fondamentaux;


public class MacroCommande implements Command{
    
   private Command[] commands;
   
   public void execute(){
       for(Command cmd : commands){
           cmd.execute();
        }
        
    }
}
