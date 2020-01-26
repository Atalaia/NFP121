package question2.essai_decorateur_injection;
import java.util.*;
import container.*;

public class NombreTests extends junit.framework.TestCase{

    public void testAvecInjection(){
        Contexte contexte = new Contexte();
        Resultat resultat = new Resultat();
        try{
            ApplicationContext ctx = Factory.createApplicationContext("./question2/essai_decorateur_injection/README.TXT");
            Nombre nombre = (Nombre) ctx.getBean("nombre");
            assertEquals(1, nombre.getValeur());
            OperationNombre operation = (OperationNombre)ctx.getBean("operation");
            operation.evaluer(contexte,nombre,resultat);
            System.out.println("resultat: " + resultat.getValeur());
            //assertEquals(2,resultat.getValeur());
        }catch(Exception e){
            fail("Exception inattendue ? " + e.getMessage());
        }
    }

    public void testSansInjection()throws Exception{
        Contexte contexte = new Contexte();
        Resultat resultat = new Resultat();

        Nombre nombre = new Nombre();
        nombre.setValeur(1);
        Condition<Void,Nombre> condition = new ToujoursVraie<Void,Nombre>();
        NombrePlus1 operation = new NombrePlus1();
        // resultat.setValeur(nombre.getValeur()+1);
        operation.evaluer(contexte, nombre, resultat);
        assertEquals(2,resultat.getValeur());
    }

    public void testAvecDeuxDecorateursSansInjection()throws Exception{
        Contexte contexte = new Contexte();
        Resultat resultat = new Resultat();

        Nombre nombre = new Nombre();
        nombre.setValeur(1);

        Condition<Contexte,Nombre> condition = new ToujoursVraie<Contexte,Nombre>();

        AbstractDecorateur operation1 = new NombreDeco();
        operation1.setCondition(condition);
        operation1.setOperation(new NombrePlus1());
        operation1.setDecore(new NombrePlus1()); 
        //operation1.evaluer(contexte,nombre,resultat);

        AbstractDecorateur operation = new NombreDeco();
        operation.setCondition(condition);
        operation.setOperation(new NombrePlus1()); // +1
        
        operation.setDecore(operation1);

        operation.evaluer(contexte,nombre,resultat);
        assertEquals(2,resultat.getValeur());

       
    }
}
