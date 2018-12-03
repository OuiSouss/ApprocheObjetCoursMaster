package fr.ubordeaux.ao.referencemanagement.infrastructure.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.referencemanagement.domain.type.Price;

public class CatalogCSVImpl implements Catalog {
    private FileWriter fileWriter;
    private BufferedReader fileReader;
    private CatalogName catalogName;

    public CatalogCSVImpl(CatalogName catalogName, String filename) {
        setName(catalogName);
        if (filename == null) {
            throw new ReferenceManagementException("filename is null");
        }
        try {
            File file = new File(filename);
            fileWriter = new FileWriter(filename, true);
            if ((file.exists() && file.length() == 0) ||
                !file.exists()) {           
                fileWriter.write("SubCatalogName;ReferenceID;ReferenceName;ReferenceDescription;ReferenceBasePrice\n");
                fileWriter.flush();
            }
            fileReader = new BufferedReader(new FileReader(filename));
            fileReader.readLine();            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CatalogCSVImpl(String filename) {
        setName(new CatalogName("root"));
        if (filename == null) {
            throw new ReferenceManagementException("filename is null");
        }
        try {
            File file = new File(filename);
            if (!file.exists()) {
                fileWriter = new FileWriter(filename);            
                fileWriter.write("SubCatalogName;ReferenceID;ReferenceName;ReferenceDescription;ReferenceBasePrice\n");
                fileWriter.flush();

                fileReader = new BufferedReader(new FileReader(filename));
                fileReader.readLine();
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setName(CatalogName name) {
        this.catalogName = name;
    }

    @Override
    public int size() {
        int size = 0;
        try {
            while (fileReader.readLine() != null) {
                size++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size - 1;
    }

    @Override
    public CatalogName getCatalogName() {
        return catalogName;
    }

    @Override
    public Set<Reference> getAllReferences() {
        Set<Reference> referenceSet = new HashSet<Reference>();
        String line = null;
        try {
            while ((line = fileReader.readLine()) != null) {
                String[] lineSplit = line.split(";");
                UUID referenceID = UUID.fromString(lineSplit[1]);
                String referenceName = lineSplit[2];
                String referenceDescription = lineSplit[3];
                Price referenceBasePrice = new Price(Integer.parseInt(lineSplit[4]));
                Reference reference = new Reference(referenceID, referenceName, referenceDescription, referenceBasePrice);
                referenceSet.add(reference);
            }
            return referenceSet;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return referenceSet;
    }

    @Override
    public Set<Reference> getOwnReferences() {
        return null;
    }

    @Override
    public Reference findReferenceById(UUID id) {
        return null;
    }

    @Override
    public void addReference(Reference reference) {
        UUID referenceID = reference.getId();
        String referenceName = reference.getName();
        String referenceDescription = reference.getDescription();
        Price price = reference.getBasePrice();
        try {
            fileWriter.write(catalogName + ";" + referenceID.toString() + ";" + referenceName + ";"
                    + referenceDescription + ";" + price.toString() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSubCatalog(Catalog catalog) {

    }

    @Override
    public void removeReference(Reference reference) {

    }

	@Override
	public void removeSubCatalog(Catalog catalog) {
		
	}
}