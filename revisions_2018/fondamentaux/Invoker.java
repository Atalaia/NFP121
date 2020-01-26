package fondamentaux;



public class Invoker{
    private Command command;
    public Invoker(Command command){
       this.command = command;
    }
    public void on(){
       command.execute();
    }
    public void off(){
       command.undo();
    }
}
