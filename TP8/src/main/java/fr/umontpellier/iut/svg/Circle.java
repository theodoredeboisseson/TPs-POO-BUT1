package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Circle extends Item {
    private final double cx;
    private final double cy;
    private final double r;

    public Circle(double cx, double cy, double r) {
        super("circle");
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public Circle(Circle c) {
        super("circle");
        this.cx = c.cx;
        this.cy = c.cy;
        this.r = c.r;
        this.setStyle(c.getStyle());
    }

    @Override
    public String getParameters() {
        return String.format(Locale.US, "cx=\"%s\" cy=\"%s\" r=\"%s\"", cx, cy, r);
    }
}
