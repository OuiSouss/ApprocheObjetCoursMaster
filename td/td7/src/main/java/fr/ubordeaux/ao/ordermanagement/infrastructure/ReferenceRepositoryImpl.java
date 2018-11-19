package fr.ubordeaux.ao.ordermanagement.infrastructure;

import java.util.Map;
import java.util.HashMap;

import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceRepository;
import fr.ubordeaux.ao.ordermanagement.domain.model.Reference;

public class ReferenceRepositoryImpl implements ReferenceRepository {
    private Map<Reference, Integer> map;
    
    public Map<Reference, Integer> getMapReferenceWithID(UUID id){
        map = new HashMap<Reference, Integer>();
        return map;
    }

}
