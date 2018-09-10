package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class Finder {

    public Set<Contact> searchContact(String name, ContactSet contactSet){
	Set<Contact> tmp = contactSet.getContact(0, contactSet.size());
	Set<Contact> res = new HashSet<Contact>();
	for (Contact contact : tmp){
	    if (contact.getFirstName().startsWith(name) ||
		contact.getSecondName().startsWith(name))
		res.add(contact);
	}
	return res;
    }
}
