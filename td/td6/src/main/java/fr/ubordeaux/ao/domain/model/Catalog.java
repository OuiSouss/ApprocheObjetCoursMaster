package fr.ubordeaux.ao.domain.model;

import java.util.Set;
import java.util.UUID;

import fr.ubordeaux.ao.domain.type.CatalogName;

public interface Catalog {
    public int size();
    public CatalogName getCatalogName();
    public Set<Reference> getAllReferences();
    public Set<Reference> getOwnReferences();
    public Reference findReferenceById(String id);
    public void addReference(Reference reference);
    public void addSubCatalog(Catalog catalog);
    public void removeReference(Reference reference);
    // public void removeSubCatalog(Catalog catalog);
}
