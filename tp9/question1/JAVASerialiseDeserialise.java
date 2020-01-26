package question1;



import java.io.*;

/**
 * Décrivez votre classe JAVASerialiseDeserialise ici.
 * 
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class JAVASerialiseDeserialise {
    public static void serialjava(IProgr p, String nomDuFichier){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nomDuFichier));
            os.writeObject(p);
            os.close();
        } catch(Exception ex) { }
    }

    public static IProgr deserialjava(String nomDuFichier){
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(nomDuFichier));
            return (IProgr)is.readObject();
        } catch(Exception ex) { }
        return null;
    }    
}
