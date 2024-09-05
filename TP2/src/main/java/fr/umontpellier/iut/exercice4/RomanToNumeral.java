package fr.umontpellier.iut.exercice4;

import java.util.HashMap;
import java.util.Map;

public class RomanToNumeral {

    private static final Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
    }

    public int getNumeral(String romanNumber) {
        System.out.println(romanNumber);
        int somme = 0;
        int valPrecedente = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            int val = map.get(romanNumber.charAt(i));

            if (val > valPrecedente) {
                somme += val - 2 * valPrecedente;
            } else {
                somme += val;
            }

            valPrecedente = val;
        }

        return somme;
    }

}
/*
    put(key, value): Ajoute une paire clé-valeur à la Map.
    get(key): Récupère la valeur associée à la clé spécifiée.
    remove(key): Supprime la paire clé-valeur associée à la clé spécifiée.
    containsKey(key): Vérifie si la Map contient une clé spécifique.
    containsValue(value): Vérifie si la Map contient une valeur spécifique.
 */