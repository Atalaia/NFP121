package question1;

public class TestsACompleter extends junit.framework.TestCase{
    private Memoire m;
    private Variable i,j;
    private VisiteurExpression<Integer> ve;
    private VisiteurExpression<String>  vp,vi;

    public void setUp(){
        m  = new Memoire();
        i  = new Variable(m,"i",3);
        j = new Variable(m,"j",5);
        ve = new VisiteurEvaluation( m);
        vi = new VisiteurInfixe( m);
        vp = new VisiteurPostfixe( m);
        assertNotNull(i);assertNotNull(j);
        assertNotNull(ve);assertNotNull(vp);assertNotNull(vi);
    }

    public void testUneAddition(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals(" 3+2 != 5 ?, curieux ",5,expr.accepter(ve).intValue());
    }

    public void testMultiplication(){
        Expression expr = new Multiplication(new Constante(3), new Constante(2));
        assertEquals(" 3 * 2 != 6 ?, curieux ",6,expr.accepter(ve).intValue());
    }

    public void testSoustraction(){
        Expression expr = new Soustraction(new Constante(3), new Constante(2));
        assertEquals(" 3 - 2 != 1 ?, curieux ",1,expr.accepter(ve).intValue());
    }

    public void testDivision(){
        Expression expr = new Division(new Constante(6), new Constante(2));
        assertEquals(" 6/2 != 3 ?, curieux ",3,expr.accepter(ve).intValue());

        try{
            new Division(i,new Constante(0)).accepter(ve);
            fail("division par zéro ? possible ");
        }catch(ArithmeticException ae){
        }
    }

    public void testVisiteurInfixe(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals("(3 + 2) est attendu ","(3 + 2)",expr.accepter(vi));
        expr = new Addition(expr, new Constante(2));
        assertEquals("((3 + 2) + 2) est attendu ", "((3 + 2) + 2)", expr.accepter(vi));
        assertEquals("{i=3, j=5}",m.toString());
        expr = new Soustraction(expr, expr);
        assertEquals("(((3 + 2) + 2) - ((3 + 2) + 2))", expr.accepter(vi));
        expr = new Multiplication(expr, expr);
        assertEquals("((((3 + 2) + 2) - ((3 + 2) + 2)) * (((3 + 2) + 2) - ((3 + 2) + 2)))", 
            expr.accepter(vi));
        Expression expr2 = new Division(new Constante(15), new Constante(5));
        assertEquals("(15 / 5) est attendu ","(15 / 5)", expr2.accepter(vi));
    }

    public void testVisiteurPostfixe(){
        Expression expr = new Addition(new Constante(3), new Constante(2));
        assertEquals("(3,2)+",expr.accepter(vp));
        expr = new Addition(expr, new Constante(2));
        assertEquals("((3,2)+,2)+",expr.accepter(vp));
        assertEquals("{i=3, j=5}", m.toString());
        expr = new Soustraction(expr, expr);
        assertEquals("(((3,2)+,2)+,((3,2)+,2)+)-", expr.accepter(vp));
        expr = new Multiplication(new Constante(5), new Constante(3));
        assertEquals("(3,5)*", expr.accepter(vp));
        Expression expr2 = new Division(new Constante(15), new Constante(5));
        assertEquals("(5,15)/", expr2.accepter(vp));
    }

}
