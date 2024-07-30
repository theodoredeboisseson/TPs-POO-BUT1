package fr.umontpellier.iut.svg;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Modélisation des paramètres de style d'une balise SVG
 */
public class Style {

    /**
     * Couleur de remplissage
     */
    private String fill;

    /**
     * Couleur du tracé
     */
    private String stroke;

    /**
     * Épaisseur du trait
     */
    private Double strokeWidth;

    /**
     * Transparence du remplissage
     */
    private Double fillOpacity;

    private List<Transform> transforms = new LinkedList<>();

    public Style(){

    }

    public Style(Style style){
        if(style.fill != null)
            this.fill = style.fill;
        if(style.stroke != null)
            this.stroke = style.stroke;
        if(style.strokeWidth != null)
            this.strokeWidth = style.strokeWidth;
        if(style.fillOpacity != null)
            this.fillOpacity = style.fillOpacity;
        if(style.transforms != null)
            this.transforms.addAll(style.transforms);


    }

    public String getFill() {
        return fill;
    }

    public Style setFill(String fill) {
        this.fill = fill;
        return this;
    }

    public String getStroke() {
        return stroke;
    }

    public Style setStroke(String stroke) {
        this.stroke = stroke;
        return this;
    }

    public Double getStrokeWidth() {
        return strokeWidth;
    }

    public Style setStrokeWidth(Double strokeWidth) {
        this.strokeWidth = strokeWidth;
        return this;
    }

    public Double getFillOpacity() {
        return fillOpacity;
    }

    public Style setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
        return this;
    }

    public List<Transform> getTransforms(){
        return transforms;
    }

    public Style addTransform(Transform transformation){
        transforms.add(0, transformation);
        return this;
    }

    /**
     * Renvoie la représentation du style sous forme d'une chaîne de caractères qui peut être insérée dans une
     * balise SVG.
     *
     * @return représentation du style au format SVG
     */
    public String toSVG() {
        StringJoiner elements = new StringJoiner(" ");
        if (fill != null)
            elements.add("fill=\"" + fill + "\"");
        if (stroke != null)
            elements.add("stroke=\"" + stroke + "\"");
        if (strokeWidth != null)
            elements.add("stroke-width=\"" + strokeWidth + "\"");
        if (fillOpacity != null)
            elements.add("fill-opacity=\"" + fillOpacity + "\"");
        if (!transforms.isEmpty()){
            elements.add("transform=\"");
            for (Transform t : transforms)
                elements.add(t.toString());
            elements.add("\"");
        }


        return elements.toString();
    }
}
