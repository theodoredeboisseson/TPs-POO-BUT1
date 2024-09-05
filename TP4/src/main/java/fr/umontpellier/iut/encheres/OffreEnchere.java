package fr.umontpellier.iut.encheres;

public class OffreEnchere {
    private int prixEnCours;
    private int prixMax;
    private final Produit produit;
    private final Compte monCompte;

    private boolean etatGagnant;

    public OffreEnchere(int prixEnCours, int prixMax, Produit produit, Compte monCompte) {
        this.prixEnCours = prixEnCours;
        this.prixMax = prixMax;
        this.produit = produit;
        etatGagnant = false;
        this.monCompte = monCompte;
    }

    public int getPrixEnCours() {return prixEnCours;}
    public void setPrixEnCours(int prixPropose) {prixEnCours = prixPropose;}

    public int getPrixMax() {return prixMax;}
    public void setPrixMax(int prixMax) {this.prixMax = prixMax;}

    public Produit getProduit() {return produit;}

    public boolean getEtatGagnant() {return etatGagnant;}
    public void setEtatGagnant(boolean etat) {
        etatGagnant = etat;
        if (!etat)
            monCompte.crediter(prixMax);
    }

    public Compte getCompte() {return monCompte;}

    @Override
    public String toString() {
        String str ="Offre pour le produit n°" + produit.getNumero() +
                    ", Prix en cours :" + prixEnCours +
                    "€, Prix max :" + prixMax +
                    "€ | ";
        if (etatGagnant) {
            str += "gagnante !";
        } else {
            str += "perdante.";
        }
        return str;
    }
}
