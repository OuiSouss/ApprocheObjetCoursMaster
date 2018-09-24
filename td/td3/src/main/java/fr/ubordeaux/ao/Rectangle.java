package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Rectangle extends Shape {
    private int _width;
    private int _height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
	_width = width;
	_height = height;
	super.htmlElement.setName("rect");
    }

    public void generateHTMLForm(Element svg){
	Attribute rectAttributeX = new Attribute("x", "" + getX() + "");
	Attribute rectAttributeY = new Attribute("y", "" + getY() + "");
	Attribute rectAttributeW = new Attribute("width", "" + _width + "");
	Attribute rectAttributeH = new Attribute("height", "" + _height + "");
	Attribute rectAttributeStroke = new Attribute("stroke", "black");
	Attribute rectAttributeStrokeW = new Attribute("stroke-width", "3");
	Attribute rectAttributeFill = new Attribute("fill", "blue");
	super.htmlElement.setAttribute(rectAttributeX);
	super.htmlElement.setAttribute(rectAttributeY);
	super.htmlElement.setAttribute(rectAttributeW);
	super.htmlElement.setAttribute(rectAttributeH);
	super.htmlElement.setAttribute(rectAttributeStroke);
	super.htmlElement.setAttribute(rectAttributeStrokeW);
	super.htmlElement.setAttribute(rectAttributeFill);
	svg.addContent(htmlElement);
    }

}
