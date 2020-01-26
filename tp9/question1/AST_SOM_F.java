package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

/**
 * Décrivez votre classe AST_SOM_F ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class AST_SOM_F extends AST_Progr implements java.io.Serializable {
    /*
     * n=100; som = 0 ; for(i=0 ; i<n ; i++){ (n> 0) { som := som+i ; }
     * afficher(som);
     */

    // som := 0; 
    // for (i = 0; i < n; i++) { (n> 0) { 
    // som := som + i; 
    // }
    
    private Contexte m;
    private Instruction ast = null;

    public AST_SOM_F(int n1) {
        m = new Memoire();

        Variable n = new Variable(m, "n", n1);
        Variable som = new Variable(m, "som", 0);
        Variable i = new Variable(m, "i", 0);
        
        ast = new Sequence(
            new Pour(
                new Affectation(i, new Constante(0)), 
                new Inf(i, n), 
                new Selection(new Sup(n, new Constante(0)), new Affectation(som, new Addition(som, i))), 
                new Affectation(i, new Addition(i, new Constante(1)))),
            new Afficher(som));
    }

    public Contexte getMem() {
        return m;
    }

    public Instruction getAST() {
        return ast;
    }

}
