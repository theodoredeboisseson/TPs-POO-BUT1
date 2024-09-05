package fr.umontpellier.iut.exo2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartementTest {

    @Test
    void test_calcul_moyenne_retourne_zero_Quand_Pas_d_etudiant() {
        Departement test = new Departement("Testeurs","1 rue du test");
        assertEquals(0,test.getMoyennePromo());
    }

    @Test
    void test_calcul_moyenne_retourne_moyenne_Quand_un_seul_etudiant() {
        Departement test = new Departement("Testeurs","1 rue du test");
        Etudiant monsieurTest = new Etudiant("test","test","test","test",8,8,2008);
        Matiere maths = new Matiere("Maths",1);

        monsieurTest.noter(maths,20);
        test.inscrire(monsieurTest);
        assertEquals(20,test.getMoyennePromo());
    }

    @Test
    void test_calcul_moyenne_retourne_moyenne_Quand_plusieurs__etudiant() {
        Departement test = new Departement("Testeurs","1 rue du test");
        Etudiant monsieurTest = new Etudiant("test","test","test","test",8,8,2008);
        Etudiant madameTest = new Etudiant("test","test","test","test",8,8,2008);
        Matiere maths = new Matiere("Maths",1);

        monsieurTest.noter(maths,20);
        madameTest.noter(maths,17);
        test.inscrire(monsieurTest);
        test.inscrire(madameTest);
        assertEquals(18.5,test.getMoyennePromo(),0);
    }
}