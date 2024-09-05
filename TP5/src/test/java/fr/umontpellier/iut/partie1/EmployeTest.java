package fr.umontpellier.iut.partie1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {
    private Employe e = new Employe("1","MonsieurTest",1,10,10);;

    @BeforeEach
    public void initialisation() {

    }

    @Test
    void salaireBrutCorrect() {
        assertEquals(100,e.getSalaireBrut());
    }

    @Test
    void salaireNetCorrect() {
        assertEquals(80,e.getSalaireNet());
    }
}