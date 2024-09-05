package fr.umontpellier.iut;

import java.util.ArrayList;
import java.util.Objects;

public class Hanoi implements JeuPuzzle {
    ArrayList<Integer> gauche = new ArrayList<>();
    ArrayList<Integer> milieu = new ArrayList<>();
    ArrayList<Integer> droite = new ArrayList<>();
    private int taille;

    /* crée un hanoi avec la configuration suivante :
     * sur la tour 1 les disques [taille,taille-1, .., 1]
     * rien sur les tour 2 et 3 (elles sont vides)
     */
    public Hanoi(int taille) {
        this.taille = taille;
        for(int i = taille; i > 0; i--)
            gauche.add(i);
    }

    /*
    Crée un hanoi où la tour 1 (resp. tour 2 et tour 3) contient les entiers de tour1 (resp. tour2 et tour3). Par exemple,
    si tour1 est une ArrayList contenant [3,2,1], et tour2 et tour3 sont des ArrayList vides, alors
    Hanoi(tour1, tour2, tour3) doit créer la même configuration que Hanoi(3).
     */
    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        gauche = tour1;
        milieu = tour2;
        droite = tour3;
        this.taille = taille;
    }

    public boolean estGagnant() {
        if (droite.size() == taille){
            for(int i = 0; i < taille; i++)
                if(droite.get(i) != taille - i)
                    return false;
            return true;
        }

        return false;
    }


    public ArrayList<Hanoi> genererFils() {
        ArrayList<Hanoi> liste = new ArrayList<>();

        if( !(gauche.isEmpty() && milieu.isEmpty()) ){
            Hanoi fils1 = genererFilsAdaptatif(new ArrayList<>(gauche),new ArrayList<>(milieu),1);
            liste.add(fils1);
        }
        if( !(gauche.isEmpty() && droite.isEmpty()) ){
            Hanoi fils2 = genererFilsAdaptatif(new ArrayList<>(gauche),new ArrayList<>(droite),2);
            liste.add(fils2);
        }
        if( !(milieu.isEmpty() && droite.isEmpty()) ){
            Hanoi fils3 = genererFilsAdaptatif(new ArrayList<>(milieu),new ArrayList<>(droite),3);
            liste.add(fils3);
        }

        return liste;
    }


    private Hanoi genererFilsAdaptatif(ArrayList<Integer> tour1, ArrayList<Integer> tour2, int mode) {
        if(tour1.isEmpty() && tour2.isEmpty()){
            System.out.println("L'une des deux tour ne doit pas être vide");
            System.exit(1);
        } if(mode != 1 && mode != 2 && mode != 3) {
            System.out.println("Votre mode pour genererFils doit etre compris entre 1 et 3");
            System.exit(1);
        }

        Hanoi fils;
        if(mode == 1)
            fils = new Hanoi(tour1,tour2,new ArrayList<>(droite),taille);
        else if(mode == 2)
            fils = new Hanoi(tour1,new ArrayList<>(milieu),tour2,taille);
        else
            fils = new Hanoi(new ArrayList<>(gauche),tour1,tour2,taille);


        if(tour1.isEmpty())
            passerDisque(tour2,tour1);
        else if (tour2.isEmpty())
            passerDisque(tour1,tour2);
        else {
            if (tour1.get(tour1.size() - 1) < tour2.get(tour2.size() - 1))
                passerDisque(tour1,tour2);
            else
                passerDisque(tour2,tour1);
        }

        return fils;
    }

    public static void passerDisque(ArrayList<Integer> source, ArrayList<Integer> destination) {
        Integer disque = source.get(source.size()-1);
        source.remove(disque);
        destination.add(disque);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hanoi hanoi)) return false;
        if (taille != hanoi.taille) return false;
        return gauche.equals(hanoi.gauche) && milieu.equals(hanoi.milieu) && droite.equals(hanoi.droite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gauche, milieu, droite, taille);
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("~~~".repeat(2*taille+4)).append("\n]");

        for(Integer i: gauche)
            str.append(i).append("-");
        str.append("-".repeat((taille-gauche.size())*2)).append("\n]");

        for(Integer i: milieu)
            str.append(i).append("-");
        str.append("-".repeat((taille-milieu.size())*2)).append("\n]");

        for(Integer i: droite)
            str.append(i).append("-");
        str.append("-".repeat((taille-droite.size())*2)).append("\n");


        str.append("~~~".repeat(2*taille+4)).append("\n");

        return str.toString();
    }
}
