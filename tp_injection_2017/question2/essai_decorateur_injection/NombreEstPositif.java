package question2.essai_decorateur_injection;


public class NombreEstPositif implements Condition<Contexte,Nombre>{
    public boolean estSatisfaite(Contexte contexte, Nombre nombre){
        return nombre.getValeur()>=0;
    }
}
