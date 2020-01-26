package examenJanvier2017.question3;

import question1.*;
import java.io.*;


public class MainRestore{
  
//     static class SubscriberTest extends Subscriber{
//     SubscriberTest(MailboxI mailbox, String name){
//       super(name);
//       this.setMailbox(mailbox);
//       this.getMailbox().subscribe(this);
//     }
// 
//     public void onMessage(String message)throws Exception{
//       System.out.println(getName() + " : " + message);
//       if("error".equals(message))throw new Exception();
//     }
//   }
  
  public static void main(String[] args){
    PubSubI pubsub = new PubSubPersistent("pubsub");
    Message msg = new Message("p1","test");
    pubsub.publish(new String[]{"a","b"}, msg);
    msg = new Message("p1","test2");
    pubsub.publish(new String[]{"a","b","c","d"}, msg);
  }
}
