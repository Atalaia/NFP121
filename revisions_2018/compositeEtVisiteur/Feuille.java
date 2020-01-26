package compositeEtVisiteur;


public class Feuille extends Composant{

    public String toString(){
        return "Feuille";
    }
    
    public <T> T accepter(Visiteur<T> v){
        return v.visiteFeuille(this);
    }

}
