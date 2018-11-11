package fr.ubordeaux.ao.infrastructure.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;

public class CatalogImpl implements Catalog {
    private CatalogName catalogName;
    private Map<String, Reference> references;
    private Set<Catalog> subCatalogs;

    public CatalogImpl(CatalogName catalogName) {
        setName(catalogName);
        references = new HashMap<String, Reference>();
        subCatalogs = new HashSet<Catalog>();
    }

    public int size() {
        return references.size();
    }

    public CatalogName getCatalogName() {
        return catalogName;
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

    public Reference findReferenceById(String id) {
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
        subCatalogs.add(catalog);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }

    /*

    public void removeSubCatalog(Catalog catalog) {
    }

    */
}
