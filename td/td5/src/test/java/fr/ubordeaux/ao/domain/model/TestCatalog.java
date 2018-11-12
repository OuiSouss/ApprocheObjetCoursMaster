package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;
import org.junit.Before;
import org.junit.Test;

public class TestCatalog {
    private Catalog catalog;

    @Before
    public void createCatalog(){
        catalog = new CatalogImpl(new CatalogName("root"));
    }

    @Test
    public void testAddReference() {
        Price price = new Price(1000);
        Reference reference = new Reference("#1", "test", "test", price);
        catalog.addReference(reference);
        assertEquals(1, catalog.size());
    }

    @Test
    public void testSubCatalog() {
        Price price = new Price(1000);
        Reference reference1 = new Reference("#1", "test", "test", price);
        catalog.addReference(reference1);

        Catalog sub = new CatalogImpl(new CatalogName("sub"));
        catalog.addSubCatalog(sub);
        Reference reference2 = new Reference("#1", "test", "test", price);
        sub.addReference(reference2);

        assertEquals(1, sub.size());
        assertEquals(2, catalog.size());
    }
}
