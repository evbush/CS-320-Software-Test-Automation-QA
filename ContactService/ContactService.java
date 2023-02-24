package com.snhu.ContactService;

import java.util.ArrayList;

public class ContactService {
	// Array list to store all created contacts
	private ArrayList<Contact> directory = new ArrayList<Contact>();
	
	// Creates and adds new contact to directory for storage and easy access
	public void addContact(String id, String fn, String ln, String ph, String ad) {
		if (idExists(id) == false) {
			directory.add(new Contact(id, fn, ln, ph, ad));
		}
	}
	
	// Removes contact from directory to then be later deleted by garbage collector by changing the object's overall value to null, 
	// therefore dereferencing it within the stack
	public void deleteContact(String id) {	
		for (int i = 0; i < directory.size(); i++) {
			if (directory.get(i).getContactId().equals(id) == true) {
				directory.set(i, null);
				directory.remove(directory.get(i));
			}
		}
	}
	
	// Searches through directory with for contact ID and then updates based on user's inputs
	public void updateContact(String id, String option, String update) {
		for (Contact contact : directory) {
			if (contact.getContactId().equals(id) == true) {
				if (option.equalsIgnoreCase("first name") == true) {
					contact.setFirstName(update);
					break;
				} else if (option.equalsIgnoreCase("last name") == true) {
					contact.setLastName(update);
					break;
				} else if (option.equalsIgnoreCase("phone") == true) {
					contact.setPhone(update);
					break;
				} else if (option.equalsIgnoreCase("address") == true) {
					contact.setAddress(update);
					break;
				}
			}
		}
	}
	
	// Checks directory for contact IDs to see if match exists, throws exception if duplicate found
	private boolean idExists(String input) {
		for (Contact contact : directory) {
			if (contact.getContactId().equals(input) == true) {
				throw new IllegalArgumentException("Invalid Contact ID input: Must be unique");
			}
		}
		return false;
	}
	
	// Returns directory size
	public int directorySize() {
		return directory.size();
	}
	
	// Returns Contact at param i's index within directory
	// Used for testing assistance
	public Contact directorySearch(int i) {
		return directory.get(i);
	}
}
