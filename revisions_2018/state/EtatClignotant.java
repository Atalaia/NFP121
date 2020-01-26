package state;
public class EtatClignotant implements Etat{
  private Lampe lampe;

    public EtatClignotant(){}
  
  public void setLampe(Lampe lampe){
    this.lampe = lampe;
  }
  
  public EtatClignotant(Lampe lampe){
    this.lampe = lampe;
  }

  public void allumer(){
    //lampe.setEtat(lampe.getEtatAllume());
    System.out.println("aucun effet, la lampe continue de clignoter.");
  }

  public void eteindre(){
    System.out.println("aucun effet, la lampe continue de clignoter.");
  }

  public void clignoter(){
    lampe.setEtat(lampe.getEtatAnterieur());
  }
  
  public String toString(){
    return "clignotante";
  }
}