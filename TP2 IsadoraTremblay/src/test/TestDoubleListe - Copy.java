package test;
import com.isa.structures.ListeDouble;
import com.isa.structures.NoeudDouble;

public class TestDoubleListe{
    
    public static void main(String[] args){
        testAjoute();
        testTrouve();
        testSuppression();
    }
    
    /**
    * Fonction testant le contenu de la liste et la coherence des noeuds entre 
    * eux, du debut vers la fin de la liste 
    */
    public static String verifieListeAvant(ListeDouble liste, int[] contenu){
        NoeudDouble noeudPremier = liste.getPremier();
        NoeudDouble noeudDernier = liste.getDernier();
        NoeudDouble courant;
        String msgErreurs = "";
        if(noeudPremier == null){
            msgErreurs+="La liste est vide et ne devrait pas!Le premier noeud = null";
            return msgErreurs;
        }
        if(noeudPremier.getValeur()!=contenu[0] )
            msgErreurs += "Le premier noeud de la liste n'est pas le bon \n";
        if( noeudDernier.getValeur()!=contenu[contenu.length-1])
            msgErreurs += "Le dernier noeud de la liste n'est pas le bon \n";
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
    * Fonction testant le contenu de la liste et la coherence des noeuds entre 
    * eux, de la fin vers le debut de la liste
    */
    public static String verifieListeArriere(ListeDouble liste, int[] contenu){
        NoeudDouble noeudPremier = liste.getPremier();
        NoeudDouble noeudDernier = liste.getDernier();
        String msgErreurs = "";
        NoeudDouble courant;
        if(noeudPremier == null){
            msgErreurs+="La liste est vide et ne devrait pas!Le premier noeud = null";
            return msgErreurs;

        }
        if(noeudDernier == null){
            msgErreurs+="Le dernier noeud = null";
            return msgErreurs;
}
        if(noeudPremier.getValeur()!=contenu[0] )
            msgErreurs += "Le premier noeud de la liste n'est pas le bon \n";
        if( noeudDernier == null || noeudDernier.getValeur()!=contenu[contenu.length-1])
            msgErreurs += "Le dernier noeud de la liste n'est pas le bon \n";
        //parcours vers la fin de la liste
        courant = liste.getDernier();
        boolean erreurParcours = false;
        for(int i = contenu.length-1; i>=0; i--){ 
            if(courant.getValeur()!=contenu[i])
                erreurParcours = true;
            courant = courant.getPrecedent();

        }
        if(erreurParcours)
            msgErreurs+="probleme dans le parcours de la fin vers le debut de la liste. Piste: est-ce que les pointeurs mPrecedent des noeuds sont coherents? \n";
        return msgErreurs;
    }
    /**
     * Fonction testant les fonctions d'ajout de la liste simplement chainee
     * utilise: getNbElement()
     *          getElementAt()
     *          toString
     */
    public static void testAjoute(){
        ListeDouble liste1 = new ListeDouble();
        ListeDouble liste2 = new ListeDouble();
        String msgErreur;
        int[] contenuListe = {0,1,2,3,4,5,6,7,8,9};
        /******************** TEST AJOUT *************/
        //test ajoute(pElement)
        liste1.ajoute(0);
        NoeudDouble noeudPremier = liste1.getPremier();
        NoeudDouble noeudDernier = liste1.getDernier();
        if(noeudPremier != noeudDernier && noeudPremier.getValeur()!=0)
            System.out.println("(1)Erreur dans ajoute(pItem) quand on insere un premier element. \n Il semble y avoir un probleme avec mDernier ou mPremier"); 
        for(int i = 1; i<10; i++)
            liste1.ajoute(i);
        if(liste1.getNbElements() != 10)
            System.out.println("(1)Erreur dans ajoute(element)(nbElements errones)");
        msgErreur = verifieListeAvant(liste1,contenuListe);
        if(msgErreur.length() != 0){
            System.out.println("(2)Probleme avec ajoute(pItem):"+msgErreur);
        }
        msgErreur = verifieListeAvant(liste1,contenuListe);
        if(msgErreur.length() != 0){
            System.out.println("(3)Probleme avec ajoute(pItem):"+msgErreur);
        }
       // test ajoute( element,index)
        liste1.ajoute(11,1);
        int[] contenuListe2 = {0,11,1,2,3,4,5,6,7,8,9};
        msgErreur = verifieListeAvant(liste1,contenuListe2);
        if(msgErreur.length()!=0)
            System.out.println("(4)Erreur dans ajoute(pElement,pIdx)"+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenuListe2);
        if(msgErreur.length()!=0)
            System.out.println("(5)Erreur dans ajoute(pElement,pIdx)"+msgErreur);
       //test ajoute(element,index) pour un premier noeud
       liste1.ajoute(14,0);
       int[] contenuListe3 = {14,0,11,1,2,3,4,5,6,7,8,9};
        msgErreur = verifieListeAvant(liste1,contenuListe3);
        if(msgErreur.length()!=0)
            System.out.println("(6)Erreur dans ajoute(pElement,pIdx)pour pIdx=0"+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenuListe3);
        if(msgErreur.length()!=0)
            System.out.println("(7)Erreur dans ajoute(pElement,pIdx)pour pIdx=0"+msgErreur);

       //test ajoute(pCollection) 
       liste2.ajoute(liste1);
       msgErreur = verifieListeAvant(liste2,contenuListe3);
       if(msgErreur.length()!=0)
        System.out.println("(7)Erreur dans ajoute(pCollection) :"+msgErreur);
        msgErreur = verifieListeArriere(liste2,contenuListe3);
        if(msgErreur.length()!=0)
        System.out.println("(8)Erreur dans ajoute(pCollection) :"+msgErreur);
    }
    /**
     * Fonction permettant de tester les fonctionalites de recherche de la classe ListeDouble
     * utilise: ajoute(pElement)
     ajoute(pCollection)
     */
    public static void testTrouve(){
        ListeDouble liste1 = new ListeDouble();
        ListeDouble liste2 = new ListeDouble();
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
     * Fonction permettant de tester les fonctionalites de suppression de la classe ListeDouble
     * utilise: ajoute(pElement)
     *           trouve(pElement)
     *           getElementAt(pIdx)
     *           estVide()
     *           
     */
    public static void testSuppression(){
        ListeDouble liste1 = new ListeDouble();
        ListeDouble liste2 = new ListeDouble();
        String msgErreur;
        liste1.ajoute(0);
        for(int i = 0; i<10; i++){
            liste1.ajoute(i);
            liste2.ajoute(i);
        }
        /******************** TEST SUPPRESSION ***********/ 

        // Test effaceTout()
        liste2.effaceTout();
        if(liste2.getNbElements() != 0|| !liste2.estVide())
            System.out.println("(1)Erreur dans effaceTout()");

        //test effaceTout(pElt) premier element
        liste1.effaceTout(0);
        int[] contenu1 = {1,2,3,4,5,6,7,8,9};
        msgErreur = verifieListeAvant(liste1,contenu1);
        if(msgErreur.length()!=0)
            System.out.println("(2)Erreur dans effaceTout(pElement) au premier element: "+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenu1);
        if(msgErreur.length()!=0)
            System.out.println("(3)Erreur dans effaceTout(pElement) au premier index: "+msgErreur);
         //test effaceTout dernier element
        liste1.effaceTout(9);
        int[] contenu2 = {1,2,3,4,5,6,7,8};
        msgErreur = verifieListeAvant(liste1,contenu2);
        if(msgErreur.length()!=0)
            System.out.println("(4)Erreur dans effaceTout(pElt) au dernier element "+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenu2);
        if(msgErreur.length()!=0)
            System.out.println("(5)Erreur dans efface au dernier element: "+msgErreur);
        //test effaceTout au milieulement
        liste1.effaceTout(4);
        int[] contenu3 = {1,2,3,5,6,7,8};
        msgErreur = verifieListeAvant(liste1,contenu3);
        if(msgErreur.length()!=0)
            System.out.println("(6)Erreur dans effaceTout(pElt) au centre "+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenu3);
        if(msgErreur.length()!=0)
            System.out.println("(7)Erreur dans efface au centre: "+msgErreur);
      /*** TEST EFFACE AT *************/
      //premier element
      liste1.effaceAt(0);
      int[] contenu4 = {2,3,5,6,7,8};
      msgErreur = verifieListeAvant(liste1,contenu4);
      if(msgErreur.length()!=0)
          System.out.println("(8)Erreur dans effaceAt(pElt) a l'index 0 "+msgErreur);
        msgErreur = verifieListeArriere(liste1,contenu4);
        if(msgErreur.length()!=0)
          System.out.println("(9)Erreur dans effaceAt(pElt) a l'index 0 "+msgErreur);
       //dernier element
      liste1.effaceAt(liste1.getNbElements()-1);
      int[] contenu5 = {2,3,5,6,7};
      msgErreur = verifieListeAvant(liste1,contenu5);
      if(msgErreur.length()!=0)
          System.out.println("(10)Erreur dans effaceAt(pElt) au dernier index"+msgErreur);
      msgErreur = verifieListeArriere(liste1,contenu5);
      if(msgErreur.length()!=0)
          System.out.println("(11)Erreur dans effaceAt(pElt) au dernier index "+msgErreur);
      //element du centre   
      liste1.effaceAt(3);
      int[] contenu6 = {2,3,5,7};
      msgErreur = verifieListeAvant(liste1,contenu6);
      if(msgErreur.length()!=0)
          System.out.println("(12)Erreur dans effaceAt(pElt) au centre"+msgErreur);
      msgErreur = verifieListeArriere(liste1,contenu6);
      if(msgErreur.length()!=0)
          System.out.println("(13)Erreur dans effaceAt(pElt) au centre"+msgErreur);
        /** Test EffaceTout(pCollection) ***/
        for(int i = 0; i<contenu6.length; i++)
            liste2.ajoute(contenu6[i]);
        liste1.effaceTout(liste2);
        if(!liste1.estVide())
            System.out.println("(14)Probleme dans la fonction effaceTout(pCollection");

    }
}
