package fr.ubordeaux.ao.referencemanagement.application.command;

import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;

public class AddReference extends Command {
    private Catalog catalog;
    private Reference reference;

    public AddReference(Catalog catalog, Reference reference) {
        super();
        this.catalog = catalog;
        this.reference = reference;
    }

    public void executeCommand() {
        catalog.addReference(reference);
    }
}
