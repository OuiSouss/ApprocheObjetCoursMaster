package fr.ubordeaux.ao;

import org.jdom2.Element;

public abstract class Shape {
    private int _x;
    private int _y;
    protected Element htmlElement;

    public Shape(int x, int y) {
	_x = x;
	_y = y;
	htmlElement = new Element("shape");
    }

    public int getX() {
	return _x;
    }

    public int getY() {
	return _y;
    }

    public abstract void generateHTMLForm(Element svg);
}
