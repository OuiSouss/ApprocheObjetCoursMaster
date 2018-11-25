package fr.ubordeaux.ao.ordermanagement.infrastructure.inmemory;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;
import fr.ubordeaux.ao.ordermanagement.domain.model.Event;
import fr.ubordeaux.ao.ordermanagement.domain.model.EventStore;
import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceAddedToBasket;
import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceRemovedFromBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventStoreImpl implements EventStore {
    private List<Event> eventStoreList;

    public EventStoreImpl(List<Event> eventStoreList) {
        this.eventStoreList = new ArrayList<Event>();
    }

    @Override
    public void add(Event event) {
        eventStoreList.add(event);
    }

    @Override
    public List<Event> getEventList() {
        return eventStoreList;
    }

    @Override
    public List<Event> getEventListByBasketID(UUID basketID) {
        List<Event> eventListByBasketID = new ArrayList<Event>();
        for (Event e : eventStoreList) {
            if (e instanceof ReferenceAddedToBasket) {
                ReferenceAddedToBasket eCasted = (ReferenceAddedToBasket) e;
                if (eCasted.getBasketID() == basketID) {
                    eventListByBasketID.add(e);
                }
            } else if (e instanceof ReferenceRemovedFromBasket) {
                ReferenceRemovedFromBasket eCasted =
                        (ReferenceRemovedFromBasket) e;
                if (eCasted.getBasketID() == basketID) {
                    eventListByBasketID.add(e);
                }
            } else {
                throw new OrderException("Can't find event for this basket id");
            }
        }
        return eventListByBasketID;
    }

    @Override
    public List<Event> getEventListByReferenceID(UUID referenceID) {
        List<Event> eventListByReferenceID = new ArrayList<Event>();
        for (Event e : eventStoreList) {
            if (e instanceof ReferenceAddedToBasket) {
                ReferenceAddedToBasket eCasted = (ReferenceAddedToBasket) e;
                if (eCasted.getReferenceID() == referenceID) {
                    eventListByReferenceID.add(e);
                }
            } else if (e instanceof ReferenceRemovedFromBasket) {
                ReferenceRemovedFromBasket eCasted =
                        (ReferenceRemovedFromBasket) e;
                if (eCasted.getReferenceID() == referenceID) {
                    eventListByReferenceID.add(e);
                }
            } else {
                throw new OrderException("Can't find event for reference id");
            }
        }
        return eventListByReferenceID;
    }
}
