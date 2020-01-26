// https://www.jmdoudoux.fr/java/dej/chap-design-patterns.htm
package facade;
import container.*;

public class Client1 {
    
    private FacadeI facade;
    public void setFacade(FacadeI facade){
        this.facade = facade;
    }
    private static ApplicationContext ctx;
    static{
        ctx = Factory.createApplicationContext("./facade/README.TXT");
    }
    
    public int resultat(){
        return facade.methode1()+ facade.methode2();
    }
    
    public void testsAvecInjection(){
        facade = ctx.getBean("facade1");
        System.out.println(facade.methode1() + facade.methode2());
    } 

    public static void main(String[] argv) {
        System.out.println("https://www.jmdoudoux.fr/java/dej/chap-design-patterns.htm");

        Facade1 facade = new Facade1();
        System.out.println(facade.methode1() + facade.methode2());
    }
}

