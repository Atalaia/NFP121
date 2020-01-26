package question1;

/**
 * Cette classe permet de parcourir un arbre d'expressions et 
 * de retourner les valeurs totales de ses expressions.
 */

public class VisiteurEvaluation extends VisiteurParDefaut<Integer> {

    private Contexte c; //réprésente la mémoire

    /**
     * constructeur de VisiteurEvaluation
     */
    public VisiteurEvaluation(Contexte c) {
        this.c = c;
    }

    /**
     * Méthode de visite d'une constante c
     * @param une constante 
     * @return la valeur de cette Constante
     */
    public Integer visite(Constante c) {
	return c.valeur();
    }
    
     /**
     * Méthode de visite d'une variable v
     * @param une variable
     * @return la valeur de cette Variable
     */
    public Integer visite(Variable v) {
	return this.c.lire(v.nom());
    }

    /**
     * Méthode de visite d'une Addition a
     * @param une addition
     * @return la valeur de cette Addition
     */
    public Integer visite(Addition a) {
	return a.op1().accepter(this) + a.op2().accepter(this);
    }
    
    /**
     * Méthode de visite d'une Soustraction s
     * @param une soustraction
     * @return la valeur de cette Soustraction
     */
    public Integer visite(Soustraction s) {
	return s.op1().accepter(this) - s.op2().accepter(this);
    }
    
    /**
     * Méthode de visite d'une Multiplication m
     * @param une multiplication
     * @return la valeur de cette Multiplication
     */
    public Integer visite(Multiplication m) {
	return m.op1().accepter(this) * m.op2().accepter(this);
    }
    
    /**
     * Méthode de visite d'une Division d
     * @param une division
     * @return la valeur de cette Division
     */
    public Integer visite(Division d) {
	return d.op1().accepter(this) / d.op2().accepter(this);
    }
    
    /**
     * Getter du contexte de ce visiteur
     * @return Contexte du visiteur
     */
    public Contexte contexte() {
        return c;
    }

}
