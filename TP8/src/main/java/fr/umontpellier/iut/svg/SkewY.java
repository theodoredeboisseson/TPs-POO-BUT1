package fr.umontpellier.iut.svg;

import java.util.Locale;

public class SkewY implements Transform{
    private int value;

    public SkewY(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "skewY(%s)",value);
    }
}