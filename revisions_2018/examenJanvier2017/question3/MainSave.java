package examenJanvier2017.question3;

import java.util.*;
import examenJanvier2017.question1.*;
import java.io.*;

public class MainSave{
  
  public static void main(String[] args){
    new File("pubsub.ser").delete();
    PubSubI pubsub = new PubSubPersistent("pubsub");
    SimpleSubscriber a = new SimpleSubscriber(pubsub, "a");
    SimpleSubscriber b = new SimpleSubscriber(pubsub, "b");
    SimpleSubscriber c = new SimpleSubscriber(pubsub, "c");
    Message msg = new Message("p1","test");
    pubsub.publish(new String[]{"a","b"}, msg);
  }
}
