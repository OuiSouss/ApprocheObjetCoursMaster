package fr.ubordeaux.ao.ordermanagement.domain.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import fr.ubordeaux.ao.ordermanagement.domain.exception.OrderException;

public class Basket {
    private UUID id;
    private Map<Reference, Integer> itemMap;

    public Basket(UUID basketID) {
        id = basketID;
        itemMap = new HashMap<Reference, Integer>();
    }

    public void add(Reference reference, int quantity) {
        if (reference == null) {
            throw new OrderException("Null Reference in basket");
        }
        if (quantity <= 0) {
            throw new OrderException("Quantity is less or equal to 0");
        }
        if (itemMap.containsKey(reference)) {
            throw new OrderException("reference is already in basket");
        }
        itemMap.put(reference, Integer.valueOf(quantity));
    }

    public void remove(Reference reference) {
        if (!itemMap.containsKey(reference)) {
            throw new OrderException("Reference is not in basket");
        }
        itemMap.remove(reference);
    }

    public void changeQuantity(Reference reference, int quantity) {
        if (!itemMap.containsKey(reference)) {
            throw new OrderException("Reference is not in basket");
        }
        if (quantity <= 0) {
            throw new OrderException("Quantity is less or equal to 0");
        }
        itemMap.put(reference, Integer.valueOf(quantity));
    }

    public int getAmount() {
        int amount = 0;
        for (Map.Entry<Reference, Integer> entry : itemMap.entrySet()) {
            int price = entry.getKey().getPrice().getPrice();
            int quantity = entry.getValue().intValue();
            amount += price * quantity;
        }
        return amount;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Basket)) {
            return false;
        }
        Basket otherBasket = (Basket) other;
        return id.equals(otherBasket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
