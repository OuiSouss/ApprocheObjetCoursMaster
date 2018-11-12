package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public class AddReference extends Command {
    private Catalog catalog;
    private Reference reference;

    public AddReference(Catalog catalog, Reference reference) {
        super();
        this.catalog = catalog;
        this.reference = reference;
    }

    public void execute() {
        catalog.addReference(reference);
    }
}
