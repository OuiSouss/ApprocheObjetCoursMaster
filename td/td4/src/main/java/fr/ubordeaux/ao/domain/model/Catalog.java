package fr.ubordeaux.ao.domain.model;

import java.util.Set;
import java.util.UUID;

import fr.ubordeaux.ao.domain.type.CatalogName;

public interface Catalog {
    public CatalogName getCatalogName();
    public void setCatalogName(CatalogName catalogName);
    public Reference getReferenceWithID(UUID id);
    public Reference getReferenceWithName(String name);
    public Set<Reference> getReferences();
    public void addReference(Reference reference);
}
