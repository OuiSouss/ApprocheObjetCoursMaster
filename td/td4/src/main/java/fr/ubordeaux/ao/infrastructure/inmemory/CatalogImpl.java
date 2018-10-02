package fr.ubordeaux.ao.infrastructure.inmemory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.model.Reference;

public class CatalogImpl implements Catalog {
    private CatalogName _catalogName;
    private Set<Reference> _referenceSet;

    public CatalogImpl(CatalogName catalogName) {
	setCatalogName(catalogName);
	_referenceSet = new HashSet<Reference>();
    }

    public CatalogName getCatalogName() {
	return _catalogName;
    }

    public void setCatalogName(CatalogName catalogName) {
	_catalogName = catalogName;
    }

    public Reference getReferenceWithID(UUID id) {
	if (id == null)
	    throw new NullPointerException();
	Reference r = null;
	for (Reference ref : _referenceSet) {
	    if (ref.getID().equals(id))
		r = ref;
	}
	return r;
    }

    public Reference getReferenceWithName(String name) {
	if (name == null)
	    throw new NullPointerException();
	Reference r = null;
	for (Reference ref : _referenceSet) {
	    if (ref.getName().compareTo(name) == 0)
		r = ref;
	}
	return r;
    }

    public Set<Reference> getReferences() {
	Set<Reference> result = new HashSet<Reference>();
	result.addAll(_referenceSet);
	return result;
    }

    public void addReference(Reference reference) {
	if (reference == null)
	    throw new NullPointerException();
	_referenceSet.add(reference);
    }
}
