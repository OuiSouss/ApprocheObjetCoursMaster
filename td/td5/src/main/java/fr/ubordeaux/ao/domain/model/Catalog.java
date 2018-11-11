package fr.ubordeaux.ao.domain.model;

import java.util.Set;

import fr.ubordeaux.ao.domain.type.CatalogName;

public interface Catalog {
    int size();
    CatalogName getCatalogName();
    Set<Reference> getAllReferences();
    Set<Reference> getOwnReferences();
    Reference findReferenceById(String id);
    void addReference(Reference reference);
    void addSubCatalog(Catalog catalog);
    void removeReference(Reference reference);
    // public void removeSubCatalog(Catalog catalog);
}
