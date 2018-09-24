package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Ellipse extends Shape {
    private int radiusX;
    private int radiusY;

    public Ellipse(int cX, int cY, int rX, int rY) {
	super(cX, cY);
	radiusX = rX;
	radiusY = rY;
	super.htmlElement.setName("ellipse");
    }

    public void generateHTMLForm(Element svg){
	Attribute ellipseAttributeX = new Attribute("cx", "" + getX() + "");
	Attribute ellipseAttributeY = new Attribute("cy", "" + getY() + "");
	Attribute ellipseAttributeRX = new Attribute("rx", "" + radiusX + "");
	Attribute ellipseAttributeRY = new Attribute("ry", "" + radiusY + "");
	Attribute ellipseAttributeStroke = new Attribute("stroke", "black");
	Attribute ellipseAttributeStrokeW = new Attribute("stroke-width", "3");
	Attribute ellipseAttributeFill = new Attribute("fill", "green");
	super.htmlElement.setAttribute(ellipseAttributeX);
	super.htmlElement.setAttribute(ellipseAttributeY);
	super.htmlElement.setAttribute(ellipseAttributeRX);
	super.htmlElement.setAttribute(ellipseAttributeRY);
	super.htmlElement.setAttribute(ellipseAttributeStroke);
	super.htmlElement.setAttribute(ellipseAttributeStrokeW);
	super.htmlElement.setAttribute(ellipseAttributeFill);
	svg.addContent(htmlElement);
    }
}
