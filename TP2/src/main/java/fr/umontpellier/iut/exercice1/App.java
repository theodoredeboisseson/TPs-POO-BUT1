package fr.umontpellier.iut.exercice1;

import java.util.Scanner;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("veuillez saisir un nombre :");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();

        FizzBuzz fizzBuzz = new FizzBuzz();
        String[] result = fizzBuzz.computeList(input);
        System.out.println(Arrays.toString(result));
    }
}
