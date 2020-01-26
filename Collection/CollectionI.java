import java.util.Iterator;

public interface CollectionI<E> extends Iterable<E>{
  
  /** Ajout d'un élément à la collection.
   * @param e l'élément (!=null)
   * @return true si la collection a été modifiée
   */
  boolean ajouter(E e);
  
  /** Ajout de tous les éléments d'une collection à la collection.
   * @param c la collection (!=null)
   * @return true si la collection a été modifiée
   */  
  boolean ajouter(CollectionI<E> c);

  /** Suppression d'un élément de la collection.
   * @param e l'élément (!=null)
   * @return true si la collection a été modifiée
   */ 
  boolean supprimer(E e);
  
  /** Suppression de tous les éléments de c de la collection en cours.
   * @param c une collection (!=null)
   * @return true si la collection a été modifiée
   */
  boolean supprimer(CollectionI<E> c);

  /** Obtention d'un itérateur sur la collection.
   * @return un itérateur
   */
  Iterator<E> iterator();

  /** Test de la présence d'un élément.
   * @param e l'élément (!=null)
   * @return true si cet élément est présent
   */
  boolean contient(E e);
  
  /** Test de l'inclusion d'une collection.
   * @param c une collection (!=null)
   * @return true si c est incluse dans la collection
   */
  boolean contient(CollectionI<E> c);

  /** Obtention du nombre d'éléments de l'inclusion d'une collection.
   * @return le nombre d'élément de la collection
   */
  int taille();

  /** Egalité de deux collections, même taille, mêmes éléments.
   * @return true si les deux collections sont égales
   */
  boolean equals(Object o);
  
  /** Obtention d'une valeur de hashCode.
   * Soit ici la somme des valeur de hashCode de chaque élément.
   * @return une valeur
   */
  int hashCode();

  
}
