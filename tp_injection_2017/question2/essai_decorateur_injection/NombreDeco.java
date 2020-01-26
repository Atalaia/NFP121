package question2.essai_decorateur_injection;

public class NombreDeco extends AbstractDecorateur{

    public NombreDeco(OperationNombre decore){
        super(decore);
    }
    public NombreDeco(){}
    public void executer(Contexte contexte, Nombre nombre, Resultat resultat) throws Exception{
      super.executer(contexte, nombre, resultat);
      getOperation().executer(contexte, nombre, resultat);
    }
 
}
