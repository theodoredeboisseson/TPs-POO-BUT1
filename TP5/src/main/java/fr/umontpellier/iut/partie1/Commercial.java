package fr.umontpellier.iut.partie1;

public abstract class Commercial extends Employe {
    private double chiffreAffaires;
    private double tauxCommision;

    public Commercial(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE,nom,echelon,base,nbHeures);
        this.chiffreAffaires = chiffreAffaires;
        this.tauxCommision = tauxCommission;
    }

    public void negocierTransaction(double sommeGagnée) {
        chiffreAffaires += sommeGagnée;
        System.out.println("Transaction négociée, somme gagnée : "+sommeGagnée);
    }

    @Override
    public double getSalaireBrut(){
        return getBase() + chiffreAffaires * tauxCommision;
    }
}
