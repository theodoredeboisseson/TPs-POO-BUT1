package fr.umontpellier.iut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContexteTest {

    @BeforeEach
    void disableConsole() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) {
            }
        }));

    }

//    @Disabled
    @Test
    public void test_no_exception() {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Contexte c = new Contexte(new Taquin(data));
        assertDoesNotThrow(() -> c.resoudre());
    }

    @Test
    public void test_resoudre_sans_solution() {
        int[][] tab = {
                {0,2},
                {3,1},
        };
        Taquin t = new Taquin(tab);

        Contexte c = new Contexte(t);
        c.resoudre();

        assertEquals(new ArrayList<Taquin>(),c.getSolution());
    }

    @Test
    public void test_resoudre_sans_solution_1D() {
        int[][] tab = {
                {0,2,1,3,4,8,9}
        };
        Taquin t = new Taquin(tab);

        Contexte c = new Contexte(t);
        c.resoudre();

        assertEquals(new ArrayList<Taquin>(),c.getSolution());
    }

    @Test
    public void test_resoudre_avec_solution_1D() {
        int[][] tab1 = { {0,1,2,3,4,5,6} };
        Taquin t1 = new Taquin(tab1);

        int[][] tab2 = { {1,0,2,3,4,5,6} };
        Taquin t2 = new Taquin(tab2);
        int[][] tab3 = { {1,2,0,3,4,5,6} };
        Taquin t3 = new Taquin(tab3);
        int[][] tab4 = { {1,2,3,0,4,5,6} };
        Taquin t4 = new Taquin(tab4);
        int[][] tab5 = { {1,2,3,4,0,5,6} };
        Taquin t5 = new Taquin(tab5);
        int[][] tab6 = { {1,2,3,4,5,0,6} };
        Taquin t6 = new Taquin(tab6);
        int[][] tab7 = { {1,2,3,4,5,6,0} };
        Taquin t7 = new Taquin(tab7);
        ArrayList<Taquin> solutionAttendue = new ArrayList<>();
        solutionAttendue.add(t1);
        solutionAttendue.add(t2);
        solutionAttendue.add(t3);
        solutionAttendue.add(t4);
        solutionAttendue.add(t5);
        solutionAttendue.add(t6);
        solutionAttendue.add(t7);

        Contexte c = new Contexte(t1);
        c.resoudre();

        assertEquals(solutionAttendue,c.getSolution());
    }

    @Test
    public void test_resoudre_avec_solution() {
        int[][] tab1 = { {3,1}, {0,2} };
        Taquin t1 = new Taquin(tab1);

        int[][] tab2 = { {0,1}, {3,2} };
        Taquin t2 = new Taquin(tab2);
        int[][] tab3 = { {1,0}, {3,2} };
        Taquin t3 = new Taquin(tab3);
        int[][] tab4 = { {1,2}, {3,0} };
        Taquin t4 = new Taquin(tab4);

        ArrayList<Taquin> solutionAttendue = new ArrayList<>();
        solutionAttendue.add(t1);
        solutionAttendue.add(t2);
        solutionAttendue.add(t3);
        solutionAttendue.add(t4);

        Contexte c = new Contexte(t1);
        c.resoudre();

        assertEquals(solutionAttendue,c.getSolution());
    }



}