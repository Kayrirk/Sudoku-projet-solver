package jeu;

import java.util.Scanner;

import grille.Grille;

//Question 2.5
public class Jeu
{
	public static void main(String[] args)
	{
		int[][] aux =
		{
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3 },
				{ 8, 9, 0, 4, 5, 6, 1, 2, 3 },
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3 },
				{ 8, 9, 0, 4, 5, 6, 1, 2, 3 },
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 5, 6, 7, 8, 9, 0, 1, 2, 3 },
				{ 8, 9, 0, 4, 5, 6, 1, 2, 3 } };

		Grille maGrille = new Grille(aux);

		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		while (!maGrille.testGrille())
		{
			System.out.println("Entrer ligne i : ");
			int i = myObj.nextInt();
			System.out.println("Entrer colonne j : ");
			int j = myObj.nextInt();
			System.out.println("Entrer chiffre n : ");
			int n = myObj.nextInt();

			maGrille.set(i, j, n);
		}
		System.out.println("Gagné");
		myObj.close();
	}

}
