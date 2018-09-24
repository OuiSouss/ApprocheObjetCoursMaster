package fr.ubordeaux.ao;

import org.jdom2.Attribute;
import org.jdom2.Element;

public class Circle extends Shape {
    private int centerX;
    private int centerY;
    private int radius;

    public Circle(int cX, int cY, int r) {
        super(cX, cY);
	radius = r;
	super.htmlElement.setName("circle");
    }

    public void generateHTMLForm(Element svg){
	Attribute circleAttributeX = new Attribute("cx", "" + getX() + "");
	Attribute circleAttributeY = new Attribute("cy", "" + getY() + "");
	Attribute circleAttributeR = new Attribute("r", "" + radius + "");
	Attribute circleAttributeStroke = new Attribute("stroke", "black");
	Attribute circleAttributeStrokeW = new Attribute("stroke-width", "3");
	Attribute circleAttributeFill = new Attribute("fill", "red");
	super.htmlElement.setAttribute(circleAttributeX);
	super.htmlElement.setAttribute(circleAttributeY);
	super.htmlElement.setAttribute(circleAttributeR);
	super.htmlElement.setAttribute(circleAttributeStroke);
	super.htmlElement.setAttribute(circleAttributeStrokeW);
	super.htmlElement.setAttribute(circleAttributeFill);
	svg.addContent(htmlElement);
    }
}
