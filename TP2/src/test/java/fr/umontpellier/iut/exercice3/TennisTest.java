package fr.umontpellier.iut.exercice3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TennisTest {
    String j1 = "Federer";
    String j2 = "Nadal";
    Tennis jeu = new Tennis(j1, j2);


//    @Disabled
    @Test
    public void test_nouveau_jeu_doit_retourner_zero_partout() {
        jeu = new Tennis(j1, j2);
        String score = jeu.getScore();

        assertEquals("0 : 0", score);
    }

//    @Disabled
    @Test
    public void test_premier_joueur_remporte_le_premier_point() {
        jeu = new Tennis(j1, j2);
        jeu.gagnerPoint(j1);
        String score = jeu.getScore();

        assertEquals("15 : 0", score);
    }

//    @Disabled
    @Test
    public void test_15_partout() {
        jeu = new Tennis(j1, j2);
        jeu.gagnerPoint(j1);
        jeu.gagnerPoint(j2);
        String score = jeu.getScore();

        assertEquals("15 : 15", score);
    }

//    @Disabled
    @Test
    public void test_deuxieme_joueur_gagne_trois_points_daffilee() {
        jeu = new Tennis(j1, j2);
        marquerPoints(0, 3);
        String score = jeu.getScore();

        assertEquals("0 : 40", score);
    }

//    @Disabled
    @Test
    public void test_premier_joueur_gagne() {
        jeu = new Tennis(j1, j2);
        marquerPoints(4, 0);
        String score = jeu.getScore();

        assertEquals("Federer gagne", score);
    }

//    @Disabled
    @Test
    public void test_deuxieme_joueur_gagne() {
        marquerPoints(1, 4);
        String score = jeu.getScore();

        assertEquals("Nadal gagne", score);
    }

//    @Disabled
    @Test
    public void test_joueurs_a_egalite() {
        jeu = new Tennis(j1, j2);
        marquerPoints(3, 3);
        String score = jeu.getScore();

        assertEquals("Égalité", score);
    }

//    @Disabled
    @Test
    public void test_joueurs_a_egalite2() {
        marquerPoints(4, 4);
        String score = jeu.getScore();

        assertEquals("Égalité", score);
    }

//    @Disabled
    @Test
    public void test_avantage_joueur_1() {
        marquerPoints(4, 3);
        String score = jeu.getScore();

        assertEquals("Avantage Federer", score);
    }

//    @Disabled
    @Test
    public void test_avantage_joueur_2() {
        marquerPoints(3, 4);
        String score = jeu.getScore();

        assertEquals("Avantage Nadal", score);
    }

//    @Disabled
    @Test
    public void test_joueur_1_gagne_apres_avantage() {
        marquerPoints(5, 3);
        String score = jeu.getScore();

        assertEquals("Federer gagne", score);
    }

//    @Disabled
    @Test
    public void test_joueur_2_gagne_apres_avantage() {
        marquerPoints(4, 6);
        String score = jeu.getScore();

        assertEquals("Nadal gagne", score);
    }

    // méthode utilitaire pour ajouter des points pour chacun des joueurs
    private void marquerPoints(int nbPoints1, int nbPoints2) {
        for (int i = 0; i < nbPoints1; i++) {
            jeu.gagnerPoint(j1);
        }
        for (int i = 0; i < nbPoints2; i++) {
            jeu.gagnerPoint(j2);
        }
    }
}