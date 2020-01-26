import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFormationSimple{

    public void testSimple(){
        LicenceSTIC licence = new LicenceSTIC();
        IngenieurAISL ingenieur = new IngenieurAISL();
        NFP121 ueNFP1211 = new NFP121();
        RSX116 ueRSX1161 = new RSX116();

        assertEquals(licence.getCode(), "LG025");
        assertEquals("Licence STIC, mention informatique générale", licence.getIntitule());
        assertEquals(licence.nombreUnitesEnseignements(), 0);
        assertEquals(licence.getNbCredits(), 0);
        assertFalse(licence.equals(ingenieur)); /* equals */      

        assertEquals(ueNFP1211.getCode(), "NFP121");
        assertEquals(ueNFP1211.getIntitule(), "Programmation avancée");
        assertEquals(ueNFP1211.getNbCredits(), 6);
        assertFalse(ueNFP1211.equals(ueRSX1161)); /* equals */ 

        assertTrue(licence.ajouterUniteEnseignement(ueNFP1211));
        assertFalse(licence.ajouterUniteEnseignement(ueNFP1211));
        assertTrue(licence.ajouterUniteEnseignement(ueRSX1161));
        assertEquals(licence.getNbCredits(), 12);

        try {
            ueNFP1211.ajouterUniteEnseignement(ueRSX1161);
            fail();
        } catch(Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }
}