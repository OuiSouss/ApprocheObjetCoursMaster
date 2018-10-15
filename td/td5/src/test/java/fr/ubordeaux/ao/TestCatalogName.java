package test.java.fr.ubordeaux.ao;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class TestCatalogName {
    
    @Test(excepted=fr.ubordeaux.ao.domain.exception.ReferenceManagementException)
    public void testShortName() {
        CatalogName shortName = new CatalogName("Li");
    }
}
