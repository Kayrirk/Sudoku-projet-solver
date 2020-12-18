package grille;

public class Grille
{
	// Question 1.1
	private int[][] grille = new int[9][9];

	// Question 1.2
	public Grille()
	{

	}

	public Grille(int[][] grille)
	{
		this.grille = grille;
	}

	// Question 1.4
	public int get(int i, int j)
	{
		return grille[i][j];
	}

	public void set(int i, int j, int valeur)
	{
		grille[i][j] = valeur;
	}

	// Question 1.3
	public String toString()
	{
		String str = "";
		for (int i = 0; i < 3; i++)
		{
			str += grille[i][0] + "" + grille[i][1] + "" + grille[i][2] + "|" + grille[i][3] + "" + grille[i][4] + ""
					+ grille[i][5] + "|" + grille[i][6] + "" + grille[i][7] + "" + grille[i][8] + "" + "\n";

		}
		str += "--------------\n";
		for (int i = 3; i < 6; i++)
		{
			str += grille[i][0] + "" + grille[i][1] + "" + grille[i][2] + "|" + grille[i][3] + "" + grille[i][4] + ""
					+ grille[i][5] + "|" + grille[i][6] + "" + grille[i][7] + "" + grille[i][8] + "" + "\n";
		}
		str += "--------------\n";
		for (int i = 6; i < 9; i++)
		{
			str += grille[i][0] + "" + grille[i][1] + "" + grille[i][2] + "|" + grille[i][3] + "" + grille[i][4] + ""
					+ grille[i][5] + "|" + grille[i][6] + "" + grille[i][7] + "" + grille[i][8] + "" + "\n";
		}
		return str;

	}

	// Question 2.1 : Methode qui teste si la ligne i est remplie et correcte.

	public boolean testLigne(int i)
	{
		int[] test = new int[9];
		for (int j = 0; j < 9; j++)
		{
			// si valeur impossible pour un sukoku -> ligne fausse
			if (grille[i][j] < 1 || grille[i][j] > 9)
				return false;
			// on stocke les valeurs de 1 à 9 déjà rencotrées
			else if (test[grille[i][j] - 1] == 0)
				test[grille[i][j] - 1] = 1;
			/*
			 * On note dans la case du tab test correspondante si la valeur n a été rencontrée 0 1 2 3 4 5 6 7 8 9 = 10 cases ( test[0] ne sera jamais utilisée) si -1 : 0 1 2 3 4 5 6 7 8 = 9 cases
			 */

			else
				// Si on rencontre à nouveau la même valeur alors test[grille[i][j]] != 0 ->
				// ligne fausse
				return false;
		}
		return true;
	}

	// Question 2.2 : Methode qui teste si la colonne i est remplie et correcte.

	public boolean testColonne(int j)
	{
		int[] test = new int[9];
		for (int i = 0; i < 9; i++)
		{
			// si valeur impossible pour un sukoku -> COLONNE fausse
			if (grille[i][j] < 1 || grille[i][j] > 9)
				return false;
			// on stocke les valeurs de 1 à 9 déjà rencotrées
			else if (test[grille[i][j] - 1] == 0)
				test[grille[i][j] - 1] = 1;

			// On note dans la case du tab test correspondante si la valeur n a été
			// rencontrée
			else
				// Si on rencontre à nouveau la même valeur alors test[grille[i][j]] != 0 ->
				// colonne fausse
				return false;
		}
		return true;
	}

	// Question 2.3 : Methode qui teste si un carre (i0, j0) est rempli et correcte.

	public boolean testCarre(int i0, int j0)
	{
		int[] test = new int[9];

		for (int i = i0; i < i0 + 3; i++)
		{
			for (int j = j0; j < j0 + 3; j++)
			{
				if (grille[i][j] < 1 || grille[i][j] > 9) // valeurs de 1 à 9 acceptés
					return false;
				else if (test[grille[i][j] - 1] == 0)
					test[grille[i][j] - 1] = 1;
				else
					return false;
			}
		}
		return true;
	}

	// Question 2.4 : m´ethode qui verifie si la grille de sudoku est terminée

	public boolean testGrille()
	{

		for (int i = 0; i < 9; i++)
		{
			if (testLigne(i) == false)
				return false;
		}
		for (int j = 0; j < 9; j++)
		{
			if (testColonne(j) == false)
				return false;
		}

		for (int i = 0; i < 9; i += 3)
		{
			for (int j = 0; j < 9; j += 3)
			{
				if (testCarre(i, j) == false)
					return false;
			}
		}
		return true;
	}

	// Question 2.5 :cf package jeu

	// Question 3.1 : methode qui teste si une valeur peut etre placee dans une case
	// dans l etat courant de la grille.

	public boolean isCorrect(int i, int j, int valeur)
	{

		// On cherche valeur dans la ligne
		for (int k = 0; k < 9; k++)
		{
			if (grille[k][j] == valeur)
				return false;

		}
		// On cherche valeur dans la colonne
		for (int k = 0; k < 9; k++)
		{
			if (grille[i][k] == valeur)
				return false;
		}
		// On cherche valeur dans le carré
		int i0 = i - i % 3;
		int j0 = j - j % 3;
		for (int ki = i0; ki < i0 + 3; ki++)
		{
			for (int kj = j0; kj < j0 + 3; kj++)
			{
				if (grille[ki][kj] == valeur)
					return false;
			}
		}
		// true si tout est ok
		return true;
	}

	// ajout
	// https://www.science-et-vie.com/questions-reponses/dans-un-sudoku-y-a-t-il-un-minimum-de-cases-preremplies-5100
	// Si le sudoku à moins de 17 valeurs remplis, alors il n'y a pas 1 solution
	// unique mais
	// plusieurs, donc nous le considereront comme faux.

	public boolean isSolvable()
	{
		int count = 81;
		for (int i = 0; i < 9; i += 3)
		{
			for (int j = 0; j < 9; j += 3)
			{
				if (grille[i][j] < 1 || grille[i][j] > 9)
					count -= 1;
			}
		}
		if (count < 17)
			return false;
		else
			return true;
	}

}
