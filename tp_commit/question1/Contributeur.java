package question1;

public class Contributeur extends Cotisant{
  private int solde;
  
  /**
   * Constructeur de Contributeur (leaf du Composite)
   * @param nom contributeu
   * @param somme de départ du contributeur (non négative)
   */
  public Contributeur(String nom, int somme){
    super(nom);
    if(somme >= 0){
    this.solde = somme;
    } else { throw new RuntimeException("nombre négatif !!");}
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){
    return 1;
  }
  
  /**
   * méthode pour débiter la somme indiquée en paramètre seulement si celle-ci 
   * est positive et inférieur au solde du contributeur. Sinon on lève
   * une exception dans les deux cas
   * @throws SoldeDebiteurException
   * @param somme à débiter
   */
    public void debit(int somme) throws SoldeDebiteurException{
        if(somme > solde){
            throw new SoldeDebiteurException();
        } else if (somme < 0){
            throw new RuntimeException("nombre négatif !!");
        } else {
            this.solde -= somme;
        }
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     * @param somme à créditer
     */
  public  void credit(int somme){
      if (somme < 0) {
          throw new RuntimeException("nombre négatif !!");
        } else {
            this.solde += somme;
        }
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre négatif !!!");
     */
  public void affecterSolde(int somme){
    if(somme <0) throw new RuntimeException("nombre négatif !!!");
    
    try{
      debit(solde()); 
      credit(somme);// mode élégant ... 
    }catch(SoldeDebiteurException sde){ 
      // exception peu probable
      this.solde = somme; // mode efficace ...
    }
  }
  
  public <T> T accepter(Visiteur<T> visiteur){
    return visiteur.visite(this);
  }
  
  public String toString(){
    return "<Contributeur : " + nom + "," + solde + ">";
  }

}
