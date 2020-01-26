import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class Question1Test extends junit.framework.TestCase{

  
  
  public void testAfficherLesMethodesPubliquesLocalesEtHeritees(){
    List<Method> list = Question1.obtenirLesMethodesPubliquesLocalesEtHeritees(Entier.class);
    List<Method> expected = Arrays.asList(Entier.class.getMethods());
    assertEquals(expected.size(),list.size());
    for(Method m : expected){
      assertTrue(list.contains(m));
    }
    for(Method m : list){
      assertTrue(expected.contains(m));
    }
  }

  
  //--------------- méthodes utilitaires ----------------
  /** Obtention de l'affichage produit par l'exécution de la méthode main d'une classe.
   * @param className le nom de la classe
   * @param methodName le nom de la méthode
   * @param args les arguments de la méthode
   * @return le texte en tableau de lignes
   * @throws une exception est levée si la classe est inconnue
   */
  public static Object execStatic(String className, String methodName, Object... args) throws Exception{
    Object res = null;
    try{
      Class<?> c = Class.forName(className);
      Class<?>[] classes = new Class<?>[args.length]; 
      for(int i = 0; i<args.length; i++){
        classes[i] = args[i].getClass();
      }
      res = c.getMethod(methodName,classes).invoke(null, args);
    }catch(Exception e){
      e.printStackTrace();
    }
    return res;
  }
}
