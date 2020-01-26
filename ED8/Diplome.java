import java.util.*;

public abstract class Diplome implements FormationI
{
   private String code;
   private String intitule;
   private int nbCredits;
   
   private List<UniteEnseignement> list = new ArrayList<UniteEnseignement>();
    
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
     
     if(!list.contains(ue)) //si la liste ne contient pas encore l'ue
     {
         b = true;
         list.add(ue);
     }
     return b;
   }
   
   public int nombreUnitesEnseignements()
   {
     return this.list.size();
   }
   
   public List<UniteEnseignement> getList(){
       return this.list;
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
