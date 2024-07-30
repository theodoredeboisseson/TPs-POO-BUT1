package fr.umontpellier.iut.svg;

import java.util.Locale;

public class SkewX implements Transform{
    private int value;

    public SkewX(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "skewX(%s)",value);
    }
}
