package examenJanvier2017.question1;


import java.util.*;

public class Tests extends junit.framework.TestCase{

    class SubscriberTest extends SimpleSubscriber{
      Stack<Message> messages;

      SubscriberTest(PubSubI pubsub, String name){
        super(name);
        pubsub.subscribe(this);
        this.messages = new Stack<Message>();
      }
      public void onMessage(Message message)throws Exception{
        this.messages.push(message);
        if("error".equals(message.getContent()))throw new Exception();
        super.onMessage(message);
      }
    }
        
    public void testSimple(){
       PubSubI pubsub = new PubSubImpl("pubsub");
       SubscriberTest a = new SubscriberTest(pubsub,"a");
       assertEquals("a", a.getName());
       assertTrue(a.getPubSubList().contains(pubsub));
       assertEquals(a, pubsub.iterator().next());
       
       SubscriberTest b = new SubscriberTest(pubsub,"b");
       SubscriberTest c = new SubscriberTest(pubsub,"c");
       
       assertFalse(pubsub.subscribe(a));
       Message message = new Message("p1","test");
       
       assertEquals(2,pubsub.publish(new String[]{"a","b"}, message));
       assertEquals("test",a.messages.pop().getContent());
       assertEquals("test",b.messages.pop().getContent());
       assertTrue(c.messages.isEmpty());
       assertEquals(3,pubsub.publish(new String[]{"c","a","b"}, message));
       assertEquals(0,pubsub.publish(new String[]{"d","e"}, message));
    }
    
 
    
    public void testAvecException(){
       PubSubI pubsub = new PubSubImpl("pubsub");
       SubscriberTest a = new SubscriberTest(pubsub,"a");
       SubscriberTest b = new SubscriberTest(pubsub,"b");
       Message message = new Message("p1","error");
       assertEquals(0,pubsub.publish(new String[]{"a","b","c"}, message));
       
    }
    
    public void testDeuxBoites(){
       PubSubI pubsub1 = new PubSubImpl("pubsub1");
       PubSubI pubsub2 = new PubSubImpl("pubsub2");
       SubscriberTest a1 = new SubscriberTest(pubsub1,"a");
       SubscriberTest a2 = new SubscriberTest(pubsub2,"a");
       Message message = new Message("p1","test");
       assertEquals(1,pubsub1.publish(new String[]{"a"}, message));
       assertEquals("test",a1.messages.pop().getContent());
       assertEquals(1,pubsub2.publish(new String[]{"a"}, message));
       assertEquals("test",a2.messages.pop().getContent());
    }
    
    public void testDeuxBoitesUnSouscripteur(){
       PubSubI pubsub1 = new PubSubImpl("pubsub1");
       PubSubI pubsub2 = new PubSubImpl("pubsub2");
       SubscriberTest st1 = new SubscriberTest(pubsub1,"a");
       SubscriberTest st2 = new SubscriberTest(pubsub2,"a");
       assertTrue(st1.getPubSubList().contains(pubsub1));
       assertEquals("a",st1.getName());
       assertTrue(st2.getPubSubList().contains(pubsub2));
       assertEquals("a",st2.getName());
       Message message = new Message("p1","test");
       assertEquals(1,pubsub1.publish(new String[]{"a"}, message));
       assertEquals("test",st1.messages.pop().getContent());
       assertEquals(1,pubsub2.publish(new String[]{"a"}, message));
       assertEquals("test",st2.messages.pop().getContent());
    }
}
