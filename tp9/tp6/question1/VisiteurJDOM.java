package tp6.question1;

import java.io.*;

import org.jdom.Element;
import java.util.*;

public class VisiteurJDOM extends VisiteurParDefaut<Element> {

    private Contexte c;

    public VisiteurJDOM(Contexte c) {
        this.c = c;
    }

    public Contexte contexte() {
        return c;
    }
    
    public Element visite(Constante c){
       Element e = new Element("Constante");
       e.setText(String.valueOf(c.valeur()));
       return e;
    }
    
    public Element visite(Variable v){
        Element e = new Element("Variable");
        e.setText(v.nom());
        return e;
    }
    
    public Element visite(Division d) {
        Element e = new Element("Division");
        List content = new ArrayList<>();
        content.add(d.op1().accepter(this));
        content.add(d.op2().accepter(this));
        e.setContent(content);
        return e;
    }
    
    public Element visite(Addition a){
        Element e = new Element("Addition");
        List content = new ArrayList<>();
        content.add(a.op1().accepter(this));
        content.add(a.op2().accepter(this));
        e.setContent(content);
        return e;
    }
    
    public Element visite(Multiplication m) {
        Element e = new Element("Multiplication");
        List content = new ArrayList<>();
        content.add(m.op1().accepter(this));
        content.add(m.op2().accepter(this));
        e.setContent(content);
        return e;
    }

    public Element visite(Soustraction s) {
        Element e = new Element("Soustraction");
        List content = new ArrayList<>();
        content.add(s.op1().accepter(this));
        content.add(s.op2().accepter(this));
        e.setContent(content);
        return e;
    }
}
