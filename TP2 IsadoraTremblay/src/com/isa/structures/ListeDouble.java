package com.isa.structures;

/*
 * A FAIRE 
 * Inserez l'entete ici
 * 
 */
public class ListeDouble {
	// declaration des variables membres ici
	private NoeudDouble premier;
	private NoeudDouble dernier;
	private int nbElements;

	/**
	 * Constructeur d'une liste vide
	 */
	public ListeDouble() {
		nbElements = 0;
	}

	/**
	 * Fonction d'acces au premier noeud de la liste
	 */
	public NoeudDouble getPremier() {
		return premier;
	}

	/**
	 * Fonction d'acces au dernier noeud de la liste
	 */
	public NoeudDouble getDernier() {
		return dernier;
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
			premier = new NoeudDouble(element);
			dernier = premier;
			++nbElements;
			return;
		}
		NoeudDouble noeud = dernier;
		dernier = new NoeudDouble(element);
		noeud.setProchain(dernier);
		dernier.setPrecedent(noeud);
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
		if (estVide()) {
			premier = new NoeudDouble(element);
			++nbElements;
		}
		NoeudDouble noeudPreced = premier;
		for (int i = 0; i < index - 1; i++) {
			noeudPreced = noeudPreced.getProchain();
		}
		NoeudDouble newNoeud = new NoeudDouble(element);
		NoeudDouble noeudProchain = noeudPreced.getProchain();
		newNoeud.setProchain(noeudProchain);
		noeudPreced.setProchain(newNoeud);
		
		if(noeudProchain!=null)
			noeudProchain.setPrecedent(newNoeud);
		newNoeud.setPrecedent(noeudPreced);
		++nbElements;
		return true;
	}

	/**
	 * Fonction qui ajoute une collection a la liste
	 * 
	 * @param collection la structure de donnees a ajouter a la liste
	 */
	public void ajoute(ListeDouble collection) {
		if (estVide()) {
			premier = collection.getPremier();
			dernier = collection.getDernier();
			return;
		}
		NoeudDouble noeudPreced = dernier;
		noeudPreced.setProchain(collection.getPremier());
		dernier = collection.getDernier();
		nbElements += collection.getNbElements();
	}

	/**
	 * Fonction effacant le contenu de la liste
	 */
	public void effaceTout() {
		premier = null;
		dernier = null;
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
	 * @return boolean vrai si un changement est apporte a la liste, false sinon
	 */
	public boolean effaceTout(ListeDouble listToErase) {
		int nbRemoved = 0;
		for (int i = 0; i < listToErase.getNbElements() - 1; i++) {
			if (trouve(listToErase.getElementAt(i))) {
				NoeudDouble noeudToErase = premier;
				while (noeudToErase.getValeur() != listToErase.getElementAt(i))
					noeudToErase = noeudToErase.getProchain();
				NoeudDouble noeudPreced = noeudToErase.getPrecedent();
				NoeudDouble noeudProchain = noeudToErase.getProchain();
				noeudPreced.setProchain(noeudProchain);
				noeudProchain.setPrecedent(noeudPreced);
				++nbRemoved;
			}
		}
		nbElements -= nbRemoved;
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

		NoeudDouble noeudToErase = premier;

		for (int i = 0; i < index; i++)
			noeudToErase = noeudToErase.getProchain();

		NoeudDouble noeudPreced = noeudToErase.getPrecedent();
		NoeudDouble noeudProchain = noeudToErase.getProchain();

		if (noeudPreced == null) {
			premier = noeudProchain;
		}

		else {
			noeudPreced.setProchain(noeudProchain);
			if (noeudProchain != null)
				noeudProchain.setPrecedent(noeudPreced);
		}

		--nbElements;
		return true;
	}

	/**
	 * Fonction effacant toutes les instances d'une certaine valeur dans la liste
	 * 
	 * @param element l'item a effacer dans la liste
	 * @return boolean vrai si un changement est apporte a la liste, false sinon
	 */

	public boolean effaceTout(int element) {
		int nbRemoved = 0;

		NoeudDouble noeudToRemove = premier;
		while (trouve(element)) {
			while (noeudToRemove.getValeur() != element) {
				noeudToRemove = noeudToRemove.getProchain();
			}

			NoeudDouble noeudPreced = noeudToRemove.getPrecedent();
			NoeudDouble noeudProchain = noeudToRemove.getProchain();
			if (noeudPreced == null) {
				premier = noeudProchain;
			} else {
				noeudPreced.setProchain(noeudProchain);
				if (noeudProchain != null)
					noeudProchain.setPrecedent(noeudPreced);
			}
			noeudToRemove = noeudProchain;
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
		NoeudDouble noeud = premier;
		while (noeud != null && noeud.getValeur() != item) {
			noeud = noeud.getProchain();
		}
		return noeud != null;
	}

	/**
	 * Fonction permettant d'indiquer si TOUS les elements d'une liste donne
	 * listToFind sont present dans la liste this.
	 * 
	 * @param listToFind la liste dont on cherche les elements
	 * @return boolean true si tous les elements de pCollection sont dans this
	 */
	public boolean trouveTout(ListeDouble listToFind) {
		NoeudDouble noeud = listToFind.getPremier();
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
	 * @param index l'index de l'element a acceder. On considerera que l'index est
	 *              valide. Nous verrons plus tard comment traiter ce type d'erreurs
	 *              avec les exceptions
	 * @return int l'element a l'index idx
	 */
	public int getElementAt(int index) {
		NoeudDouble noeud = premier;

		for (int i = 0; i < index; i++)
			noeud = noeud.getProchain();

		return noeud.getValeur();
	}

	/**
	 * Surdefinition de la fonction toString
	 * 
	 * @return String representation sous forme de String de la liste
	 */
	private boolean isIndexInvalide(int index) {
		return nbElements < index || index < 0;
	}

	public String toString() {
		String liste = "";
		NoeudDouble noeud;
		for (noeud = premier; noeud != null; noeud = noeud.getProchain())
			liste += noeud.getValeur() + " ";

		return liste;
	}

}
