package fr.umontpellier.iut.partie1;

public class Employe {
    private String nrINSEE;
    private String nom;
    private int echelon;
    private double base;
    private double nbHeures;

    public Employe(String nrINSEE, String nom, int echelon, double base, double nbHeures) {
        this.nrINSEE = nrINSEE;
        this.nom = nom;
        this.echelon = echelon;
        this.base = base;
        this.nbHeures = nbHeures;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Employe setEchelon(int echelon) {
        this.echelon = echelon;
        return this;
    }

    //--------------------------------------------------------
    public String getNrINSEE() {
        return nrINSEE;
    }

    public String getNom() {
        return nom;
    }

    public int getEchelon() {
        return echelon;
    }

    public double getBase() {
        return base;
    }

    public double getNbHeures() {
        return nbHeures;
    }


    public double getSalaireBrut(){
        return base * nbHeures;
    }

    public double getSalaireNet() {
        return getSalaireBrut() * 0.8;
    }

    public void incrementerEchelon(int n) {
        echelon += n;
    }

    @Override
    public String toString() {
        return String.format("""
                L'employé %s avec nrINSEE : %s
                Est d'échelon %s, avec une base de %s
                Il a travaillé %s heures ce mois-ci.
                Salaire BRUT : %s€
                Salaire NET : %s€
                """,nom,nrINSEE,echelon,base,nbHeures,getSalaireBrut(),getSalaireNet());
    }
}
