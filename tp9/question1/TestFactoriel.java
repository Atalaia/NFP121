package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

import java.io.*;

public class TestFactoriel extends junit.framework.TestCase {

	private static int fact(int n) {
		if (n == 0)
			return 1;
		else
			return n * fact(n - 1);
	}

	public void testFactoriel() {
		try {
			AST_Fact p = new AST_Fact(10);
			Contexte m = p.getMem(); // récupération du contexte

			VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
			VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
			VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

			VisiteurExpression<String> ves = new VisiteurInfixe(m);
			VisiteurExpressionBooleenne<String> vbs = new VisiteurBoolToString(ves);
			VisiteurInstruction<String> vs = new VisiteurInstToString(ves, vbs);

			Instruction ast = p.getAST(); // récupération de l'AST
			ast.accepter(vi); // évaluation proprement dite de l'AST

			assertTrue((String) ast.accepter(vs) + " ne donne pas le résultat attendu ...",	m.lire("fact") == fact(10));

		} catch (Exception e) {
			fail("exception inattendue !!! : " + e.getMessage());
		}
	}
	
	public void test_AST_Mult1() {
        try {
            AST_Mult1 p = new AST_Mult1(10, 50);
            Contexte m = p.getMem();

            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            ast.accepter(vi);

            assertTrue((String) ast.accepter(vs) + " ne donne pas le rÃ©sultat attendu ...", m.lire("produit") == 500);

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }
    
    public void test_AST_Mult2() {
        try {
            AST_Mult2 p = new AST_Mult2(7, 85);
            Contexte m = p.getMem();

            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            ast.accepter(vi);

            assertTrue((String) ast.accepter(vs) + " ne donne pas le rÃ©sultat attendu ...", m.lire("produit") == 595);

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }
    
    public void test_AST_SOM_F() {
        try {
            AST_SOM_F p = new AST_SOM_F(100);
            Contexte m = p.getMem();

            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            ast.accepter(vi);

            assertTrue((String) ast.accepter(vs) + " ne donne pas le rÃ©sultat attendu ...", m.lire("som") == 4950);

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }
    
    public void test_AST_SOM_W() {
        try {
            AST_SOM_W p = new AST_SOM_W(100);
            Contexte m = p.getMem();

            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            VisiteurExpression ves = new VisiteurInfixe(m);
            VisiteurExpressionBooleenne vbs = new VisiteurBoolToString(ves);
            VisiteurInstruction vs = new VisiteurInstToString(ves, vbs);

            Instruction ast = p.getAST();
            ast.accepter(vi);

            assertTrue((String) ast.accepter(vs) + " ne donne pas le rÃ©sultat attendu ...", m.lire("som") == 5050);

        } catch (Exception e) {
            fail("exception inattendue !!! : " + e.getMessage());
        }
    }
	
}
