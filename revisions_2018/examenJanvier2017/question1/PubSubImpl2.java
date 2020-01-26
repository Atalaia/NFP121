package examenJanvier2017.question1;

import java.util.*;
import java.io.Serializable;
/**
 * Write a description of class PubSubImpl2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PubSubImpl2 implements PubSubI
{
    
  private String name;
  private Map<String, SubscriberI> subscribers; 
  
  public PubSubImpl2(){
    this.subscribers = new HashMap<String, SubscriberI>();
    }
    
  public PubSubImpl2(String name){
     this(); 
     this.name = name; 
    }
    
    public String getName(){return name;}
    
  /** Publication d'un message à  certains souscripteurs.
   * @param names les noms des souscripteurs
   * @param message le message à  transmettre
   * @return le nombre de souscripteurs ayant reçu le message
   */
  public int publish(String[] names, Message message){
    int subs = 0;
    for(String name : names){
        if(publish(name,message));
        subs++;
    }
    return subs;
    }
  
  /** Publication d'un message à un souscripteur.
   * @param name le nom du souscripteur
   * @param message le message à  transmettre
   * @return true si l'envoi est réussi, false autrement
   */
  public boolean publish(String name,Message message){
    boolean res = false;
    SubscriberI sub = subscribers.get(name);
    if(sub != null){
        try{
        sub.onMessage(message);
        res = true;
    }catch (Exception e){}
    }
    return res;
    }
  
  /** Souscription.
   * @param subscriber le souscripteur 
   * @return false si ce souscripteur a déjà souscrit avec le même nom
   */
  public boolean subscribe(SubscriberI subscriber){
    if(subscribers.get(subscriber.getName()) != null) return false;
    subscribers.put(subscriber.getName(),subscriber);
    subscriber.addPubSub(this);
    return true;
    }

  /** Obtention d'un itérateur.
   * @return un itérateur sur les souscripteurs enregistrés
   */
  public Iterator<SubscriberI> iterator(){
    return subscribers.values().iterator();
    }
}
