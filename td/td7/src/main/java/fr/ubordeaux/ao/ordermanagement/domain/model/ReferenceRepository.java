package fr.ubordeaux.ao.ordermanagement.domain.model;

import java.util.Map;
import java.util.UUID;

import fr.ubordeaux.ao.ordermanagement.domain.model.Reference;

public interface ReferenceRepository {
    Map<Reference, Integer> getMapReferenceWithID(UUID id);
}
