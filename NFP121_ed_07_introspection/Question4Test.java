import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Question4Test extends junit.framework.TestCase{

  
  
  public void testVisiteurNombre(){
    Expression n = new Nombre(33);
    Visiteur<String> v = new VisiteurString();
    assertEquals("33", n.accepter(v));
  }
  
  public void testVisiteurAddition(){
    Expression a = new Addition(new Nombre(33),new Nombre(2));
    Visiteur<String> v = new VisiteurStringAvecAddition();
    assertEquals("(33 + 2)", a.accepter(v));
  }

  
 
}
