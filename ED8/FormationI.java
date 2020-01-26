
public interface FormationI {
    
   public String getCode();
   public String getIntitule();
   public int getNbCredits();
   public boolean ajouterUniteEnseignement(UniteEnseignement ue);
   
   public String interpreter();
}
