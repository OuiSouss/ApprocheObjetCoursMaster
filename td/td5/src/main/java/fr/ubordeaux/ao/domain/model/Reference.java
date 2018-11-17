package fr.ubordeaux.ao.domain.model;

import java.util.Objects;
import java.util.UUID;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.type.Price;

public class Reference {
    private UUID id;
    private String name;
    private String description;
    private Price basePrice;

    public Reference(String name, String description,
                     Price basePrice) {
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
        this.setBasePrice(basePrice);
    }

    private void setName(String name) {
        if (name == null) {
            throw new ReferenceManagementException("cannot create reference"
                                                   + "with null name");
        }
        this.name = name;
    }

    private void setDescription(String description) {
        if (description == null) {
            throw new ReferenceManagementException("with null description"
                                                   + "cannot create reference");
        }
        this.description = description;
    }

    private void setBasePrice(Price basePrice) {
        if (basePrice == null) {
            throw new ReferenceManagementException("cannot create reference"
                                                   + "with null basePrice");
        }
        this.basePrice = basePrice;
    }

    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Price getBasePrice() {
        return this.basePrice;
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
        return "Reference id=" + id + " name=" + name + " description="
               + description;
    }
}
