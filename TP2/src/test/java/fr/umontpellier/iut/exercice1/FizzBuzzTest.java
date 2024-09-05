package fr.umontpellier.iut.exercice1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class FizzBuzzTest {
    private FizzBuzz fizzBuzz = new FizzBuzz();

    //@Disabled//
    @Test
    public void test_one_should_print_one() {
        String result = fizzBuzz.getValue(1);
        assertEquals("1", result);
    }

   /* @Disabled*/
    @Test
    public void test_two_should_print_two() {
        String result = fizzBuzz.getValue(2);
        assertEquals("2", result);
    }

//    @Disabled
    @Test
    public void test_three_should_print_fizz() {
        String result = fizzBuzz.getValue(3);
        assertEquals("Fizz", result);
    }

//    @Disabled
    @Test
    public void test_five_should_print_buzz() {
        String result = fizzBuzz.getValue(5);
        assertEquals("Buzz", result);
    }

//    @Disabled
    @Test
    public void test_six_should_print_fizz() {
        String result = fizzBuzz.getValue(6);
        assertEquals("Fizz", result);
    }

//    @Disabled
    @Test
    public void test_ten_should_print_buzz() {
        String result = fizzBuzz.getValue(10);
        assertEquals("Buzz", result);
    }

//    @Disabled
    @Test
    public void test_fifteen_should_print_fizzbuzz() {
        String result = fizzBuzz.getValue(15);
        assertEquals("FizzBuzz", result);
    }

//    @Disabled
    @Test
    public void test_getList_Should_Return_a_sequence_of_5_FizzBuzz_elements_when_5() {
        String[] result = fizzBuzz.computeList(5);
        assertEquals("1", result[0]);
        assertEquals("2", result[1]);
        assertEquals("Fizz", result[2]);
        assertEquals("4", result[3]);
        assertEquals("Buzz", result[4]);
    }
}
