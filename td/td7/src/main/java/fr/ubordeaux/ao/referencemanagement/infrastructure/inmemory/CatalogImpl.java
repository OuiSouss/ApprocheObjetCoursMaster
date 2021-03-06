package fr.ubordeaux.ao.referencemanagement.infrastructure.inmemory;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.type.CatalogName;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class CatalogImpl implements Catalog {
    private CatalogName catalogName;
    private Map<UUID, Reference> references;
    private Set<Catalog> subCatalogs;

    public CatalogImpl(CatalogName catalogName) {
        setName(catalogName);
        references = new HashMap<UUID, Reference>();
        subCatalogs = new HashSet<Catalog>();
    }

    public int size() {
        int sizeAllReferences = references.size();
        for (Catalog subCatalog : subCatalogs) {
            sizeAllReferences += subCatalog.size();
        }
        return sizeAllReferences;
    }

    public CatalogName getCatalogName() {
        return this.catalogName;
    }

    private void setName(CatalogName name) {
        this.catalogName = name;
    }

    public Set<Reference> getAllReferences() {
        if (subCatalogs.isEmpty()) {
            return getOwnReferences();
        }
        Set<Reference> recursiveReferencesSet = getOwnReferences();
        for (Catalog c : subCatalogs) {
            recursiveReferencesSet.addAll(c.getAllReferences());
        }
        return recursiveReferencesSet;
    }

    public Set<Reference> getOwnReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Reference findReferenceById(UUID id) {
        if (!references.containsKey(id)) {
            throw new ReferenceManagementException("cannot find Reference,"
                                                   + "id unknown !");
        }
        return references.get(id);
    }

    public void addReference(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void addSubCatalog(Catalog catalog) {
        for (Catalog c : subCatalogs) {
            if (c.getCatalogName().equals(catalog.getCatalogName())) {
                throw new ReferenceManagementException("Invalid catalog name");
            }
        }
        this.subCatalogs.add(catalog);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }

    public void removeSubCatalog(Catalog catalog) {
        for (Catalog c : subCatalogs) {
            if (c.getCatalogName().equals(catalog.getCatalogName())) {
                subCatalogs.remove(c);
            }
        }
    }
}
