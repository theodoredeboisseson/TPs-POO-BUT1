package fr.umontpellier.iut.expressions;

public class Operation implements Expression {

    private final char operateur;
    private final Expression expressionGauche;
    private final Expression expressionDroite;

    public Operation(char operateur, Expression expressionGauche, Expression expressionDroite) {
        this.operateur = operateur;
        this.expressionGauche = expressionGauche;
        this.expressionDroite = expressionDroite;
    }

    @Override
    public double calculerValeur() {
        double valGauche = expressionGauche.calculerValeur();
        double valDroite = expressionDroite.calculerValeur();

        return switch (operateur) {
            case '+' -> valGauche + valDroite;
            case '-' -> valGauche - valDroite;
            case '*' -> valGauche * valDroite;
            case '/' -> {
                if (valDroite == 0)
                    throw new ArithmeticException("Division par zéro");
                yield valGauche / valDroite;
            }
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "(" + expressionGauche + operateur + expressionDroite + ")";
    }
}
