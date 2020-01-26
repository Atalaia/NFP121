package question3;
 
import question1.*;

public class TransactionDebit extends AbstractTransaction{
  private Gardien gardien;
  
  public TransactionDebit(Cotisant cotisant){
		super(cotisant);
		this.gardien = new Gardien();
	}
	
  /**      
   * avant une transaction l'�tat initiale est sauvegard�      
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
   * si une erreur est lev�e, retour � l'�tat pr�c�dent      
   */
  public  void rollbackTransaction(){
    gardien.getMemento().setState(cotisant);
  }
}