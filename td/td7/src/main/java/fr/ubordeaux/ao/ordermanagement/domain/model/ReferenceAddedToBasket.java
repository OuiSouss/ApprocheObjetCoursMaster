package fr.ubordeaux.ao.ordermanagement.domain.model;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;

import java.util.UUID;

public class ReferenceAddedToBasket extends Event {
    private UUID basketID;
    private UUID referenceID;
    private int quantity;
    private ReferenceRepository referenceRepository;

    public ReferenceAddedToBasket(UUID basketID, UUID referenceID,
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
        basket.add(reference, quantity);
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
            throw new OrderException("Basket UUID is null");
        }
        this.basketID = basketID;
    }

    private void setReferenceID(UUID referenceID) {
        if (referenceID == null) {
            throw new OrderException("Reference UUID is null");
        }
        this.referenceID = referenceID;
    }

    private void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new OrderException("Quantity is less or equals to 0");
        }
        this.quantity = quantity;
    }
}
