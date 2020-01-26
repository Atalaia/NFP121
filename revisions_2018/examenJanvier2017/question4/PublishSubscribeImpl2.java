package examenJanvier2017.question4;

import examenJanvier2017.question1.*;
import java.util.*;

public class PublishSubscribeImpl2 implements PublishSubscribeI
{
  private Map<String, PubSubI> table;
  
  public PublishSubscribeImpl2(){
      table = new HashMap<String, PubSubI>();
    }    
    
    /** Publication pour sur th�me (topic) d'un message.
   * @param topic le th�me
   * @param message le message � transmettre
   * @return le nombre de souscripteurs ayant �t� notifi�s
   */
  public int publish(String topic, Message message){
    int res = 0;
    PubSubI pubsub = table.get(topic);
    if(pubsub != null){
    for(SubscriberI subscriber : pubsub){
        if(pubsub.publish(subscriber.getName(),message));
        res++;
     }
    }
    return res;
    }
  
  /** Souscription � un th�me (topic) de publication.
   * Si ce th�me est inconnu, il est cr��.
   * @param topic le th�me
   * @param subscriber le souscripteur
   * @return false le sosucripteur est d�j� inscrit � ce th�me
   */
  public boolean subscribe(String topic, SubscriberI subscriber){
     PubSubI pubsub = table.get(topic);
     if(pubsub == null){
         pubsub = new PubSubImpl("pubsub-"+table.size());
         table.put(topic,pubsub);
        }
        return subscriber.addPubSub(pubsub);
    }
  
  /** Obtention d'un it�rateur.
   * @return un it�rateur sur les th�mes enregistr�s
   */
  public Iterator<String> iterator(){
    return table.keySet().iterator();
    }
  
  /**Obtention de la liste des souscripteurs � un th�me.
   * @param topic le th�me
   * @return la liste des souscripteurs
   */
  public List<SubscriberI> getSubscribers(String topic){
     PubSubI pubsub = table.get(topic);
     List<SubscriberI> list = new ArrayList<SubscriberI>();
     
     if(pubsub != null){
         for(SubscriberI sub : pubsub){
             list.add(sub);
            }
        }
        return list;
    }
}
