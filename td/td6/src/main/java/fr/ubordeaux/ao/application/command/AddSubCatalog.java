package fr.ubordeaux.ao.application.command;

import fr.ubordeaux.ao.domain.model.Catalog;

public class AddSubCatalog extends Command {
    private Catalog catalog;
    private Catalog subCatalog;

    public AddSubCatalog(Catalog catalog, Catalog subCatalog) {
        this.catalog = catalog;
        this.subCatalog = subCatalog;
    }

    public void execute() {
        catalog.addSubCatalog(subCatalog);
    }
}
