package compositeEtVisiteur;

import java.util.*;

public class Conteneur extends Composant{
  private List<Composant> composants;
  
  public Conteneur(){
    this.composants = new ArrayList<Composant>();
  }
    
  public void ajouter(Composant composant){
    this.composants.add(composant);
  }
  
  public String toString(){
      String res = new String();
      for(Composant composant : composants)
        res = res + composant.toString();
        
      return res;
    }
    
   public <T> T accepter(Visiteur<T> v){
        return v.visiteConteneur(this);
    }
}
