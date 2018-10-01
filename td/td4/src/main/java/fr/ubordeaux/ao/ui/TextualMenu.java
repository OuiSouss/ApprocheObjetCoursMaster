package fr.ubordeaux.ao.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class TextualMenu {
    private BufferedReader _in;
    private PrintWriter _out;
    private Catalog _rootCatalog;

    public TextualMenu(InputStream in , PrintStream out) {
        _in = new BufferedReader(new InputStreamReader(in));
        _out = new PrintWriter(out, true);
	initialCatalog();
    }

    private void initialCatalog() {
	_rootCatalog = new CatalogImpl("root");
    }

    public void communicationWithUser() throws IOException {
	boolean end = false;
	while (!end) {
	    _out.println("(1) Add new Reference to Catalog, (2) end");
	    _out.println("Your choise is 1 or 2 :");
	    String choise = _in.readLine();
	    switch (choise) {
	    case "1" :
		_out.println("Todo");
		break;
	    case "2" :
		end = true;
		break;
	    default :
		_out.println("Can't do anything");
	    }
	}
    }
}
