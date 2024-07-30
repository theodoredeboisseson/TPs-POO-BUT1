package fr.umontpellier.iut;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GestionEmployesTest {

    private Employe e1 = new Employe("1","1",1);
    private Employe e2 = new Employe("2","2",2);
    private Entreprise et = new Entreprise();

//    @Disabled
    @Test
    public void test_if_main_method_was_implemented() {
        assertDoesNotThrow(() -> GestionEmployes.main(new String[1]));
    }

    @Test
    public void meme_mois_anciennete_avec_jour_differents(){
        e1.setDateEmbauche(LocalDate.now().minusMonths(6));
        e2.setDateEmbauche(LocalDate.now().minusMonths(6).minusDays(15));

        assertEquals(e1.getMoisAnciennete(),e2.getMoisAnciennete());
    }

    @Test
    public void mois_anciennete_differents_avec_1_jour_differents(){
        e1.setDateEmbauche(LocalDate.now().minusMonths(6));
        e2.setDateEmbauche(LocalDate.now().minusMonths(5).minusDays(29));

        assertNotEquals(e1.getMoisAnciennete(),e2.getMoisAnciennete());
    }

    @Test
    public void test_scenario_remercier(){
        Employe fifi = new Employe("0","filou",15);
        Employe loulou = new Employe("0","filou",30);
        Employe toto = new Employe("0+0","toto",100);


        et.embaucher(toto,LocalDate.of(2000, 1, 1));
        et.embaucher(fifi,LocalDate.of(2024, 5, 2));
        et.embaucher(loulou,LocalDate.of(2024, 5, 30));

        et.remercier(1);
        assertTrue(et.getLePersonnel().stream().anyMatch(e -> e == toto));
        assertTrue(et.getLePersonnel().stream().anyMatch(e -> e == fifi));
        assertFalse(et.getLePersonnel().stream().anyMatch(e -> e == loulou));
    }
/*
    Astuce : Pour cette question, pensez à vérifier le scénario suivant :

    Créer 3 employés comme ceci
2 employés fifi et loulou avec le même numéro INSEE et le même nom et des bases différentes
1 employé toto avec numéro INSEE, nom et base quelconques
    Embaucher d'abord toto avec une date d'embauche la plus ancienne (disons 1er janvier 2000), ensuite fifi (2 mai 2024) et ensuite loulou (30 mai 2024)
    Remercier qu'un seul employé en invoquant remercier(1) et vérifier que tout fonctionne correctement.*/

}