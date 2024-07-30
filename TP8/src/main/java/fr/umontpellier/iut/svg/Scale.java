package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Scale implements Transform {
    private final double x;
    private final double y;

    public Scale(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format(Locale.US,"scale(%s %s)",x,y);
    }
}
