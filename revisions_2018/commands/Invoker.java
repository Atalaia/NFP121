package commands;


public class Invoker<E,R>{
    private Command<E,R> command;
    private Command<E,R> exception;
    
    public void setCommand(Command<E,R> command){
        this.command = command;
    }
    public void setException(Command<E,R> exception){
        this.exception = exception;
    }

    public void execute(E entity,R result){
        
        try{
          command.execute(entity, result);
        }catch(RuntimeException e){
            if(exception!=null) exception.execute(entity, result);
        }
    }
}
