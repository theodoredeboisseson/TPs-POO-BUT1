package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Line extends Item{
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    public Line(String name, double x1, double y1, double x2, double y2) {
        super(name);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public String getParameters() {
        return String.format(Locale.US, "x1=\"%s\" y1=\"%s\" x2=\"%s\" y2=\"%s\" ", x1, y1, x2, y2);
    }
}
