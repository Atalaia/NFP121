package chain_of_responsability;

public class Plus extends Handler<Nombre>{
    private int operande;
    private int max;
    
    public void setOperande(int operande){
        this.operande = operande;
    }
    public void setMax(int max){
        this.max = max;
    }
    
   public boolean handleRequest(Nombre nombre){
    if ( nombre.getValeur() >= max ) 
      return true;
    else 
      nombre.setValeur(nombre.getValeur()+operande);
      
    //System.out.println("handleRequest: nombre: " + nombre.getValeur());
    return super.handleRequest(nombre);
  }
 
}
