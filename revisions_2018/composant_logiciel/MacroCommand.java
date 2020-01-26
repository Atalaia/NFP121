package composant_logiciel;

public class MacroCommand<T> implements Command<T>{
   private Command<T>[] commands;
   public void setCommands(Command<T>[] commands){
       this.commands = commands;
    }
    
   public void execute(T t){
       for(Command<T> cmd : commands)
         cmd.execute(t);
   }
       
   public void undo(T t){
       for(Command<T> cmd : commands)
         cmd.undo(t);
   }
}
