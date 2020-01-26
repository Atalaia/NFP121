
/**
 * Write a description of class Adaptateur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Adaptateur implements FileEntiersI
{
    ///Buffer f non
    CollectionI adapté;
    
    public Adaptateur(CollectionI adapté)
    {
        this.adapté = adapté;
    }
    
    public void enfiler(int i) throws FilePleineException,FullException
    {
        adapté.put(i);
    }
    
    public int defiler() throws FileVideException
    {
        return adapté.get();
    }
    
    //interrogations
    public int taille(){
        return adapté.size();
    }
    
    public int capacite(){
        return adapté.capacity();
    }
    
    public boolean estVide(){
        return adapté.empty();
    }
    
    public boolean estPleine(){
        return adapté.full();
    }
}
