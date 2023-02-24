package com.snhu.ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	ContactService contactService;
	
	@BeforeEach
	void setup() {
		contactService = new ContactService();
	}
	
	@Nested
	@DisplayName("Add Contacts Tests")
	class AddContactTests {
		
		@Test
		@DisplayName("Add Contact Test")
		void addContactsTest() { 
			contactService.addContact("123456", "Evan", "Bush", "3152515092", "Charleston, SC");
			assertEquals(1, contactService.directorySize());
		}
		
		@Test
		@DisplayName("Adding Duplicate ID Test")
		void addDuplicateIDTest() {
			contactService.addContact("123456", "Evan", "Bush", "3152515092", "Charleston, SC");
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				contactService.addContact("123456", "Kylie", "Bush", "3158980156", "Charleston, SC");
			});
		}		
	}
	
	@Test
	@DisplayName("Remove Contact Test")
	void removeContactsTest() {
		contactService.addContact("123456", "Evan", "Bush", "3152515092", "Charleston, SC");
		contactService.addContact("123457", "Kylie", "Bush", "3158980156", "Charleston, SC");
		contactService.deleteContact("123456");
		Assertions.assertEquals(1, contactService.directorySize());
	}
	
	@Nested
	@DisplayName("Update Contacts Tests")
	class UpdateContactFields {
		
		@BeforeEach
		void setup() {
			contactService.addContact("123456", "Evan", "Bush", "3152515092", "Charleston, SC");
		}

		@Test
		@DisplayName("Update first name test")
		void updateFirstNameTest() {
			contactService.updateContact("123456", "first name", "Kylie");
			assertTrue(contactService.directorySearch(0).getFirstName().equals("Kylie"));
		}
		
		@Test
		@DisplayName("Update last name test")
		void updateLastNameTest() {
			contactService.updateContact("123456", "Last Name", "White");
			assertTrue(contactService.directorySearch(0).getLastName().equals("White"));
		}
		
		@Test
		@DisplayName("Update phone number test")
		void updatePhoneTest() {
			contactService.updateContact("123456", "phone", "3158980156");
			assertTrue(contactService.directorySearch(0).getPhone().equals("3158980156"));
		}
		
		@Test
		@DisplayName("Update address test")
		void updateAddressTest() {
			contactService.updateContact("123456", "address", "Summerville, SC");
			assertTrue(contactService.directorySearch(0).getAddress().equals("Summerville, SC"));
		}
	}

}
