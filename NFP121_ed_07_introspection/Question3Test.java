import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Question3Test extends junit.framework.TestCase{
  
  public static class PriseFactice implements Plug{
    private static int nombre;
    public void RCA(){
       nombre++;
    }
    public static int getNombre(){
      return nombre;
    }
  }
  
  public void testNouvellePriseRCA(){
    try{
      PrintWriter writer = new PrintWriter("configTest.txt", "UTF-8");
      writer.println("classe_adaptateur=Adaptateur");
      writer.println("classe_a_adapter=Question3Test$PriseFactice");
      writer.close();
    }catch (Exception e) {
      fail(e.getMessage());
    }
    try{
      Prise prise = (Prise)Configuration.genererAdaptateur("configTest.txt");
      assertNotNull(prise);
      prise.peritel();
      assertEquals(1, PriseFactice.getNombre());
    }catch(Exception e) {
      fail(e.getMessage());
    }
  }
}
