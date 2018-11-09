package fr.ubordeaux.ao.domain.model;

import java.util.Set;

import fr.ubordeaux.ao.domain.type.CatalogName;

public interface Catalog {
    public int size();
    public CatalogName getCatalogName();
    public Set<Reference> getReferences();
    public Reference findReferenceById(String id);
    public void addReference(Reference reference);
    public void removeReference(Reference reference);
}
