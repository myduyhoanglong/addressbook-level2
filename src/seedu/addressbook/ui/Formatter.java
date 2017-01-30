package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class Formatter {
	
	/** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();
    
    private static final String DIVIDER = "===================================================";
    
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** add '||' before the line*/
    public static String addLinePrefix(String line) {
    	return LINE_PREFIX + line;
    }
    
    /** append divider to the line*/
    public static String addDivider(String line) {
    	StringBuilder appendedLine = new StringBuilder();
    	return appendedLine.append(line).append("\n").append(DIVIDER).toString();
    }
    
    public static String formatStorageFilePath(String storageFilePath) {
    	return String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    }
    
    /**
     * format welcome message
     * @param message to be displayed
     * @return a string nested by dividers
     */
    public static String formatWelcomeMessage(String version, String storageFilePath) {
    	final StringBuilder formatted = new StringBuilder();
    	formatted.append(DIVIDER).append("\n");
    	formatted.append(DIVIDER).append("\n");
    	formatted.append(MESSAGE_WELCOME).append("\n");
    	formatted.append(version).append("\n");
    	formatted.append(MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE).append("\n");
    	formatted.append(Formatter.formatStorageFilePath(storageFilePath)).append("\n");
    	formatted.append(DIVIDER);
    	return formatted.toString();
    }
    
    /**
     * format goodbye message, add two dividers after message
     * @param message to be displayed
     * @return the formatted string
     */
    public static String formatGoodbyeMessage() {
    	final StringBuilder formatted = new StringBuilder();
    	formatted.append(MESSAGE_GOODBYE).append("\n");
    	formatted.append(DIVIDER).append("\n");
    	formatted.append(DIVIDER);
    	return formatted.toString();
    }
    
    /**
     * format message for failed initialization, add two dividers after message
     * @param message to be displayed
     * @return the formatted string
     */
    public static String formatInitFailedMessage(String... message) {
    	final StringBuilder formatted = new StringBuilder();
    	formatted.append(MESSAGE_INIT_FAILED);
    	formatted.append(DIVIDER).append("\n");
    	formatted.append(DIVIDER);
    	return formatted.toString();
    }
    
    /**
     * add line prefix to this line and to the next line if any
     * @param string to format
     * @return string of formatted line
     */
    public static String formatLine(String line) {
    	return LINE_PREFIX + line.replace("\n", LS + LINE_PREFIX);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
