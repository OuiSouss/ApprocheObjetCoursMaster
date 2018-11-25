package fr.ubordeaux.ao.referencemanagement.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.referencemanagement.domain.type.Price;
import fr.ubordeaux.ao.referencemanagement.infrastructure.inmemory.CatalogImpl;

public class TextualMenu {
    private BufferedReader in;
    private PrintWriter out;
    private Catalog catalog;

    protected TextualMenu(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
        initCollection();
    }

    TextualMenu(InputStream in, PrintStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new PrintWriter(out, true);
        initCollection();
    }

    private void initCollection() {
        catalog = new CatalogImpl(new CatalogName("root"));
    }

    void handleUserInstructions() throws IOException {
        boolean end = false;
        while (!end) {
            out.println("(1) Add new Reference to Catalog,  (2) exit");
            out.println("Your choice 1-2:");
            String choice = in.readLine();
            switch (choice) {
            case "1":
                createReferenceAndAddItToCatalog();
                break;
            case "2":
                end = true;
                break;
            default:
                end = true;
            }
        }
    }

    private void createReferenceAndAddItToCatalog() throws IOException {
        out.println("You ask to create a new reference and add it to the root"
                    + "catalog!");
        out.println("Reference name : ");
        String refName = in.readLine();
        out.println("Reference description : ");
        String refDescription = in.readLine();
        out.println("Price : ");
        String price = in.readLine();
        Price refPrice = new Price(Integer.parseInt(price));
        Reference reference = new Reference(refName, refDescription,
                                            refPrice);

        catalog.addReference(reference);
        out.println("Reference (" + reference.getId() + ") has been created and"
                    + "added to the catalog !");
    }
}