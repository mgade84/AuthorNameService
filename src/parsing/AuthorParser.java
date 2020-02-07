package parsing;

import java.util.*;

import author.Author;

public class AuthorParser implements Parser<Author> {
    
    /**
     * Delimiter when parsing "{firstname} {lastname}"
     */
    private static final String FORWARD_DELIMITER = " ";
    
    /**
     * Delimiter when parsing "{lastname}, {firstname}"
     */
    private static final String BACKWARD_DELIMITER = ",";
    
    public AuthorParser() {
        
    }

    @Override
    public Author parse(String authorName) {
        List<String> nameList;
        String firstNames;
        String lastName;
        
        if (authorName.contains(BACKWARD_DELIMITER)) {
            String[] backwardNames = authorName.split(BACKWARD_DELIMITER);
            nameList = new ArrayList<String>(Arrays.asList(backwardNames));
            lastName = nameList.remove(0).trim();
        } else {
            String[] forwardNames = authorName.split(FORWARD_DELIMITER);
            nameList = new ArrayList<String>(Arrays.asList(forwardNames));
            lastName = nameList.remove(nameList.size() - 1).trim();
        }
        firstNames = String.join(Author.NAME_SEPARATOR, nameList).trim();
        return new Author(firstNames, lastName);
    }

}
