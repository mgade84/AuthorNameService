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

    public Author(String firstNames, String lastName) {
        this.firstNames = firstNames;
        this.lastName = lastName;
    }
    
    public String getFirstNames() {
        return firstNames;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        return this.firstNames + NAME_SEPARATOR + this.lastName;
    }
    
    @Override
    public String toString() {
        return getFullName();
    }
}
