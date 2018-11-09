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

    public CatalogImpl(CatalogName catalogName) {
	setName(catalogName);
	references = new HashMap<String, Reference>();
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

    public Set<Reference> getReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id))
            throw new ReferenceManagementException("cannot find Reference,"
                                                   + "id unknown !");
        return references.get(id);
    }

    public void addReference(Reference reference) {
	references.put(reference.getId(), reference);
    }

    public void removeReference(Reference reference) {
        references.remove(reference.getId());
    }
}
