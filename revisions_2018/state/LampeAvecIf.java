package state;

public class LampeAvecIf{
  
  private static int ALLUME     = 0;
  private static int ETEINTE    = 1;
  private static int CLIGNOTANT = 2;
  
  private static int ARRET      = 3;
  
  private int etat = ETEINTE;
  
  public void allumer(){
    if(etat==ETEINTE){
      System.out.println("la lampe est allumée");
      etat = ALLUME;
    }else if(etat==ALLUME){
      System.out.println("la lampe est déjà allumée");
    }else if(etat==CLIGNOTANT){
      // aucun effet
    }
  }
  public void eteindre(){
    if(etat==ALLUME){
      System.out.println("la lampe est éteinte");
      etat = ETEINTE;
    }else if(etat==ETEINTE){
      System.out.println("la lampe est déjà éteinte");
    }else if(etat==CLIGNOTANT){
      // aucun effet
    }
  }
  private int etatAnterieur;
  
  public void clignoter(){
    if(etat==ALLUME){
      System.out.println("la lampe clignote");
      etatAnterieur = etat;
      etat = CLIGNOTANT;
    }else if(etat==CLIGNOTANT){
      etat= etatAnterieur;
    }
  }
  
  public void arreter(){
    if(etat!=ARRET){
      System.out.println("arret au disjoncteur ");
      etatAnterieur = etat;
      etat = ARRET;
    }else{
      System.out.println("arret au disjoncteur ");
      etat= ETEINTE;
    }
  }
}
