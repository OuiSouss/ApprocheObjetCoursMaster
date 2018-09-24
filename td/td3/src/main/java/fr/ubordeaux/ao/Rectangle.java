package fr.ubordeaux.ao;

public class Rectangle extends Shape {
    int x;
    int y;
    int width;
    int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
	this.width = width;
	this.height = height;
    }
}
