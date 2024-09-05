package fr.umontpellier.iut.exo3;

import java.time.LocalDate;
import java.util.ArrayList;

public class EtudiantJavaBeans {
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private LocalDate dateNaissance;
    private ArrayList<Note> notes;

    public EtudiantJavaBeans() {
        this.notes = new ArrayList<>();
    }


    public String toString() {
        return String.format("""
                        Etudiant : %s %s né le %s
                        dont le mail est %s
                        habite %s
                        """,nom,prenom,dateNaissance,mail,adresse);
    }


    public void noter (Matiere matière, int valeur) {
        Note n = new Note(matière,valeur);
        this.notes.add(n);
    }


    public double calculerMoyenne () {
        int totalCoef = 0;
        double totalNotes = 0;

        for(Note n : this.notes){
            int coef = n.getMatiere().getCoefficient();

            totalNotes += n.getValeur() * coef;
            totalCoef += coef;
        }

        double moyenne;
        if (!this.notes.isEmpty())
            moyenne = totalNotes / totalCoef;
        else
            moyenne = 0;

        return moyenne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateDeNaissance() {
        return dateNaissance;
    }

    public void setDateDeNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
