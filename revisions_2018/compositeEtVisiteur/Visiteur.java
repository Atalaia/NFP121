package compositeEtVisiteur;



public abstract class Visiteur<T>{

    public abstract T visiteFeuille(Feuille feuille);
    
    public abstract T visiteConteneur(Conteneur conteneur);
}
