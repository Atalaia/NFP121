package question1;

public class Contributeur extends Cotisant{
  private int solde;
  
  /**
   * Constructeur de Contributeur (leaf du Composite)
   * @param nom contributeu
   * @param somme de d�part du contributeur (non n�gative)
   */
  public Contributeur(String nom, int somme){
    super(nom);
    if(somme >= 0){
    this.solde = somme;
    } else { throw new RuntimeException("nombre n�gatif !!");}
  }
  
  public int solde(){
    return this.solde;
  }
  
  public int nombreDeCotisants(){
    return 1;
  }
  
  /**
   * m�thode pour d�biter la somme indiqu�e en param�tre seulement si celle-ci 
   * est positive et inf�rieur au solde du contributeur. Sinon on l�ve
   * une exception dans les deux cas
   * @throws SoldeDebiteurException
   * @param somme � d�biter
   */
    public void debit(int somme) throws SoldeDebiteurException{
        if(somme > solde){
            throw new SoldeDebiteurException();
        } else if (somme < 0){
            throw new RuntimeException("nombre n�gatif !!");
        } else {
            this.solde -= somme;
        }
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n�gatif !!!");
     * @param somme � cr�diter
     */
  public  void credit(int somme){
      if (somme < 0) {
          throw new RuntimeException("nombre n�gatif !!");
        } else {
            this.solde += somme;
        }
    }
    
    /**
     * throws RuntimeException new RuntimeException("nombre n�gatif !!!");
     */
  public void affecterSolde(int somme){
    if(somme <0) throw new RuntimeException("nombre n�gatif !!!");
    
    try{
      debit(solde()); 
      credit(somme);// mode �l�gant ... 
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
