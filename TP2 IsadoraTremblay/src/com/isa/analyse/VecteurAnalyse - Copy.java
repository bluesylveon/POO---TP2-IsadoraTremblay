package com.isa.analyse;

import com.isa.structures.Vecteur;

public class VecteurAnalyse {
	public static void main(String[] args) {
		Vecteur vecteur1000 = new Vecteur();
		Vecteur vecteur10000 = new Vecteur();
		Vecteur vecteur100000 = new Vecteur();

		TimeCounter time = new TimeCounter();

		time.start();
		for (int i = 0; i < 1000; i++) {
			vecteur1000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements a la fin 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			vecteur10000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements la fin 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 100000; i++) {
			vecteur100000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements a la fin 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 1000; i++) {
			vecteur1000.effaceAt(vecteur1000.getNbElements());
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements a la fin 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			vecteur10000.effaceAt(vecteur10000.getNbElements());
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements la fin 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 100000; i++) {
			vecteur100000.effaceAt(vecteur100000.getNbElements());
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements a la fin 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 1000; i++) {
			vecteur1000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			vecteur10000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100000; i++) {
			vecteur100000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 100; i++) {
			vecteur1000.trouve(50);
			time.stop();
		}
		System.out.printf("Recherche d'elements 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100; i++) {
			vecteur10000.trouve(50);
			time.stop();
		}
		System.out.printf("Recherche d'elements 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100; i++) {
			vecteur100000.trouve(50);
			time.stop();
		}
		System.out.printf(
				"Recherche d'elements 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < vecteur1000.getNbElements() - 1; i++) {
			vecteur1000.effaceAt(0);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements au debut 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < vecteur10000.getNbElements() - 1; i++) {
			vecteur10000.effaceAt(0);
			time.stop();
		}

		System.out.printf(
				"Suppression d'elements au debut 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < vecteur100000.getNbElements() - 1; i++) {
			vecteur100000.effaceAt(0);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements au debut 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
	}

}
