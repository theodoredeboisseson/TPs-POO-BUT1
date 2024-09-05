package fr.umontpellier.iut.encheres;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Compte {
    private String pseudo;
    private int solde;
    private ArrayList<OffreEnchere> mesEncheres;
    private ArrayList<Produit> produitsAchetés;

    public Compte(String pseudo, int solde) {
        this.pseudo = pseudo;
        this.solde = solde;
        mesEncheres = new ArrayList<>();
        produitsAchetés = new ArrayList<>();
    }

    public String getPseudo() {return pseudo;}

    public int getSolde() {return solde;}

    /**
     * Renvoie une offre pour le produit passé en paramètres avec un prix de base et
     * un prix maximal à ne pas dépasser. Si la création a pu avoir lieu, l'offre est
     * ajoutée à la liste des enchères du compte et le solde est mis à jour.
     *
     * @return l'offre d'enchère correspondante ou null si la création n'a pas pu avoir lieu
     */
    public OffreEnchere creerOffre(Produit produit, int prix, int prixMax) {
        OffreEnchere offreGagnante = produit.getOffreGagnante();
        boolean gagnant = ( offreGagnante != null && mesEncheres.contains(offreGagnante) );
        int Cp = produit.getCoutParticipation();

        OffreEnchere nouvelleOffre = new OffreEnchere(prix,prixMax,produit,this);

        if (!gagnant && solde < prixMax + Cp) {
            System.out.println("\u001B[31mVotre solde n'est pas suffisant pour cette offre !\u001B[0m");
            return null;
        } else if (gagnant && solde + offreGagnante.getPrixMax() < prixMax + Cp) {
            System.out.println("\u001B[31mVotre solde n'est pas suffisant pour surenchérir !\u001B[0m");
            return null;
        } else if (prix > prixMax) {
            System.out.println("\u001B[31mErreur de saisie, votre prix est supérieur a votre max !\u001B[0m");
            return  null;
        } else if (!produit.verifierOffre(nouvelleOffre)) {
            return null;
        }

        mesEncheres.add(nouvelleOffre);
//        produit.ajouterOffre(nouvelleOffre);
        crediter( -(prixMax+Cp) );
        return nouvelleOffre;
    }

    public void crediter(int somme) {
        solde += somme;
    }

    public void ajouterProduit(Produit p) {
        produitsAchetés.add(p);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Compte de "+pseudo+
                                              "\nSolde : "+solde+"€");
        if (mesEncheres.isEmpty()) {
            str.append("\nLa liste des enchères est vide !");

        } else {
            str.append("\nLa liste des enchères est la suivante :");

            for (OffreEnchere offre : mesEncheres) {
                if (offre.getEtatGagnant()) {
                    str.append("\n    ").append(offre);
                }

            }

        }

        if (produitsAchetés.isEmpty()) {
            str.append("\nAucun produit n'as été acheté");
        } else {
            str.append("\nLa liste des produits achetés est la suivante :");

            for (Produit produit : produitsAchetés) {
                str.append("\n    ").append(produit);
            }
        }
        return str.toString()+"\n";
    }
}
