package fr.ubordeaux.ao.ordermanagement.infrastructure.inmemory;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;
import fr.ubordeaux.ao.ordermanagement.domain.model.Reference;
import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReferenceRepositoryImpl implements ReferenceRepository {
    private List<Reference> referenceList;

    public ReferenceRepositoryImpl() {
        referenceList = new ArrayList<Reference>();
    }

    @Override
    public void add(Reference reference) {
        if (reference == null) {
            throw new OrderException("Reference is null");
        }
        referenceList.add(reference);
    }

    @Override
    public List<Reference> getAllReference() {
        return referenceList;
    }

    @Override
    public Reference getReferenceWithID(UUID id) {
        Reference referenceWithID = null;
        for (Reference reference : referenceList) {
            if (reference.getId() == id) {
                referenceWithID = reference;
            }
        }
        return referenceWithID;
    }
}
