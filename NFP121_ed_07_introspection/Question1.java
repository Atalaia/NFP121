

import java.lang.reflect.*;
import java.util.*;

public class Question1{
  
  public static void main(String[] args){
    try{
      Class<?> cl = Class.forName(args[0]);
      // https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#forName(java.lang.String)
      List<Method> l = null;
      l = obtenirLesMethodesPubliquesLocalesEtHeritees(cl);
      afficher("MethodesPubliquesLocalesEtHeritees",l);
      
      l = obtenirToutesLesMethodesAccessiblesDeCetteClasse(cl);
      afficher("ToutesLesMethodesAccessiblesDeCetteClasse",l);
      
      l = obtenirLesMethodesPubliquesRedefiniesLocalement(cl);
      afficher("LesMethodesRedefiniesLocalement",l);
      
      
    }catch(ExceptionInInitializerError e){
      System.out.println("Exception: the initialization provoked by this method fails");
    }catch(LinkageError e){
      System.out.println("Exception: the linkage fails");
    }catch(ClassNotFoundException e){
      System.out.println("Exception: the class cannot be located");
    }
  }
     
  private static void afficher(String titre, List<Method> list){
    System.out.println(titre);
    for( Method m : list){
       System.out.println(m.toGenericString());
    }
    System.out.println();
  }
  
  public static List<Method> obtenirLesMethodesPubliquesLocalesEtHeritees(Class<?> cl){
    return Arrays.asList(cl.getMethods());
  }
  
  public static List<Method> obtenirToutesLesMethodesAccessiblesDeCetteClasse(Class<?> cl){
    return Arrays.asList(cl.getDeclaredMethods());
  }
  
  public static List<Method> obtenirLesMethodesPubliquesRedefiniesLocalement(Class<?> cl){
    List<Method> listMethodsSuper = Arrays.asList(cl.getSuperclass().getMethods());
    List<Method> list = new ArrayList<Method>();
    for( Method m : cl.getDeclaredMethods()){
      if(m.getModifiers()==Modifier.PUBLIC)
        if(contient(listMethodsSuper,m)) // la liste contient m
          list.add(m);
    }
    return list;
  }
  

  
  // ------- methodes utilitaires, cf. extraites du web --------
  private static String methodName(){
    // http://stackoverflow.com/questions/4065518/java-how-to-get-the-caller-function-name
    StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
    StackTraceElement e = stacktrace[2];//maybe this number needs to be corrected
    return e.getMethodName();
  }
  
  private static boolean contient(List<Method> list, Method m){
    for( Method ms : list){
      if ((ms.getName().equals(m.getName())) && // meme nom
         // modifier compatible ? a voir
         //(m.getModifiers()==Modifier.PUBLIC) &&
         sameParameterType(ms,m) && // meme parametres
         sameReturnTypeWithCovariance(ms,m) //meme type de retour incluant la covariance
         //(ms.getReturnType()==m.getReturnType())
         )
         return true;
    }
    return false;
  }
  

  
  private static boolean sameParameterType(Method me, Method m){
    Class<?>[] paramsMe = me.getParameterTypes();
    Class<?>[] paramsM  = m.getParameterTypes();
    if(paramsMe.length != paramsM.length) return false;
    for(int i = 0; i< paramsMe.length; i++){
      if(paramsMe[i] !=  paramsM[i]) return false;
    }
    return true;
  }
  
  private static boolean sameReturnTypeWithCovariance(Method ms, Method m){
    Class<?> cl = m.getReturnType(); // la m�thode de la classe
    Class<?> superClass = ms.getReturnType();
    if(superClass==cl) return true; // la m�me classe
    while(cl != null){
      cl = cl.getSuperclass();
      if(superClass==cl) return true;
    }
    return false;
  }
  
  private static boolean sameReturnType(Method ms, Method m){
    return ms.getReturnType() == m.getReturnType();
  }
  
  // ------- méthodes pour les tests --------
  public boolean equals(Object obj){
    return false;
  }
  public int hashCode(){
    return 0;
  }
  @Override
  public Object clone(){
    return null;
  }
  
  
  public static Object execStatic(String className, String methodName, Object... args) throws Exception{
    Object res = null;
    try{
      Class<?> c = Class.forName(className);
      Class<?>[] classes = new Class<?>[args.length]; 
      for(int i = 0; i<args.length; i++){
        classes[i] = args[i].getClass();//
      }
      res = c.getMethod(methodName,classes).invoke(null, args);
    }catch(Exception e){
      e.printStackTrace();
    }
    return res;
  }
}