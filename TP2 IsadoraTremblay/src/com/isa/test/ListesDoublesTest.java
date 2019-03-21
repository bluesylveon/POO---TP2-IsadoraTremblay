package com.isa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.isa.structures.ListeDouble;

public class ListesDoublesTest {
	private ListeDouble list;

	@Before
	public void before() {
		list = new ListeDouble();
		for (int i = 0; i <= 10; i++) {
			list.ajoute(i);
		}
	}

	@Test
	public void ajouteTest() {
		list.ajoute(42);

		assertEquals(12, list.getNbElements());
	}

	@Test
	public void ajouteAtTest() {
		list.ajoute(42, 5);

		assertEquals(true, list.trouve(42));
	}

	@Test
	public void trouveItemTrueTest() {
		assertEquals(true, list.trouve(5));
	}

	@Test
	public void trouveItemFalseTest() {
		assertEquals(false, list.trouve(100));
	}

	@Test
	public void getProchainTest() {
		assertEquals(1, list.getPremier().getProchain().getValeur());
	}

	@Test
	public void trouveToutTrueTest() {
		ListeDouble toFind = new ListeDouble();
		toFind.ajoute(2);
		toFind.ajoute(1);

		assertEquals(true, list.trouveTout(toFind));
	}

	@Test
	public void trouveToutFalseTest() {
		ListeDouble toFind = new ListeDouble();
		toFind.ajoute(2);
		toFind.ajoute(42);

		assertEquals(false, list.trouveTout(toFind));
	}

	@Test
	public void ajouteCollectionTest() {
		// Arrange
		ListeDouble listeAdd;
		listeAdd = new ListeDouble();
		for (int i = 11; i <= 20; i++) {
			listeAdd.ajoute(i);
		}

		list.ajoute(listeAdd);

		assertEquals(true, list.trouveTout(listeAdd));
	}

	@Test
	public void effaceToutTest() {
		list.effaceTout();

		assertEquals(true, list.estVide());
	}

	@Test
	public void effaceAtTest() {
		list.effaceAt(0);

		assertEquals(false, list.trouve(0));
	}

	@Test
	public void effaceToutListeTest() {
		ListeDouble toErase = new ListeDouble();
		toErase.ajoute(2);
		toErase.ajoute(3);
		toErase.ajoute(10);

		list.effaceTout(toErase);

		assertEquals(false, list.trouveTout(toErase));
	}

	@Test
	public void effaceToutElementTest() {
		list.ajoute(0);
		list.ajoute(0);
		list.ajoute(0);

		list.effaceTout(0);

		assertEquals(false, list.trouve(0));
	}

}