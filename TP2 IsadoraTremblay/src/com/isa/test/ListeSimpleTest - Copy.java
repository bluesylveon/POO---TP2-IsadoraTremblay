package com.isa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.isa.structures.ListeSimple;

public class ListeSimpleTest {
	private ListeSimple list;

	@Before
	public void before() {
		list = new ListeSimple();
		for (int i = 0; i <= 10; i++) {
			list.ajoute(i);
		}
	}

	@Test
	public void ajouteTest() {
		list.ajoute(42);

		assertEquals(42, list.getLastElement());
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
		ListeSimple toFind = new ListeSimple();
		toFind.ajoute(2);
		toFind.ajoute(1);

		assertEquals(true, list.trouveTout(toFind));
	}

	@Test
	public void trouveToutFalseTest() {
		ListeSimple toFind = new ListeSimple();
		toFind.ajoute(2);
		toFind.ajoute(42);

		assertEquals(false, list.trouveTout(toFind));
	}

	@Test
	public void ajouteCollectionTest() {
		// Arrange
		ListeSimple listeAdd;
		listeAdd = new ListeSimple();
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
		list.effaceAt(10);

		assertEquals(false, list.trouve(9));
	}

	@Test
	public void effaceToutListeTest() {
		ListeSimple toErase = new ListeSimple();
		toErase.ajoute(2);
		toErase.ajoute(3);
		toErase.ajoute(10);

		list.effaceTout(toErase);

		assertEquals(false, list.trouveTout(toErase));
	}

	@Test
	public void effaceToutElementTest() {
		list.ajoute(10);
		list.ajoute(10);
		list.ajoute(10);

		list.effaceTout(10);

		assertEquals(false, list.trouve(10));
	}

}
