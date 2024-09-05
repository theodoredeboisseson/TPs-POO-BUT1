package fr.umontpellier.iut.exo1;

import java.time.LocalDate;

public class Etudiant {
    private String nom;
    private String prenom;
    private String mail;
    private String adresse;
    private LocalDate dateNaissance;

    public Etudiant(String nom, String prenom, String mail, String adresse,
                    int jour, int mois, int annee) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.dateNaissance = LocalDate.of(annee,mois,jour);
    }


    public String toString() {
        return String.format("""
                        Etudiant : %s %s né le %s
                        dont le mail est %s
                        habite %s
                        """,nom,prenom,dateNaissance,mail,adresse);
    }


    public void setNom(String nom){
        this.nom = nom;
    }
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setMail(String mail){this.mail = mail;}
    public void setAdresse(String adresse){this.adresse = adresse;}
    public void setDateNaissance(LocalDate date){this.dateNaissance = date;}

    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public String getMail(){return this.mail;}
    public String getAdresse(){return this.adresse;}
    public LocalDate getDateNaissance(){return this.dateNaissance;}

}
