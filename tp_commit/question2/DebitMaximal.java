package question2;

import question1.Contributeur;
import question1.GroupeDeContributeurs;
import question1.Visiteur;
import question1.Cotisant;
/**  
 * Un visiteur qui retourne le débit maximal d'un Contributeur ou d'un GroupeDeContributeurs  
 */
public class DebitMaximal implements Visiteur<Integer>{
  /**      
   * @return le débit maximal d'un seul contributeur      
   */
  public Integer visite(Contributeur c){
    return c.solde();
  }
  
  /**      
   * @return le solde minimale de tous les Contributeurs      
   */ 
  public Integer visite(GroupeDeContributeurs g){
    int res = 0;
    for(Cotisant c : g.getChildren()){
        int temp = c.accepter(this);
        if(res == 0 || temp < res ){                             
                res =temp; 
            } 
        } 
    return res ;
  }
}