/**
 * -----------------------------------------------------------------------------
 * Name: Grant McCord
 * Date: June 1, 2025
 * Course: CS-320: Software Test Automation QA 2025
 * Project: 3-2 Milestone: Contact Class Unit Tests
 * File: ContactTest.java
 * Description:
 *   This test class verifies the validation logic of the Contact object.
 * -----------------------------------------------------------------------------
 * Updates 6-14-2025:
 * - Removed assertions of exact messages returned from Exceptions; it is sufficient
 *   to check that only an Exception was thrown.
 * - Added missing tests to bring Contact.java coverage up to 100%
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    // Requirement: All fields must meet constraints; valid contact creation.
    void testValidContactCreation() {
        Contact tony = new Contact("10001", "Tony", "Stark", "1234567890", "Stark Tower, NYC");
        assertEquals("10001", tony.getContactId());
        assertEquals("Tony", tony.getFirstName());
        assertEquals("Stark", tony.getLastName());
        assertEquals("1234567890", tony.getPhone());
        assertEquals("Stark Tower, NYC", tony.getAddress());
    }

    @Test
    // Requirement: Contact ID must be ≤ 10 characters.
    void testInvalidContactIdTooLong() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tony", "Stark", "1234567890", "Stark Tower, NYC");
        });
    }

    @Test
    // Requirement: Contact ID must be non-null.
    void testNullContactId() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tony", "Stark", "1234567890", "Stark Tower, NYC");
        });
    }

    @Test
    // Requirement: First name must be ≤ 10 characters.
    void testInvalidFirstNameTooLong() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10002", "AnthonyEdward", "Stark", "1234567890", "Stark Tower");
        });
    }

    @Test
    // Requirement: First name must be non-null.
    void testNullFirstName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10003", null, "Stark", "1234567890", "Stark Tower");
        });
    }

    @Test
    // Requirement: Last name must be ≤ 10 characters.
    void testInvalidLastNameTooLong() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10004", "Steve", "RogersAmerica", "0987654321", "Brooklyn, NYC");
        });
    }

    @Test
    // Requirement: Last name must be non-null.
    void testNullLastName() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10005", "Steve", null, "0987654321", "Brooklyn, NYC");
        });
    }

    @Test
    // Requirement: Phone must be exactly 10 digits.
    void testInvalidPhoneTooShort() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10006", "Bruce", "Banner", "12345", "Dayton, Ohio");
        });
    }

    @Test
    // Requirement: Phone must be digits only.
    void testInvalidPhoneNonNumeric() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10007", "Peter", "Parker", "123ABC4567", "Queens, NYC");
        });
    }

    @Test
    // Requirement: Phone must not be null.
    void testNullPhone() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10008", "Peter", "Parker", null, "Queens, NYC");
        });
    }

    @Test
    // Requirement: Address must be ≤ 30 characters.
    void testInvalidAddressTooLong() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10009", "Thor", "Odinson", "5556667777", 
                "This address is way too long to be valid in the system.");
        });
    }

    @Test
    // Requirement: Address must not be null.
    void testNullAddress() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10010", "Thor", "Odinson", "5556667777", null);
        });
    }
	    
	@Test
	// Requirement: First name can be updated to a valid value.
	void testSetValidFirstName() {
	     Contact contact = new Contact("20001", "Bruce", "Wayne", "9876543210", "Gotham City");
	     contact.setFirstName("Clark");
	     assertEquals("Clark", contact.getFirstName());
	 }
	
	 @Test
	 // Requirement: Last name can be updated to a valid value.
	 void testSetValidLastName() {
	     Contact contact = new Contact("20002", "Bruce", "Wayne", "9876543210", "Gotham City");
	     contact.setLastName("Kent");
	     assertEquals("Kent", contact.getLastName());
	 }
	
	 @Test
	 // Requirement: Phone number can be updated to a valid 10-digit number.
	 void testSetValidPhone() {
	     Contact contact = new Contact("20003", "Bruce", "Wayne", "9876543210", "Gotham City");
	     contact.setPhone("0123456789");
	     assertEquals("0123456789", contact.getPhone());
	 }
	
	 @Test
	 // Requirement: Address can be updated to a valid ≤ 30 character string.
	 void testSetValidAddress() {
	     Contact contact = new Contact("20004", "Bruce", "Wayne", "9876543210", "Gotham City");
	     contact.setAddress("Fortress of Solitude");
	     assertEquals("Fortress of Solitude", contact.getAddress());
	 }

	 @Test
	// Requirement: First name must not be null or >10 characters.
	void testSetInvalidFirstName() {
	    Contact contact = new Contact("30001", "Bruce", "Wayne", "9876543210", "Gotham City");

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setFirstName(null);
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setFirstName("ThisNameIsWayTooLong");
	    });
	}

	@Test
	// Requirement: Last name must not be null or >10 characters.
	void testSetInvalidLastName() {
	    Contact contact = new Contact("30002", "Bruce", "Wayne", "9876543210", "Gotham City");

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setLastName(null);
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setLastName("TooLongLastName");
	    });
	}

	@Test
	// Requirement: Phone must not be null, must be 10 digits, and numeric only.
	void testSetInvalidPhone() {
	    Contact contact = new Contact("30003", "Bruce", "Wayne", "9876543210", "Gotham City");

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone(null);
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone("123"); // too short
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone("12345678901"); // too long
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setPhone("12345abcde"); // not all digits
	    });
	}

	@Test
	// Requirement: Address must not be null or >30 characters.
	void testSetInvalidAddress() {
	    Contact contact = new Contact("30004", "Bruce", "Wayne", "9876543210", "Gotham City");

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setAddress(null);
	    });

	    assertThrows(IllegalArgumentException.class, () -> {
	        contact.setAddress("This address is far too long to be valid in this class.");
	    });
	}
	 
    
}


