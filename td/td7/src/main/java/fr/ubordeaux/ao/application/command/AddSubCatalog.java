package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;

public class AddSubCatalog extends Command {
    private Catalog catalog;
    private Catalog subCatalog;

    public AddSubCatalog(Catalog catalog, Catalog subCatalog) {
        super();
        this.catalog = catalog;
        this.subCatalog = subCatalog;
    }

    public void executeCommand() {
        catalog.addSubCatalog(subCatalog);
    }
}
