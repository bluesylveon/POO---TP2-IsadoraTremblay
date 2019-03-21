package com.isa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.isa.structures.Vecteur;

public class VecteurTest {
	private Vecteur vecteur;

	@Before
	public void before() {
		int[] tab = { 0, 1, 6, 3, 4, 5, 6, 7, 8, 9 };
		vecteur = new Vecteur(tab);
	}

	@Test
	public void vecteurCreationTest() {
		new Vecteur();
	}

	@Test
	public void vecteurPleinCreationTest() {
		// Arrange
		int[] tab = new int[10];

		// Act
		new Vecteur(tab);
	}

	@Test
	public void ajouteElementTest() {
		// Arrange
		Vecteur vecteur1 = new Vecteur();

		// Act
		vecteur1.ajoute(5);

		// Assert
		assertEquals(1, vecteur1.getNbElements());
	}

	@Test
	public void ajouteDeuxElementTest() {
		// Arrange
		vecteur = new Vecteur();

		// Act
		vecteur.ajoute(5);
		vecteur.ajoute(6);

		// Assert
		assertEquals(2, vecteur.getNbElements());
	}

	@Test
	public void getElementAvecIndexInvalideTest() {
		// Arrange
		vecteur = new Vecteur();

		// Act
		int valeur = vecteur.getElementAt(0);

		// Assert
		assertEquals(Integer.MIN_VALUE, valeur);
	}

	@Test
	public void getElementAvecIndexValideTest() {
		// Arrange
		Vecteur vecteur1 = new Vecteur();
		vecteur1.ajoute(42);

		// Act
		int valeur = vecteur.getElementAt(3);

		// Assert
		assertEquals(3, valeur);
	}

	@Test
	public void effaceToutTest() {
		// Act
		vecteur.effaceTout();

		// Assert
		assertEquals(0, vecteur.getNbElements());
	}

	@Test
	public void estVideTrueTest() {
		// Arrange
		vecteur.effaceTout();

		// Assert
		assertEquals(true, vecteur.estVide());
	}

	@Test
	public void estVideFalseTest() {
		// Assert
		assertEquals(false, vecteur.estVide());
	}

	@Test
	public void trouveTrueTest() {
		// Assert
		assertEquals(true, vecteur.trouve(3));
	}

	@Test
	public void trouveFalseTest() {
		// Assert
		assertEquals(false, vecteur.trouve(42));
	}

	@Test
	public void effaceToutElementsTrueTest() {
		assertEquals(true, vecteur.effaceTout(6));
	}

	@Test
	public void effaceToutElementsFalseTest() {
		assertEquals(false, vecteur.effaceTout(42));
	}

	@Test
	public void effaceToutElementsTest() {
		// Act
		vecteur.effaceTout(6);

		// Assert
		assertEquals(false, vecteur.trouve(6));
	}

	@Test
	public void effaceAtTrueTest() {
		assertEquals(true, vecteur.effaceAt(4));
	}

	@Test
	public void effaceAtFalseTest() {
		assertEquals(false, vecteur.effaceAt(42));
	}

	@Test
	public void effaceAtTest() {
		// Act
		vecteur.effaceAt(3);

		// Assert
		assertEquals(false, vecteur.trouve(3));
	}

	@Test
	public void ajouteVecteurTest() {
		// Arrange
		int[] integers = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		Vecteur vecteur2 = new Vecteur(integers);

		// Act
		vecteur.ajoute(vecteur2);

		// Assert
		assertEquals(true, vecteur.trouveTout(vecteur2));
	}

	@Test
	public void ajouteElementAtIndexTrueTest() {
		// Assert
		assertEquals(true, vecteur.ajoute(2, 2));
	}

	@Test
	public void ajouteElementAtIndexFalseTest() {
		// Assert
		assertEquals(false, vecteur.ajoute(2, 1000));
	}

	@Test
	public void ajouteElementAtIndexTest() {
		// Act
		vecteur.ajoute(50, 5);

		// Assert
		assertEquals(50, vecteur.getElementAt(5));
	}

	@Test
	public void effaceToutVecteurTest() {
		// Arrange
		int[] tabTest = { 0, 1, 6 };
		Vecteur vecteur2 = new Vecteur(tabTest);

		// Act
		vecteur.effaceTout(vecteur2);

		// Assert
		assertEquals(false, vecteur.trouveTout(vecteur2));
	}

	@Test
	public void trouveToutVecteurTrueTest() {
		// Arrange
		int[] tabTest = { 0, 1, 6 };
		Vecteur vecteur2 = new Vecteur(tabTest);

		// Assert
		assertEquals(true, vecteur.trouveTout(vecteur2));
	}

	@Test
	public void trouveToutVecteurFalseTest() {
		// Arrange
		int[] tabTest = { 0, 42, 6 };
		Vecteur vecteur2 = new Vecteur(tabTest);

		// Assert
		assertEquals(false, vecteur.trouveTout(vecteur2));
	}
}