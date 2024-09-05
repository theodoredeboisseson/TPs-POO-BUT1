package fr.umontpellier.iut.partie2;

import fr.umontpellier.iut.partie2.JeuPuzzle;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class Couple {

    private final JeuPuzzle jeuPuzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle jeuPuzzle, Couple predecesseur) {
        this.jeuPuzzle = jeuPuzzle;
        this.predecesseur = predecesseur;
    }

    /**
     * Vérifie si les fils du taquin sont déjà vus et met à jour la frontière
     * et l'ensemble des configurations déjà vues.
     */
    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<JeuPuzzle> dejaVus) {
        ArrayList<? extends JeuPuzzle> listeFils = jeuPuzzle.genererFils();

        if(!listeFils.isEmpty())
            for(JeuPuzzle j : listeFils)
                if(!dejaVus.contains(j)){
                    dejaVus.add(j);
                    frontiere.add(new Couple(j,this));
                }
    }

    /**
     * @return la liste des taquins intermédiaires à partir du taquin initial
     * et jusqu'au taquin courant
     */
    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> liste = new ArrayList<>();
        Couple actuel = this;

        while(actuel != null){
            liste.add(actuel.jeuPuzzle);
            actuel = actuel.predecesseur;
        }
        Collections.reverse(liste);

        return liste;
    }
    //couple courant = solution trouvée par l'arbre

    public JeuPuzzle getJeuPuzzle() {
        return jeuPuzzle;
    }


}
