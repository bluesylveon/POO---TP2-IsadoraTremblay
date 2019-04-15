package com.isa.structures;

/*
* A FAIRE 
* Inserez l'entete ici
* 
*/
public class Vecteur {
	private int nbElements;
	private static final int VALEUR_INITIALE = 10;
	private int[] tableau;
	private final int RATIO_AGRANDISSEMENT = 2;

	/**
	 * Constructeur d'un vecteur vide
	 */
	public Vecteur() {
		tableau = new int[VALEUR_INITIALE];
		nbElements = 0;
	}

	/**
	 * Constructeur avec des elements de depart dans le vecteur
	 */
	public Vecteur(int[] elementDepart) {
		tableau = elementDepart;
		nbElements = elementDepart.length;
	}

	/**
	 * Fonction indiquant si la structures de donnees vide
	 * 
	 * @return true si la structure est vide
	 */
	public boolean estVide() {
		return nbElements == 0 ? true : false;
	}

	/**
	 * Fonction ajoutant un element a la fin du vecteur
	 * 
	 * @param element la valeur de l'element a ajouter
	 */
	public void ajoute(int element) {
		needResize();
		tableau[nbElements] = element;
		++nbElements;
	}

	/**
	 * Fonction qui ajoute une collection au vecteur
	 * 
	 * @param collection la structure de donnees a ajouter au vecteur
	 */
	public void ajoute(Vecteur collection) {
		int indexTableau = nbElements;
		for (int i = 0; i < collection.getNbElements(); i++) {
			needResize();
			tableau[indexTableau] = collection.getElementAt(i);
			++indexTableau;
		}
	}

	/**
	 * Fonction qui ajoute un element a un index donne du vecteur
	 * 
	 * @param pElement l'element a ajouter
	 * @param pIdx     l'index auquel on insere l'element
	 * @return boolean true si pIdx est valide, false sinon
	 */
	public boolean ajoute(int element, int index) {
		if (isIndexInvalide(index))
			return false;

		needResize();
		permutation(index);
		tableau[index] = element;
		++nbElements;

		return true;
	}

	private void permutation(int index) {
		for (int i = nbElements; i >= index; i--) {
			if (i == nbElements - 1) {
				emergencyResize();

			}
			int tempo = tableau[i];
			tableau[i] = tableau[i + 1];
			tableau[i + 1] = tempo;

		}
	}

	/**
	 * Fonction effacant le contenu d'un vecteur
	 */
	public void effaceTout() {
		tableau = new int[VALEUR_INITIALE];
		nbElements = 0;
	}

	private void needResize() {
		if (nbElements >= tableau.length)
			resize();
	}

	/**
	 * Fonction permettant d'agrandir le vecteur lorsque celui-ci est rempli
	 */
	private void resize() {
		int[] tabTempo = new int[tableau.length * RATIO_AGRANDISSEMENT];
		for (int i = 0; i < tableau.length; i++)
			tabTempo[i] = tableau[i];
		tableau = tabTempo;
	}

	private void emergencyResize() {
		int[] tabTempo = new int[tableau.length + 2];
		for (int i = 0; i < tableau.length; i++)
			tabTempo[i] = tableau[i];
		tableau = tabTempo;
	}

	/**
	 * Fonction d'acces au nombre d'elements du vecteur
	 * 
	 * @return int le nombre d'elements contenus dans le vecteur
	 */
	public int getNbElements() {
		return nbElements;
	}

	/**
	 * Fonction permettant d'effacer un element en particulier d'un vecteur
	 * 
	 * @param idx l'index dont on veut effacer le contenu
	 * @return boolean indiquant si oui ou non l'index etait valide
	 */
	public boolean effaceAt(int index) {
		if (isIndexInvalide(index))
			return false;

		int newNbElements = nbElements - 1;
		int[] tabTempo = tableau;
		tableau = new int[newNbElements];
		int indexTableau = 0;
		for (int i = 0; i < nbElements - 1; i++) {
			if (i != index) {
				tableau[indexTableau] = tabTempo[i];
				++indexTableau;
			}
		}
		nbElements = newNbElements;
		return true;
	}

	/**
	 * Fonction effacant toutes les instances d'une certaine valeur dans le vecteur
	 * 
	 * @param element l'item a effacer dans le vecteur
	 * @return boolean vrai si un changement est effectue dans le vecteur this
	 */
	public boolean effaceTout(int element) {
		int[] tabTempo = tableau;
		int nbRemove = 0;

		for (int i = 0; i < tableau.length; i++) {
			nbRemove += tableau[i] == element ? 1 : 0;
		}
		if (nbRemove == 0)
			return false;

		int newNbElements = nbElements - nbRemove;
		tableau = new int[nbElements];

		int indexTableau = 0;
		for (int i = 0; i < newNbElements - 1; i++) {
			if (tabTempo[i] != element) {
				tableau[indexTableau] = tabTempo[i];
				++indexTableau;
			}
		}
		nbElements = newNbElements;
		return true;
	}

	/**
	 * Fonction permettant d'effacer de this tous les elements de la structure
	 * pCollection
	 * 
	 * @param pCollection, Vecteur
	 * @return true si des changements sont apportes a this
	 */
	public boolean effaceTout(Vecteur collection) {
		int elementToRemove = 0;
		for (int i = 0; i < tableau.length; i++) {
			if (collection.trouve(tableau[i]))
				++elementToRemove;
		}
		if (elementToRemove == 0)
			return false;

		nbElements -= elementToRemove;
		int[] tabTempo = new int[nbElements];
		int index = 0;

		for (int i = 0; i < tableau.length; i++) {
			if (!collection.trouve(tableau[i])) {
				tabTempo[index] = tableau[i];
				++index;
			}
		}
		tableau = tabTempo;
		return true;
	}

	/**
	 * Fonction permettant de cherche un element dans un vecteur
	 * 
	 * @param item l'element a chercher
	 * @return boolean vrai si l'element est present dans le vecteur
	 */
	public boolean trouve(int item) {
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] == item)
				return true;
		}
		return false;
	}

	/**
	 * Fonction permettant d'indiquer si TOUS les elements d'un vecteur donne
	 * pCollection sont present dans le vecteur this.
	 * 
	 * @param collection le vecteur dont on cherche les elements
	 * @return boolean true si tous les elements de pCollection sont dans this
	 */
	public boolean trouveTout(Vecteur collection) {
		for (int i = 0; i < collection.getNbElements(); i++) {
			if (!trouve(collection.getElementAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * Fonction permettant d'acceder au ieme element d'un vecteur
	 * 
	 * @param idx l'index de l'element a acceder. On considerera que l'index est
	 *            valide. Nous verrons plus tard comment traiter ce type d'erreurs
	 *            avec les exceptions
	 * @return int l'element a l'index idx
	 */
	public int getElementAt(int index) {
		if (isIndexInvalide(index))
			return Integer.MIN_VALUE;
		return tableau[index];
	}

	private boolean isIndexInvalide(int index) {
		return (nbElements <= index && index != 0) || index < 0;
	}

	/**
	 * Surdefinition de la fonction toString
	 * 
	 * @return String representation sous forme de String du vecteur
	 */
	public String toString() {
		String vec = "";
		for (int i = 0; i < tableau.length; i++)
			vec += tableau[i] + " ";
		return vec;
	}

}
