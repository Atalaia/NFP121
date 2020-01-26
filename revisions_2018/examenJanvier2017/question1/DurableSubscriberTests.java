package examenJanvier2017.question1;

import container.*;

import java.util.*;

public class DurableSubscriberTests extends junit.framework.TestCase{

    public static class SubscriberTest extends DurableSubscriber{
      Stack<Message> messages;
      boolean fail;
      public SubscriberTest(PubSubI pubsub, String name){
        super(name);
        pubsub.subscribe(this);
        this.messages = new Stack<Message>();
      }
      
      public SubscriberTest(){
          this.messages = new Stack<Message>();
      }
      public void setName(String name){
          super.setName(name);
      }
      public void setPubSub(PubSubI pubsub){
          pubsub.subscribe(this);
        }
      public void fail(boolean failed){
        this.fail = failed;
      }
      public void onMessage(Message message)throws Exception{
        if(fail){throw new Exception();}
        this.messages.push(message);
        super.onMessage(message);
      }
    }
        
    
    public void testDurableSubscriber(){
       PubSubI pubsub = new PubDurableSubImpl("pubsub");
       SubscriberTest a = new SubscriberTest(pubsub,"a");
       SubscriberTest b = new SubscriberTest(pubsub,"b");
       Message message = new Message("s1","msg 1");
       a.fail(true);
       assertEquals(1,pubsub.publish(new String[]{"a","b"}, message));
       message = new Message("s2","msg 2");
       assertEquals(1,pubsub.publish(new String[]{"a","b"}, message));
       
       a.fail(false);
       message = new Message("s2","msg 3");
       assertEquals(4,pubsub.publish(new String[]{"a","b"}, message));
       assertEquals("msg 3",a.messages.pop().getContent());
       assertEquals("msg 2",a.messages.pop().getContent());
       assertEquals("msg 1",a.messages.pop().getContent());
       
       message = new Message("s1","msg 4");
       assertEquals(2,pubsub.publish(new String[]{"a","b"}, message));
    }
    
  
    
  
}
