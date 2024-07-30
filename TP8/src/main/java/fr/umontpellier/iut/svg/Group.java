package fr.umontpellier.iut.svg;

import java.util.ArrayList;
import java.util.List;

public class Group extends Item {

    private List<Item> content = new ArrayList<>();

    public Group() {
        super("g");
    }

    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        for (Item item: content){
            item.setIndentLevel(getIndentLevel() +1);
            builder.append(item.toSVG());
        }
        return builder.toString();
    }

    public void add(Item i) {
        content.add(i);
    }

    @Override
    public String getParameters() {
        return "";
    }
}
