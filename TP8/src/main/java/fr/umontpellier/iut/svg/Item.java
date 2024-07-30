package fr.umontpellier.iut.svg;

public abstract class Item extends Tag{

    public Item(String name) {
        super(name);
    }

    public Item setItemStyle(Style style) {
        this.setStyle(style);
        return this;
    }

    public abstract String getParameters();

}
