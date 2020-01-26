package examenJanvier2017.question1;
import java.util.*;


public abstract class Subscriber implements SubscriberI{
  private String name;
  private List<PubSubI> pubsubList=null;
  
  public Subscriber(){
      if(pubsubList==null) pubsubList = new ArrayList<PubSubI>();
    }
  public Subscriber(String name){
    this();
    this.name = name;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }

  public List<PubSubI> getPubSubList(){
    return pubsubList;
  }
  
  public boolean addPubSub(PubSubI pubsub){
    if(!(pubsubList.contains(pubsub))){
      pubsub.subscribe(this);
      return this.pubsubList.add(pubsub);
    }
    return false;
  }

  public boolean equals(Object obj){
    if(!(obj instanceof SubscriberI))return false;
    SubscriberI s = (SubscriberI)obj;
    return getName().equals(s.getName()); // hyp: pas d'homonyme ...
           //&& getPubSubList().equals(s.getPubSubList()); 
  }

  public int hashCode(){
    return getName().hashCode();
  }
}
