package fr.umontpellier.iut.svg;

import java.util.Locale;

public class Rotate implements Transform{
    private final double a;
    private final double x;
    private final double y;

    public Rotate(double a, double x, double y){
        this.a = a;
        this.x = x;
        this.y = y;
    }

    public Rotate(double a){
        this.a = a;
        this.x = -1;
        this.y = -1;
    }

    public String toString(){
        if(x != -1 & y != -1)
            return String.format(Locale.US,"rotate(%s %s %s)",a,x,y);
        else
            return String.format(Locale.US,"rotate(%s)",a);

    }

}
