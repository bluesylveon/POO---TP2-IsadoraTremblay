package com.isa.structures;

public class NoeudDouble {
	private int valeur;
	private NoeudDouble prochain;
	private NoeudDouble precedent;

	public NoeudDouble(int element) {
		valeur = element;
	}

	public int getValeur() {
		return valeur;
	}

	public NoeudDouble getProchain() {
		return prochain;
	}

	public NoeudDouble getPrecedent() {
		return precedent;
	}

	public void setProchain(NoeudDouble prochain) {
		this.prochain = prochain;
	}

	public void setPrecedent(NoeudDouble precedent) {
		this.precedent = precedent;
	}
}
