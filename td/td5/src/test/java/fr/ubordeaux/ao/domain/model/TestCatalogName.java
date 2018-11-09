package fr.ubordeaux.ao.domain.model;

import org.junit.Test;

import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;

public class TestCatalogName {
    
    @Test
    public void testShortName() {
        try {
            CatalogName shortName = new CatalogName("Li");
            assert(false);
        } catch (ReferenceManagementException e) {
            assert(true);
        }
    }
}
