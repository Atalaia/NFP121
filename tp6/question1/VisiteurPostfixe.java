package question1;

public class VisiteurPostfixe extends VisiteurParDefaut<String> {

    private Contexte c;

    public VisiteurPostfixe(Contexte c) {
        this.c = c;
    }

    public String visite(Constante c) {
        return Integer.toString(c.valeur());
    }

    public String visite(Variable v) {
        return Integer.toString(c.lire(v.nom()));
    }

    public String visite(Division d) {
        return "(" + d.op2().accepter(this) + "," + d.op1().accepter(this)
        + ")" + "/";
    }

    public String visite(Addition a) {
        return "(" + a.op1().accepter(this) + "," + a.op2().accepter(this)
        + ")" + "+";
    }

    public String visite(Multiplication m) {
        return "(" + m.op2().accepter(this) + "," + m.op1().accepter(this)
        + ")"  + "*";
    }

    public String visite(Soustraction s) {
        return "(" + s.op2().accepter(this) + "," + s.op1().accepter(this)
        + ")" + "-";
    }

    public Contexte contexte() {
        return c;
    }

}
