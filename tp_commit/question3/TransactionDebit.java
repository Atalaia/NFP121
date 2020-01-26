package question3;
 
import question1.*;

public class TransactionDebit extends AbstractTransaction{
  private Gardien gardien;
  
  public TransactionDebit(Cotisant cotisant){
		super(cotisant);
		this.gardien = new Gardien();
	}
	
  /**      
   * avant une transaction l'état initiale est sauvegardé      
   */ 
  public void beginTransaction(){
     gardien.setMemento(new Memento(cotisant));
  }
  
  /**
   * fin d'une transaction
   */
  public void endTransaction(){
  }
  
  /**      
   * si une erreur est levée, retour à l'état précédent      
   */
  public  void rollbackTransaction(){
    gardien.getMemento().setState(cotisant);
  }
}