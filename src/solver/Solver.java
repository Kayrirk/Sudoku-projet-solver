package solver;

import grille.Grille;

public class Solver
{
	Grille grille;

	public Solver(Grille grille)
	{
		this.grille = grille;
	}

	public boolean solve()
	{
		if (grille.isSolvable() == false)
		{
			System.out.println("Sudoku non solvable (moins de 17 valeurs)");
			return false;
		}

		else
		{
			// on parcourt le sudoku ligne i par ligne i et colonne j par colonne j
			for (int i = 0; i < 9; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					// si une case a pour valeur 0 alors la case est à complétée
					if (grille.get(i, j) == 0)
					{
						// on test les différentes valeurs possibles pour la case vide
						for (int k = 1; k < 10; k++)
						{
							// si la valeur testée peut être placée dans le sudoku
							if (grille.isCorrect(i, j, k))
							{
								grille.set(i, j, k);
								if (solve())// début de la partie récursive
									return true;
								else
									grille.set(i, j, 0);
								// si la valeur testée n'est pas la solution, on vide la case et on continu
							}
						}
						return false;
					}
				}
			}
			return true; // le Sudoku est résolu
		}
	}// fin solver

}// fin de classe
