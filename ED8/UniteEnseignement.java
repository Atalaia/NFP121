
public abstract class UniteEnseignement implements FormationI
{
   private String code;
   private String intitule;
   private int nbCredits;
    
   public String getCode(){
       return this.code;
    }
   
   public String getIntitule()
   {
       return this.intitule;
   }
    
   public int getNbCredits()
   {
       return this.nbCredits;
   }
   
   public boolean ajouterUniteEnseignement(UniteEnseignement ue)
   {
     boolean b = false;
     
     return b;
   }
   
   public void setCode(String code){
       this.code = code;
    }
    
   public void setIntitule(String intitule){
       this.intitule = intitule;
    }
    
   public void setNbCredits(int nbCredits){
       this.nbCredits = nbCredits;
    }
}
