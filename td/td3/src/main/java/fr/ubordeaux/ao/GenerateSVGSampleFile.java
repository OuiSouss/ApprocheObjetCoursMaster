package fr.ubordeaux.ao;

import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import fr.ubordeaux.ao.SVG;

public class GenerateSVGSampleFile {
    public static void main(String[] args) throws IOException {
	SVG svg = new SVG(2000, 2000);
        svg.add(new Ellipse(250, 250,30,80));
	svg.add(new Circle(550,300, 10));
	svg.add(new Line(250,250,550,300));
	svg.add(new Line(250,450,150,300));
	svg.add(new Rectangle(100,750,200,850));
	svg.add(new Rectangle(750,300,600,350));
	generateHTML(svg);
    }

    public static void generateHTML(SVG svg) throws IOException {
	Document document = new Document();
	Element racine = new Element("html");
	document.addContent(racine);
	Element body = new Element("body");
	racine.addContent(body);
	svg.generateHTML(body);

	XMLOutputter outputPutter = new XMLOutputter(Format.getPrettyFormat());
	outputPutter.output(document, System.out);
	outputPutter.output(document, new FileWriter("test.svg"));
    }
}
