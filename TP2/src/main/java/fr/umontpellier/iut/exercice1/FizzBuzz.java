package fr.umontpellier.iut.exercice1;

public class FizzBuzz {

    public String getValue(int i) {
        String str = "";
        if (i%3 == 0) {
            str += "Fizz";
        }
        if (i%5 == 0) {
            str += "Buzz";
        }
        if (str.isEmpty()) {
            str += i;
        }

        return str;
    }

    public String[] computeList(int n) {
        String[] tab = new String[n];

        for(int i = 0; i < n; i++)
            tab[i] = getValue(i+1);

        return tab;
    }
}
