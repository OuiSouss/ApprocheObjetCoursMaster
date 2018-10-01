package fr.ubordeaux.ao.domain.model;

import java.util.UUID;

public class Reference {
    private UUID _id;
    private String _name;
    private String _description;
    private int _basePrice;

    public Reference(UUID id, String name, String description, int basePrice) {
	_id = id;
	_name = name;
	_description = description;
	_basePrice = basePrice;
    }

    public UUID getID() {
	return _id;
    }

    public String getName() {
	return _name;
    }

    public String getDescription() {
	return _description;
    }

    public int getBasePrice() {
	return _basePrice;
    }

    @Override
    public boolean equals(Object other) {
	if (!(other instanceof Reference))
	    return false;
	Reference otherReference = (Reference) other;
	boolean sameID = _id.compareTo(otherReference.getID()) == 0;
	boolean sameName = _name.compareTo(otherReference.getName()) == 0;
	boolean sameDescription = _description.compareTo(
				  otherReference.getDescription()) == 0;
	boolean sameBasePrice = _basePrice == otherReference.getBasePrice();
	return sameID && sameName && sameDescription && sameBasePrice;
    }

    @Override
    public String toString() {
	return "Reference id : " + _id + ", name : " + _name +
	       ", description : " + _description;
    }
    
}
