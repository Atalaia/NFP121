package examenJanvier2017.question3;

import java.util.*;
import java.io.*;
import examenJanvier2017.question1.*;

public class PubSubPersistent extends PubSubImpl implements PubSubI{
  private List<SubscriberI> list;
  private String fileName;

  public PubSubPersistent(String name){
    super(name);
    this.fileName = name + ".ser";
    if(new File(fileName).exists())
      restoreSubscribersList();
    else
      this.list = new ArrayList<SubscriberI>();
  }
        
  public boolean subscribe(SubscriberI subscriber){
    boolean res = false;
    if(super.subscribe(subscriber)){
      list.add(subscriber);
      saveSubscribersList();
      res = true;
    }
    return res;
  }
  
  private void saveSubscribersList(){
    try{
      ObjectOutputStream oos = new ObjectOutputStream(
                                 new FileOutputStream(fileName));
      oos.writeObject(this.list);
      oos.flush();
      oos.close();
    }catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    
  }
  
  private void restoreSubscribersList(){
    try{
      ObjectInputStream ois = new ObjectInputStream(
                                 new FileInputStream(fileName));
      this.list = (List)ois.readObject();
      ois.close();
    }catch(Exception e){
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
    
    for(SubscriberI s : list){
      super.subscribe(s);
    }
  }

}
