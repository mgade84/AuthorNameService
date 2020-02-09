package author;

/**
 * Class to hold information about an author
 * @author Mikkel Gade
 */
public class Author {
    
    public static final String NAME_SEPARATOR = " ";

    /**
     * First names of the author
     */
    private String firstNames;
    
    /**
     * Last name of the author
     */
    private String lastName;

    /**
     * Creates a new Author
     * @param firstNames First names of the author (may be mulitple names e.g. "FirstName MiddleName")
     * @param lastName Last name of the author (should be only one name)
     */
    public Author(String firstNames, String lastName) {
        this.firstNames = firstNames;
        this.lastName = lastName;
    }
    
    /**
     * Getter for first names
     * @return First names
     */
    public String getFirstNames() {
        return firstNames;
    }
    
    /**
     * Getter for last name
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns full name of the author
     * @return Full name
     */
    public String getFullName() {
        return this.firstNames + NAME_SEPARATOR + this.lastName;
    }
    
    @Override
    public String toString() {
        return getFullName();
    }
}
