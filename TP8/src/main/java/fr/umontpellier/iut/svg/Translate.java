package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Translate implements Transform{
    private final double x;
    private final double y;

    public Translate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format(Locale.US,"translate(%s %s)",x,y);
    }
}