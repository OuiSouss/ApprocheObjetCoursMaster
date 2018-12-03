package fr.ubordeaux.ao.referencemanagement.domain.type;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;

public class CatalogName {
    private String value;

    public CatalogName(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    private void setValue(String value) {
        Pattern pattern = Pattern.compile("[a-z]{3,10}");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            throw new ReferenceManagementException("A catalog name should have"
                                                   + "between 3 and 10"
                                                   + "alphabetical chars in "
                                                   + "lowercase");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatalogName)) {
            return false;
        }
        CatalogName otherName = (CatalogName) other;
        return this.getValue().equals(otherName.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
