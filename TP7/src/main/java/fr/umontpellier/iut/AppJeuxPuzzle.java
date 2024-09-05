package fr.umontpellier.iut;

import java.util.ArrayList;

public class AppJeuxPuzzle {
    public static void main(String[] args) {
        int[][] tableau = {
                {4,2,7},
                {5,6,1},
                {3,8,0}
        };
        JeuPuzzle taquin = new Taquin(tableau);
        Contexte contexte = new Contexte(taquin);

        contexte.resoudre();
        System.out.println(contexte);

//        JeuPuzzle hanoi = new Hanoi(3);
//        System.out.println(hanoi);
//        ArrayList<Integer> tour1 = new ArrayList<>();
//        ArrayList<Integer> tour2 = new ArrayList<>();
//        ArrayList<Integer> tour3 = new ArrayList<>();
//        tour1.add(3);
//        tour1.add(2);
//        tour1.add(1);
//        JeuPuzzle hanoi2 = new Hanoi(tour1,tour2,tour3,3);


//        hanoi.genererFils();
//        Contexte partieHanoi = new Contexte(hanoi);
//        partieHanoi.resoudre();
//        System.out.println(partieHanoi);

//        int[][] g = {   { 0, 0, 9, 7, 8, 1, 3, 0, 5 },
//                        { 4, 7, 3, 9, 6, 5, 8, 0, 2 },
//                        { 8, 1, 5, 0, 0, 3, 0, 0, 7 },
//                        { 9, 5, 8, 3, 1, 2, 4, 0, 6 },
//                        { 7, 0, 2, 4, 0, 0, 0, 0, 9 },
//                        { 1, 6, 0, 8, 0, 0, 2, 0, 3 },
//                        { 3, 0, 1, 0, 0, 0, 0, 0, 4 },
//                        { 0, 9, 6, 1, 0, 4, 0, 0, 8 },
//                        { 2, 4, 7, 6, 9, 8, 0, 3, 1 } };
//        int[][] g2 = {
//                {4, 1, 2, 3},
//                {3, 2, 1, 4},
//                {2, 3, 4, 1},
//                {1, 4, 3, 2} };
//        int[][] g3 = new int[9][9];
//        JeuPuzzle s1 = new Sudoku(g);
//        System.out.println(s1);
//        ArrayList<? extends JeuPuzzle> a = s1.genererFils();
//
//        Contexte partieSudoku = new Contexte(s1);
//
//
//        long startTime = System.nanoTime();
//
//        partieSudoku.resoudre();
//        System.out.println(partieSudoku);
//
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime)/1000;  // Temps écoulé en nanosecondes
//
//        System.out.println("Temps d'exécution de la fonction : " + duration + " nanosecondes");
    }
}
