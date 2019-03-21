package test;
import com.isa.structures.Vecteur;

public class TestVecteur{
    
    public static void main(String[] args){
        testTrouve();
        testAjoute(); 
        testSuppression();
    }

    /**
     * Fonction permettant de tester les fonctions de recherche du vecteur
     * Utilise le constructeur Vecteur(int[] pElementDepart)
     */
    public static void testTrouve(){
        /***** TEST RECHERCHE *************/
        int[] tabDepart1 = {1,2,3,4,5,6};
        int[] tabDepart2 = {1,2,3,4,5,6,7}; 
        //trois vecteurs: v1 et v2 identique, v3 different
        Vecteur v1 = new Vecteur(tabDepart1);
        Vecteur v2 = new Vecteur(tabDepart1);
        Vecteur v3 = new Vecteur(tabDepart2);
        // test trouve(int pItem)
        for(int i =0; i<tabDepart1.length; i++){
            if(!v1.trouve(tabDepart1[i]))
                System.out.println("(1)Probleme: fonction trouve(int pItem)");
        }
        if(v1.trouve(104))
            System.out.println("(2)Probleme: fonction trouve(int pItem)");

        //test trouveTout(pCollection): deux vecteurs pareils
        if(!v1.trouveTout(v2))
            System.out.println("(3)Probleme: fonction trouveTout(pCollection)");

        //test trouveTout(pCollection): deux vecteurs differents
        if(v1.trouveTout(v3))
            System.out.println("(4)Probleme: fonction trouveTout(pCollection)");
        
    }
    
    /**
     * Fonction testant les fonctions d'ajout de la classe Vecteur
     * Utilise: le constructeur vide 
     *          la fonction trouveTout(pCollection)
     *          la fonction trouve(pItem)
     *          la fonction getElementAt(pIdx)
     *          la fonction getNbElement()
     */
    public static void testAjoute(){
        Vecteur v1 = new Vecteur();
        Vecteur v2 = new Vecteur();
        /******************** TEST AJOUT *************/
        for(int i = 0; i<10; i++)
            v1.ajoute(i);
        for(int i = 0; i<10; i++)
            if(!(v1.trouve(i)))
                System.out.println("(1)Erreur dans ajoute(element)");
        if(v1.getNbElements() != 10)
            System.out.println("(2)Erreur dans ajoute(element)");

        // test ajoute( element,index)
        v1.ajoute(11,5);
        if(v1.getElementAt(5)!= 11)
            System.out.println("(3)Erreur dans ajoute(pElement,pIdx)");
        //test ajoute(pCollection) 
        v2.ajoute(v1);
        if(!v2.trouveTout(v1))
            System.out.println("(4)Erreur dans ajoute(pVecteur) ");

    }
    /**
    * Test des fonctions de suppression de la classe Vecteur
    * Utilise: constructeur vide
    *          getNbElement
    *          trouve(pItem)
    *           ajoute(pItem)
    *
    */
    public static void testSuppression(){
        /******************** TEST SUPPRESSION ***********/ 
        Vecteur v1 = new Vecteur();
        Vecteur v2 = new Vecteur();
        for(int i = 0; i<10; i++)
            v1.ajoute(v1);
        /* Test effaceTout*/
        v2.effaceTout();
        if(v2.getNbElements() != 0)
            System.out.println("Erreur dans effaceTout()");
        v2.ajoute(1);
        v2.ajoute(2);
        v2.ajoute(3);
        v2.effaceAt(0);
        if(v2.getNbElements() != 2 || v2.getElementAt(0) != 2 || v2.getElementAt(1)!=3)
            System.out.println("Probleme dans effaceAt(idx)");
        v2.ajoute(2);
        v2.effaceTout(2);
        if(v2.trouve(2) || v2.getNbElements() != 1)
            System.out.println("Proble dans effaceTout(element)");
        v2.ajoute(4);
        v1.effaceTout(v2);
        if(v1.trouve(4) || v1.trouve(3))
            System.out.println("Probleme dans effaceTout(pCollection)");
    }
}
