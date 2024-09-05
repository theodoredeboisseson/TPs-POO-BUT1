package fr.umontpellier.iut.exo3;

import java.util.ArrayList;
public class Departement {
    private String specialite;
    private String adresse;
    private ArrayList<Etudiant> etudiants;

    public Departement(String specialite, String adresse) {
        this.specialite = specialite;
        this.adresse = adresse;
        this.etudiants = new ArrayList<Etudiant>();
    }

    public String toString() {
        String str = String.format("""
                Département spécialisé dans %s
                Situé à l'adresse : %s
                Comprend les étudiants suivants :
                """,specialite,adresse);

        int n = etudiants.size();
        for (Etudiant e : etudiants) {
            str += "    " + e.getNom() + " " + e.getPrenom() + "\n";
        }

        return str;
    }


    public void inscrire(Etudiant e){
        this.etudiants.add(e);
    }


    public void desinscrire(Etudiant e){
        this.etudiants.remove(e);
    }


    public double getMoyennePromo(){
        double totalMoyennes = 0;
        for(Etudiant etu : this.etudiants){
            totalMoyennes += etu.calculerMoyenne();
        }

        double moyennePromo;
        if (!this.etudiants.isEmpty())
            moyennePromo = totalMoyennes / this.etudiants.size();
        else
            moyennePromo = 0;

        return moyennePromo;
    }


}
