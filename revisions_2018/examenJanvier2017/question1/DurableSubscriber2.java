package examenJanvier2017.question1;


/**
 * Write a description of class DurableSubscriber2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DurableSubscriber2 extends Subscriber
{
    public DurableSubscriber2(String name){
        super(name);
    }
    
    public DurableSubscriber2(){
        super();
    }
    
     public void onMessage(Message message) throws Exception{
    System.out.println("Durable " + getName() + " : " + message);
  }
    
}
