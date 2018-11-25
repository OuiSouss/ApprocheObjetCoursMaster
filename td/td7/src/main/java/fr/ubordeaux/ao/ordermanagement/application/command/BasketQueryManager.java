package fr.ubordeaux.ao.ordermanagement.application.command;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;
import fr.ubordeaux.ao.ordermanagement.domain.model.Basket;
import fr.ubordeaux.ao.ordermanagement.domain.model.Event;
import fr.ubordeaux.ao.ordermanagement.domain.model.EventStore;

import java.util.UUID;

public class BasketQueryManager {
    private EventStore eventStore;

    public BasketQueryManager(EventStore eventStore) {
        this.setEventStore(eventStore);
    }

    public Basket buildBasketFromID(UUID basketID) {
        Basket basket = new Basket(basketID);
        for (Event event : eventStore.getEventListByBasketID(basketID)) {
            event.build(basket);
        }
        return basket;
    }

    private void setEventStore(EventStore eventStore) {
        if (eventStore == null) {
            throw new OrderException("Event store is null");
        }
        this.eventStore = eventStore;
    }
}
