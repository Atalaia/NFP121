package state;

public class EtatAllume implements Etat{
  private Lampe lampe;

  public EtatAllume(){}
  
  public void setLampe(Lampe lampe){
    this.lampe = lampe;
  }
  
  public EtatAllume(Lampe lampe){
    this.lampe = lampe;
  }
  
  public void allumer(){
    //lampe.setEtat(lampe.getEtatAllume());
    System.out.println("la lampe est déjà allumée !");
  }

  public void eteindre(){
    //lampe.setEtat(lampe.getEtatEteint());
    //lampe.setEtat( new EtatEteint(lampe));
    lampe.setEtat( lampe.getEtatEteint());
  }

  public void clignoter(){
    lampe.setEtat( lampe.getEtatClignotant());
  }
  
  public String toString(){
    return "allumée";
  }
}
