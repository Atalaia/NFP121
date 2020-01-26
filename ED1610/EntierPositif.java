
/**
 * Write a description of class EntierPositif here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EntierPositif extends Entier
{
    
   public EntierPositif(int valeur) throws EntierPositifException
   {
       /*super(valeur); //appel le constructeur de la classe mère Entier
 
       //si la valeur est négative
       if(this.getValeur() < 0) 
       this.setValeur(-1 * getValeur());
       */
      super(valeur);
      if(this.getValeur()<0)
      throw new EntierPositifException("Valeur négative");
    }
    
}
