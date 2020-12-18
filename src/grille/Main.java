package grille;

import solver.Solver;

public class Main
{
	public static void main(String[] args)
	{
		int[][] auxComplet =
		{

				{ 1, 2, 3, 8, 6, 9, 5, 7, 4 },
				{ 8, 9, 7, 5, 4, 1, 2, 6, 3 },
				{ 5, 4, 6, 3, 7, 2, 1, 8, 9 },
				{ 6, 1, 8, 4, 5, 7, 3, 9, 2 },
				{ 4, 7, 9, 2, 3, 6, 8, 1, 5 },
				{ 3, 5, 2, 1, 9, 8, 6, 4, 7 },
				{ 2, 6, 4, 7, 8, 5, 9, 3, 1 },
				{ 7, 8, 5, 9, 1, 3, 4, 2, 6 },
				{ 9, 3, 1, 6, 2, 4, 7, 5, 8 } };

		int[][] aux =
		{

				{ 1, 2, 3, 0, 6, 9, 5, 7, 4 },
				{ 8, 9, 7, 5, 4, 1, 2, 6, 3 },
				{ 5, 4, 6, 3, 0, 2, 1, 8, 9 },
				{ 6, 1, 8, 4, 5, 0, 3, 9, 2 },
				{ 4, 7, 9, 2, 3, 6, 0, 1, 5 },
				{ 3, 5, 2, 1, 9, 8, 0, 0, 7 },
				{ 2, 6, 4, 7, 8, 5, 9, 3, 0 },
				{ 7, 8, 0, 0, 0, 3, 4, 2, 6 },
				{ 9, 3, 1, 6, 0, 4, 7, 5, 8 } };

		// Grille grille = new Grille(auxComplet);
		// System.out.println(grille.testGrille());

		Grille maGrille = new Grille(aux);
		// System.out.println(maGrille.testGrille());

		Solver monSolver = new Solver(maGrille);

		long t0 = System.nanoTime();
		// long t2 = System.currentTimeMillis();
		monSolver.solve(); // résolution du Sudoku
		long t1 = System.nanoTime();
		// long t3 = System.currentTimeMillis();

		System.out.println("Temps d'exécution en millisecondes 10^(-6) : " + (t1 - t0) / 1000);
		// System.out.println("Temps d'exécution en millisecondes ( 10^(-3)secs ) : " + (t3 - t2));
		System.out.println("\n");

		System.out.println(maGrille.toString());

		// permet de savoir si le solveur à résolu correctement le Sudoku
		System.out.println("Le solver a t-il correctement résolu le Suduko ? \n");
		boolean egal = true;
		for (int i = 0; i < 9; i++)
		{

			for (int j = 0; j < 9; j++)
			{
				if (auxComplet[i][j] != (aux[i][j]))
				{
					egal = false;
				}
			}
		}
		System.out.println(egal);

	}// fin du main

}// fin de la classe