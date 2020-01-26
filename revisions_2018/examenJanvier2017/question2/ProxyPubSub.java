package examenJanvier2017.question2;


import examenJanvier2017.question1.*;
import java.util.*;

public class ProxyPubSub implements PubSubI{
  private PubSubI pubsub;
  private List<String> users;

  public ProxyPubSub(String name, List<String> users){
    this.pubsub = new PubSubImpl(name);
    this.users = users;
  }
  
  public String getName(){
      return pubsub.getName();
  }
  
  public int publish(String[] names, Message message){
    if(users.contains(message.getSource()))
      return pubsub.publish(names,message);
    return 0;
  }

  public boolean publish(String name, Message message){
    if(users.contains(message.getSource()))
      return pubsub.publish(name,message);
    return false;
  }

  public boolean subscribe(SubscriberI subscriber){
    return pubsub.subscribe(subscriber);
  }

  public Iterator<SubscriberI> iterator(){
    return pubsub.iterator();
  }
}
