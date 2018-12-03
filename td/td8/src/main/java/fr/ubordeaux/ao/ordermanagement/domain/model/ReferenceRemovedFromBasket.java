package fr.ubordeaux.ao.ordermanagement.domain.model;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;

import java.util.UUID;

public class ReferenceRemovedFromBasket extends Event {
    private UUID basketID;
    private UUID referenceID;
    private int quantity;
    private ReferenceRepository referenceRepository;

    public ReferenceRemovedFromBasket(UUID basketID, UUID referenceID,
                                      int quantity,
                                      ReferenceRepository referenceRepository) {
        this.setBasketID(basketID);
        this.setReferenceID(referenceID);
        this.setQuantity(quantity);
        this.referenceRepository = referenceRepository;
    }

    @Override
    public void build(Basket basket) {
        Reference reference = referenceRepository.getReferenceWithID(referenceID);
        basket.remove(reference);
    }

    public UUID getBasketID() {
        return basketID;
    }

    public UUID getReferenceID() {
        return referenceID;
    }

    public int getQuantity() {
        return quantity;
    }

    private void setBasketID(UUID basketID) {
        if (basketID == null) {
            throw new OrderException("Basket id is null");
        }
        this.basketID = basketID;
    }

    private void setReferenceID(UUID referenceID) {
        if (referenceID == null) {
            throw new OrderException("Reference id is null");
        }
        this.referenceID = referenceID;
    }

    private void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new OrderException("Quantity is less or equal to 0");
        }
        this.quantity = quantity;
    }
}
