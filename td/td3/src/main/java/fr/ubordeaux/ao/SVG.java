package fr.ubordeaux.ao;

import org.jdom2.Element;
import java.util.

public class SVG {
    private int width;
    private int heigth;
    private List<Shape> shapeList;

    public SVG(int width, int heigth) {
        this.width = width;
        this.heigth = heigth;
	shapeList = new ArrayList<Shape>();
    }
    /* Il va nous falloir ajouter un element svg quelque part */
    public void add(Shape shape) {
	shapeList.add(shape);
    }

    public void generateHTML(Element body) {
	Element svg = new Element("svg");
	for (s : shapeList) {
	    svg.addContent(s);
	}
	body.addContent(svg);
    }
}
