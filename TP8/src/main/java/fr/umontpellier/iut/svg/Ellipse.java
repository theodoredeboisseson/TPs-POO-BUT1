package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Ellipse extends Item{
    private final double rx;
    private final double ry;
    private final double cx;
    private final double cy;

    public Ellipse(double rx, double ry, double cx, double cy) {
        super("ellipse");
        this.rx = rx;
        this.ry = ry;
        this.cx = cx;
        this.cy = cy;
    }

    @Override
    public String getParameters() {
        return String.format(Locale.US, "rx=\"%s\" ry=\"%s\" cx=\"%s\" cy=\"%s\" ", rx, ry, cx, cy);
    }
}
