package fr.umontpellier.iut.exo3;

import java.time.LocalDate;
import java.time.Month;

public class GestionEtudiants {

    public static void copier(Etudiant e1, Etudiant e2){
        e1.setNom(e2.getNom());
        e1.setPrenom(e2.getPrenom());
        e1.setMail(e2.getMail());
        e1.setAdresse(e2.getAdresse());
        e1.setDateNaissance(e2.getDateNaissance());
    }

    public static void main(String[] args) {
        EtudiantJavaBeans toto = new EtudiantJavaBeans();
        toto.setNom("Dupont");
        toto.setDateDeNaissance(LocalDate.of(2003, Month.JANUARY, 28));
        toto.setAdresse("99, av. Occitanie, 34000 Montpellier");

        Etudiant lolo = new Etudiant.EtudiantBuilder()
                .setNom("Dupont")
                .setPrenom("Philippe")
                .setDateNaissance(LocalDate.of(2003, Month.JANUARY, 28))
                .setMail("dupont@etu.umontpellier.fr")
                .setAdresse("99, av. Occitanie, 34000 Montpellier")
                .build();
    }
}
