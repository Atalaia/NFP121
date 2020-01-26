package examenJanvier2017.question4;

import question1.*;
imp ort java.util.*;


public class Tests extends junit.framework.TestCase{

    class SubscriberTest extends SimpleSubscriber{
      Stack<Message> messages;
      SubscriberTest(String name){
        super(name);
        this.messages = new Stack<Message>();
      }
      public void onMessage(Message message)throws Exception{
        this.messages.push(message);
        if("error".equals(message.getContent()))throw new Exception();
        super.onMessage(message);
      }
    }
        
    public void testSimple(){
       PublishSubscribeI pubsub = new PublishSubscribeImpl();
       SubscriberTest a = new SubscriberTest("a");
       assertTrue(pubsub.subscribe("meteo",a));
       SubscriberTest b = new SubscriberTest("b");
       assertTrue(pubsub.subscribe("meteo",b));
       SubscriberTest c = new SubscriberTest("c");
       assertTrue(pubsub.subscribe("meteo",c));
       
       Message message = new Message("s1","il neige");
       
       assertEquals(3,pubsub.publish("meteo", message));
       assertEquals("il neige",a.messages.pop().getContent());
       assertEquals("il neige",b.messages.pop().getContent());
       assertEquals("meteo",pubsub.iterator().next());
    }
    
    public void testDeuxThemesUnSouscripteur(){
       PublishSubscribeI pubsub = new PublishSubscribeImpl();
       SubscriberTest a = new SubscriberTest("a");
       assertTrue(pubsub.subscribe("meteo",a));
       assertTrue(pubsub.subscribe("verglas",a));
       Message message = new Message("s1","il g�le");
       assertEquals(1,pubsub.publish("meteo", message));
       assertEquals(1,pubsub.publish("verglas", message));
    }

//     
//     public void testDeuxBoites(){
//        PubSubI pubsub1 = new PubSubImpl("pubsub1");
//        PubSubI pubsub2 = new PubSubImpl("pubsub2");
//        SubscriberTest a1 = new SubscriberTest(pubsub1,"a");
//        SubscriberTest a2 = new SubscriberTest(pubsub2,"a");
//        Message message = new Message("s1","test");
//        assertEquals(1,pubsub1.publish(new String[]{"a"}, message));
//        assertEquals("test",a1.messages.pop().getContent());
//        assertEquals(1,pubsub2.publish(new String[]{"a"}, message));
//        assertEquals("test",a2.messages.pop().getContent());
//     }
//     
//     public void testDeuxBoitesUnSouscripteur(){
//        PubSubI pubsub1 = new PubSubImpl("pubsub1");
//        PubSubI pubsub2 = new PubSubImpl("pubsub2");
//        SubscriberTest a = new SubscriberTest(pubsub1,"a");
//        assertTrue(a.addPubSub(pubsub2));
//        Message message = new Message("s1","test");
//        assertEquals(1,pubsub1.publish(new String[]{"a"}, message));
//        assertEquals("test",a.messages.pop().getContent());
//        assertEquals(1,pubsub2.publish(new String[]{"a"}, message));
//        assertEquals("test",a.messages.pop().getContent());
//     }
}
