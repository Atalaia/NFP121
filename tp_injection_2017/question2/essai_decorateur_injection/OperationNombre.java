package question2.essai_decorateur_injection;

public abstract class OperationNombre 
   extends Operation<Contexte,Nombre,Resultat>{
       
  protected static final boolean T = true;
  
  private OperationNombre operation;
  
  public void setOperation(OperationNombre operation){
      this.operation = operation;
  }
  public OperationNombre getOperation(){
      return this.operation;
    }
}
