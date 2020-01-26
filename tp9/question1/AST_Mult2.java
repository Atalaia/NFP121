package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_Mult2 ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_Mult2 extends AST_Progr implements java.io.Serializable {
    /*
     * a := 7 ; b := 85 ; produit := 0 ; m1:=a ; m2:=b; while (m2 > 0) do if
     * (m2/2*2)=m2 then m1:= m1*2 ; m2 := m2/2;end produit := produit + m1 ;
     * m2:=m2-1; end afficher(produit);
     */

    // produit := 0; 
    // while (m2 > 0) do 
    // if (m2 / 2 * 2) = m2 then 
    // m1 := m1 * 2; 
    // m2 := m2 / 2; 
    // fi; 
    // produit  := produit  + m1 ; m2 := m2 - 1; 
    // ftp;
    
    private Contexte m;
    private Instruction ast = null;

    public AST_Mult2(int n1, int n2) {
        m = new Memoire();

        Variable a = new Variable(m, "a", n1);
        Variable b = new Variable(m, "b", n2);
        Variable produit = new Variable(m, "produit", 0);
        Variable m1 = new Variable(m, "m1", 0);
        Variable m2 = new Variable(m, "m2", 0);
        
        ast = new Sequence(
            new Sequence(
                new Affectation(m1, a),
                new Affectation(m2, b)),
            new Sequence(
                new TantQue(
                    new Sup(m2, new Constante(0)),
                    new Sequence(
                        new Selection(
                            new Egal(new Multiplication(new Division(m2, new Constante(2)), new Constante(2)), m2),
                            new Sequence(
                                new Affectation(m1, new Multiplication(m1, new Constante(2))),
                                new Affectation(m2, new Division(m2, new Constante(2))))),
                        new Sequence(
                            new Affectation(produit, new Addition(produit, m1)),
                            new Affectation(m2, new Soustraction(m2, new Constante(1)))))),
                new Afficher(produit)));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
