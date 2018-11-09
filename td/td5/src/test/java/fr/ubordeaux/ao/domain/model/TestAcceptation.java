package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class TestAcceptation {
    private Catalog catalog;

    @Before
    public void createCatalog() {
        catalog = new CatalogImpl(new CatalogName("Foo"));
    }

    @Test
    public void testAddReferenceAndFind() {
        Price price = new Price(1000);
        Reference reference = new Reference("ID", "Foo", "Bar", price);
        catalog.addReference(reference);
        Set<Reference> references = catalog.getAllReferences();
        for (Reference r : references) {
            assertEquals(r, reference);
        }
    }
}
