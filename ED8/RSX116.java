
public class RSX116 extends UniteEnseignement
{

    /**
     * Constructor for objects of class RSX116
     */
    public RSX116()
    {
        this.setCode("RSX116");
        this.setNbCredits(6);
        this.setIntitule("Reseau mobile et reseaux sans fil");
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
