package question2.essai_decorateur_injection;

public class NombreIdentite extends OperationNombre{
 
  public void executer(Contexte contexte, Nombre nombre, Resultat resultat) throws Exception{
    resultat.setValeur(nombre.getValeur());
  }

}
