package fr.umontpellier.iut.exercice2;

import java.util.ArrayList;

public class PrimeFactors {
    public ArrayList<Integer> computeFactors(int number) {
        ArrayList<Integer> facteursPremiers = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                facteursPremiers.add(i);
                number /= i;
            }
        }

        return facteursPremiers;
    }
}
