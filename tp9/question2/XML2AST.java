package question2;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;
import java.util.*;
import java.util.stream.*;
import org.jdom.*;

/**
 * Décrivez votre classe XML2AST ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class XML2AST {

    public static Instruction xmlInst2ast(Contexte m, Element element) {
        List<Element> children = getChildren(element.getContent());
        return parseInstruction(m, children.get(0));
    }

    private static List<Element> getChildren(List<Content> content) {
        return content.stream().filter(e -> e instanceof Element).map(e -> (Element)e).collect(Collectors.toList());
    }

    private static Expression parseExpression(Contexte ctx, Element e) {
        switch (e.getName()) {
            case "Constante":
            return parseConstante(ctx, e);
            case "Variable":
            return parseVariable(ctx, e);
            case "Addition":
            return parseAddition(ctx, e);
            case "Soustraction":
            return parseSoustraction(ctx, e);
            case "Division":
            return parseDivision(ctx, e);
            case "Multiplication":
            return parseMultiplication(ctx, e);
            default:
            return null;
        }
    }

    private static Constante parseConstante(Contexte ctx, Element e) {
        return new Constante(Integer.parseInt(e.getText()));
    }

    private static Variable parseVariable(Contexte ctx, Element e) {
        return new Variable(ctx, e.getText());
    }

    private static Addition parseAddition(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Addition(exp1, exp2);
    }

    private static Soustraction parseSoustraction(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Soustraction(exp1, exp2);
    }

    private static Division parseDivision(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Division(exp1, exp2);
    }

    private static Multiplication parseMultiplication(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Multiplication(exp1, exp2);
    }

    private static ExpressionBooleenne parseExpressionBooleene(Contexte ctx, Element e) {
        switch (e.getName()) {
            case "Vrai":
            return parseVrai(ctx, e);
            case "Faux":
            return parseFaux(ctx, e);
            case "Non":
            return parseNon(ctx, e);
            case "Ou":
            return parseOu(ctx, e);
            case "Et":
            return parseEt(ctx, e);
            case "Inf":
            return parseInf(ctx, e);
            case "Egal":
            return parseEgal(ctx, e);
            case "Sup":
            return parseSup(ctx, e);
            default:
            return null;
        }
    }

    private static Vrai parseVrai(Contexte ctx, Element e) {
        return new Vrai();
    }

    private static Faux parseFaux(Contexte ctx, Element e) {
        return new Faux();
    }

    private static Non parseNon(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne exp = parseExpressionBooleene(ctx, children.get(0));
        return new Non(exp);
    }

    private static Ou parseOu(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne exp1 = parseExpressionBooleene(ctx, children.get(0));
        ExpressionBooleenne exp2 = parseExpressionBooleene(ctx, children.get(1));
        return new Ou(exp1, exp2);
    }

    private static Et parseEt(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne exp1 = parseExpressionBooleene(ctx, children.get(0));
        ExpressionBooleenne exp2 = parseExpressionBooleene(ctx, children.get(1));
        return new Et(exp1, exp2);
    }

    private static Inf parseInf(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Inf(exp1, exp2);
    }

    private static Egal parseEgal(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Egal(exp1, exp2);
    }

    private static Sup parseSup(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp1 = parseExpression(ctx, children.get(0));
        Expression exp2 = parseExpression(ctx, children.get(1));
        return new Sup(exp1, exp2);
    }

    private static Instruction parseInstruction(Contexte ctx, Element e) {
        switch (e.getName()) {
            case "Affectation":
            return parseAffectation(ctx, e);
            case "Sequence":
            return parseSequence(ctx, e);
            case "Selection":
            return parseSelection(ctx, e);
            case "TantQue":
            return parseTantQue(ctx, e);
            case "Pour":
            return parsePour(ctx, e);
            case "Afficher":
            return parseAfficher(ctx, e);
            case "Assertion":
            return parseAssertion(ctx, e);
            default:
            return null;
        }
    }

    private static Affectation parseAffectation(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Variable v = parseVariable(ctx, children.get(0));
        Expression exp = parseExpression(ctx, children.get(1));
        return new Affectation(v, exp);
    }

    private static Sequence parseSequence(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Instruction i1 = parseInstruction(ctx, children.get(0));
        Instruction i2 = parseInstruction(ctx, children.get(1));
        return new Sequence(i1, i2);
    }

    private static Selection parseSelection(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne cond = parseExpressionBooleene(ctx, children.get(0));
        Instruction i1 = parseInstruction(ctx, children.get(1));
        if (children.size() == 3) {
            return new Selection(cond, i1, parseInstruction(ctx, children.get(2)));
        }
        return new Selection(cond, i1);
    }

    private static TantQue parseTantQue(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne cond = parseExpressionBooleene(ctx, children.get(0));
        Instruction i = parseInstruction(ctx, children.get(1));
        return new TantQue(cond, i);
    }

    private static Pour parsePour(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Instruction init = parseInstruction(ctx, children.get(0));
        ExpressionBooleenne cond = parseExpressionBooleene(ctx, children.get(1));        
        Instruction i = parseInstruction(ctx, children.get(2));
        Instruction inc = parseInstruction(ctx, children.get(3));
        return new Pour(init, cond, i, inc);
    }
    
    private static Afficher parseAfficher(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        Expression exp = parseExpression(ctx, children.get(0));
        return new Afficher(exp);
    }
    
    private static Assertion parseAssertion(Contexte ctx, Element e) {
        List<Element> children = getChildren(e.getContent());
        ExpressionBooleenne exp = parseExpressionBooleene(ctx, children.get(0));
        return new Assertion(exp);
    }
}
