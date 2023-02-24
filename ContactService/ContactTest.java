package com.snhu.ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	@DisplayName("Contact Class constructor validation")
	void testContactClass() {
		Contact contact = new Contact("123456", "Evan", "Bush", "3152515092", "1400 Caliper Oak Circle");
		assertTrue(contact.getContactId().equals("123456"));
		assertTrue(contact.getFirstName().equals("Evan"));
		assertTrue(contact.getLastName().equals("Bush"));
		assertTrue(contact.getPhone().equals("3152515092"));
		assertTrue(contact.getAddress().equals("1400 Caliper Oak Circle"));
	}
	
	@Nested
	@DisplayName("Contact ID Tests")
	class ContactIDTests {
		
		@Test
		@DisplayName("Contact ID length is not over 10 characters")
		void testContactIdLengthValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("12345678910", "Evan", "Bush", "3152515092", "1400 Caliper Oak Circle");
			});
		}
		
		@Test
		@DisplayName("Contact ID is not null")
		void testContactIdNullValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "Evan", "Bush", "3152515092", "1400 Caliper Oak Circle");
			});
		}
	}
	
	@Nested
	@DisplayName("First Name Tests")
	class FirstNameTests {
		
		@Test
		@DisplayName("First name length is not over 10 characters")
		void testFirstNameLengthValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan1234567", "Bush", "3152515092", "1400 Caliper Oak Circle");
			});
		}
		
		@Test
		@DisplayName("First name is not null")
		void testFirstNameNullValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", null, "Bush", "3152515092", "1400 Caliper Oak Circle");
			});
		}		
	}
	
	@Nested
	@DisplayName("Last Name Tests")
	class LastNameTests {
		
		@Test
		@DisplayName("Last name length is not over 10 characters")
		void testLastNameLengthValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", "Bush1234567", "3152515092", "1400 Caliper Oak Circle");
			});
		}
		
		@Test
		@DisplayName("Last name is not null")
		void testLastNameNullValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", null, "3152515092", "1400 Caliper Oak Circle");
			});
		}
	}
	
	@Nested
	@DisplayName("Phone Tests")
	class PhoneTests {
		
		@Test
		@DisplayName("Phone number length is 10")
		void testPhoneLengthValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", "Bush", "13152515092", "1400 Caliper Oak Circle");
			});
		}
		
		@Test
		@DisplayName("Phone number is not null")
		void testPhoneNullValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", "Bush", null, "1400 Caliper Oak Circle");
			});
		}
	}
	
	@Nested
	@DisplayName("Address Tests")
	class AddressTests {
		
		@Test
		@DisplayName("Address length is not over 30 characters")
		void testAddressLengthValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", "Bush", "3152515092", "1400 Caliper Oak Circle, Mount Pleasant");
			});
		}
		
		@Test
		@DisplayName("Address is not null")
		void testAddressNullValidation() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("123456", "Evan", "Bush", "3152515092", null);
			});
		}		
	}
	
	@Nested
	@DisplayName("Setter Tests")
	class SetterTests {
		Contact contact;
		
		@BeforeEach
		void setup() {
			contact = new Contact("12345", "Evan", "Bush", "3152515092", "Charleston, SC");
		}
		
		@Test
		@DisplayName("First Name Setter Test")
		void firstNameSetterTest() {
			contact.setFirstName("Kylie");
			assertTrue(contact.getFirstName().equals("Kylie"));
		}
		
		@Test
		@DisplayName("Last Name Setter Test")
		void lastNameSetterTest() {
			contact.setLastName("White");
			assertTrue(contact.getLastName().equals("White"));
		}
		
		@Test
		@DisplayName("Phone Setter Test")
		void phoneSetterTest() {
			contact.setPhone("3158980156");
			assertTrue(contact.getPhone().equals("3158980156"));
		}
		
		@Test
		@DisplayName("Address Setter Test")
		void addressSetterTest() {
			contact.setAddress("Summerville, SC");
			assertTrue(contact.getAddress().equals("Summerville, SC"));
		}
	}
	
}

