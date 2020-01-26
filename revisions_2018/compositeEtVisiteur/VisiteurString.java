package compositeEtVisiteur;


public class VisiteurString extends Visiteur<String>{
    
    public  String visiteFeuille(Feuille feuille){
        return feuille.toString();
    }
    
    public String visiteConteneur(Conteneur conteneur){
        return conteneur.accepter(this);
    }
}
