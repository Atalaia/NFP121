package container;

/**
 * Un conteneur de beans adapté au cours NFP121.
 * Injection de dépendances par mutateur.
 *
 * @author jm Douin
 * @version 13 Janvier 2017
 */

public interface ApplicationContext extends Iterable<String>{
  
  /** Obtention d'une instance d'un bean géré par le conteneur.
   *  Il n'existe qu'une seule instance avec cet id, c'est un singleton.
   * @param id l'identifiant unique du bean
   * @return l'instance associée ou null si cet identifiant est inconnu
   */
  public <T> T getBean(String id);
  
  /** Obtention du type du bean à partir de son identifiant.
   * param id l'identifiant unique du bean
   * @return le type du bean ou null
   */
  public Class<?> getType(String id);
  
  /** Obtention d'un itérateur sur les beans déjà créés.
   * L'opération de retrait : remove, est sans effet.
   * @return un itérateur des identifiants du conteneur
   */
  public java.util.Iterator<String> iterator();
  
  /** Ajout, cumul d'une autre instance d'ApplicationContext
   * @param appContext le conteneur à ajouter
   */
  public void addApplicationContext(ApplicationContext appContext);
}
