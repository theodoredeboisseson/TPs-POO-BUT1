package fr.umontpellier.iut.expressions;

public class Nombre implements Expression {
    private final double valeur;

    public Nombre(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public double calculerValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return ""+valeur;
    }
}
