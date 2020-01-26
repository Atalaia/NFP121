package question4;

import java.io.InputStream;
import java.io.IOException;
import java.io.FilterInputStream;

/**
 * Cette classe "décore" un fichier (InputSream) par la conversion de tous
 * les caractères Minuscule en Majuscule
 * @author (votre nom) 
 * @version (un numéro de version ou une date)
 */
public class UpperCaseInputStream extends FilterInputStream { 

    public UpperCaseInputStream(InputStream in){
        super(in);
    }

    /**
     * Redefinition de read() methode qui met en majuscule.
     * @return le caractère en majuscule
     */
    public int read() throws IOException{
        int c = super.read();
        if(c != -1){
            return Character.toUpperCase((char)c);
        } else {
            return c;
        }
    }

    /**
     * Redefinition de read().
     * @return le caractère en maj avec PushBackInputStream
     */
    public int read(byte[] b, int off, int len) throws IOException{
        int c = super.read(b, off, len);
        for(int i = off; i < off+c; i++){
            b[i] = (byte)Character.toUpperCase((char)b[i]);
        }
        return c;
    }
}