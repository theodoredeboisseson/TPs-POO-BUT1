package fr.umontpellier.iut.exercice4;

class NumeralToRoman {

    public String getRoman(int number){
        String str = "";
        int[] valeurs = {1000,500,100,50,10,9,5,4,1};
        String[] roman = {"M","D","C","L","X","IX","V","IV","I"};

        int i = 0;
        while (i < valeurs.length) {

            while (number >= valeurs[i]) {
                str += roman[i];
                number -= valeurs[i];
            }

        i++;
        }

        return str;
    }
}
