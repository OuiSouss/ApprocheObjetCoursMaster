package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Line extends Shape {
    private int _x2;
    private int _y2;

    public Line(int x1, int y1, int x2, int y2) {
	super(x1, y1);
	_x2 = x2;
	_y2 = y2;
	super.htmlElement.setName("line");
    }

    public void generateHTMLForm(Element svg){
	Attribute lineAttributeX1 = new Attribute("x1", "" + getX() + "");
	Attribute lineAttributeY1 = new Attribute("y1", "" + getY() + "");
	Attribute lineAttributeX2 = new Attribute("x2", "" + _x2 + "");
	Attribute lineAttributeY2 = new Attribute("y2", "" + _y2 + "");
	Attribute lineAttributeStroke = new Attribute("stroke", "black");
	Attribute lineAttributeStrokeW = new Attribute("stroke-width", "3");
	super.htmlElement.setAttribute(lineAttributeX1);
	super.htmlElement.setAttribute(lineAttributeY1);
	super.htmlElement.setAttribute(lineAttributeX2);
	super.htmlElement.setAttribute(lineAttributeY2);
	super.htmlElement.setAttribute(lineAttributeStroke);
	super.htmlElement.setAttribute(lineAttributeStrokeW);
	svg.addContent(htmlElement);
    }
}
