package fr.umontpellier.iut.expressions;

public class AppExpression {

    public static void main(String[] args) {
        Expression exp1 = new Operation('/', new Nombre(9), new Nombre(6));
        Expression exp2 = new Operation('*', new Nombre(5), new Nombre(4));
        Expression exp3 = new Operation('-', exp2, exp1);
        System.out.println(exp3);

        Expression exp4 = new Operation('/', new Nombre(1), new Nombre(0));
    }
}
