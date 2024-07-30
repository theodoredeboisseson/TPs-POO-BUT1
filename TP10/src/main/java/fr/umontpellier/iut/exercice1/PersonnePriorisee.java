package fr.umontpellier.iut.exercice1;

public class PersonnePriorisee {
    private Personne p;
    private int numeroPassage;

    public PersonnePriorisee(Personne p, int numero){
        this.p = p;
        this.numeroPassage = numero;
    }

    public Personne getPersonne(){
        return p;
    }

    public int getNumeroPassage(){
        return numeroPassage;
    }

    @Override
    public String toString(){
        return p.toString() + "possède le numero " + numeroPassage + " de la file d'attente";
    }
}