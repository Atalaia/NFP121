

public class Mandataire1 implements Subject{
  private Subject real;
  public Mandataire1(){
    this.real = new RealSubject();
  }
 public String requete(String url) throws Exception{
   if(url.contains("cnam.fr"))
     return real.requete(url);
   return "échec";
  }
}