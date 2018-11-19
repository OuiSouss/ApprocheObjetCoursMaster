package fr.ubordeaux.ao.ordermanagement.domain.model;

import java.util.Objects;
import java.util.UUID;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.referencemanagement.domain.type.Price;

public class Reference {
    private UUID id;
    private String name;
    private Price price;

    public Reference(UUID id, String name, Price price) {
        this.id = id;
        this.setName(name);
        this.setPrice(price);
    }

    private void setName(String name) {
        if (name == null) {
            throw new ReferenceManagementException("cannot create reference"
                                                   + "with null name");
        }
        this.name = name;
    }

    private void setPrice(Price price) {
        if (price == null) {
            throw new ReferenceManagementException("cannot create reference"
                                                   + "with null basePrice");
        }
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    public Price getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Reference) {
            Reference otherReference = (Reference) other;
            return this.getId().compareTo(otherReference.getId()) == 0;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Reference id=" + id + " name=" + name;
    }
}
