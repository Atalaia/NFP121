package facade;

public class Facade1 implements FacadeI {

  ClasseA classeA;
  ClasseB classeB;
  ClasseC classeC;
  ClasseD classeD;

  public Facade1() {
    classeA = new ClasseA();
    classeB = new ClasseB();
    classeC = new ClasseC();
    classeD = new ClasseD();
  }

  public int methode1() {
    System.out.println("Methode1 : ");
    return classeA.methodeA() +
           classeD.methodeD() +
           classeC.methodeC();
  }

  public int methode2() {
    System.out.println("Methode2 : ");
    return classeB.methodeB() +
           classeC.methodeC();
  }
  
      
}