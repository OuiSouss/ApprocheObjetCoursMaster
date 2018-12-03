package fr.ubordeaux.ao.referencemanagement.ui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import fr.ubordeaux.ao.referencemanagement.application.command.AddReference;
import fr.ubordeaux.ao.referencemanagement.application.command.AddSubCatalog;
import fr.ubordeaux.ao.referencemanagement.application.command.Command;
import fr.ubordeaux.ao.referencemanagement.application.command.Gateway;
import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.referencemanagement.domain.type.Price;
import fr.ubordeaux.ao.referencemanagement.infrastructure.command.GatewayImpl;
import fr.ubordeaux.ao.referencemanagement.infrastructure.command.HandlerImpl;
import fr.ubordeaux.ao.referencemanagement.infrastructure.csv.CatalogCSVImpl;
import fr.ubordeaux.ao.referencemanagement.infrastructure.inmemory.CatalogImpl;

public class TextualMenu {
    private BufferedReader in;
    private PrintWriter out;
    private Gateway gateway;
    private Catalog catalog;

    protected TextualMenu(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
        initCollection();
        createCommandGatewayAndHandler();
    }

    TextualMenu(InputStream in, PrintStream out) {
        this.in = new BufferedReader(new InputStreamReader(in));
        this.out = new PrintWriter(out, true);
        initCollection();
        createCommandGatewayAndHandler();
    }

    private void initCollection() {
        catalog = new CatalogImpl(new CatalogName("root"));
    }

    private void createCommandGatewayAndHandler() {
        gateway = new GatewayImpl();
        gateway.addCommandHandler(new HandlerImpl());
    }

    void handleUserInstructions() throws IOException {
        boolean end = false;
        while (!end) {
            out.println("(1) Add new Reference to Catalog,  (2) exit, (3) Add new Reference to catalog in csv");
            out.println("Your choice 1-3:");
            String choice = in.readLine();
            switch (choice) {
            case "1":
                createReferenceAndAddItToCatalog();
                break;
            case "2":
                end = true;
                break;
            case "3":
                createReferenceAndAddItToCatalogCSV();
                break;
            default:
                end = true;
            }
        }
    }

    private void createReferenceAndAddItToCatalogCSV() throws IOException {
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
        out.println("Catalog Name (root) : ");
        String name = in.readLine();
        out.println("Filename : ");
        String filename = in.readLine();
        CatalogName catalogName = new CatalogName(name);
        Catalog newCatalog = new CatalogCSVImpl(catalogName, filename);
        newCatalog.addReference(reference);
        int size = newCatalog.size();
        out.println("size of catalog is : " + size);
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
        out.println("Catalog Name (root) : ");
        String name = in.readLine();
        if (name.compareTo("") != 0){
            CatalogName catalogName = new CatalogName(name);
            Catalog newCatalog = new CatalogImpl(catalogName);
            Command commandAddCatalog = new AddSubCatalog(catalog, newCatalog);
            gateway.pushCommand(commandAddCatalog);
            out.println("A new Catalog with name " + catalogName.getValue() +
                        " should be created soon!");
            Command commandAddReference = new AddReference(newCatalog,
                                                           reference);
            gateway.pushCommand(commandAddReference);
        } else {
            CatalogName catalogName = new CatalogName("root");
            Command commandAddReference = new AddReference(catalog, reference);
            gateway.pushCommand(commandAddReference);
        }
        out.println("Reference " + reference.getId() + " should be created"
                    + " soon !");
    }
}
