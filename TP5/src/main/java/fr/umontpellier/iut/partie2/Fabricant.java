package fr.umontpellier.iut.partie2;

public class Fabricant extends Employe {
    private int nbUnitesProduites;
    private double tauxCommissionUnite;

    public Fabricant(String nrINSEE, String nom, int echelon, double base, double nbHeures, int nbUnitesProduites, double tauxCommissionUnite) {
        super(nrINSEE,nom,echelon,base,nbHeures);
        this.nbUnitesProduites = nbUnitesProduites;
        this.tauxCommissionUnite = tauxCommissionUnite;
    }

    public Fabricant(Builder b) {
        super(b);
        this.nbUnitesProduites = b.nbUnitesProduites;
        this.tauxCommissionUnite = b.nbUnitesProduites;
    }

    public void fabriquerProduits(int nbProduits) {
        nbUnitesProduites += nbProduits;
        System.out.println("Fabrication de "+nbProduits+" produits.");
    }

    @Override
    public double getSalaireBrut(){
        return super.getSalaireBrut() + nbUnitesProduites * tauxCommissionUnite;
    }

    public static class Builder extends Employe.Builder {
        private String nrINSEE;
        private String nom;
        private int echelon;
        private double base;
        private double nbHeures;
        private int nbUnitesProduites;
        private double tauxCommissionUnite;

        public Builder() {}

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

        public Builder setNbUnitesProduites(int nbUnitesProduites) {
            this.nbUnitesProduites = nbUnitesProduites;
            return this;
        }

        public Builder setTauxCommissionUnite(double tauxCommissionUnite) {
            this.tauxCommissionUnite = tauxCommissionUnite;
            return this;
        }

        public Fabricant build() {
            return new Fabricant(this);
        }
    }
}
