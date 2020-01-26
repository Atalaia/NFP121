package question2;

import question1.*;

public class TestsDuVisiteurBoolEvaluation extends junit.framework.TestCase {

    protected Contexte m;
    protected VisiteurExpressionBooleenne<Boolean> veb;

    public void setUp() {
        m = new Memoire();
        veb = new VisiteurBoolEvaluation(new VisiteurEvaluation(m));
    }

    public void testVisiteurBoolEvaluation() {
        assertTrue(new Vrai().accepter(veb));
        assertFalse(new Faux().accepter(veb));
        assertTrue(new Sup(new Constante(5), new Constante(3)).accepter(veb));

        assertFalse("(5 > 8)", new Sup(new Constante(5), new Constante(8)).accepter(veb));
        assertTrue("((5 + 3) == 8)", new Egal(new Addition(new Constante(5), new Constante(3)), new Constante(8)).accepter(veb));
        assertTrue("(1 < 2)", new Inf(new Constante(1), new Constante(2)).accepter(veb));
    }

}
