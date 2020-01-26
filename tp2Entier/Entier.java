
/**
 * Write a description of class Entier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entier
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Entier
     */ 
    public Entier(int x)
    {
        //initialisation des variables d'instance
        this.x = x;
    }

    //principe de l'encapsulation
    public int getX()
    {
        return this.x;
    }
    
    public int getValeur()
    {
        return getX();
    }
    
    public void dec()
    {
        this.x = this.x-1;
        //this.x--;
    }
    
    public void inc()
    {
        x++;
    }
    
    public boolean equals(Entier e)
    {
        return this.x == e.getValeur();
    }
    
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Entier)) return false;
        Entier monEntier = (Entier) obj;
        return this.getValeur() == monEntier.getValeur();
    }
    
    public int hashCode()
    {
        return this.getValeur();
    }
    
    public static Entier parseEntier(String s) throws NumberFormatException
    {
       int val = s.parseInt();
       Entier montEntier = new Entier(val);
       return monEntier;
    }
}
