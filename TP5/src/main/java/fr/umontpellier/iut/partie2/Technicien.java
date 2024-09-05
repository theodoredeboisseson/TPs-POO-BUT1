package fr.umontpellier.iut.partie2;

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

    public static class Builder extends Employe.Builder{
        private String nrINSEE;
        private String nom;
        private int echelon;
        private double base;
        private double nbHeures;

        public Builder setNrINSEE(String nrINSEE) {
            this.nrINSEE = nrINSEE;
            return this;
        }

        public Builder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder setEchelon(int echelon) {
            this.echelon = echelon;
            return this;
        }

        public Builder setBase(double base) {
            this.base = base;
            return this;
        }

        public Builder setNbHeures(double nbHeures) {
            this.nbHeures = nbHeures;
            return this;
        }

        public Technicien build() {
            return new Technicien(nrINSEE, nom, echelon, base, nbHeures);
        }
    }
}
