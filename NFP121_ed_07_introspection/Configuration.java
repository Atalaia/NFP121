import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class Configuration{
  
  public static Object genererAdaptateur(String nomDuFichier) throws Exception{
    Properties props = new Properties();
    props.load(new FileInputStream(new File(nomDuFichier)));
    String adaptateurClassName = props.getProperty("classe_adaptateur");
    String adaptateeClassName = props.getProperty("classe_a_adapter");
    
    Class<?> classeAdaptateur = Class.forName(adaptateurClassName);
    Constructor cons = classeAdaptateur.getConstructor(Plug.class);
    Class<?> classeAAdapter  = Class.forName(adaptateeClassName);
    Plug plug = (Plug) classeAAdapter.newInstance();
    
    Object adaptateur = cons.newInstance(plug);
    return adaptateur;
  }

  public static Subject newProxyInstance(String nomDuFichier) throws Exception{
    Properties props = new Properties();
    props.load(new FileInputStream(new File(nomDuFichier)));
    String mandataireClassName = props.getProperty("mandataire");
    Class<?> classeMandataire = Class.forName(mandataireClassName);
    return (Subject)classeMandataire.newInstance();
  }
}


