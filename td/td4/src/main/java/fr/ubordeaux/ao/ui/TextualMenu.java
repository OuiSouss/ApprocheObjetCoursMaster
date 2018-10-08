package fr.ubordeaux.ao.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.UUID;


import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class TextualMenu {
    private BufferedReader in;
    private PrintWriter out;
    private Catalog catalog;

    public TextualMenu(InputStream in , PrintStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new PrintWriter(out, true);
	initialCatalog();
    }

    private void initialCatalog() {
	catalog = new CatalogImpl(new CatalogName("root"));
    }

    public void communicationWithUser() throws IOException {
	boolean end = false;
	while (!end) {
	    out.println("(1) Add new Reference to Catalog, (2) end");
	    out.println("Your choice is 1 or 2 :");
	    String choise = in.readLine();
	    switch (choise) {
	    case "1" :
		addNewReferenceToCatalog();
		break;
	    case "2" :
		end = true;
		break;
	    default :
		out.println("Can't do anything");
	    }
	}
    }

    private void addNewReferenceToCatalog() throws IOException {
	out.println("Put information to create a Reference");
	UUID refID = UUID.randomUUID();
	out.println("Reference name : ");
	String refName = in.readLine();
	out.println("Reference description : ");
	String refDescription = in.readLine();
	out.println("Price (in Euro cents) : ");
	String price = in.readLine();
	Price refPrice = new Price(Integer.parseInt(price));
	Reference reference = new Reference(refID, refName, refDescription,
					    refPrice);
	catalog.addReference(reference);
	out.println("Reference with id : " + refID + "has been created");
    }
}
