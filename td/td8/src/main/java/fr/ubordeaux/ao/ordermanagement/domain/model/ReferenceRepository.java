package fr.ubordeaux.ao.ordermanagement.domain.model;

import java.util.List;
import java.util.UUID;

public interface ReferenceRepository {
    void add(Reference reference);
    List<Reference> getAllReference();
    Reference getReferenceWithID(UUID id);
}
