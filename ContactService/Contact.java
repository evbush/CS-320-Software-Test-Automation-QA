package com.snhu.ContactService;

public class Contact {
	
	// Instance variables
	private final String contactId; 
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructor
	public Contact(String id, String fn, String ln, String pn, String ad) {
		this.contactId = id;
		this.firstName = fn;
		this.lastName = ln;
		this.phone = pn;
		this.address = ad;
		ValidateState();
	}
	
	// Getters and Setters -------------------------
	public String getContactId() {
		return contactId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setFirstName(String fn) { 		
		this.firstName = fn;
		ValidateState();
	}
	
	public void setLastName(String ln) {
		this.lastName = ln;
		ValidateState();
	}
	
	public void setPhone (String pn) {
		this.phone = pn;
		ValidateState();
	}
	
	public void setAddress(String ad) {
		this.address = ad;
		ValidateState();
	}
	
	private void ValidateState() {
		if (this.contactId == null || this.contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID input: cannot be null or longer than 10 characters");
		}
		if (this.firstName == null || this.firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name input: cannot be null or longer than 10 characters");
		}
		if (this.lastName == null || this.lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name input: cannot be null or longer than 10 characters");
		}
		if (this.phone == null || this.phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone input: cannot be null and must be 10 characters");
		}
		if (this.address == null || this.address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address input: cannot be null or longer than 30 characters");
		}
	}
}
