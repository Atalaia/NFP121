import java.util.*;

public class LicenceSTIC extends Diplome
{
    public LicenceSTIC(){
        this.setCode("LG025");
        this.setIntitule("Licence STIC, mention informatique générale");
        this.setNbCredits(0);
    }
    
    public boolean equals(Object o){
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
