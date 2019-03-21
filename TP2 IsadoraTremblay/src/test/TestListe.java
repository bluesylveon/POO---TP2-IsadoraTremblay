package test;
import com.isa.structures.ListeSimple;
import com.isa.structures.NoeudSimple;
public class TestListe{
   
    public static void main(String[] args){
        testAjoute();
        testTrouve();
        testSuppression();
    }

    /**
    * Fonction testant le contenu de la liste et la coherence des noeuds entre 
    * eux, du debut vers la fin de la liste 
    */
    public static String verifieListe(ListeSimple liste, int[] contenu){
        NoeudSimple noeudPremier = liste.getPremier();
        NoeudSimple courant;
        String msgErreurs = "";
        if(noeudPremier == null){
            msgErreurs+="La liste est vide et ne devrait pas!Le premier noeud = null";
            return msgErreurs;
        }
        if(noeudPremier.getValeur()!=contenu[0] )
            msgErreurs += "Le premier noeud de la liste n'est pas le bon \n";

        //parcours vers la fin de la liste
        courant = liste.getPremier();
        boolean erreurParcours = false;
        for(int i = 0; i<contenu.length; i++){ 
            if(courant.getValeur()!=contenu[i])
                erreurParcours = true;
            courant = courant.getProchain();
        }
        if(erreurParcours)
            msgErreurs+="probleme dans le parcours du debut vers la fin de la liste. Piste: est-ce que les pointeurs mProchain des noeuds sont coherents? \n";
        return msgErreurs;
    }

    /**
     * Fonction testant les fonctions d'ajout de la liste simplement chainee
     * utilise: getNbElement()
     *          getElementAt()
     *          toString
     */
    public static void testAjoute(){
        ListeSimple liste1 = new ListeSimple();
        ListeSimple liste2 = new ListeSimple();
        /******************** TEST AJOUT *************/
        //test ajoute(pElement)
        for(int i = 0; i<10; i++)
            liste1.ajoute(i);
        if(liste1.getNbElements() != 10)
            System.out.println("(1)Erreur dans ajoute(element)");
        int[] contenu1 = {0,1,2,3,4,5,6,7,8,9};
        String msgErreur = verifieListe(liste1,contenu1); 
        if(msgErreur.length() != 0)
            System.out.println("(2)Probleme dans ajoute(pElement):"+msgErreur);

        // test ajoute( element,index)
        //test ajoute debut
        liste1.ajoute(20,0);
        int[] contenu2 = {20,0,1,2,3,4,5,6,7,8,9};
        msgErreur = verifieListe(liste1,contenu2);
        if(msgErreur.length()!=0)
            System.out.println("(3)Probleme avec ajoute(pItem,pIdx=0):"+msgErreur);
        //test ajoute fin
        liste1.ajoute(30,liste1.getNbElements()-1);
        int[] contenu3 = {20,0,1,2,3,4,5,6,7,8,30,9};
        msgErreur = verifieListe(liste1,contenu3);
        if(msgErreur.length()!=0)
            System.out.println("(4)Probleme avec ajoute(pItem,pIdx=dernier index):"+msgErreur);
       //test ajout centre
        liste1.ajoute(11,5);
        int[] contenu4 = {20,0,1,2,3,11,4,5,6,7,8,30,9};
        msgErreur = verifieListe(liste1,contenu4);
        if(msgErreur.length() != 0)
             System.out.println("(5)Probleme dans ajoute(pElement,pIdx=centre):"+msgErreur);
           
        //test ajoute(pCollection) 
        liste2.ajoute(liste1);
        if(liste1.getNbElements() != 13)
            System.out.println("(6)Erreur dans ajoute(pCollection):nbElement errones");
        msgErreur = verifieListe(liste2,contenu4);
        if(msgErreur.length() != 0)
             System.out.println("(7)Probleme dans ajoute(pCollection):"+msgErreur);
 
    }
    /**
     * Fonction permettant de tester les fonctionalites de recherche de la classe ListeSimple
     * utilise: ajoute(pElement)
     ajoute(pCollection)
     */
    public static void testTrouve(){
        ListeSimple liste1 = new ListeSimple();
        ListeSimple liste2 = new ListeSimple();
        for(int i = 0; i<10; i++)
            liste1.ajoute(i);
        for(int i =0; i<10; i++)
            if(!liste1.trouve(i))
                System.out.println("(1)Probleme avec la fonction trouve(pItem)");
        liste2.ajoute(liste1);
        if(!liste2.trouveTout(liste1))
            System.out.println("(2)Probleme avec la fonction trouveTout(pCollection");
        liste1.ajoute(14);
        if(liste2.trouveTout(liste1))
            System.out.println("(3)Probleme avec la fonction trouveTout(pCollection");
    }
    /**
     * Fonction permettant de tester les fonctionalites de suppression de la classe ListeSimple
     * utilise: ajoute(pElement)
     *           trouve(pElement)
     *           getElementAt(pIdx)
     *           estVide()
     *           
     */
    public static void testSuppression(){
        ListeSimple liste1 = new ListeSimple();
        ListeSimple liste2 = new ListeSimple();
        for(int i = 0; i<10; i++){
            liste1.ajoute(i);
            liste2.ajoute(i);
        }
        /******************** TEST SUPPRESSION ***********/ 

        // Test effaceTout
        liste2.effaceTout();
        if(liste2.getNbElements() != 0|| !liste2.estVide())
            System.out.println("(1)Erreur dans effaceTout()");
        liste2.ajoute(1);
        liste2.ajoute(2);
        liste2.ajoute(3);
        liste2.effaceAt(0);
        int[] contenu1 = {2,3};
        String msgErreur = verifieListe(liste2,contenu1);
        if(msgErreur.length() != 0)
            System.out.println("(2)Probleme avec effaceAt(pIdx=0)"+msgErreur);
        liste2.effaceAt(1);
        int[] contenu2 = {2};
        msgErreur = verifieListe(liste2,contenu2);
        if(msgErreur.length() != 0)
            System.out.println("(3)Probleme avec effaceAt(pIdx=1)"+msgErreur);

        liste2.ajoute(2);
        liste2.ajoute(4);
        liste2.effaceTout(2);
        int[] contenu3 = {4};
        msgErreur = verifieListe(liste2,contenu3);
        if(msgErreur.length() != 0)
            System.out.println("(4)Probleme avec effaceTout(pElement)"+msgErreur);
        
        liste2.ajoute(3);
        liste1.effaceTout(liste2);
        int[] contenu4 = {0,1,2,5,6,7,8,9};
        msgErreur = verifieListe(liste1,contenu4);
        if(msgErreur.length() != 0)
            System.out.println("(5)Probleme avec effaceTout(pCollection)"+msgErreur);
    }
}
