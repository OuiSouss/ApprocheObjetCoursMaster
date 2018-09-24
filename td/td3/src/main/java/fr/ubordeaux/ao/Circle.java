package fr.ubordeaux.ao;

public class Circle extends Shape {
    int centerX;
    int centerY;
    int radius;

    public Circle(int cX, int cY, int r) {
        super(cX, cY);
	radius = r;
	super.htmlElement.setName("cicle");
    }

    public generateHTMLCircle(){
	super.htmlElement.setAttribute(new Attribut("cx", ""+getX()""));
    }
}
