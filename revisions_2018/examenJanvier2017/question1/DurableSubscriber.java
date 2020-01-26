package examenJanvier2017.question1;


public class DurableSubscriber extends Subscriber{

  public DurableSubscriber(){
    super();
  }
  
  public DurableSubscriber(String name){
    super(name);
  }

  public void onMessage(Message message) throws Exception{
    System.out.println("Durable " + getName() + " : " + message);
  }
}
