package question2;

import java.io.*;
import question1.IProgr;
import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;
import org.jdom.*;
import org.jdom.output.*;
import org.jdom.input.*;

/**
 * Décrivez votre classe SerialiseDeserialiseAST_XML ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class SerialiseDeserialiseAST_XML {

    public static void serialAst2xml(IProgr p, String nomDuFichier) {
        try {
            Contexte ctx = p.getMem();
            VisiteurExpression<Element> ve = new VisiteurJDOM(ctx);
            VisiteurExpressionBooleenne<Element> vb = new VisiteurBoolJDOM(ve);
            VisiteurInstruction<Element> vi = new VisiteurInstJDOM(ve, vb);
            Element e = new Element("programme");
            e.setContent(p.getAST().accepter(vi));
            Document doc = new Document(e);
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

            sortie.output(doc, new FileOutputStream(nomDuFichier));
        } catch(Exception ex) { }
    }

    public static Element deserialXml(String nomDuFichier) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(nomDuFichier);
            return doc.getRootElement();
        } catch(Exception ex) { }
        return null;
    }
}