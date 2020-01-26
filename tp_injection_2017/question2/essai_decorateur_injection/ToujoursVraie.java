package question2.essai_decorateur_injection;

public class ToujoursVraie<C,E> implements Condition<C,E>{
    
  public boolean estSatisfaite(C contexte, E entite){
      return true;
    }
    
}
