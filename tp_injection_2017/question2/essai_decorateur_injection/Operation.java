package question2.essai_decorateur_injection;

public abstract class Operation<C,E,R>{
    private Condition<C,E> condition;
    
    public Operation(){
        this.condition = new ToujoursVraie<C,E>();
    }
    
    public void setCondition(Condition<C,E> condition){
        this.condition = condition;
    }
    
    public void evaluer(C contexte, E entite, R resultat)throws Exception{
      if(condition.estSatisfaite(contexte,entite)){
          this.executer(contexte,entite,resultat);
        }
    }
    
    
    public abstract void executer(C contexte, E entite, R resultat) throws Exception;
}
