package fr.umontpellier.iut.encheres;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.max;

public class Produit {
    private final int numero;
    private String description;
    private final int prixInitial;
    private static int pasEnchere = 5;
    private final int coutParticipation;

    private boolean disponible;

    private ArrayList<OffreEnchere> historiqueOffres = new ArrayList<>();
    private OffreEnchere offreGagnante;

    public Produit(int numero, String description, int prixInitial, int coutParticipation) {
        this.description = description;
        this.prixInitial = prixInitial;
        this.coutParticipation = coutParticipation;
        this.numero = numero;
        disponible = false;
    }

    public int getNumero() {
        return numero;
    }

    // question 2
    public static int getPasEnchere() {return pasEnchere;}
    public static void setPasEnchere(int pas) {pasEnchere = pas;}

    public int getCoutParticipation() {
        return coutParticipation;
    }

    public boolean estDisponible() {return disponible;}

    // question 5
    public int getPrixActuel() {
        if(offreGagnante != null)
            return offreGagnante.getPrixEnCours();
        else
            return prixInitial;
    }

    public OffreEnchere getOffreGagnante() {
        return offreGagnante;
    }
    public void setOffreGagnante(OffreEnchere o) {
        if(offreGagnante != null)
            offreGagnante.setEtatGagnant(false);
        o.setEtatGagnant(true);
        offreGagnante = o;
    }

    public void demarrerEnchere() {
        disponible = true;
    }

    public void arreterEnchere() {
        disponible = false;
        if(offreGagnante != null){
            offreGagnante.getCompte().crediter (offreGagnante.getPrixMax() - offreGagnante.getPrixEnCours());
            offreGagnante.getCompte().ajouterProduit(this);
            System.out.println(offreGagnante.getCompte().getPseudo() + " est le gagnant de l'enchère et remporte le produit n°"+numero);
        }
    }

    // pré-requis : l'offre passée en paramètre est valide
    public void ajouterOffre(OffreEnchere o) {
        historiqueOffres.add(o);
        if (offreGagnante == null) {
            setOffreGagnante(o);
            return;
        }

        int maxG = offreGagnante.getPrixMax();
        int maxO = o.getPrixMax();
        Compte Cg = offreGagnante.getCompte();
        Compte Co = o.getCompte();
        if (maxG >= maxO) {
            if (Cg == Co) {
                offreGagnante.setPrixMax(maxO);
                offreGagnante.setPrixEnCours(o.getPrixEnCours());
                Cg.crediter(maxG);
            } else {
                offreGagnante.setPrixEnCours(maxO);
                o.setEtatGagnant(false);
            }
        } else {
            if ( Cg != Co) {
                o.setPrixEnCours( max(maxG,o.getPrixEnCours()) );
            }
            setOffreGagnante(o);
        }
    }

    // vérifie si l'offre est correcte
    public boolean verifierOffre(OffreEnchere offre) {
        boolean bool = false;
        int prix = offre.getPrixEnCours();

        if (!disponible) { //Ouvert aux enchères
            System.out.println("\u001B[31mLes enchères ne sont pas disponibles pour ce produit !\u001B[0m");

        } else if (offre.getProduit() != this) { //Correspondance
            System.out.println("\u001B[31mLe produit pour lequel vous proposez une offre ne correspond pas !\u001B[0m");

        } else if (historiqueOffres.isEmpty() && prix < prixInitial) { //Supérieur au prix initial si pas d'offres
            System.out.println("\u001B[31mL'offre ne peut pas être inférieure au prix initial !\u001B[0m");

        } else if (!historiqueOffres.isEmpty() && prix < getPrixActuel()+getPasEnchere()) { //Supérieur au prixActuel + pasEnchere si il y a des offres
            System.out.println("\u001B[31mL'offre ne représente pas une augmentation du prix !\u001B[0m");

        } else {
            bool = true;
            System.out.println("\u001B[32mOffre effectuée avec succès\u001B[0m");
        }

        return bool;
    }

    // fonction permettant la comparaison des Produits
    // cette fonction doit rester intacte
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit produit)) return false;
        return getNumero() == produit.getNumero();
    }

    // fonction auxiliaire définissant le hashCode des objets de type Produit en respectant le contrat de equals(Object o)
    // cette fonction doit rester intacte
    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public String toString() {
        String str = String.format("""
                   
                   Le produit n° %s
                   | %s
                   A comme prix de départ : %s€ + %s€ de participation
                   """,numero,description,prixInitial,coutParticipation);

        if (disponible) {
            str += "Il est actuellement à la vente";

            if (offreGagnante != null) {
                str +=  String.format("""
                         et à pour gagnant actuel '%s' grâce à l'offre suivante :
                        ------
                            %s
                        ------
                        """,offreGagnante.getCompte().getPseudo(),offreGagnante);
            } else {
                str += " et n'as pour l'instant aucune offre!\n";
            }

        } else {
            str += "Il est actuellement pas à la vente.";
        }
        return str+"\n";
    }
}