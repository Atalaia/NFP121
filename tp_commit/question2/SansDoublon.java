package question2;

import question1.*;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SansDoublon implements Visiteur<Boolean>{
    
  Set<Cotisant> ct = new TreeSet<Cotisant>();  
  
  public Boolean visite(Contributeur c){ 
    return this.ct.equals((Cotisant)c);
  }
  
  public Boolean visite(GroupeDeContributeurs g){
    Iterator<Cotisant> it = g.iterator();
    
    while(it.hasNext()){
        Cotisant cts = it.next();
        if(!cts.accepter(this)){
            return false;
        }
    }
    return this.ct.equals((Cotisant)g) ;
  }
  
}