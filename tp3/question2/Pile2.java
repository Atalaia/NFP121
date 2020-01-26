package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par d�l�gation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacit� de la pile */
    private int capacite;

    /**
     * Cr�ation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit �tre > 0
     */
    public Pile2(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk.empty();
    }

    /**
     * Effectue un test de l'�tat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.stk.size() == this.capacite;

    }

    /**
     * Retourne une repr�sentation en String d'une pile, contenant la
     * repr�sentation en String de chaque �l�ment.
     * 
     * @return une repr�sentation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for(int i = this.stk.size()-1; i>=0; i--){
            s+= this.stk.get(i).toString();
            if(i >0){
                s+= ",";
            }       
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 p1 = (Pile2)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i= stk.size()-1; i>=0 ; i--){
                Object temp = this.stk.get(i);
                boolean existe = false;
                for(int j = this.stk.size() - 1; j >= 0; j--){
                    if((temp == p1.stk.get(i))){
                        existe = true;
                    }
                }
                if(existe){
                    estEgale = true;
                } else{
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'�l�ment d'une pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int taille() {
        return this.stk.size();
    }

    /**
     * Retourne la capacit� de cette pile.
     * 
     * @return le nombre d'�l�ment
     */
    public int capacite() {
        return this.capacite;
    }

} // Pile2.java
