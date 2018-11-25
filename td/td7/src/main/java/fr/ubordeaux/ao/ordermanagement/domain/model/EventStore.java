package fr.ubordeaux.ao.ordermanagement.domain.model;

import java.util.List;
import java.util.UUID;

public interface EventStore {
    void add(Event event);
    List<Event> getEventList();
    List<Event> getEventListByBasketID(UUID basketID);
    List<Event> getEventListByReferenceID(UUID referenceID);
}
