package fr.ubordeaux.ao.referencemanagement.domain.model;

import java.util.Set;
import java.util.UUID;

import fr.ubordeaux.ao.referencemanagement.domain.type.CatalogName;

public interface Catalog {
    int size();
    CatalogName getCatalogName();
    Set<Reference> getAllReferences();
    Set<Reference> getOwnReferences();
    Reference findReferenceById(UUID id);
    void addReference(Reference reference);
    void addSubCatalog(Catalog catalog);
    void removeReference(Reference reference);
    void removeSubCatalog(Catalog catalog);
}
