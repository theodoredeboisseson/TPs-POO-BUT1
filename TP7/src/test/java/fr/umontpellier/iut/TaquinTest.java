package fr.umontpellier.iut;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaquinTest {
//    @Disabled
    @Test
    public void test_est_gagnant_faux_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        assertFalse(t.estGagnant());
    }

//    @Disabled
    @Test
    public void test_trouver_trou_coin_hd_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        int[] res = t.trouverTrou();
        int[] res2 = {0, 2};
        assertArrayEquals(res2, res);
    }

//    @Disabled
    @Test
    public void test_equals_vrai_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        int[][] data2 = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t2 = new Taquin(data2);
        assertEquals(t, t2);
    }

//    @Disabled
    @Test
    public void test_generer_Fils_coin_3_X_3() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin t = new Taquin(data);
        ArrayList<Taquin> res = t.genererFils();

        ArrayList<Taquin> res2 = new ArrayList<>();
        int[][] datafils1 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        Taquin fils1 = new Taquin(datafils1);
        int[][] datafils2 = {{1, 0, 2}, {4, 5, 3}, {7, 8, 6}};
        Taquin fils2 = new Taquin(datafils2);
        res2.add(fils1);
        res2.add(fils2);
        assertTrue(res.containsAll(res2) && res2.containsAll(res));
    }

    @Test
    public void test_trouverTrou_avec_trou() {
        int[][] data = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        Taquin t = new Taquin(data);
        int[] attendu = {1,1};
        assertArrayEquals(attendu, t.trouverTrou());
    }

    @Test
    public void test_genererFils(){
        int[][] tab1 = { {0,1}, {1,1} };
        Taquin t1 = new Taquin(tab1);

        int[][] tab1_1 = { {1,1}, {0,1} };
        Taquin t1_1 = new Taquin(tab1_1);
        int[][] tab1_2 = { {1,0}, {1,1} };
        Taquin t1_2 = new Taquin(tab1_2);

        ArrayList<Taquin> fils1 = t1.genererFils();
        assertTrue(fils1.contains(t1_1) && fils1.contains(t1_2));
        assertEquals(2,fils1.size());



        int[][] tab2 = { {1,1}, {1,0} };
        Taquin t2 = new Taquin(tab2);

        int[][] tab2_1 = { {1,1}, {0,1} };
        Taquin t2_1 = new Taquin(tab2_1);
        int[][] tab2_2 = { {1,0}, {1,1} };
        Taquin t2_2 = new Taquin(tab2_2);

        ArrayList<Taquin> fils2 = t2.genererFils();
        assertTrue(fils2.contains(t2_1) && fils2.contains(t2_2));
        assertEquals(2,fils2.size());


        int[][] tab3 = { {1,1,1}, {1,0,1}, {1,1,1} };
        Taquin t3 = new Taquin(tab3);

        int[][] tab3_1 = { {1,1,1}, {0,1,1}, {1,1,1} };
        Taquin t3_1 = new Taquin(tab3_1);
        int[][] tab3_2 = { {1,1,1}, {1,1,0}, {1,1,1} };
        Taquin t3_2 = new Taquin(tab3_2);
        int[][] tab3_3 = { {1,1,1}, {1,1,1}, {1,0,1} };
        Taquin t3_3 = new Taquin(tab3_3);
        int[][] tab3_4 = { {1,0,1}, {1,1,1}, {1,1,1} };
        Taquin t3_4 = new Taquin(tab3_4);

        ArrayList<Taquin> fils3 = t3.genererFils();
        assertTrue(fils3.contains(t3_1) && fils3.contains(t3_2) && fils3.contains(t3_3) && fils3.contains(t3_4));
        assertEquals(4,fils3.size());
    }
}