package examenJanvier2017.question4;


import examenJanvier2017.question1.Message;
import examenJanvier2017.question1.SubscriberI;
import java.util.Iterator;
import java.util.List;

public interface PublishSubscribeI extends Iterable<String>{
  /** Publication pour sur th�me (topic) d'un message.
   * @param topic le th�me
   * @param message le message � transmettre
   * @return le nombre de souscripteurs ayant �t� notifi�s
   */
  public int publish(String topic, Message message);
  
  /** Souscription � un th�me (topic) de publication.
   * Si ce th�me est inconnu, il est cr��.
   * @param topic le th�me
   * @param subscriber le souscripteur
   * @return false le sosucripteur est d�j� inscrit � ce th�me
   */
  public boolean subscribe(String topic, SubscriberI subscriber);
  
  /** Obtention d'un it�rateur.
   * @return un it�rateur sur les th�mes enregistr�s
   */
  public Iterator<String> iterator();
  
  /**Obtention de la liste des souscripteurs � un th�me.
   * @param topic le th�me
   * @return la liste des souscripteurs
   */
  public List<SubscriberI> getSubscribers(String topic);
  
}
