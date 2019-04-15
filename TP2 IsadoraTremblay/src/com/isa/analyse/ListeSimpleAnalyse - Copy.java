package com.isa.analyse;

import com.isa.structures.ListeSimple;;

public class ListeSimpleAnalyse {
	public static void main(String[] args) {
		ListeSimple listeSimple1000 = new ListeSimple();
		ListeSimple listeSimple10000 = new ListeSimple();
		ListeSimple listeSimple100000 = new ListeSimple();

		TimeCounter time = new TimeCounter();

		time.start();
		for (int i = 0; i < 1000; i++) {
			listeSimple1000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements a la fin 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			listeSimple10000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements la fin 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100000; i++) {
			listeSimple100000.ajoute(45);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements a la fin 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 1000; i++) {
			listeSimple1000.effaceAt(listeSimple1000.getNbElements() - 1);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements a la fin 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			listeSimple10000.effaceAt(listeSimple10000.getNbElements() - 1);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements la fin 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100000; i++) {
			listeSimple100000.effaceAt(listeSimple100000.getNbElements() - 1);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements a la fin 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 1000; i++) {
			listeSimple1000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 10000; i++) {
			listeSimple10000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100000; i++) {
			listeSimple100000.ajoute(45, 0);
			time.stop();
		}
		System.out.printf(
				"Insertion d'elements au debut 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < 100; i++) {
			listeSimple1000.trouve(50);
			time.stop();
		}
		System.out.printf("Recherche d'elements 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100; i++) {
			listeSimple10000.trouve(50);
			time.stop();
		}
		System.out.printf("Recherche d'elements 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < 100; i++) {
			listeSimple100000.trouve(50);
			time.stop();
		}
		System.out.printf(
				"Recherche d'elements 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());

		time.start();
		for (int i = 0; i < listeSimple1000.getNbElements() - 1; i++) {
			listeSimple1000.effaceAt(0);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements au debut 1000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < listeSimple10000.getNbElements() - 1; i++) {
			listeSimple10000.effaceAt(0);
		}
		time.stop();
		System.out.printf(
				"Suppression d'elements au debut 10 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
		time.start();
		for (int i = 0; i < listeSimple100000.getNbElements() - 1; i++) {
			listeSimple100000.effaceAt(0);
			time.stop();
		}
		System.out.printf(
				"Suppression d'elements au debut 100 000\nTemps total: %d\nTemps moyen: %d\nMinimum: %d\nMaximum: %d\n\n",
				time.getTotalTime(), time.getAverageTime(), time.getMinTime(), time.getMaxTime());
	}

}
