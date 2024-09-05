package fr.umontpellier.iut.partie1;

public class AppTaquin {
    public static void main(String[] args) {
        int[][] tab = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Taquin t1 = new Taquin(tab);

        t1.estGagnant();
//        System.out.println(t1);
//        System.out.println(t1.estGagnant());
//
//        ArrayList<Taquin> liste = t1.genererFils();

//        ArrayList<Integer> test = new ArrayList<>();
//        test.add(1); test.add(2); test.add(3);
//        System.out.println(test);

        Contexte partie = new Contexte(t1);
        partie.resoudre();
    }
}
