package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents postal code in an address.
 * Guarantees: immutable; is valid as declared in {@link #isValidPostalCode(String)}
 */
class PostalCode {
	
	public static final String EXAMPLE = "118420"; 
	public static final String MESSAGE_POSTAL_CODE_CONSTRAINTS = "Postal code should be sequence of numbers";
	public static final String POSTAL_CODE_VALIDATION_REGEX = "\\d+";
	
	public final String value;
	
	/**
     * Validates given postal code.
     *
     * @throws IllegalValueException if given postal code string is invalid.
     */
	public PostalCode(String postalCode) throws IllegalValueException {
		String trimmedPostalCode = postalCode.trim();
		if (!isValidPostalCode(trimmedPostalCode)) {
			throw new IllegalValueException(MESSAGE_POSTAL_CODE_CONSTRAINTS);
		}
		this.value = trimmedPostalCode;
	}
	
	/**
     * Returns true if a given string is a valid postal code.
     */
	public static boolean isValidPostalCode(String test) {
		return test.matches(POSTAL_CODE_VALIDATION_REGEX);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this
				|| (other instanceof PostalCode && this.value.equals(((PostalCode) other).value));
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
