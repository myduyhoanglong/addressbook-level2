package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents street name in an address.
 * Guarantees: immutable; is valid as declared in {@link #isValidStreet(String)}
 */
class Street {
	
	public static final String EXAMPLE = "Clementi Ave 3"; 
	public static final String MESSAGE_STREET_CONSTRAINTS = "Street should be sequence of numbers, alphabetic characters and spaces";
	public static final String STREET_VALIDATION_REGEX = "[[\\p{Alpha}|\\d] ]+";
	
	public final String value;
	
	/**
     * Validates given street name.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
	public Street(String street) throws IllegalValueException {
		String trimmedStreet = street.trim();
		if (!isValidStreet(trimmedStreet)) {
			throw new IllegalValueException(MESSAGE_STREET_CONSTRAINTS);
		}
		this.value = trimmedStreet;
	}
	
	/**
     * Returns true if a given string is a valid street.
     */
	public static boolean isValidStreet(String test) {
		return test.matches(STREET_VALIDATION_REGEX);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this
				|| (other instanceof Street && this.value.equals(((Street) other).value));
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
