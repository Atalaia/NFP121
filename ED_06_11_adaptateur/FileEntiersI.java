
public interface FileEntiersI {
  
//opérations
  public void enfiler(int i) throws FilePleineException;
  public int defiler() throws FileVideException;

// interrogations
  public int taille();
  public int capacite();
  public boolean estVide();
  public boolean estPleine();
}