package state;

public class EtatEteint implements Etat{
  private Lampe lampe;

   public EtatEteint(){}
  
  public void setLampe(Lampe lampe){
    this.lampe = lampe;
  }
  public EtatEteint(Lampe lampe){
    this.lampe = lampe;
  }

  public void allumer(){
    //lampe.setEtat(lampe.getEtatAllume());
    //lampe.setEtat(new EtatAllume(lampe));
    lampe.setEtat(lampe.getEtatAllume());
  }

  public void eteindre(){
    System.out.println("la lampe est déjà éteinte.");
    //lampe.setEtat(lampe.getEtatEteint());
  }

  public void clignoter(){
    // aucun effet
  }

  public String toString(){
    return "éteinte";
  }
}
