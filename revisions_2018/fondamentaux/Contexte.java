package fondamentaux;



public class Contexte{
    private Strategie strategie;


  public void setStrategie(Strategie strategie){
      this.strategie = strategie;
    }
   
  public int calcul(int x){
      return strategie.f(x);
    }
}
