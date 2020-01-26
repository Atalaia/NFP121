package question2.essai_decorateur_injection;

public class NombrePlus1 extends OperationNombre{

    public void executer(Contexte contexte, Nombre nombre, Resultat resultat) throws Exception{
        resultat.setValeur(nombre.getValeur()+1);
        if(T) System.out.println("appel de NombrePlus1.executer");
    }

}
