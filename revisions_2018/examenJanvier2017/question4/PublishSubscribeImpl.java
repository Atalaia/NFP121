package examenJanvier2017.question4;


import java.util.*;
import examenJanvier2017.question1.*;

public class PublishSubscribeImpl implements PublishSubscribeI{
  private Map<String, PubSubI> table;

  public PublishSubscribeImpl(){
    this.table = new HashMap<String,PubSubI>();
  }

  public int publish(String topic, Message message){
    int res = 0;
    PubSubI pubsub = table.get(topic);
    if(pubsub!=null){
      for(SubscriberI subscriber : pubsub){
        if(pubsub.publish(subscriber.getName(),message))
          res++;
      }
    }
    return res;
  }

  public boolean subscribe(String topic, SubscriberI subscriber){
    PubSubI pubsub = table.get(topic);
    if(pubsub==null){
      pubsub = new PubSubImpl("pubsub-"+table.size());
      table.put(topic,pubsub);
    }
    return subscriber.addPubSub(pubsub);
  }


  public Iterator<String> iterator(){
    return table.keySet().iterator();
  }
  
  public List<SubscriberI> getSubscribers(String topic){
    PubSubI pubsub = table.get(topic);
    List<SubscriberI> list = new ArrayList<SubscriberI>();
    if(pubsub!=null){
      for(SubscriberI s : pubsub){
        list.add(s);
      }
    }
    return list;
  }
      
}