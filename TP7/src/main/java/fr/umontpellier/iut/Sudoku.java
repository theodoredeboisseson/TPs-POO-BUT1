package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Sudoku implements JeuPuzzle {
    private int[][] grille;

    // pré-requis : la grille est carrée
    public Sudoku(int[][] g) {
        if(g.length != g[0].length){
            System.out.println("La grille de Sodoku n'est pas carrée");
            System.exit(1);
        }

        this.grille = g;
    }


    public boolean estGagnant() {
        for(int[] tab: grille)
            for(int n: tab)
                if(n == 0)
                    return false;

        return checkLignesEtColonnes() && checkCarre();
    }

    public boolean checkLignesEtColonnes(){
        ArrayList<Integer> dejaVusLigne;
        ArrayList<Integer> dejaVusColonne;

        for(int i = 0; i < grille.length; i++){
            dejaVusLigne = new ArrayList<>();
            dejaVusColonne = new ArrayList<>();

            for(int j = 0; j < grille.length; j++){
                if(dejaVusLigne.contains(grille[i][j]) || dejaVusColonne.contains(grille[j][i]))
                    return false;

                dejaVusLigne.add(grille[i][j]);
                dejaVusColonne.add(grille[j][i]);
            }
        }
        return true;
    }

    public boolean checkCarre(){
        ArrayList<Integer> dejaVusCarre;
        int n = (int) sqrt(grille.length);

        for(int i = 0; i < grille.length; i += n)
            for(int j = 0; j < grille.length; j += n){
                dejaVusCarre = new ArrayList<>();

                for(int i2 = i; i2 < i+n; i2++)
                    for(int j2 = j; j2 < j+2; j2++){
                        if(dejaVusCarre.contains(grille[i2][j2]))
                            return false;

                        dejaVusCarre.add(grille[i2][j2]);
                    }
            }
        return true;
    }


    @Override
    public ArrayList<Sudoku> genererFils() {
        ArrayList<Sudoku> listeFils = new ArrayList<>();

        int[] currentTrou = trouverTrou();
        if(currentTrou == null)
            return null;

        ArrayList<Integer> valPossibles = valPossibles(currentTrou);
        for(int n: valPossibles){
            Sudoku copie = nouvelleCopie();
            copie.grille[currentTrou[0]][currentTrou[1]] = n;
            listeFils.add(copie);
        }

        return listeFils;
    }

    public int[] trouverTrou(){
        for(int i = 0; i < grille.length; i++)
            for(int j = 0; j < grille.length; j++)
                if(grille[i][j] == 0)
                    return new int[]{i,j};

        return null;
    }


    public Sudoku nouvelleCopie(){
        int n2 = grille.length;
        Sudoku copie = new Sudoku(new int[n2][n2]);

        for(int i = 0; i < n2; i++)
            System.arraycopy(this.grille[i], 0, copie.grille[i], 0, n2);

        return copie;
    }


    public ArrayList<Integer> ensPlein(){
        ArrayList<Integer> ens = new ArrayList<>();
        for(int i = 1; i <= grille.length; i++)
            ens.add(i);

        return ens;
    }


    public int[] debCarre(int i,int j) {
        int n = (int) sqrt(grille.length);

        i = i - (i%n);
        j = j - (j%n);
        return new int[]{i,j};
    }


    public ArrayList<Integer> valPossibles(int[] trou){
        ArrayList<Integer> valPossibles = ensPlein();
        int n2 = grille.length;


        for (int[] ligne:grille) //col
            if (valPossibles.contains(ligne[trou[1]]))
                valPossibles.remove(Integer.valueOf(ligne[trou[1]]));

        if(!valPossibles.isEmpty())
            for(int j = 0; j < n2; j++) //lin
                if(valPossibles.contains(grille[trou[0]][j]))
                    valPossibles.remove(Integer.valueOf(grille[trou[0]][j]));

        int[] debCarre = debCarre(trou[0], trou[1]);
        int n = (int) sqrt(n2);
        if(!valPossibles.isEmpty())
            for(int i = debCarre[0]; i < debCarre[0]+n; i++) //carré
                for(int j = debCarre[1]; j < debCarre[1]+n; j++)
                    if(valPossibles.contains(grille[i][j]))
                        valPossibles.remove(Integer.valueOf(grille[i][j]));

        return valPossibles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sudoku sudoku)) return false;
        if (grille.length != sudoku.grille.length) return false;
        return Arrays.deepEquals(grille, sudoku.grille);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grille);
    }

    @Override
    public String toString() {
        int n2 = grille.length;
        StringBuilder str = new StringBuilder();

        str.append("   "); //Espacement pour afficher les coordonnées au bon endroit
        for(int l = 1; l <= n2; l++) //Coordonnées horizontales
            str.append(l).append(" ");
        str.append("\n");

        for(int i = 0; i <= n2; i++){ //lignes
            if(i % (int) sqrt(n2) == 0){ // Barre horizontale pour séparer quand ligne divisible par k.
                str.append("-".repeat(n2 * 2 + 3));
                str.append("\n");
            }

            if(i<n2){
                str.append(i + 1).append(" "); //Coordonnées verticales

                for(int j = 0; j <= n2; j++){ //colonnes
                    if(j % (int) sqrt(n2) == 0)
                        str.append("|"); // Barre verticale
                    else
                        str.append(" ");

                    if(j<n2){
                        if(grille[i][j] ==0) str.append(" ");
                        else str.append(grille[i][j]);
                    }
                }
                str.append("\n");

            }
        }

        return str.toString();
    }

}
