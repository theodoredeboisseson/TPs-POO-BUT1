package fr.umontpellier.iut.partie2;

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
        Technicien t = new Technicien(getNrINSEE(),getNom(),getEchelon(),getBase(),getNbHeures());
        return t.getSalaireBrut() + (representationsEffectuees * 123);
    }

    public static class Builder extends Employe.Builder {
        private String nrINSEE;
        private String nom;
        private int echelon;
        private double base;
        private double nbHeures;
        private double chiffreAffaires;
        private double tauxCommission;

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

        public Builder setChiffreAffaires(double chiffreAffaires) {
            this.chiffreAffaires = chiffreAffaires;
            return this;
        }

        public Builder setTauxCommission(double tauxCommission) {
            this.tauxCommission = tauxCommission;
            return this;
        }

        public Representant build() {
            return new Representant(nrINSEE, nom, echelon, base, nbHeures, chiffreAffaires, tauxCommission);
        }
    }
}
