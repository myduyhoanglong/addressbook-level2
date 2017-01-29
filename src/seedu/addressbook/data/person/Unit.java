package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents unit in an address.
 * Guarantees: immutable; is valid as declared in {@link #isValidUnit(String)}
 */
class Unit {
	
	public static final String EXAMPLE = "#12-34"; 
	public static final String MESSAGE_UNIT_CONSTRAINTS = "Unit should be started with '#' followed by numbers";
	public static final String UNIT_VALIDATION_REGEX = "#[\\d\\-]+";
	
	public final String value;
	
	/**
     * Validates given unit.
     *
     * @throws IllegalValueException if given unit string is invalid.
     */
	public Unit(String unit) throws IllegalValueException {
		String trimmedUnit = unit.trim();
		if (!isValidUnit(trimmedUnit)) {
			throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
		}
		this.value = trimmedUnit;
	}
	
	/**
     * Returns true if a given string is a valid unit.
     */
	public static boolean isValidUnit(String test) {
		return test.matches(UNIT_VALIDATION_REGEX);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this
				|| (other instanceof Unit && this.value.equals(((Unit) other).value));
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
