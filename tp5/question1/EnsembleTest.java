package question1;

public class EnsembleTest extends junit.framework.TestCase {
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Met en place les engagements.
     * 
     * Méthode appelée avant chaque appel de méthode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements

    }

    /**
     * Supprime les engagements
     * 
     * Méthode appelée aprés chaque appel de méthode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Libérez ici les ressources engagées par setUp()
    }

    /**
     * test de la méthode add(T t) dans la classe Ensemble
     */
    public void testAdd(){
        question1.Ensemble<Integer> e1,e2;
        e1 = new question1.Ensemble<Integer>();
        e2 = new question1.Ensemble<Integer>();
        
        //on ajoute les entiers 2 et 5 à l'ensemble e1
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(5));
        
        //on vérifie que les entiers 2 et 5 sont contenus dans l'ensemble e1
        assertTrue(e1.contains(2));
        assertTrue(e1.contains(5));
        
        //on vérifie que la taille de l'ensemble e1 = 2
        assertEquals(2, e1.size());
        
        //on ajoute les entiers 3, 4 et 5 à l'ensemble e1
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));
        assertEquals(true, e2.add(5));
        
        //on vérifie que les entiers 3, 4 et 5 sont contenus dans l'ensemble e1
        assertTrue(e2.contains(3));
        assertTrue(e2.contains(4));
        assertTrue(e2.contains(5));
        
        //on vérifie que l'entier 2 ne se trouve pas dans e2
        assertFalse(e2.contains(2));
        
        //on vérifie que la taille de l'ensemble e2 = 3
        assertEquals(3, e2.size());
        
        //on vérifie qu'on ne peut pas ajouter l'entier 3 à l'ensemble e2
        //à nouveau car il est déjà dans l'ensemble e2
        assertEquals(false,e2.add(3));
    }

    /**
     * Il ne vous reste plus qu'à définir une ou plusieurs méthodes de test. Ces
     * méthodes doivent vérifier les résultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient débuter par
     * "test". Vous pouvez baucher le corps grâce au menu contextuel
     * "Enregistrer une méthode de test".
     */
    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    
    /**
     * test méthode intersection
     */
    public void testIntersection() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> inter = e1.inter(e2);
        assertEquals(1, inter.size());
        assertTrue(inter.contains(3));
        assertFalse(inter.contains(2));
        assertFalse(inter.contains(4));
    }
    
    /**
     * test méthode différence
     */
    public void testDifference() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> diff = e1.diff(e2);
        assertEquals(1, diff.size());
        assertTrue(diff.contains(2));
        assertFalse(diff.contains(3));
        assertFalse(diff.contains(4));
    }
    
    /**
     * test méthode différence symétrique
     */
    public void testDifferenceSymétrique() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> diffSym = e1.diffSym(e2);
        assertEquals(2, diffSym.size());
        assertTrue(diffSym.contains(2));
        assertTrue(diffSym.contains(4));
        assertFalse(diffSym.contains(3));
    }
}
