package fr.umontpellier.iut;

import java.time.LocalDate;

public class GestionEmployes {

    public static void main(String[] args) {
        Entreprise bandOfTheHawk = new Entreprise();
        System.out.println(bandOfTheHawk);

        Employe Griffith = new Employe("666","Griffith",-10000);
        bandOfTheHawk.embaucher(Griffith, LocalDate.now().minusYears(2));
        System.out.println(bandOfTheHawk);

        Employe Casca = new Employe("777","Casca",10000);
        bandOfTheHawk.embaucher(Casca, LocalDate.now().minusYears(1));
        System.out.println(bandOfTheHawk);

        Employe Guts = new Employe("999","Guts",1);
        bandOfTheHawk.embaucher(Guts, LocalDate.now());
        System.out.println(bandOfTheHawk);

        bandOfTheHawk.remercier(3);

    }

}
