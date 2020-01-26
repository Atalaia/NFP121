package question3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Introspection{

    public static Set<Method> getHeritees(String nomDeLaClasse) throws ClassNotFoundException{
        // à compléter
        Class c = Class.forName(nomDeLaClasse);
        //méthodes définies dans la classe à tester
        Set<Method> methodesDefiniesLocalement = new HashSet<Method>(Arrays.asList(c.getDeclaredMethods()));
        //méthodes définies dans les super classes 
        Set<Method> methodesHeritees = new HashSet<Method>(Arrays.asList(c.getDeclaredMethods()));
        //methodes héritées non redéfinies
        Set<Method> methodesHeriteesNonRedefinies = new HashSet<Method>();

        //récupère les méthodes de la super classe
        Class parent = c;
        Set<Method> methodesAAjouter;
        int mod;

        while(parent.getSuperclass() != null) {
            parent = parent.getSuperclass();
            methodesAAjouter = new HashSet<Method>(Arrays.asList(parent.getDeclaredMethods()));
            for(Method m: methodesAAjouter) {
                if(!Introspection.ContientMethode(methodesHeritees, m)) {
                    mod = m.getModifiers();
                    if (mod != 0 && (Modifier.isPublic(mod) || Modifier.isProtected(mod)) && !Modifier.isAbstract(mod)) {
                        methodesHeritees.add(m);
                    }
                }
            }
        }
        for(Method m1: methodesHeritees) {
            if(!Introspection.ContientMethode(methodesDefiniesLocalement, m1)) {
                methodesHeriteesNonRedefinies.add(m1);
            }
        }
        return methodesHeriteesNonRedefinies;
    }

  
    public static void main(String[] args) throws ClassNotFoundException{

        for(Method m : Introspection.getHeritees("java.util.AbstractCollection")){
            System.out.println(m);
        }
    }

    private static boolean MethodesEgales(Method m1, Method m2) {
        Class[] param1 = m1.getParameterTypes();
        Class[] param2 = m2.getParameterTypes();

        if(!m1.getName().equals(m2.getName()))
            return false;
        if(param1.length != param2.length) 
            return false;
        for( int i = 0; i < param1.length; i++) {
            if(!param1[i].getName().equals(param2[i].getName()))
                return false;
        }
        if (!m1.getReturnType().equals(m2.getReturnType()))
            return false;
        return true;

    }

    private static boolean ContientMethode(Set<Method> set, Method m) {
        boolean present = false;
        for(Method m2: set) {
            if(Introspection.MethodesEgales(m,m2)) {
                return true;
            }
        }
        return false;
    }

}