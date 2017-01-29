package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a block in an address.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
class Block {
	
	public static final String EXAMPLE = "123"; 
	public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block should be sequence of numbers and alphabetic characters";
	public static final String BLOCK_VALIDATION_REGEX = "\\w+";
	
	public final String value;
	
	/**
     * Validates given block.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
	public Block(String block) throws IllegalValueException {
		String trimmedBlock = block.trim();
		if (!isValidBlock(trimmedBlock)) {
			throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
		}
		this.value = trimmedBlock;
	}
	
	/**
     * Returns true if a given string is a valid block.
     */
	public static boolean isValidBlock(String test) {
		return test.matches(BLOCK_VALIDATION_REGEX);
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this
				|| (other instanceof Block && this.value.equals(((Block) other).value));
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
