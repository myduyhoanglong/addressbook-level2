package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
    
    private static final String ADD_TAG_PREFIX = "+";
    private static final String REMOVE_TAG_PREFIX = "-";
    
    private static final String MESSAGE_TAGGING_FORMAT = "%1$s %1$s %1$s";
    
    public ReadOnlyPerson targetPerson;
    public Tag changedTag;
    public boolean isAdded;
    
    /**
     * Constructs Tagging object
     * @param person whose tag is added or removed
     * @param tag is added or removed
     * @param isAdded is true if the tag is added, false otherwise
     */
    public Tagging(ReadOnlyPerson person, Tag tag, boolean isAdded) {
        this.targetPerson = person;
        this.changedTag = tag;
        this.isAdded = isAdded;
    }
    
    @Override
    public String toString() {
        return String.format(MESSAGE_TAGGING_FORMAT, isAdded ? ADD_TAG_PREFIX : REMOVE_TAG_PREFIX,
                targetPerson.getName(), changedTag);
    }
    
}
