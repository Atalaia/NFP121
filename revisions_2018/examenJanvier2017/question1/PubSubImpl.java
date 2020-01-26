package examenJanvier2017.question1;

import java.util.*;
import java.io.Serializable;

public class PubSubImpl implements PubSubI{
  private String name;
  private Map<String,SubscriberI> subscribers;
  
  public PubSubImpl(){
      this.subscribers = new HashMap<String,SubscriberI>();
  }
  public PubSubImpl(String name){
    this();
    this.name = name;
  }
  public void setName(String name){this.name =name;}
  public String getName(){
    return name;
  }
  
  public boolean publish(String name, Message message){
    boolean res = false;
    SubscriberI sub = subscribers.get(name);
    if(sub != null){
      try{
        sub.onMessage(message);
        res = true;
      }catch(Exception e){
      }
    }
    return res;
  }

  public int publish(String[] names, Message message){
    int number = 0;
    for(String name : names){
      if(publish(name,message)){
        number++;
      }
    }
    return number;
  }

  public boolean subscribe(SubscriberI subscriber){
    if(subscribers.get(subscriber.getName()) != null)return false;
    subscribers.put(subscriber.getName(), subscriber);
    subscriber.addPubSub(this);
    return true;
  }

  public Iterator<SubscriberI> iterator(){
    return subscribers.values().iterator();
  }
  
  public boolean equals(Object obj){
    if(!(obj instanceof PubSubI)) return false;
    PubSubI pubsub = (PubSubI)obj;
    return getName().equals(pubsub.getName()); // && map ?
  }
  public int hashCode(){
    return name.hashCode();
  }

}
