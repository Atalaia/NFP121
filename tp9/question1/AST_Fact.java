package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_Fact ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_Fact extends AST_Progr implements java.io.Serializable {

    /*
     * construire l'AST du programme "WhileL style" est à construire ci dessous
     * xxx:=n ; fact := 1 ; while (~(xxx=0) ) do fact := fact * xxx ; xxx:=
     * xxx-1; ftp; afficher(fact); remarque : on calcule ici fact(n) i.e. n est
     * une donnée fournie au moment de l'exécution, d'où le constructeur suivant
     */
    
   // xxx := n; 
   // fact := 1;  
   // while (~(xxx=0)) do 
   // fact := fact * xxx ; xxx := xxx - 1;  
   // ftp;

    private Contexte m;
    private Instruction ast;

    public AST_Fact(int n1) {
        m = new Memoire();

        Variable n = new Variable(m, "n", n1);
        Variable fact = new Variable(m, "fact", 0);

        ast = new Sequence(
            new Affectation(fact, new Constante(1)),
            new Sequence(
                new TantQue(new Non(new Egal(n, new Constante(0))), new Sequence(
                        new Affectation(fact, new Multiplication(fact, n)),
                        new Affectation(n, new Soustraction(n, new Constante(1))))),
                new Afficher(fact)));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
