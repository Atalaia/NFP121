package examenJanvier2017.question2;


import examenJanvier2017.question1.*;

import java.util.*;

public class TestsProxy extends junit.framework.TestCase{


  public void testProxyPubSub(){
    List<String> users = new ArrayList<String>();
    users.add("p1");users.add("p2");users.add("p3");
    
    PubSubI pubsub = new ProxyPubSub("pubsub",users);
    SubscriberI a = new SimpleSubscriber(pubsub, "a");
    SubscriberI b = new SimpleSubscriber(pubsub, "b");
    SubscriberI c = new SimpleSubscriber(pubsub, "c");
    
    Message msg = new Message("p1","test");
    assertEquals(3,pubsub.publish(new String[]{"a","c","b"}, msg));
    
    msg = new Message("x","test");
    assertEquals(0,pubsub.publish(new String[]{"a","c","b"}, msg));
  }
  
  public void testProxyThreadPubSub(){

    PubSubI pubsub = new ProxyThreadPubSub("pubsub");
    SubscriberI a = new SimpleSubscriber(pubsub, "a");
    SubscriberI b = new SimpleSubscriber(pubsub, "b");
    SubscriberI c = new SimpleSubscriber(pubsub, "c");
    
    Message msg = new Message("p1","test");
    assertEquals(3,pubsub.publish(new String[]{"a","c","b"}, msg));
    
    msg = new Message("x","test");
    assertEquals(3,pubsub.publish(new String[]{"a","c","b"}, msg));
  }



}
