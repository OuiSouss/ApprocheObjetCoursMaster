package fr.ubordeaux.ao;

public class Finder {

    public Set<Contact> searchContact(String name, Contacts contacts){
	Set<Contact> tmp = contacts.getContacts(0, contacts.size());
	Set<Contact> res = new HashSet<Contact>();
	for (Contact contact : tmp){
	    if (contact.getFirstName().startsWith(name) ||
		contact.getSecondName().startsWith(name))
		res.add(contact);
	}
	return res;
    }
}
