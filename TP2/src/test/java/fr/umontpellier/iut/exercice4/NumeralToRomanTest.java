package fr.umontpellier.iut.exercice4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeralToRomanTest {

    private NumeralToRoman numeralToRoman = new NumeralToRoman();


//    @Disabled
    @Test
    void one_should_give_I() {
        assertEquals("I", numeralToRoman.getRoman(1));
    }


//    @Disabled
    @Test
    void five_should_give_V() {
        assertEquals("V", numeralToRoman.getRoman(5));
    }


//    @Disabled
    @Test
    void ten_should_give_X() {
        assertEquals("X", numeralToRoman.getRoman(10));
    }


//    @Disabled
    @Test
    void fifty_should_give_L() {
        assertEquals("L", numeralToRoman.getRoman(50));
    }


//    @Disabled
    @Test
    void hundred_should_give_C() {
        assertEquals("C", numeralToRoman.getRoman(100));
    }


//    @Disabled
    @Test
    void fivehundred_should_give_D() {
        assertEquals("D", numeralToRoman.getRoman(500));
    }


//    @Disabled
    @Test
    void thousand_should_give_M() {
        assertEquals("M", numeralToRoman.getRoman(1000));
    }


//    @Disabled
    @Test
    void two_should_give_II() {
        assertEquals("II", numeralToRoman.getRoman(2));
    }


//    @Disabled
    @Test
    void three_should_give_III() {
        assertEquals("III", numeralToRoman.getRoman(3));
    }


//    @Disabled
    @Test
    void four_should_give_IV() {
        assertEquals("IV", numeralToRoman.getRoman(4));
    }


//    @Disabled
    @Test
    void six_should_give_VI() {
        assertEquals("VI", numeralToRoman.getRoman(6));
    }


//    @Disabled
    @Test
    void seven_should_give_VII() {
        assertEquals("VII", numeralToRoman.getRoman(7));
    }


//    @Disabled
    @Test
    void eight_should_give_VIII() {
        assertEquals("VIII", numeralToRoman.getRoman(8));
    }


//    @Disabled
    @Test
    void nine_should_give_IX() {
        assertEquals("IX", numeralToRoman.getRoman(9));
    }

//    @Disabled
    @Test
    void eleven_should_give_XI() {
        assertEquals("XI", numeralToRoman.getRoman(11));
    }


//    @Disabled
    @Test
    void thousandsixtysix_should_give_MLXVI() {
        assertEquals("MLXVI", numeralToRoman.getRoman(1066));
    }

}
