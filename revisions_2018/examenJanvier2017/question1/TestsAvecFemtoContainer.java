package examenJanvier2017.question1;

import container.*;

import java.util.*;

public class TestsAvecFemtoContainer extends junit.framework.TestCase{

    
    public static class SubscriberTest extends SimpleSubscriber{
      Stack<Message> messages;
      public SubscriberTest(){
          this.messages = new Stack<Message>();
        }
      public void setName(String name){
          super.setName(name);
      }
      public void setPubSub(PubSubI pubsub){
          pubsub.subscribe(this);
        }
      public SubscriberTest(PubSubI pubsub, String name){
        super(name);
        pubsub.subscribe(this);
        this.messages = new Stack<Message>();
      }
      @Override
      public void onMessage(Message message)throws Exception{
          System.out.println("onMessage !! " + getName());
        this.messages.push(message);
        if("error".equals(message.getContent()))throw new Exception();
        super.onMessage(message);
      }
    }
        
    public void testSimple(){
       ApplicationContext ctx = Factory.createApplicationContext("./examenJanvier2017/question1/README.TXT");
       // // PubSubI pubsub = new PubSubImpl("pubsub");
       PubSubI pubsub = ctx.getBean("pubsub");
       // SubscriberTest a = new SubscriberTest(pubsub,"a");
       SubscriberTest a = ctx.getBean("a");
       assertEquals("A", a.getName());
       assertTrue(a.getPubSubList().contains(pubsub));
       assertEquals(a, pubsub.iterator().next());
       
       // SubscriberTest b = new SubscriberTest(pubsub,"b");
       SubscriberTest b = ctx.getBean("b");
       // SubscriberTest c = new SubscriberTest(pubsub,"c");
       SubscriberTest c = ctx.getBean("c");
       
       assertFalse(pubsub.subscribe(a));
       Message message = new Message("p1","test");
       
       assertEquals(2,pubsub.publish(new String[]{"A","B"}, message));
       assertEquals("test",a.messages.pop().getContent());
       assertEquals("test",b.messages.pop().getContent());
       assertTrue(c.messages.isEmpty());
       assertEquals(3,pubsub.publish(new String[]{"C","A","B"}, message));
       assertEquals(0,pubsub.publish(new String[]{"D","E"}, message));
    }
    
 
    public void testAvecException(){
       ApplicationContext ctx = Factory.createApplicationContext("./examenJanvier2017/question1/README.TXT");
       // // PubSubI pubsub = new PubSubImpl("pubsub");
       PubSubI pubsub = ctx.getBean("pubsub");
 
       //SubscriberTest a = new SubscriberTest(pubsub,"a");
       //SubscriberTest b = new SubscriberTest(pubsub,"b");
       Message message = new Message("p1","error");
       assertEquals(0,pubsub.publish(new String[]{"A","B","C"}, message));
       
    }
    
    public void testDeuxBoites(){
       ApplicationContext ctx = Factory.createApplicationContext("./examenJanvier2017/question1/README.TXT");
       //  // PubSubI pubsub1 = new PubSubImpl("pubsub1");
       PubSubI pubsub1 = ctx.getBean("pubsub1");
       //  // PubSubI pubsub2 = new PubSubImpl("pubsub2");
       PubSubI pubsub2 = ctx.getBean("pubsub2");

       // SubscriberTest a1 = new SubscriberTest(pubsub1,"a");
       SubscriberTest a1 = ctx.getBean("a1");
       // SubscriberTest a2 = new SubscriberTest(pubsub2,"a");
       SubscriberTest a2 = ctx.getBean("a2");

       
       Message message = new Message("p1","test");
       assertEquals(1,pubsub1.publish(new String[]{"A"}, message));
       assertEquals("test",a1.messages.pop().getContent());
       assertEquals(1,pubsub2.publish(new String[]{"A"}, message));
       assertEquals("test",a2.messages.pop().getContent());
    }
    
    public void testDeuxBoitesUnSouscripteur(){
       ApplicationContext ctx = Factory.createApplicationContext("./examenJanvier2017/question1/README.TXT");
       PubSubI pubsub1 = ctx.getBean("pubsub1");
       PubSubI pubsub2 = ctx.getBean("pubsub2");

       SubscriberTest st1 = ctx.getBean("a1");
       SubscriberTest st2 = ctx.getBean("a2");
       
       assertTrue(st1.getPubSubList().contains(pubsub1));
       assertEquals("A",st1.getName());
       assertTrue(st2.getPubSubList().contains(pubsub2));
       assertEquals("A",st2.getName());
       Message message = new Message("p1","test");
       assertEquals(1,pubsub1.publish(new String[]{"A"}, message));
       assertEquals("test",st1.messages.pop().getContent());
       assertEquals(1,pubsub2.publish(new String[]{"A"}, message));
       assertEquals("test",st2.messages.pop().getContent());
    }
}
