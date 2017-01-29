package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    public static final int NUMBER_OF_PROPERTIES_IN_ADDRESS = 4;
    
    public static final String FIRST_PROPERTY = "block, ";
    public static final String SECOND_PROPERTY = "street, ";
    public static final String THIRD_PROPERTY = "unit, ";
    public static final String FOURTH_PROPERTY = "postal code ";
    public static final String MESSAGE_FOR_INVALID_ADDRESS = "Address should contain " 
    					+ NUMBER_OF_PROPERTIES_IN_ADDRESS + " properties: "
    					+ FIRST_PROPERTY + SECOND_PROPERTY + THIRD_PROPERTY + FOURTH_PROPERTY;
    public static final int BLOCK_INDEX = 0;
    public static final int STREET_INDEX = 1;
    public static final int UNIT_INDEX = 2;
    public static final int POSTAL_CODE_INDEX = 3;

    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode; 
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        String[] decodedAddress = decodeAddress(trimmedAddress);
        if (decodedAddress.length != 4) {
        	throw new IllegalValueException(MESSAGE_FOR_INVALID_ADDRESS);
        }
        this.block = new Block(decodedAddress[BLOCK_INDEX]);
        this.street = new Street(decodedAddress[STREET_INDEX]);
        this.unit = new Unit(decodedAddress[UNIT_INDEX]);
        this.postalCode = new PostalCode(decodedAddress[POSTAL_CODE_INDEX]);
        value = trimmedAddress;
    }
    
    /**
     * split input address string into block, street, unit and postal code
     * 
     * @param string represents full address
     * @return string array of block, street, unit and postal code
     */
    private String[] decodeAddress(String encodedAddress) {
    	return encodedAddress.split(", ");
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String[] decodedAddress) {
        if (decodedAddress.length != NUMBER_OF_PROPERTIES_IN_ADDRESS) {
        	return false;
        }
        return Block.isValidBlock(decodedAddress[BLOCK_INDEX])
        		&& Street.isValidStreet(decodedAddress[STREET_INDEX])
        		&& Unit.isValidUnit(decodedAddress[UNIT_INDEX])
        		&& PostalCode.isValidPostalCode(decodedAddress[POSTAL_CODE_INDEX]);
    }

    public Block getBlock() {
    	return block;
    }
    
    public Street getStreet() {
    	return street;
    }
    
    public Unit getUnit() {
    	return unit;
    }
    
    public PostalCode getPostalCode() {
    	return postalCode;
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).getBlock())
                && this.street.equals(((Address) other).getStreet())
                && this.unit.equals(((Address) other).getUnit())
                && this.postalCode.equals(((Address) other).getPostalCode())); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
