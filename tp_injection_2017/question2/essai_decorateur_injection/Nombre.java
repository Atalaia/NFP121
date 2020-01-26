package question2.essai_decorateur_injection;


public class Nombre {
    private int valeur;
    public Nombre(){this(0);}
    public Nombre(int valeur){this.valeur=valeur;}
    public void setValeur(int valeur){
        this.valeur = valeur;
    }
    public int getValeur(){
        return valeur;
    }
}
