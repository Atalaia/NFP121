package examenJanvier2017.question3;


import question1.*;

import java.util.*;
import java.io.*;

public class TestSaveRestore extends junit.framework.TestCase{

  public void testSave(){
    PubSubI pubsub = new PubSubPersistent("pubsub");
    SimpleSubscriber a = new SimpleSubscriber(pubsub,"a");
    SimpleSubscriber b = new SimpleSubscriber(pubsub,"b");
    SimpleSubscriber c = new SimpleSubscriber(pubsub,"c");

    Message msg = new Message("p1","save");
    assertEquals(2,pubsub.publish(new String[]{"a","b"}, msg));
  }

  public void testRestore(){
    PubSubI pubsub = new PubSubPersistent("pubsub");
    Message msg = new Message("p1","restore");
    assertEquals(2,pubsub.publish(new String[]{"a","b"}, msg));
  }

  public void testDelete(){
    new File("pubsub.ser").delete();
  }

}
