package com.isa.structures;

/*
 * A FAIRE 
 * Inserez l'entete ici
 * 
 */
public class ListeSimple {
	// declaration des variables membres ici
	private NoeudSimple premier;
	private int nbElements;

	/**
	 * Constructeur d'une liste vide
	 */
	public ListeSimple() {
		nbElements = 0;
	}

	/**
	 * Fonction d'acces au premier noeud de la liste
	 */
	public NoeudSimple getPremier() {
		return premier;
	}

	/**
	 * Fonction indiquant si la structures de donnees vide
	 * 
	 * @return true si la structure est vide
	 */
	public boolean estVide() {
		return premier == null;
	}

	/**
	 * Fonction ajoutant un element a la fin de la liste
	 * 
	 * @param element la valeur de l'element a ajouter
	 */
	public void ajoute(int element) {
		if (estVide()) {
			premier = new NoeudSimple(element);
			++nbElements;
			return;
		}
		NoeudSimple noeud = getNoeudAt(nbElements - 1);
		NoeudSimple newNoeud = new NoeudSimple(element);
		noeud.setProchain(newNoeud);
		++nbElements;
	}

	/**
	 * Fonction qui ajoute un element a un index donne de la liste
	 * 
	 * @param element l'element a ajouter
	 * @param index   l'index auquel on insere l'element
	 * @return boolean true si pIdx est valide, false sinon
	 */
	public boolean ajoute(int element, int index) {
		if (isIndexInvalide(index))
			return false;

		NoeudSimple noeud = getNoeudAt(index);
		NoeudSimple newNoeud = new NoeudSimple(element);
		for (int i = 0; i < index - 1; i++) {
			noeud = noeud.getProchain();
		}
		if (noeud.getProchain() == null)
			newNoeud.setProchain(null);
		else {
			newNoeud.setProchain(noeud.getProchain());
			noeud.setProchain(newNoeud);
		}
		++nbElements;
		return true;
	}

	/**
	 * Fonction qui ajoute une collection a la liste
	 * 
	 * @param collection la structure de donnees a ajouter a la liste
	 */
	public void ajoute(ListeSimple collection) {
		if (estVide()) {
			premier = collection.getPremier();
			return;
		}
		NoeudSimple noeud = premier;
		while (noeud.getProchain() != null)
			noeud = noeud.getProchain();

		noeud.setProchain(collection.getPremier());
		nbElements += collection.getNbElements();
		return;
	}

	/**
	 * Fonction effacant le contenu de la liste
	 */
	public void effaceTout() {
		premier = null;
	}

	/**
	 * Fonction d'acces au nombre d'elements de la liste
	 * 
	 * @return int le nombre d'elements contenus dans la liste
	 */
	public int getNbElements() {
		return nbElements;
	}

	/**
	 * Fonction effacant toutes les instances d'une certaine valeur dans la liste
	 * 
	 * @param item l'item a effacer dans la liste
	 * @return boolean vrai si un changement est apporte a la liste.
	 */
	public boolean effaceTout(ListeSimple listToErase) {
		int nbRemoved = 0;
		for (int i = 0; i < listToErase.getNbElements(); i++) {
			if (trouve(listToErase.getElementAt(i))) {
				NoeudSimple noeudPreced = premier;
				NoeudSimple noeudToErase = noeudPreced.getProchain();
				while (noeudToErase.getValeur() != listToErase.getElementAt(i)) {
					noeudPreced = noeudPreced.getProchain();
					noeudToErase = noeudToErase.getProchain();
				}
				noeudPreced.setProchain(noeudToErase.getProchain());
				++nbRemoved;
			}
			nbElements -= nbRemoved;
		}
		return nbRemoved != 0;
	}

	/**
	 * Fonction permettant d'effacer un element en particulier dans la liste
	 * 
	 * @param idx l'index dont on veut effacer le contenu
	 * @return boolean indiquant si oui ou non l'index etait valide
	 */
	public boolean effaceAt(int index) {
		if (isIndexInvalide(index))
			return false;

		NoeudSimple noeud = premier;
		NoeudSimple noeudToErase = premier;
		for (int i = 0; i < index - 1; i++) {
			noeud = noeudToErase;
			noeudToErase = noeudToErase.getProchain();
		}
		if (noeudToErase.getProchain() == null)
			noeud.setProchain(null);
		else
			noeud.setProchain(noeudToErase.getProchain());
		--nbElements;
		return true;
	}

	/**
	 * Fonction effacant toutes les instances d'une certaine valeur dans la liste
	 * 
	 * @param element l'item a effacer dans la liste
	 * @return boolean vrai si un changement est apporte a la liste.
	 */

	public boolean effaceTout(int element) {
		int nbRemoved = 0;

		NoeudSimple noeudPreced = premier;
		NoeudSimple noeudToRemove = premier;

		while (trouve(element)) {
			while (noeudToRemove.getValeur() != element) {
				noeudPreced = noeudToRemove;
				noeudToRemove = noeudPreced.getProchain();
			}

			NoeudSimple noeudSuivant = noeudToRemove.getProchain();
			noeudPreced.setProchain(noeudSuivant);
			noeudToRemove = noeudSuivant;
			++nbRemoved;
		}
		nbElements -= nbRemoved;
		return nbRemoved != 0;
	}

	/**
	 * Fonction permettant de cherche un element dans une liste
	 * 
	 * @param item l'element a chercher
	 * @return boolean vrai si l'element est present, false sinon
	 */
	public boolean trouve(int item) {
		NoeudSimple noeud = premier;
		while (noeud != null && noeud.getValeur() != item) {
			noeud = noeud.getProchain();
		}
		return noeud != null;
	}

	/**
	 * Fonction permettant d'indiquer si TOUS les elements d'une liste donne
	 * pCollection sont present, dans l'ordre ou pas, dans la liste this.
	 * 
	 * @param pCollection la liste dont on cherche les elements
	 * @return boolean true si tous les elements de pCollection sont dans this
	 */
	public boolean trouveTout(ListeSimple listToFind) {
		NoeudSimple noeud = listToFind.getPremier();
		while (noeud != null) {
			if (!trouve(noeud.getValeur()))
				return false;
			noeud = noeud.getProchain();
		}
		return true;
	}

	/**
	 * Fonction permettant d'acceder au ieme element d'une liste
	 * 
	 * @param idx l'index de l'element a acceder. On considerera que l'index est
	 *            valide. Nous verrons plus tard comment traiter ce type d'erreurs
	 *            avec les exceptions
	 * @return int l'element a l'index idx
	 */
	public int getElementAt(int index) {
		NoeudSimple noeud = premier;

		for (int i = 0; i < index; i++)
			noeud = noeud.getProchain();

		return noeud.getValeur();
	}

	public int getLastElement() {
		NoeudSimple noeud = premier;
		while (noeud.getProchain() != null)
			noeud = noeud.getProchain();
		return noeud.getValeur();
	}

	private NoeudSimple getNoeudAt(int index) {
		NoeudSimple noeud = premier;
		for (int i = 0; i < index; i++) {
			noeud = noeud.getProchain();
		}
		return noeud;
	}

	private boolean isIndexInvalide(int index) {
		return nbElements < index || index < 0;
	}

	/**
	 * Surdefinition de la fonction toString
	 * 
	 * @return String representation sous forme de String de la liste
	 */
	public String toString() {
		String liste = "";
		NoeudSimple noeud;
		for (noeud = premier; noeud != null; noeud = noeud.getProchain())
			liste += noeud.getValeur() + " ";

		return liste;
	}

}
