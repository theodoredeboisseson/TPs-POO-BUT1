package fr.umontpellier.iut.partie1;

public class Representant extends Commercial {
    private int representationsEffectuees = 0;

    public Representant(String nrINSEE, String nom, int echelon, double base, double nbHeures, double chiffreAffaires, double tauxCommission) {
        super(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
    }

    public void representerEntreprise() {
        representationsEffectuees++;
    }



    @Override
    public double getSalaireBrut(){
        Technicien t = new Technicien(super.getNrINSEE(),super.getNom(),super.getEchelon(),super.getBase(),super.getNbHeures());
        return t.getSalaireBrut() + (representationsEffectuees * 123);
    }
}
