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
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class TextualMenu {
    private BufferedReader _in;
    private PrintWriter _out;
    private Catalog _catalog;

    public TextualMenu(InputStream in , PrintStream out) {
        _in = new BufferedReader(new InputStreamReader(in));
        _out = new PrintWriter(out, true);
	initialCatalog();
    }

    private void initialCatalog() {
	_catalog = new CatalogImpl(new CatalogName("root"));
    }

    public void communicationWithUser() throws IOException {
	boolean end = false;
	while (!end) {
	    _out.println("(1) Add new Reference to Catalog, (2) end");
	    _out.println("Your choice is 1 or 2 :");
	    String choise = _in.readLine();
	    switch (choise) {
	    case "1" :
		addNewReferenceToCatalog();
		break;
	    case "2" :
		end = true;
		break;
	    default :
		_out.println("Can't do anything");
	    }
	}
    }

    private void addNewReferenceToCatalog() throws IOException {
	_out.println("Put information to create a Reference");
	UUID refID = UUID.randomUUID();
	_out.println("Reference name : ");
	String refName = _in.readLine();
	_out.println("Reference description : ");
	String refDescription = _in.readLine();
	_out.println("Price (in Euro cents) : ");
	String price = _in.readLine();
	int refPrice = Integer.parseInt(price);
	Reference reference = new Reference(refID, refName, refDescription,
					    refPrice);
	_out.println("Catalog Name (root) : ");
	String name = _in.readLine();
	CatalogName catalogName = new CatalogName("root");
	if (name.compareTo("") != 0)
	    catalogName = new CatalogName(name);
	_catalog.setCatalogName(catalogName);
	_catalog.addReference(reference);
	_out.println("Reference with id : " + refID + "has been created");
    }
}
