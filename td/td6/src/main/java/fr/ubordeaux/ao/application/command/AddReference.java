package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public class AddReference implements Command {
    private Catalog catalog;
    private Reference reference;

    public AddReference(Catalog catalog, Reference reference) {
        this.catalog = catalog;
        this.reference = reference;
    }

    public void execute() {
        catalog.addReference (reference);
    }
}
