package question2.essai_decorateur_injection;

public abstract class AbstractDecorateur extends OperationNombre{
    private OperationNombre decore; // le décoré

    
    public AbstractDecorateur(OperationNombre decore){
        this.decore = decore; // le décoré
    }
    public AbstractDecorateur(){}
    public void setDecore(OperationNombre decore){
        this.decore = decore;
    }
   
    
    public void executer(Contexte contexte, Nombre nombre, Resultat resultat) throws Exception{
      decore.executer(contexte, nombre, resultat);
    }
    
}
