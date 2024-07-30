package fr.umontpellier.iut.svg;

public class AppSVG {
    public static void main(String[] args) {
        SVG svg = new SVG(1000,1000);

        Circle c = new Circle(100,100,20);
        c.setStyle(new Style().setFill("blue").setStroke("black").setFillOpacity(0.5).setStrokeWidth(10.0));
        svg.add(c);

        svg.saveAsFile("testToSvg.svg");

        svgGrece();
        svgEx11();
        svgEx12();
        svgEx12Complexe();











    }

    public static void svgGrece(){
        SVG svg = new SVG(270,180);
        Rectangle fond = new Rectangle(0,0,270,180);
        fond.setStyle(new Style().setFill("white"));
        svg.add(fond);

        Style bleu = new Style().setFill("blue");

        Item rec1 = new Rectangle(0,0,40,40,10,10);
        Item rec2 = new Rectangle(60,0,40,40);
        Item rec3 = new Rectangle(0,60,40,40);
        Item rec4 = new Rectangle(60,60,40,40);
        Item rec5 = new Rectangle(100,0,180,20);
        Item rec6 = new Rectangle(100,40,180,20);
        Item rec7 = new Rectangle(100,80,180,20);
        Item rec8 = new Rectangle(0,120,270,20) ;
        Item rec9 = new Rectangle(0,160,270,20);
        //rec1.setStyle(new Style().setFillOpacity(15.0).addTransform(new Rotate(45)).addTransform(new Scale(2,2)).addTransform(new Translate(135,30)));
        rec1.setStyle(bleu);
        rec2.setStyle(bleu);
        rec3.setStyle(bleu);
        rec4.setStyle(bleu);
        rec5.setStyle(bleu);
        rec6.setStyle(bleu);
        rec7.setStyle(bleu);
        rec8.setStyle(bleu);
        rec9.setStyle(bleu);
        svg.add(rec1);
        svg.add(rec2);
        svg.add(rec3);
        svg.add(rec4);
        svg.add(rec5);
        svg.add(rec6);
        svg.add(rec7);
        svg.add(rec8);
        svg.add(rec9);

        svg.saveAsFile("Grece.svg");
    }

    public static void svgEx11(){
        SVG svg = new SVG(1000,1000);

        Rectangle rec = new Rectangle(0,0,1000,1000);
        rec.setStyle(new Style().setFill("lightblue"));

        Rectangle rec1 = new Rectangle(100,100,200,200);
        Rectangle rec2 = new Rectangle(200,200,400,400);
        Rectangle rec3 = new Rectangle(100,100,200,200);
        Rectangle rec4 = new Rectangle(200,200,400,400);

        Group group1 = new Group();
        group1.setStyle(new Style().setStroke("black").setStrokeWidth(20.0).setFillOpacity(0.8));

        Group group2 = new Group();
        group2.setStyle(new Style().addTransform(new Rotate(-45,100,50)).addTransform(new Translate(0, 700)));

        rec1.setStyle(new Style().setFill("#080"));
        group1.add(rec1);
        rec2.setStyle(new Style().setFill("#0C0"));
        group1.add(rec2);

        rec3.setStyle(new Style().setFill("#800"));
        group2.add(rec3);
        rec4.setStyle(new Style().setFill("#C00"));
        group2.add(rec4);

        group1.add(group2);

        svg.add(rec);
        svg.add(group1);

        svg.saveAsFile("Exo11.svg");
    }

    public static void svgEx12(){
        SVG svg = new SVG(300,300);

        Circle c1 = new Circle(110,110,100);
        Circle c2 = new Circle(190,110,100);
        Circle c3 = new Circle(150,190,100);

        Style styleCommun = new Style().setFillOpacity(0.5).setStroke("black").setStrokeWidth(3.0);

        svg.add(c3.setItemStyle(new Style(styleCommun).setFill("red")));
        svg.add(c1.setItemStyle(new Style(styleCommun).setFill("green")));
        svg.add(c2.setItemStyle(new Style(styleCommun).setFill("blue")));


        svg.saveAsFile("Exo12.svg");
    }

    public static void svgEx12Complexe(){
        String[] colors = {"red", "green", "blue", "gray", "orange", "yellow", "purple", "pink", "brown", "beige", "olive", "turquoise", "magenta", "maroon", "cyan", "indigo", "lavender", "peach", "gold", "silver", "ivory", "rust", "teal", "navy", "plum", "mauve", "khaki", "fuchsia", "chartreuse", "crimson", "ebony", "emerald", "garnet", "jade", "lemon", "lime", "mint", "mustard", "onyx", "periwinkle", "rose", "ruby", "sapphire", "scarlet", "tangerine", "topaz", "vermilion", "violet", "wine","black", "white"};
        SVG svg = new SVG(1000,1000);

        Circle c = new Circle(500,600,300);
        Style styleCommun = new Style().setFillOpacity(0.5).setStroke("black").setStrokeWidth(10.0);

        for(int i = 0; i < 8; i++){
            Circle copy = new Circle(c);
            copy.setItemStyle(new Style(styleCommun).setFill(colors[i]).addTransform(new Rotate(45*i,500,500)));
            svg.add(new Circle(copy));
        }

        int[] points = {400,400,400,600,600,600,600,400};
        Polyline polyline = new Polyline(points);
        svg.add(polyline);

        svg.saveAsFile("Exo12complexe.svg");
    }
}
