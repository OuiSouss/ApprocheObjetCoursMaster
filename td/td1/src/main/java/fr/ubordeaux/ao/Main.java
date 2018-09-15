package fr.ubordeaux.ao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Set;

public class Main {
    private static  final int MAX = 3000;
    public static void main(String[] args) {
        ContactSet contactSet = new ContactSet();
	TownSet townSet = new TownSet();
	TownFactory tf = new TownFactory();

        for (int i = 0 ; i < MAX ; i++) {
	    townSet.addTown(tf.getNextTown());
            Address address = new Address(351, "Cours de la libération",
					  townSet.getTown(i,i).iterator().next());
            Contact newContact = new Contact("John", "Do", address);
            contactSet.addContact(newContact);
        }
        System.out.println(MAX + " contacts created !");

	Finder finder = new Finder();

	BufferedReader br = null;
	try {
	    br = new BufferedReader(new InputStreamReader(System.in));
	    System.out.print("Enter a name : ");
	    String input = br.readLine();
	    Set<Contact> search = finder.searchContact(input, contactSet);
	    for (Contact s : search){
		System.out.println(s.toString());
	    }
	} catch (IOException e){
	    e.printStackTrace();
	}
        try {
            Thread.sleep(200000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
