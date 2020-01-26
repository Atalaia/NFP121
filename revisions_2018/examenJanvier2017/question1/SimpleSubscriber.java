package examenJanvier2017.question1;



public class SimpleSubscriber extends Subscriber{
  public SimpleSubscriber(){}
  public SimpleSubscriber(String name){
    super(name);
  }
  public void onMessage(Message message) throws Exception{
    System.out.println(getName() + " : " + message);
  }
}
