package fr.umontpellier.iut.exercice3;

public class Tennis {
    private final String j1;
    private final String j2;
    private int nbPointsJ1;
    private int nbPointsJ2;

    public Tennis(String joueur1, String joueur2) {
        j1 = joueur1;
        j2 = joueur2;
    }

    // incrémente les points du joueur correspondant
    public void gagnerPoint(String joueur) {
        if(joueur.equals(this.j1)) {
            if (nbPointsJ1 < 30)
                nbPointsJ1 += 15;
//            else if (nbPointsJ2 == 50 && nbPointsJ1 == 40) {
//                nbPointsJ2 -= 10;
//            }
            else
                nbPointsJ1 += 10;
        }
        else if(joueur.equals(this.j2)){
            if(nbPointsJ2 < 30)
                nbPointsJ2 += 15;
            else
                nbPointsJ2 += 10;
        }

        else
            System.out.println(joueur+", c'est qui lui ?");
    }

    // Retourne le score courant de la partie sous forme de chaîne de caractères
    // Cette fonction interprète le score actuel sous forme d'un texte respectant la nomenclature d'un jeu de tennis
    public String getScore() {
        if(nbPointsJ1 == nbPointsJ2 && nbPointsJ1 < 40)
            return nbPointsJ1+" : "+nbPointsJ2;
        else if (nbPointsJ1 == nbPointsJ2) {
            return "Égalité";
        } else if ( (nbPointsJ1 == 50 && nbPointsJ2 < 30) || (nbPointsJ2 >= 30 && nbPointsJ1 == nbPointsJ2+20)){
            return j1+" gagne";
        } else if (nbPointsJ2 >= 30 && nbPointsJ1 == nbPointsJ2 +10) {
            return  "Avantage "+j1;
        } else if ( (nbPointsJ2 == 50 && nbPointsJ1 < 30) || (nbPointsJ1 >= 30 && nbPointsJ2 == nbPointsJ1+20)){
            return j2+" gagne";
        } else if (nbPointsJ1 >= 30 && nbPointsJ2 == nbPointsJ1 +10) {
            return "Avantage " + j2;
        }
        else return nbPointsJ1+" : "+nbPointsJ2;
    }
}
