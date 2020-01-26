package question3;
import java.text.Normalizer;

/**
 * NFP121 TpIntroduction, usage de BlueJ et du "Submitter".
 * 
 * @version septembre 2009
 * @author à compléter
 * @see java.lang.String, java.lang.Math
 */
public class AuditeurCNAM {
    /** l'attribut nom de chaque auditeur. */
    private String nom;
    /** l'attribut prenom de chaque auditeur. */
    private String prenom;
    /** l'attribut matricule de chaque auditeur. */
    private String matricule;

    /**
     * "Création", le constructeur d'un auditeur avec son nom, son prénom et son
     * matricule.
     * 
     * @param nom
     *            le nom de l'auditeur
     * @param prenom
     *            son prénom
     * @param matricule
     *            sur la carte d'inscription, près de la photo
     */
    public AuditeurCNAM(String nom, String prenom, String matricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
    }

/** le login au Cnam : 
* 6 premières lettres du nom suivies de la première lettre du prénom séparées de '_' .
* le login retourné est en minuscules, 
* le trait d'union, ou spéciaux (pour unix)sont remplacés par des '_' 
* pas de caractères accentués pour le login
* voir les classes prédéfines,
* java.lang.String : les méthodes replaceAll, toLowerCase et substring
* java.lang.Math   : la méthode min
* BlueJ : Menu Aide
* @return le login du Cnam simplifié, sans les adaptations dues aux homonymes...
*/
    public String login(){
        String nomL;
        String prenomL;
        nomL=this.nom();
        nomL=nomL.replaceAll("[0-9]","");
        nomL=sansAccents(nomL).toLowerCase().substring(0, Math.min(nomL.length(),6)).replaceAll("[^a-z]","_");
        prenomL=this.prenom();
        prenomL=prenomL.replaceAll("[0-9]","");
        prenomL=sansAccents(prenomL).toLowerCase().substring(0,1).replaceAll("[^a-z]","_");    

        return nomL+"_"+prenomL;
    }
    
     /** Retourne une chaîne en remplaçant les caractères accentués par les caractères non-accentués correspondants.
        * @param s la chaîne accentuée initiale
        * @return la chaîne non accentuée
     */
    public String sansAccents(String s) {
        String sAccents = "äâàáåãéèëêòóôõöøìíîïùúûüıñçÿÄÂÀÁÅÃÉÈËÊÒÓÔÕÖØÌÍÎÏÙÚÛÜİÑÇİ";
        String sSansAccents ="aaaaaaeeeeooooooiiiiuuuuyncyaaaaaaeeeeooooooiiiiuuuuyncy";
        int longueur = sAccents.length();
        for (int i=0;i<longueur;i++) {
            s = s.replace(sAccents.charAt(i),sSansAccents.charAt(i));
        }
        return s;
   }

    /**
     * Lecture du nom de l'auditeur.
     * 
     * @return son nom
     */
    public String nom() {
        return this.nom;
    }

    /**
     * Lecture du prénom de l'auditeur.
     * 
     * @return son prénom
     */
    public String prenom() {
        return this.prenom;
    }

    /**
     * Lecture du matricule de l'auditeur.
     * 
     * @return son matricule
     */
    public String matricule() {
        return this.matricule;
    }

    /**
     * méthode toString ( méthode redéfinie de la classe Object).
     * 
     * @return la concaténation du nom, du prénom et du login, selon cette
     *         syntaxe
     *         <code>nom() + " " + prenom() +  " login : " + login()</code>
     */
    @Override
    public String toString() {
        return nom() + " " + prenom() + " login : " + login();
    }

}
