package fr.umontpellier.iut.exo2;

public class Note {
    private Matiere matiere;
    private int valeur;

    public Note(Matiere matiere, int valeur) {
        this.matiere = matiere;

        if(valeur < 0)
            valeur = 0;
        this.valeur = valeur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
