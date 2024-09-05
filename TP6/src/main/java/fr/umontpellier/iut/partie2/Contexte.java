package fr.umontpellier.iut.partie2;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Contexte{

    private final JeuPuzzle jeuPuzzleInitial;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle jeuPuzzleInitial) {
        this.jeuPuzzleInitial = jeuPuzzleInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<JeuPuzzle> dejaVus = new ArrayList<>();
        ArrayList<? extends JeuPuzzle> filsActuels;

        Couple coupleInitial = new Couple(jeuPuzzleInitial,null);
        coupleInitial.mettreAJour(frontiere,dejaVus);

        if (jeuPuzzleInitial.estGagnant()){
            solution.add(jeuPuzzleInitial);
            System.out.println("Puzzle déjà résolu");
        } else if(dejaVus.get(0).estGagnant()){
            solution = frontiere.get(0).getListeDeMouvements();
            System.out.println("Solution en 1 coup");
        }

        while(!frontiere.isEmpty() && solution.isEmpty()){
            System.out.println(frontiere.size());

            //Couple f = frontiere.remove(0); //file
            Couple f = frontiere.remove(frontiere.size()-1);//pîle
            filsActuels = f.getJeuPuzzle().genererFils();

            for (JeuPuzzle j:filsActuels)
                if(!dejaVus.contains(j) && j.estGagnant()){
                    Couple gagant = new Couple(j,f);
                    solution = gagant.getListeDeMouvements();
                    System.out.println("Trouvé!");
                }
            f.mettreAJour(frontiere,dejaVus);
        }

        if (solution.isEmpty())
            System.out.println("Aucune solution trouvée.");
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(solution.equals(new ArrayList<>())){
            str.append("Aucune solution pour l'instant, puzzle initial :\n").append(jeuPuzzleInitial);
        } else {
            for(JeuPuzzle j : solution){
                str.append(j).append("\n");
            }
        }
        return str.toString();
    }
}
