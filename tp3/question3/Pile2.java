package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par delegation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacite de la pile */
    private int capacite;

    /** Creation d'une pile.
     * @param taille la "taille maximale" de la pile, doit etre > 0
     */
    public Pile2(int taille){
        if(taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
    }

    public Pile2(){
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if(estPleine())
            throw new PilePleineException();
        this.stk.push(o);
    }

    public T depiler() throws PileVideException{
        if(estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public T sommet() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return this.stk.peek();
    }

    public int capacite(){
        return this.capacite;
    }

    public int taille(){
        return this.stk.size();
    }

    public boolean estVide(){
        return this.stk.empty();
    }

    public boolean estPleine(){
        return this.stk.size() == this.capacite;
    }

    public boolean equals(Object o) { 
        if (o instanceof PileI) { 
            PileI p = (PileI) o; 
            return this.capacite() == p.capacite() 
            && this.hashCode() == p.hashCode(); 
        } else 
            return false; 
    }

    public int hashCode(){
        return toString().hashCode();
    }

    public String toString(){
        String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
            s+= this.stk.get(i).toString();
            if(i >0){
                s+= ", ";
            }       
        }
        return s + "]"; 
    }

} // Pile2