package tp6.question3;

import org.jdom.Element;

import tp6.question1.Contexte;
import tp6.question1.VisiteurExpression;
import tp6.question2.VisiteurExpressionBooleenne;
import java.util.*;

/**
 * Visiteur d'instruction, chaque classe concrète possède une implémentation de
 * la visite
 * 
 */
public class VisiteurInstJDOM extends VisiteurInstruction<Element> {

    private VisiteurExpression<Element> vi;
    private VisiteurExpressionBooleenne<Element> vb;

    /**
     * Création d'un visiteur d'instructions
     * 
     * @param vi
     *            le visiteur d'expressions arithmétiques
     * @param vb
     *            le visiteur d'expression booléennes
     */
    public VisiteurInstJDOM(VisiteurExpression<Element> vi,
    VisiteurExpressionBooleenne<Element> vb) {
        this.vi = vi;
        this.vb = vb;
    }

    /**
     * obtention du contexte,
     * 
     * @return le contexte ici de vi(le visiteur d'expression)
     */
    public Contexte contexte() {
        return this.vi.contexte();
    }

    public Element visite(Affectation a) {
        Element e = new Element("Affectation");
        List content = new ArrayList<>();
        content.add(a.v().accepter(vi));
        content.add(a.exp().accepter(vi));
        e.setContent(content);
        return e;
    }

    public Element visite(Sequence seq) {
        Element e = new Element("Sequence");
        List content = new ArrayList<>();
        content.add(seq.i1().accepter(this));
        content.add(seq.i2().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Selection sel) {
        Element e = new Element("Selection");
        List content = new ArrayList<>();
        content.add(sel.cond().accepter(vb));
        content.add(sel.i1().accepter(this));
        if (sel.i2() != null) {
            content.add(sel.i2().accepter(this));
        }
        e.setContent(content);
        return e;
    }

    public Element visite(TantQue tq) {
        Element e = new Element("TantQue");
        List content = new ArrayList<>();
        content.add(tq.cond().accepter(vb));
        content.add(tq.i1().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Pour pour) {
        Element e = new Element("Pour");
        List content = new ArrayList<>();
        content.add(pour.init().accepter(this));
        content.add(pour.cond().accepter(vb));
        content.add(pour.i1().accepter(this));
        content.add(pour.inc().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Afficher a) {
        Element e = new Element("Afficher");
        e.setContent(a.exp().accepter(vi));
        return e;
    }

    public Element visite(Assertion a) {
        Element e = new Element("Assertion");
        e.setContent(a.cond().accepter(vb));
        return e;
    }
}