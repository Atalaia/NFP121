package tp6.question2;

import java.io.*;
import org.jdom.Element;
import java.util.*;
import tp6.question1.VisiteurExpression;

public class VisiteurBoolJDOM extends VisiteurExpressionBooleenne<Element> {

    private VisiteurExpression<Element> ve;

    public VisiteurBoolJDOM(VisiteurExpression<Element> ve) {
        this.ve = ve;
    }

    public Element visite(Vrai v){
        return new Element("Vrai");
    }
    
    public Element visite(Faux f){
        return new Element("Faux");
    }
    
    public Element visite(Non n){
        Element e = new Element("Non");
        e.setContent(n.bop().accepter(this));
        return e;
    }
    
    public Element visite(Ou ou){
        Element e = new Element("Ou");
        List content = new ArrayList<>();
        content.add(ou.bop1().accepter(this));
        content.add(ou.bop2().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Et et) {
        Element e = new Element("Et");
        List content = new ArrayList<>();
        content.add(et.bop1().accepter(this));
        content.add(et.bop2().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Sup sup) {
        Element e = new Element("Sup");
        List content = new ArrayList<>();
        content.add(sup.op1().accepter(ve));
        content.add(sup.op2().accepter(ve));
        e.setContent(content);
        return e;
    }

    public Element visite(Egal eg) {
        Element e = new Element("Egal");
        List content = new ArrayList<>();
        content.add(eg.op1().accepter(ve));
        content.add(eg.op2().accepter(ve));
        e.setContent(content);
        return e;
    }

    public Element visite(Inf inf) {
        Element e = new Element("Inf");
        List content = new ArrayList<>();
        content.add(inf.op1().accepter(ve));
        content.add(inf.op2().accepter(ve));
        e.setContent(content);
        return e;
    }
}
