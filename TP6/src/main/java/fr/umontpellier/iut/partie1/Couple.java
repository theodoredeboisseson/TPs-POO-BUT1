package fr.umontpellier.iut.partie1;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class Couple {

    private final Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }

    /**
     * Vérifie si les fils du taquin sont déjà vus et met à jour la frontière
     * et l'ensemble des configurations déjà vues.
     */
    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> dejaVus) {
        ArrayList<Taquin> listeFils = taquin.genererFils();

        if(!listeFils.isEmpty())
            for(Taquin t : listeFils)
                if(!dejaVus.contains(t)){
                    dejaVus.add(t);
                    frontiere.add(new Couple(t,this));
                }
    }

    /**
     * @return la liste des taquins intermédiaires à partir du taquin initial
     * et jusqu'au taquin courant
     */
    public ArrayList<Taquin> getListeDeMouvements() {
        ArrayList<Taquin> liste = new ArrayList<>();
        Couple actuel = this;

        while(actuel != null){
            liste.add(actuel.taquin);
            actuel = actuel.predecesseur;
        }
        Collections.reverse(liste);

        return liste;
    }
    //couple courant = solution trouvée par l'arbre

    public Taquin getTaquin() {
        return taquin;
    }


}
