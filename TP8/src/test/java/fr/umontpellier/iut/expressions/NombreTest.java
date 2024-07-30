package fr.umontpellier.iut.expressions;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NombreTest {

    @Test
    public void calculerValeur_0() {
        assertEquals(0, new Nombre(0).calculerValeur());
    }

    @Test
    public void calculerValeur_double(){
        assertEquals(3.14,new Nombre(3.14).calculerValeur());
    }

    @Test
    void calculerValeur_double_negatif(){
        double d = -358789.441115;
        assertEquals(d, new Nombre(d).calculerValeur());
    }
}