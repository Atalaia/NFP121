package examenJanvier2017.question1;

import java.util.Iterator;
import java.util.List;
import java.io.Serializable;

public interface PubSubI extends Iterable<SubscriberI>, Serializable{

  /** Obetntion du nom de ce "pubsub".
   * @return son nom
   */
  public String getName();

  /** Publication d'un message à des souscripteurs à l'aide de leur nom.
   * @param names les noms des destinataires
   * @param message le message à transmettre
   * @return le nombre de souscripteurs ayant reçu le message
   */
  public int publish(String[] names, Message message);

  /** Publication d'un message à un souscripteur.
   * @param name le nom du destinataire
   * @param message le message à transmettre
   * @return true si l'envoi est réussi, false autrement
   */
  public boolean publish(String name, Message message);

  /** Souscription à cette boite mail.
   * @param subscriber le souscripteur 
   * @return false si ce sosucripteur est déjàinscrit avec le même nom
   */
  public boolean subscribe(SubscriberI subscriber);

  /** Obtention d'un itérateur.
   * @return un itérateur sur les souscripteurs enregistrés
   */
  public Iterator<SubscriberI> iterator();
}
