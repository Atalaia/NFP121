package composant_logiciel;



public class Nombre{
   private int valeur;

   public void setValeur(int valeur){
       this.valeur = valeur;
   }
   
   public int getValeur(){
       return this.valeur;
   }
    
   public String toString(){
       return Integer.toString(valeur);
    }
}
