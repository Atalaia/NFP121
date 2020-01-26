package fondamentaux;


public class CommandeLampe implements Command{
    private Lampe lampe;
    public CommandeLampe(Lampe lampe){
        this.lampe = lampe;
    }

    public void execute(){
        lampe.allumer();
    }

    public void undo(){
        lampe.eteindre();
    }
}
