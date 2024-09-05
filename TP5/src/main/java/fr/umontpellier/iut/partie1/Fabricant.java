package fr.umontpellier.iut.partie1;

public class Fabricant extends Employe {
    private int nbUnitesProduites;
    private double tauxCommissionUnite;

    public Fabricant(String nrINSEE, String nom, int echelon, double base, double nbHeures, int nbUnitesProduites, double tauxCommissionUnite) {
        super(nrINSEE,nom,echelon,base,nbHeures);
        this.nbUnitesProduites = nbUnitesProduites;
        this.tauxCommissionUnite = tauxCommissionUnite;
    }

    public void fabriquerProduits(int nbProduits) {
        nbUnitesProduites += nbProduits;
        System.out.println("Fabrication de "+nbProduits+" produits.");
    }

    @Override
    public double getSalaireBrut(){
        return super.getSalaireBrut() + nbUnitesProduites * tauxCommissionUnite;
    }
}
