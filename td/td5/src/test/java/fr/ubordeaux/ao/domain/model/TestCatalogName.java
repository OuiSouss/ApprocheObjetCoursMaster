package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;

public class TestCatalogName {
    
    @Test
    public void testShortName() {
        try {
            CatalogName shortName = new CatalogName("li");
            assert(false);
        } catch (ReferenceManagementException e) {
            assert(true);
        }
    }

    @Test
    public void testLongName() {
        try {
            CatalogName longName = new CatalogName("luxembourgcity");
            assert(false);
        } catch (ReferenceManagementException e) {
            assert(true);
        }
    }

    @Test
    public void testUppercaseName() {
        try {
            CatalogName uppercaseName = new CatalogName("Luxembourg");
            assert(false);
        } catch (ReferenceManagementException e) {
            assert(true);
        }
    }

    @Test
    public void testNumericName() {
        try {
            CatalogName numericName = new CatalogName("1234");
            assert(false);
        } catch (ReferenceManagementException e) {
            assert(true);
        }
    }

    @Test
    public void testNormalName() {
        CatalogName normalName = new CatalogName("root");
        assertEquals("root", normalName.getValue());
    }

    @Test
    public void testEqualsName() {
        CatalogName c1 = new CatalogName("root");
        CatalogName c2 = new CatalogName("root");
        assertTrue(c1.equals(c2));
    }
}
