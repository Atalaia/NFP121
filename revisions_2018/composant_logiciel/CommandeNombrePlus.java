package composant_logiciel;


public class CommandeNombrePlus implements Command<Nombre>{
   private int operande;
   
   public void setOperande(int operande){
       this.operande = operande;
   }
    
   public void execute(Nombre nombre){
       nombre.setValeur(nombre.getValeur()+operande);
   }
    
   public void undo(Nombre nombre){
        nombre.setValeur(nombre.getValeur()-operande);
   }
   
}
