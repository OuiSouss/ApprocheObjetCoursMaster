package fr.ubordeaux.ao;

public abstract class Shape {
    private int _x;
    private int _y;
    private Element htmlElement;

    public Shape(int x, int y) {
	_x = x;
	_y = y;
	htmlElement = new Element("shape");
    }
}
