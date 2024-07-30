package fr.umontpellier.iut.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperationTest {

//    @Disabled
    @Test
    void calculerValeur_10_fois_5() {
        Expression e = new Operation('*', new Nombre(10), new Nombre(5));
        assertEquals(50, e.calculerValeur());
    }


//    @Disabled
    @Test
    void calculerValeur_2_fois_parenthese_3_plus_1_parenthese() {
        Expression e = new Operation('*', new Nombre(2), new Operation('+', new Nombre(3), new Nombre(1)));
        assertEquals(8, e.calculerValeur());
    }

    @Test
    void calculerValeur_erreur_division_par_0(){
        Expression e = new Operation('/', new Nombre(1), new Nombre(0));
        try {
            e.calculerValeur();
            fail();
        } catch (ArithmeticException ae){
            assertTrue(true);
        }
    }
}
