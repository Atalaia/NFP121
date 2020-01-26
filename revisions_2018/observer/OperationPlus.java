package observer;
import operations.*;

public class OperationPlus implements Operation<Nombre,Resultat>{
  private int operande;
  public void setOperande(final int operande){
      this.operande = operande;
  }
  
  public void execute(Nombre n, Resultat resultat){
      if(n.getValeur()>=1000) throw new RuntimeException("n.getValeur()>=1000");
      
      resultat.setValeur(resultat.getValeur()+operande);
  }
}
