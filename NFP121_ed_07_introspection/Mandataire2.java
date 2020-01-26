

public class Mandataire2 implements Subject{
  private Subject real;
  public Mandataire2(){
    this.real = new RealSubject();
  }
 public String requete(String url) throws Exception{
   if(url.contains("cnam.fr"))
     return real.requete(url);
   return "échec";
  }
}