//classe finale, une feuille

public class NFP121 extends UniteEnseignement
{
    /**
     * Constructeur d'objets de la classe NFP121
     */
    public NFP121()
    {
        this.setCode("NFP121");
        this.setNbCredits(6);
        this.setIntitule("Programmation avancée");
    }
    
    public boolean equals(Object o)
    {
        boolean b = false;
        
        if(o instanceof UniteEnseignement)
        { 
            UniteEnseignement ue = (UniteEnseignement) o;
            if(ue.getCode() == this.getCode())
                b = true;
        }
        
        return b; 
    }
}
