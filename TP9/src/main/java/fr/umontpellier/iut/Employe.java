package fr.umontpellier.iut;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employe {
    private String nrINSEE;
    private String nom;
    private double base;

    private LocalDate dateEmbauche;

    private double bonus; // pour exo3

    private String villeDeResidence; // pour exo4

    public Employe(String nrINSEE, String nom, double base) {
        this.nrINSEE = nrINSEE;
        this.nom = nom;
        this.base = base;
    }

    public String getNrINSEE() {
        return nrINSEE;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getVilleDeResidence() {
        return villeDeResidence;
    }

    public void setVilleDeResidence(String villeDeResidence) {
        this.villeDeResidence = villeDeResidence;
    }

    public int getMoisAnciennete() {
        long intervalleEnMois = ChronoUnit.MONTHS.between(dateEmbauche, LocalDate.now());
        return (int) intervalleEnMois;
    }

    public double getIndemniteTransport() {
        try {
            int distance = GestionDistances.getDistance(villeDeResidence);
            return base * distance;
        } catch (VilleInconnueException v) {
            System.out.println("Pas de distance pour la ville "+villeDeResidence);
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nrINSEE, employe.nrINSEE) && Objects.equals(nom, employe.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrINSEE, nom);
    }

    @Override
    public String toString() {
        return String.format("""
                %s d'INSEE %s, reçoit actuellement un bonus de %s€
                """,nom,nrINSEE,bonus);
    }
}
