package question1;

import java.lang.reflect.Method;

import java.util.Map;
import java.util.TreeMap;
import java.util.NoSuchElementException;

/** Gestion par introspection des méthodes de la classe java.lang.Math,<br>
 *  Seules sont conservées :les méthodes retournant un double et d'arité 1 ou 2<p>
 *   Note : Emploi du Pattern Singleton pour cette table, accessible uniquement en lecture par des accesseurs<p>
 * La convention de nommage est la suivante :
 *        le "Nom" de la fonction suivi de "(double)"  exemple : "sqrt(double)"
 *  ou le "Nom" de la fonction suivi de "(double, double)"  exemple : "IEEEremainder(double, double)"
 */

final public class TableMethodesJavaLangMath{
  /** Singleton */
  private static TableMethodesJavaLangMath instanceUnique = null;

  public static TableMethodesJavaLangMath getInstance(){
    synchronized(TableMethodesJavaLangMath.class){
      if (instanceUnique==null){
        instanceUnique = new TableMethodesJavaLangMath();
      }
      return instanceUnique;
    }
  }
        
  private TableMethodesJavaLangMath(){
  } 
  // fin du Singleton
  
  /** 
   * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
   * @return true si la fonction est présente
   */
  public boolean cetteMethodeEstPresente(String nomDeLaMethode){
    return tableDesMethodes.containsKey(nomDeLaMethode);
  }
  
  /** 
   * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
   * @return true si la fonction est binaire, d'arité 2
   * @throws NoSuchElementException si la méthode demandée n'existe pas
   */
  public boolean cetteMethodeAttendDeuxParametres(String nomDeLaMethode)
   throws NoSuchElementException{
    if(!cetteMethodeEstPresente(nomDeLaMethode)){
        throw new NoSuchElementException();
    }
    
    if(nomDeLaMethode.contains("(double, double)")){
        return true;
    }else{
        return false; 
    }
  }
  
  /** 
   * @param  nomDeLaMéthode Nom de la fonction + "(double)" ou "(double, double)"
   * @return true si la fonction est unaire, d'arité 1
   * @throws NoSuchElementException si la méthode demandée n'existe pas 
   */
  public boolean cetteMethodeAttendUnSeulParametre(String nomDeLaMethode)
  throws NoSuchElementException{
    if(!cetteMethodeEstPresente(nomDeLaMethode)){
        throw new NoSuchElementException();
    }
    
    if(nomDeLaMethode.contains("(double)")){
        return true;
    }else{
        return false; 
    }
  }
  
  /** 
   * Obtention de la liste ordonnée des méthodes
   * @return la liste triée des fonctions issues de java.lang.Math
   */  
  public String[] listeDesMethodes(){
    String[] tab = new String[tableDesMethodes.size()];
      
    int compteur = 0;
    for(String s: tableDesMethodes.keySet()){
        tab[compteur] = s;
        compteur++;
    }
    
    return tab;
  }
  
 /** Invocation d'une méthode de la table
   * @param  nomDeLaMéthode Nom de la fonction + "(double)"
   * @param arg1 l'opérande
   * @return un résultat
   * @throws NoSuchElementException si la méthode demandée n'existe pas ou une exception levée par la fonction appelée
   */
  public double invoquer(String nomDeLaMethode,double arg1) throws Exception{
      try{
          if(this.cetteMethodeAttendUnSeulParametre(nomDeLaMethode)){
             Class cl = Class.forName("java.lang.Math");
             
             Object result = tableDesMethodes.get(nomDeLaMethode).invoke(cl, new Object[]{arg1});
             return (Double)result;
            }else{
                throw new NoSuchElementException();
            }
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
  }
  
 /** Invocation d'une méthode de la table
   * @param  nomDeLaMéthode Nom de la fonction + "(double, double)"
   * @param arg1 l'opérande
   * @return un résultat
   * @throws NoSuchElementException si la méthode demandée n'existe pas ou une exception levée par la fonction appelée
   */  
  public double invoquer(String nomDeLaMethode, double arg1, double arg2) throws Exception{
   try{
       if(this.cetteMethodeAttendDeuxParametres(nomDeLaMethode)){
           Class cl = Class.forName("java.lang.Math");
           
           Object result = tableDesMethodes.get(nomDeLaMethode).invoke(cl, new Object[]{arg1, arg2});
           return (Double)result;
        }else{
            throw new NoSuchElementException();
        }
     }catch (NoSuchElementException e){
        throw new NoSuchElementException();
    }
  }
    

  /**
   * Le dictionnaire contient la liste des méthodes disponibles.
   * un choix de dictionnaire pourrait être pour la Clé une String soit le Nom de la fonction + "(double)" ou "(double, double)".<br>
   *  et en Valeur =  la Method correspondante.
   *  ou tout autre choix
   */
  private static Map<String,Method> tableDesMethodes = null;

  /** bloc statique d'intialisation de la table des méthodes */
  static{
      tableDesMethodes = new TreeMap<String,Method>();
      try{
          Class cl = Class.forName("java.lang.Math");
          for(Method m: cl.getMethods()){
              boolean isDouble = true;
              boolean endParam = false;
              int compteur = 0;
              while(endParam == false && isDouble ==true){
                  for(Class param: m.getParameterTypes()){
                      if(param.getName()!="double"){
                          isDouble = false;
                        }else{
                            compteur++;
                        }
                  
                        if(m.getReturnType().getName()!= "double"){
                            isDouble = false;
                        }
                    }
                    endParam = true;
                }
            
                if(isDouble){
                    if(compteur == 1){
                        tableDesMethodes.put(m.getName()+"(double)", m);
                    } else if (compteur == 2){
                        tableDesMethodes.put(m.getName()+"(double, double)", m);
                    }
                }
            }   
        }catch(Exception e){}
    
  }
  

}
