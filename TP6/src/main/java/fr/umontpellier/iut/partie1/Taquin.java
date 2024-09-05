package fr.umontpellier.iut.partie1;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Taquin {
    private final int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    /**
     * @return true si le Taquin courant est dans une configuration gagnante
     */
    public boolean estGagnant() {
        int n = tableau.length, m = tableau[0].length;
        int numero = 1;

        for (int[] t: tableau)
            for (int palet: t) {
                if( !( (palet == numero && numero != n*m)|| (palet == 0 && numero == n*m) )  )
                    return false;
                numero++;
            }

        return true;
    }

    /**
     * @return la liste des configurations obtenues avec un seul mouvement
     * à partir du Taquin courant
     */
    public ArrayList<Taquin> genererFils() {
        ArrayList<Taquin> liste = new ArrayList<>();
        int[] trou = trouverTrou();
        int i = trou[0], j = trou[1];

        if(trou[0] != 0 && tableau.length > 1){
            Taquin haut = nouvelleCopie();
            haut.tableau[i][j] = haut.tableau[i-1][j];
            haut.tableau[i-1][j] = 0;
            liste.add(haut);
        } if(trou[1] != 0){
            Taquin gauche = nouvelleCopie();
            gauche.tableau[i][j] = gauche.tableau[i][j-1];
            gauche.tableau[i][j-1] = 0;
            liste.add(gauche);
        } if(trou[0] != tableau.length-1 && tableau.length > 1){
            Taquin bas = nouvelleCopie();
            bas.tableau[i][j] = bas.tableau[i+1][j];
            bas.tableau[i+1][j] = 0;
            liste.add(bas);
        }  if(trou[1] != tableau[0].length-1 ){
            Taquin droite = nouvelleCopie();
            droite.tableau[i][j] = droite.tableau[i][j+1];
            droite.tableau[i][j+1] = 0;
            liste.add(droite);
        } return liste;
    }


    public Taquin nouvelleCopie(){
        int n = tableau.length, m = tableau[0].length;
        Taquin copie = new Taquin(new int[n][m]);

        for(int i = 0; i < n; i++)
            System.arraycopy(this.tableau[i], 0, copie.tableau[i], 0, m);
        return copie;
    }

    /**
     * @return un tableau [i,j] si tableau[i][j]==0
     */
    public int[] trouverTrou() {
        for(int i = 0; i < tableau.length; i++)
            for(int j = 0; j < tableau[0].length; j++)
                if(tableau[i][j] == 0)
                    return new int[]{i, j};

        return new int[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taquin taquin)) return false;
        if (tableau.length != taquin.tableau.length) return false;
        return Arrays.deepEquals(tableau, taquin.tableau);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tableau);
    }

    @Override
    public String toString() {
        int n = tableau.length, m = tableau[0].length;
        StringBuilder str = new StringBuilder();

        str.append("X");
        str.append("~~~".repeat(m));
        str.append("X\n");

        for(int i = 0; i < n; i++){
            str.append("|");
            for (int palet: tableau[i])
                str.append(String.format("%2s", palet)).append(" ");
            str.append("|\n");
        }

        str.append("X");
        str.append("~~~".repeat(m));
        str.append("X\n");

        return str.toString();
    }
}
