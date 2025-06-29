/*
 * -----------------------------------------------------------------------------
 * Name: Grant McCord
 * Date: May 25, 2025
 * Course: CS-320: Software Test Automation QA 2025
 * Project: 3-2 Milestone: Contact Service Assignment
 * File: ContactService.java
 * Description:
 *   This file defines the ContactService class, which provides operations for
 *   managing contacts in memory. It supports adding, deleting, and updating 
 *   contact data by contact ID, ensuring uniqueness and validation constraints.
 * -----------------------------------------------------------------------------
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	/*
     * Stores contacts in memory, using the contactId as the key.
     *
     * A HashMap makes it quick and easy to add, remove, or look up a contact 
     * by ID. Since each ID is unique and we need to find contacts fast, 
     * HashMap is a good fit.
     */
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     * The contactId must be unique; if it already exists, the operation will fail.
     * Implements: [REQ] The contact service shall be able to add contacts with a unique ID.
     *
     * @param contact the Contact object to add
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists!");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact from the service by contact ID.
     * Implements: [REQ] The contact service shall be able to delete contacts per contact ID.
     *
     * @param contactId the ID of the contact to delete
     * @throws IllegalArgumentException if the contact ID does not exist
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found!");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact by contact ID.
     * Implements: [REQ] The contact service shall be able to update contact fields per contact ID
     *             - updates 'firstName'
     *
     * @param contactId the ID of the contact to update
     * @param newFirstName the new first name to set
     * @throws IllegalArgumentException if the contact ID does not exist or the input is invalid
     */
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContactById(contactId);
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of a contact by contact ID.
     * Implements: [REQ] The contact service shall be able to update contact fields per contact ID
     *             - updates 'lastName'
     *
     * @param contactId the ID of the contact to update
     * @param newLastName the new last name to set
     * @throws IllegalArgumentException if the contact ID does not exist or the input is invalid
     */
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContactById(contactId);
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of a contact by contact ID.
     * Implements: [REQ] The contact service shall be able to update contact fields per contact ID
     *             - updates 'Number'
     *
     * @param contactId the ID of the contact to update
     * @param newPhone the new phone number to set
     * @throws IllegalArgumentException if the contact ID does not exist or the input is invalid
     */
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContactById(contactId);
        contact.setPhone(newPhone);
    }

    /**
     * Updates the address of a contact by contact ID.
     * Implements: [REQ] The contact service shall be able to update contact fields per contact ID
                   - updates 'Address'
     *
     * @param contactId the ID of the contact to update
     * @param newAddress the new address to set
     * @throws IllegalArgumentException if the contact ID does not exist or the input is invalid
     */
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContactById(contactId);
        contact.setAddress(newAddress);
    }

    /**
     * Helper method to retrieve a contact by ID.
     * Throws an exception if the contact does not exist.
     *
     * @param contactId the ID of the contact to retrieve
     * @return the Contact object with the given ID
     * @throws IllegalArgumentException if no contact with the given ID is found
     */
    private Contact getContactById(String contactId) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found!");
        }
        return contact;
    }
}
