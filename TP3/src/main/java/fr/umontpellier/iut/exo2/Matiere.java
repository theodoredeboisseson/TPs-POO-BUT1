package fr.umontpellier.iut.exo2;

public class Matiere {
    private String intitulé;
    private int coefficient;

    public Matiere(String intitulé, int coefficient) {
        this.intitulé = intitulé;

        if(coefficient < 0)
                coefficient = 0;
        this.coefficient = coefficient;
    }

    public int getCoefficient() {
        return coefficient;
    }
}
