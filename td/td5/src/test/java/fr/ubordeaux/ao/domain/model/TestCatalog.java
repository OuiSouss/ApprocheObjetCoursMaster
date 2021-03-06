package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.UUID;

public class TestCatalog {
    private Catalog catalog;

    @Before
    public void createCatalog(){
        catalog = new CatalogImpl(new CatalogName("root"));
    }

    @Test
    public void testAddReference() {
        Price price = new Price(1000);
        Reference reference = new Reference("test", "test", price);
        catalog.addReference(reference);
        assertEquals(1, catalog.size());
    }

    @Test
    public void testSubCatalog() {
        Price price = new Price(1000);
        Reference reference1 = new Reference("test", "test", price);
        catalog.addReference(reference1);

        Catalog sub = new CatalogImpl(new CatalogName("sub"));
        catalog.addSubCatalog(sub);
        Reference reference2 = new Reference("test", "test", price);
        sub.addReference(reference2);

        assertEquals(1, sub.size());
        assertEquals(2, catalog.size());
    }

    @Test
    public void testSubCatalogsDifferentNames() {
        Catalog sub1 = new CatalogImpl(new CatalogName("subu"));
        Catalog sub2 = new CatalogImpl(new CatalogName("subu"));
        catalog.addSubCatalog(sub1);
        try {
            catalog.addSubCatalog(sub2);
            assert(false);
        } catch (ReferenceManagementException e) {
            assert (true);
        }
    }

    @Test
    public void testGetAllReferences() {
        final int MAX = 50000;
        for (int i = 0 ; i < MAX ; ++i) {
            Reference reference = new Reference("test", "test", new Price(2000));
            catalog.addReference(reference);
        }

        Catalog sub = new CatalogImpl(new CatalogName("test"));
        catalog.addSubCatalog(sub);
        for (int i = 0 ; i < MAX ; ++i) {
            Reference reference = new Reference("test", "test", new Price(2000));
            sub.addReference(reference);
        }
        Set<Reference> references = catalog.getAllReferences();
        assertEquals(MAX * 2, references.size());
    }

    @Test
    public void testGetOwnReferences() {
       final int MAX = 10000;
       for (int i = 0; i < MAX; ++i) {
           Reference reference = new Reference("test", "test", new Price(1000));
           catalog.addReference(reference);
       }
       Set<Reference> references = catalog.getOwnReferences();
       assertEquals(MAX, references.size());
    }

    @Test
    public void testFindReferenceById() {
        Price price = new Price(1000);
        Reference reference1 = new Reference("test", "test", price);
        catalog.addReference(reference1);

        UUID id = reference1.getId();
        assertEquals(reference1, catalog.findReferenceById(id));
    }

    @Test
    public void testRemoveReference() {
        Price price = new Price(1000);
        Reference reference1 = new Reference("test", "test", price);
        catalog.addReference(reference1);
        catalog.removeReference(reference1);
        assertEquals(0, catalog.size());
    }

    @Test
    public void testRemoveSubCatalog() {
        Price price = new Price(1000);
        Reference reference1 = new Reference("test", "test", price);
        catalog.addReference(reference1);

        Catalog sub = new CatalogImpl(new CatalogName("sub"));
        catalog.addSubCatalog(sub);
        Reference reference2 = new Reference("test", "test", price);
        sub.addReference(reference2);

        catalog.removeSubCatalog(sub);

        assertEquals(1, catalog.size());
    }
}
