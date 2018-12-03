package fr.ubordeaux.ao.ordermanagement.application.command;

import fr.ubordeaux.ao.ordermanagement.domain.model.Event;
import fr.ubordeaux.ao.ordermanagement.domain.model.EventStore;
import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceAddedToBasket;
import fr.ubordeaux.ao.ordermanagement.domain.model.ReferenceRepository;

import java.util.UUID;

public class AddReferenceToBasket extends Command {
    private EventStore eventStore;
    private UUID basketID;
    private UUID referenceID;
    private int quantity;
    private ReferenceRepository referenceRepository;

    public AddReferenceToBasket(EventStore eventStore, UUID basketID,
                                UUID referenceID, int quantity,
                                ReferenceRepository referenceRepository) {
        this.eventStore = eventStore;
        this.basketID = basketID;
        this.referenceID = referenceID;
        this.quantity = quantity;
        this.referenceRepository = referenceRepository;
    }

    @Override
    public void execute() {
        Event event = new ReferenceAddedToBasket(basketID, referenceID,
                                                 quantity,
                                                 referenceRepository);
        eventStore.add(event);
    }
}
