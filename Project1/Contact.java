/*
 * -----------------------------------------------------------------------------
 * Name: Grant McCord
 * Date: May 25, 2025
 * Course: CS-320: Software Test Automation QA 2025
 * Project: 3-2 Milestone: Contact Service Assignment
 * File: Contact.java
 * Description:
 *   This file defines the Contact class for managing individual contact entries.
 *   Each contact includes a unique, immutable ID, along with editable fields 
 *   for name, phone number, and address. Validation rules are enforced on all
 *   fields to ensure data integrity.
 * -----------------------------------------------------------------------------
 */

public class Contact {

    // Unique contact identifier (max 10 characters, non-null, immutable once set)
    private final String contactId;

    // Contact's first name (max 10 characters, non-null, editable)
    private String firstName;

    // Contact's last name (max 10 characters, non-null, editable)
    private String lastName;

    // Contact's phone number (exactly 10 numeric digits, non-null, editable)
    private String phone;

    // Contact's address (max 30 characters, non-null, editable)
    private String address;

    /**
     * Constructor for Contact.
     * Initializes a new contact object with all fields validated against constraints.
     * 
     * @param contactId Unique identifier for the contact (max 10 chars, non-null)
     * @param firstName Contact's first name (max 10 chars, non-null)
     * @param lastName  Contact's last name (max 10 chars, non-null)
     * @param phone     Contact's phone number (exactly 10 numeric digits, non-null)
     * @param address   Contact's address (max 30 chars, non-null)
     * @throws IllegalArgumentException if any field does not meet its constraints
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Gets the contact ID.
     * This value is immutable once set.
     *
     * @return the contact's unique identifier
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Gets the first name of the contact.
     *
     * @return the contact's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a new first name for the contact.
     * Must be non-null and not exceed 10 characters.
     *
     * @param firstName new first name
     * @throws IllegalArgumentException if the input is invalid
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name!");
        }
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the contact.
     *
     * @return the contact's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a new last name for the contact.
     * Must be non-null and not exceed 10 characters.
     *
     * @param lastName new last name
     * @throws IllegalArgumentException if the input is invalid
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name!");
        }
        this.lastName = lastName;
    }

    /**
     * Gets the contact's phone number.
     *
     * @return the phone number (10 digits)
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets a new phone number for the contact.
     * Must be exactly 10 numeric digits and non-null.
     *
     * @param phone new phone number
     * @throws IllegalArgumentException if the input is invalid
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number!");
        }
        this.phone = phone;
    }

    /**
     * Gets the contact's address.
     *
     * @return the contact's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a new address for the contact.
     * Must be non-null and not exceed 30 characters.
     *
     * @param address new address
     * @throws IllegalArgumentException if the input is invalid
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address!");
        }
        this.address = address;
    }
}
