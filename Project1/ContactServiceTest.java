/*
 * -----------------------------------------------------------------------------
 * Name: Grant McCord
 * Date: May 25, 2025
 * Course: CS-320: Software Test Automation QA 2025
 * Project: 3-2 Milestone: Contact Service Assignment
 * File: ContactServiceTest.java
 * Description:
 *   This file defines the ContactServiceTest class, which provides validation for
 *   the ContactService class.
 * -----------------------------------------------------------------------------
 * Updates 6-14-2025:
 * - Removed assertions of exact messages returned from Exceptions; it is sufficient
 *   to check that only an Exception was thrown.
 *  - Added missing tests to bring ContactService.java coverage up to 100%
 */   


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    void setUp() {
        // Dependency: ContactService must be instantiated before each test to isolate state.
        contactService = new ContactService();
    }

    @Test
    // Requirement: The system shall prevent adding a contact if the contact ID already exists.
    // Dependency: ContactService must track contact IDs; Contact must have getContactId() method.
    void testAddContact() {
        Contact tony = new Contact("001", "Tony", "Stark", "1234567890", "Stark Tower, NYC");
        contactService.addContact(tony);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(tony);
        });
    }

    @Test
    // Requirement: The system shall allow deleting a contact by contact ID.
    // Dependency: ContactService must support deletion logic and Contact must be retrievable by ID.
    void testDeleteContact() {
        Contact steve = new Contact("002", "Steve", "Rogers", "0987654321", "Brooklyn, NYC");
        contactService.addContact(steve);
        contactService.deleteContact("002");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("002");
        });
    }

    @Test
    // Requirement: The system shall allow updating a contact's first name by contact ID.
    // Dependency: Contact must allow changing first name via setFirstName().
    void testUpdateFirstName() {
        Contact bruce = new Contact("003", "Bruce", "Banner", "1112223333", "Dayton, Ohio");
        contactService.addContact(bruce);
        contactService.updateFirstName("003", "Hulk");
        assertEquals("Hulk", bruce.getFirstName());
    }

    @Test
    // Requirement: The system shall allow updating a contact's last name by contact ID.
    // Dependency: Contact must allow chaning last name via setLastName().
    void testUpdateLastName() {
        Contact natasha = new Contact("004", "Natasha", "Romanoff", "2223334444", "Stalingrad");
        contactService.addContact(natasha);
        contactService.updateLastName("004", "Belova");
        assertEquals("Belova", natasha.getLastName());
    }

    @Test
    // Requirement: The system shall allow updating a contact's phone number by contact ID.
    // Dependency: Contact must changing of phone via setPhone().
    void testUpdatePhone() {
        Contact clint = new Contact("005", "Clint", "Barton", "3334445555", "Iowa Farm");
        contactService.addContact(clint);
        contactService.updatePhone("005", "9998887777");
        assertEquals("9998887777", clint.getPhone());
    }

    @Test
    // Requirement: The system shall allow updating a contact's address by contact ID.
    // Dependency: Contact must allow chaning of address via setAddress().
    void testUpdateAddress() {
        Contact thor = new Contact("006", "Thor", "Odinson", "4445556666", "Asgard");
        contactService.addContact(thor);
        contactService.updateAddress("006", "New Asgard");
        assertEquals("New Asgard", thor.getAddress());
    }
    
    @Test
	 // Requirement: The system shall throw an exception when trying to update a contact that does not exist.
	 void testUpdateNonexistentContact() {
	     Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
	         contactService.updateFirstName("999", "Nick");
	     });
	
	     Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
	         contactService.updateLastName("999", "Fury");
	     });
	
	     Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {
	         contactService.updatePhone("999", "0001112222");
	     });
	
	     Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {
	         contactService.updateAddress("999", "Unknown");
	     });
	 }
    
}
