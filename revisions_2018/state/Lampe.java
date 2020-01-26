package state;


public class Lampe{
  private Etat etatCourant;
  private Etat etatAnterieur;
    
  private Etat etatAllume;
  private Etat etatEteint;
  private Etat etatClignotant;

  public Lampe(){
    this.etatCourant    = new EtatEteint(this);
    this.etatAllume     = new EtatAllume(this);
    this.etatEteint     = new EtatEteint(this);
    this.etatClignotant = new EtatClignotant(this);
    setEtat(etatEteint);
  }

  public void clignoter(){
    etatCourant.clignoter();
  }
  public void allumer(){
    etatCourant.allumer();
  }

  public void eteindre(){
    etatCourant.eteindre();
  }

  public void setEtat(Etat etat){
    System.out.println("lampe " + etat);
    etatAnterieur = etatCourant;
    etatCourant = etat;
  }

  public Etat getEtat(){
    return etatCourant;
  }
  
  public Etat getEtatAnterieur(){
    return etatAnterieur;
  }

  public Etat getEtatAllume(){
    return etatAllume;
  }

  public Etat getEtatEteint(){
    return etatEteint;
  }
  
  public Etat getEtatClignotant(){
    return etatClignotant;
  }

}