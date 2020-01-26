package compositeEtVisiteur;



public abstract class Composant{
 
    public abstract String toString();
    
    public abstract <T> T accepter(Visiteur<T> v);
}
