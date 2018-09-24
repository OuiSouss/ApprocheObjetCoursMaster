package fr.ubordeaux.ao;

import org.jdom2.Element;
import org.jdom2.Attribute;
import java.util.List;
import java.util.ArrayList;

public class SVG {
    private int width;
    private int height;
    private List<Shape> shapeList;

    public SVG(int width, int height) {
        this.width = width;
        this.height = height;
	shapeList = new ArrayList<Shape>();
    }
    /* Il va nous falloir ajouter un element svg quelque part */
    public void add(Shape shape) {
	shapeList.add(shape);
    }

    public int getWidth() {
	return this.width;
    }

    public int getHeight() {
	return this.height;
    }

    public void generateHTML(Element body) {
	Element svg = new Element("svg");
	Attribute svgAttributeW = new Attribute("width", "" + getWidth() + "");
	Attribute svgAttributeH = new Attribute("height", "" + getHeight() + "");
	svg.setAttribute(svgAttributeW);
	svg.setAttribute(svgAttributeH);
	for (Shape s : shapeList) {
	    s.generateHTMLForm(svg);
	}
	body.addContent(svg);
    }
}
