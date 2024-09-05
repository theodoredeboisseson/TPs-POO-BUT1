package fr.umontpellier.iut.partie1;

import java.util.ArrayList;

public class Contexte {

    private final Taquin taquinInitial;
    private ArrayList<Taquin> solution;

    public Contexte(Taquin taquinInitial) {
        this.taquinInitial = taquinInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<Taquin> dejaVus = new ArrayList<>(), filsActuels;

        Couple coupleInitial = new Couple(taquinInitial,null);
        coupleInitial.mettreAJour(frontiere,dejaVus);

        while(!frontiere.isEmpty() && solution.isEmpty()){
            System.out.println(frontiere.size());

            Couple f = frontiere.remove(0);
            filsActuels = f.getTaquin().genererFils();

            for (Taquin t:filsActuels)
                if(!dejaVus.contains(t) && t.estGagnant()){
                    Couple gagant = new Couple(t,f);
                    solution = gagant.getListeDeMouvements();
                    System.out.println("Trouvé!");
                }
            f.mettreAJour(frontiere,dejaVus);
        }

        if (solution.isEmpty())
            System.out.println("Aucune solution trouvée.");
    }

    public ArrayList<Taquin> getSolution() {
        return solution;
    }
}
