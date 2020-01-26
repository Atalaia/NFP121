package question2;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.*;

public class ParIntrospection{

  /** Cette methode permet de relier par introspection, un observable et un observateur<p>
   * Appel par introspection de la methode observable.addObserver(observer) 
   *
   * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
   * @param observer une implementation de l'interface java.util.Observer
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void lierObservableEtObserver(Object observable, Object observer) throws Exception{
      try{
        String obs = observable.getClass().getName();
        Class cl = Class.forName(obs);
        Class[] types = new Class[] {Observer.class};
        Method m = cl.getMethod("addObserver",types);
        m.invoke(observable, new Object[] {observer});
      }catch (Exception e){
          throw new NoSuchElementException();
      }
  }
  
  /** Cette methode permet de delier par introspection, un observable et un observateur<p>
   * Appel par introspection de la methode observable.deleteObserver(observer) 
   * 
   * @param observable une instance de la classe java.util.Observable ou l'une de ses derivees
   * @param observer une implementation de l'interface java.util.Observer
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void delierObservableEtObserver(Object observable, Object observer) throws Exception{
      try{
        String obs = observable.getClass().getName(); //"java.util.Observable"
        Class cl = Class.forName(obs);
        Class[] types = new Class[] {Observer.class};
        Method m = cl.getMethod("deleteObserver",types);
        m.invoke(observable, new Object[] {observer});
      }catch (Exception e){
          throw new NoSuchElementException();
      }
  }
  
  /** Cette methode permet de relier par introspection, une source et un "listener"<p>
   * Appel par introspection de la methode source.addXXXXListener(listener) 
   * 
   * @param source est une instance 
   * @param listener une implementation d'une interface XXXXListener
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void lierSourceEtListener(Object source, Object listener) throws Exception{
      try{
          Class clListener = listener.getClass();
          Class clSource = source.getClass();
          boolean invoked = false;
          
          for(Method m: clSource.getMethods()){
            if(m.getParameterCount()==1){
                if(m.getName().contains("add") 
                && m.getParameterTypes()[0].isInstance(listener)){
                    m.invoke(source, listener);
                    invoked = true;
                }
            }
        }
        
        if(!invoked){
            throw new NoSuchElementException();
        }
        
      }catch(Exception e){
          throw new NoSuchElementException();
      }
  }

  /** Cette methode permet de delier par introspection, une source et un "listener"<p>
   * Appel par introspection de la methode source.removeXXXXListener(listener) 
   * 
   * @param source est une instance 
   * @param listener une implementation d'une interface XXXXListener
   * @throws NoSuchElementException en cas d'erreur
   */
  public static void delierSourceEtListener(Object source, Object listener) throws Exception{
      try{
          Class clListener = listener.getClass();
          Class clSource = source.getClass();
          boolean invoked = false;
          
          for(Method m: clSource.getMethods()){
            if(m.getParameterCount()==1){
                if(m.getName().contains("remove") 
                && m.getParameterTypes()[0].isInstance(listener)){
                    m.invoke(source, listener);
                    invoked = true;
                }
            }
        }
        
        if(!invoked){
            throw new NoSuchElementException();
        }
        
      }catch(Exception e){
          throw new NoSuchElementException();
      }
  }
  
}
