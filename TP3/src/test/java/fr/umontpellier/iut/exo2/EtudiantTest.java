package fr.umontpellier.iut.exo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EtudiantTest {

    @Test
    void test_calcul_moyenne_retourne_zero_Quand_Pas_De_Note () {
        Etudiant test = new Etudiant("test","test","test","test",8,8,2008);
        assertEquals(0, test.calculerMoyenne());
    }
    @Test
    void test_calcul_moyenne_retourne_valeur_note_quand_une_seule_note_avec_coefficient_de_1 () {
        Etudiant test = new Etudiant("test","test","test","test",8,8,2008);
        Matiere maths = new Matiere("Maths",1);
        test.noter(maths,20);
        assertEquals(20,test.calculerMoyenne());
    }
    @Test
    void test_calcul_moyenne_retourne_valeur_note_quand_une_seule_note_avec_coefficient_autre_que_1 () {
        Etudiant test = new Etudiant("test","test","test","test",8,8,2008);
        Matiere maths = new Matiere("Maths",7);
        test.noter(maths,20);
        assertEquals(20,test.calculerMoyenne());
    }
    @Test
    void test_calcul_moyenne_retourne_moyenne_quand_plusieurs_notes_avec_differents_coefficients () {
        Etudiant test = new Etudiant("test","test","test","test",8,8,2008);

        Matiere maths = new Matiere("maths",5);
        Matiere dev = new Matiere("dev",6);
        Matiere bd = new Matiere("bd",4);

        test.noter(maths,18);
        test.noter(dev,16);
        test.noter(bd,14);
        assertEquals(16.1,test.calculerMoyenne(),0.2);
    }

    @Test
    void test_calcul_moyenne_retourne_moyenne_quand_plusieurs_notes_avec_meme_coefficients () {
        Etudiant test = new Etudiant("test", "test", "test", "test", 8, 8, 2008);

        Matiere maths = new Matiere("maths", 5);
        Matiere dev = new Matiere("dev", 5);
        Matiere bd = new Matiere("bd", 5);

        test.noter(maths, 18);
        test.noter(dev, 15);
        test.noter(bd, 14);

        assertEquals(15.5, test.calculerMoyenne(),0.5);
    }
}