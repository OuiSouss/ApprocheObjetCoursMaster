package fr.ubordeaux.ao.domain.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;

public class SearchEngine {
    private Catalog catalog;

    public SearchEngine(Catalog catalog) {
        this.setCatalog(catalog);
    }

    private void setCatalog(Catalog catalog) {
        if (catalog == null)
            throw new ReferenceManagementException("cannot create SearchEngine"
                                                   + "with null as catalog");
        this.catalog = catalog;
    }

    public Reference searchReferenceById(String id) {
        for (Reference reference : catalog.getAllReferences()) {
            if (reference.getId().compareTo(id)==0) {
                return reference;
            }
        }
        throw new ReferenceManagementException("cannot find reference,"
                                               + "id does not exist");
    }

    public Set<Reference> searchReferencesByName(String name) {
        Set<Reference> foundReferences = new HashSet<Reference>();
        for (Reference reference : catalog.getAllReferences()) {
            if (reference.getName().compareTo(name)==0) {
                foundReferences.add(reference);
            }
        }
        return foundReferences;
    }

}
