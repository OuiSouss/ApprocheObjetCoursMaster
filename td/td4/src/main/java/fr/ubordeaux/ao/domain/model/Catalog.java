package fr.ubordeaux.ao.domain.model;

import java.util.Set;
import java.util.UUID;

public interface Catalog {
    public String getCatalogName();
    public Reference getReferenceWithID(UUID id);
    public Reference getReferenceWithName(String name);
    public Set<Reference> getReferences();
    public void addReference(Reference reference);
}
