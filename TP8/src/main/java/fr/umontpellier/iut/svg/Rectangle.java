package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Rectangle extends Item {
    private final double x;
    private final double y;
    private final double width;
    private final double height;
    private double rx = 0;
    private double ry = 0;

    public Rectangle(double x, double y, double width, double height) {
        super("rect");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x, double y, double width, double height, double rx, double ry) {
        super("rect");
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.rx = rx;
        this.ry = ry;
    }

    public Rectangle(Rectangle rec){
        super("rect");
        this.x = rec.x;
        this.y = rec.y;
        this.width = rec.width;
        this.height = rec.height;
        this.rx = rec.rx;
        this.ry = rec.ry;
    }


    @Override
    public String getParameters() {
        String str = String.format(Locale.US, "x=\"%s\" y=\"%s\" width=\"%s\" height=\"%s\" ", x, y, width, height);
        if(rx != 0)
            str += String.format(Locale.US,"rx=\"%f\" ",rx);
        if(ry != 0)
            str += String.format(Locale.US,"ry=\"%f\" ",ry);

        return str;
    }
}
