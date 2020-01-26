package examenJanvier2017.question1;

import java.util.*;



public class PubDurableSubImpl extends PubSubImpl{

  private Map<String, List<Message>> messages;
  
  public PubDurableSubImpl(){}
  public void setName(String name){
      super.setName(name);
    }
  public PubDurableSubImpl(String name){
    super(name);
    this.messages = new TreeMap<String, List<Message>>();
  }

  public int publish(String[] names, Message message){
    int number = 0;
    for(String name : names){
      List<Message> liste = messages.get(name);

      if(liste != null && liste.size()>0){ // c'est un DurableSuscriber
        Iterator<Message> it = liste.iterator();
        while(it.hasNext()){ // r�-�mission de tous les messages
          Message msg =  it.next();
          boolean result = publish(name,msg);
          if(result){ // si bonne r�ception
            number++;
            it.remove();
          }
        }
      }

      if(publish(name,message)){
        number++;
      }else{
        if(liste != null) // c'est un DurableSuscriber
          liste.add(message); // alors sauvegarde du message...
      }
    }
    
    return number;
  }

  @Override
  public boolean subscribe(SubscriberI subscriber){
    boolean res = super.subscribe(subscriber);
    if(res && subscriber instanceof DurableSubscriber){
      if(messages.get(subscriber.getName())==null){
        messages.put(subscriber.getName(),new ArrayList<Message>());
      }
    }
    return res;
  }
}
