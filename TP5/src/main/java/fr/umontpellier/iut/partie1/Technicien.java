package fr.umontpellier.iut.partie1;

public class Technicien extends Employe {

    public Technicien(String nrINSEE, String nom, int echelon, double base, double nbHeures) {
        super(nrINSEE,nom,echelon,base,nbHeures);
    }

    public void effectuerTacheTechnique() {
        incrementerEchelon(1);
        System.out.println("Tâche technique effectuée, augmentation d'échelon.");
    }

    @Override
    public double getSalaireBrut(){
        return super.getSalaireBrut() + getEchelon() * 100;
    }

}
