package fr.ubordeaux.ao.domain.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatalogName {
    private String _value;

    public CatalogName(String value) {
	setValue(value);
    }

    public String getValue() {
	return _value;
    }

    private void setValue(String value) {
	Pattern pattern = Pattern.compile("[a-zA-Z]{1,10}");
	Matcher matcher = pattern.matcher(value);
	if (!matcher.matches())
	    throw new IllegalArgumentException("Catalog name need to have less"
                                                + "than 10 alphabetical chars");
	_value = value;
    }

    @Override
    public boolean equals(Object other) {
	if (! (other instanceof CatalogName))
	    return false;
	CatalogName otherName = (CatalogName) other;
	return _value.compareTo(otherName.getValue()) == 0;
    }

    @Override
    public String toString() {
	return _value;
    }
}
