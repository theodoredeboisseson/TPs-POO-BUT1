package fr.umontpellier.iut.svg;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SVG extends Tag {
    private double width;
    private double height;
    private Group group;

    public SVG(double width, double height) {
        super("svg");
        this.width = width;
        this.height = height;
        group = new Group();
    }

    @Override
    public String getParameters() {
        return "xmlns=\"http://www.w3.org/2000/svg\" width=\"" + width + "\" height=\"" + height + "\"";
    }

    @Override
    public String getContent() {
        return group.getContent();
    }

    /**
     * Ajoute une balise à l'image
     * @param item balise à ajouter à l'image
     */
    public void add(Item item) {
        group.add(item);
    }

    /**
     * Exporte l'image au format SVG dans un fichier
     *
     * @param filename le nom du fichier SVG à créer représentant l'image
     */
    public void saveAsFile(String filename) {
        PrintStream out;
        try {
            out = new PrintStream(new FileOutputStream(filename));
            out.print("<?xml version=\"1.0\" standalone=\"no\"?>\n<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n");
            out.print(toSVG());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
