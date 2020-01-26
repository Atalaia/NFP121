package observer;


public class InvokerException extends CommandNombre {
    private Resultat resultat;
    private RuntimeException runtimeException;
    
    public void setResultat(Resultat resultat){
        this.resultat = resultat;
    }
    public void setRuntimeException(RuntimeException runtimeException){
        this.runtimeException = runtimeException;
    }
    @Override
    public void execute(Nombre nombre,Resultat r){
      if(resultat!=null)r.setValeur(resultat.getValeur());
      if(runtimeException!=null)throw runtimeException; // propagation
    }
}
