package fr.umontpellier.iut.svg;

public class Polyline extends Item{
    private final int[] listePoints;

    public Polyline(int[] listePoints) {
        super("polyline");
        if(listePoints.length % 2 != 0 || listePoints.length < 4)
            System.err.println("Number of arguments for Polyline incorrect");

        this.listePoints = listePoints;
    }


    @Override
    public String getParameters() {
        StringBuilder str = new StringBuilder();
        str.append("points=\"");
        for(int i = 0; i < listePoints.length; i++){
            str.append(" ").append(listePoints[i]);
            if(i % 2 == 0)
                str.append(",");
        }
        return str+"\"";
    }
}
