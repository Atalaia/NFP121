package question1;

import tp6.question1.*;
import tp6.question2.*;
import tp6.question3.*;

public class TestDesSer extends junit.framework.TestCase {

	public void testSimple() {
		try {
			question1.JAVASerialiseDeserialise.serialjava(new AST_Aff(), "test.ser");

			question1.AST_Aff p = (question1.AST_Aff) question1.JAVASerialiseDeserialise.deserialjava("test.ser");
			assertNotNull(p);

			Contexte m = new Memoire();
			VisiteurExpression<Integer> ve = new VisiteurEvaluation(m);
			VisiteurExpressionBooleenne<Boolean> vb = new VisiteurBoolEvaluation(ve);
			VisiteurInstruction<Contexte> vi = new VisiteurInstEvaluation(ve, vb);

			Instruction ast = p.getAST(); // récupération de l'AST
			ast.accepter(vi); // évaluation proprement dite de l'AST
			assertTrue(" ce n'est pas le résultat attendu ...", m.lire("y") == 12);
		} catch (Exception e) {
			fail("exception inattendue : " + e.getMessage());
		}
	}
	
	private static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return n * fact(n - 1);
    }
    
    public void test_AST_Fact() {
        try {
            JAVASerialiseDeserialise.serialjava(new AST_Fact(10), "test.ser");

            AST_Fact fact = (AST_Fact)JAVASerialiseDeserialise.deserialjava("test.ser");
            assertNotNull(fact);

            Contexte m = fact.getMem();
            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            Instruction ast = fact.getAST();
            ast.accepter(vi);
            assertEquals((int)m.lire("fact"), fact(10));
        } catch (Exception e) {
            fail("exception inattendue : " + e.getMessage());
        }
    }
    
    public void test_AST_Mult1() {
        try {
            JAVASerialiseDeserialise.serialjava(new AST_Mult1(10, 50), "test.ser");

            AST_Mult1 mult = (AST_Mult1)JAVASerialiseDeserialise.deserialjava("test.ser");
            assertNotNull(mult);

            Contexte m = mult.getMem();
            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            Instruction ast = mult.getAST();
            ast.accepter(vi);
            assertEquals((int)m.lire("produit"), 500);
        } catch (Exception e) {
            fail("exception inattendue : " + e.getMessage());
        }
    }
    
    public void test_AST_Mult2() {
        try {
            JAVASerialiseDeserialise.serialjava(new AST_Mult2(7, 85), "test.ser");

            AST_Mult2 mult = (AST_Mult2)JAVASerialiseDeserialise.deserialjava("test.ser");
            assertNotNull(mult);

            Contexte m = mult.getMem();
            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            Instruction ast = mult.getAST();
            ast.accepter(vi);
            assertEquals((int)m.lire("produit"), 595);
        } catch (Exception e) {
            fail("exception inattendue : " + e.getMessage());
        }
    }
    
    public void test_AST_SOM_F() {
        try {
            JAVASerialiseDeserialise.serialjava(new AST_SOM_F(100), "test.ser");

            AST_SOM_F som = (AST_SOM_F)JAVASerialiseDeserialise.deserialjava("test.ser");
            assertNotNull(som);

            Contexte m = som.getMem();
            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            Instruction ast = som.getAST();
            ast.accepter(vi);
            assertEquals((int)m.lire("som"), 4950);
        } catch (Exception e) {
            fail("exception inattendue : " + e.getMessage());
        }
    }
    
    public void test_AST_SOM_W() {
        try {
            JAVASerialiseDeserialise.serialjava(new AST_SOM_W(100), "test.ser");

            AST_SOM_W som = (AST_SOM_W)JAVASerialiseDeserialise.deserialjava("test.ser");
            assertNotNull(som);

            Contexte m = som.getMem();
            VisiteurExpression ve = new VisiteurEvaluation(m);
            VisiteurExpressionBooleenne vb = new VisiteurBoolEvaluation(ve);
            VisiteurInstruction vi = new VisiteurInstEvaluation(ve, vb);

            Instruction ast = som.getAST();
            ast.accepter(vi);
            assertEquals((int)m.lire("som"), 5050);
        } catch (Exception e) {
            fail("exception inattendue : " + e.getMessage());
        }
    }
}
