

public class EntierPositif extends Entier{

    public EntierPositif(int valeur){
      super(valeur);
      if(valeur<0) throw new RuntimeException();  
    }

    private void plus1Bis(){
      setValeur(getValeur()+1);
    }
  
    public EntierPositif copie(){
      return new EntierPositif(getValeur()); 
    }
}
