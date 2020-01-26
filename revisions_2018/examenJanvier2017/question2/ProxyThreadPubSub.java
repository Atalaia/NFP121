package examenJanvier2017.question2;

import examenJanvier2017.question1.*;
import java.util.*;


public class ProxyThreadPubSub implements PubSubI{
  private PubSubI pubsub;

  public ProxyThreadPubSub(String name){
    this.pubsub = new PubSubImpl(name);
  }

  public int publish(String[] names, Message message){
    int res = 0;
    for(String name : names){
      try{
        if(publish(name, message))
          res++;
      }catch(Exception e){}
    }
    return res;
  }

  @Override
  public boolean publish(String name, Message message){
    PublishThread thread = new PublishThread(name, message);
    thread.start();
    return thread.getResult();
  }
  
  public String getName(){
    return pubsub.getName();
    }

  private class PublishThread extends Thread{
    private boolean res = false;
    private String name;
    private Message message;

    
    PublishThread(String name, Message message){
      this.name = name;
      this.message = message;
    }

    public void run(){
      res = pubsub.publish(name,message);
      try{
        Thread.sleep(5000);
      }catch(Exception e){}
    }

    public boolean getResult(){
      try{
        this.join();
        System.out.println("join, res: " + res);
      }catch(Exception e){}
      return res;
    }
  }

  public boolean subscribe(SubscriberI subscriber){
    if(subscriber.getName().startsWith("nfp121"))
      return pubsub.subscribe(subscriber);

    return false;
  }

  public Iterator<SubscriberI> iterator(){
    return pubsub.iterator();
  }
}
