import java.util.*;

public class IngenieurAISL extends Diplome
{
    public IngenieurAISL(){
        this.setCode("LG300");
        this.setIntitule("Ingenieur");
        this.setNbCredits(0);
    }
    
    public boolean equals(Object o)
    {
        //parcours la liste des UE
        
        boolean b = false;
        
        if(o instanceof Diplome)
        {
            Diplome diplome = (Diplome) o;
            List<UniteEnseignement> listeAutreDiplome = diplome.getList();
            //il faut parcourir la liste et comparer les unités d'enseignement
            //des 2 diplomes
        }
        
        return true;
    }
}
