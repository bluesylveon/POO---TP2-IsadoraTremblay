package com.isa.structures;

//A implanter
public class NoeudSimple {
	public int valeur;
	private NoeudSimple prochain;

	public NoeudSimple(int nValeur) {
		valeur = nValeur;
	}

	public int getValeur() {
		return valeur;
	}

	public NoeudSimple getProchain() {
		return prochain;
	}

	public void setProchain(NoeudSimple pProchain) {
		prochain = pProchain;
	}

	public String toString() {
		return String.format("Noeud courant % : Noeud prochain %", valeur, prochain.getValeur());
	}
}
