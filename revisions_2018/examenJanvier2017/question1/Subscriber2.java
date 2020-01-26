package examenJanvier2017.question1;
import java.util.*;

/**
 * Abstract class Subscriber2 - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Subscriber2 implements SubscriberI
{
    private String name;
    private List<PubSubI> pubsubList = null;
    
    public Subscriber2(){
        if(pubsubList == null) pubsubList = new ArrayList<PubSubI>();
    }
    
    public Subscriber2(String name){
     this();
     this.name = name;   
    }
    /** Obtention du nom du souscripteur.
   * @return le nom du souscripteur
   */
  public String getName(){
    return name;
    }
    public void setName(String name){
        this.name = name;
    }

/** Obtention de la liste des abonnements de ce souscripteur.
 * @return la liste des souscriptions effectuées
 */ 
public List<PubSubI> getPubSubList(){
    return pubsubList;
}

/** Ajout d'un abonnement pour ce souscripteur.
 * @return false si l'abonnement était déjà en place
 */
public boolean addPubSub(PubSubI pubsub){
    if(!(pubsubList.contains(pubsub))){
        pubsub.subscribe(this);
        return this.pubsubList.add(pubsub);
    }
    return false;
}



}
