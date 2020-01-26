package chain_of_responsability;


public class Moins extends Handler<Nombre>{
    private int operande;
    private int min;
    
    public void setOperande(int operande){
        this.operande = operande;
    }
    public void setMin(int min){
        this.min = min;
    }
    
   public boolean handleRequest(Nombre nombre){
    if ( nombre.getValeur() <= min ) 
      return true;
    else 
      nombre.setValeur(nombre.getValeur()-operande);
      
    //System.out.println("handleRequest: nombre: " + nombre.getValeur());
    return super.handleRequest(nombre);
  }
 
}
