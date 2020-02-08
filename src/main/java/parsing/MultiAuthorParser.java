package parsing;

import java.util.ArrayList;
import java.util.List;

import author.Author;
import logging.Logger;

public class MultiAuthorParser implements Parser<List<Author>> {
    
    /**
     * Delimiter when parsing multiple authors"
     */
    private static final String AUTHOR_DELIMITER = ";";
    
    private Logger log;
    
    public MultiAuthorParser(Logger log) {
        this.log = log;
    }

    @Override
    public List<Author> parse(String input) {
        Parser<Author> singleAuthorParser = new AuthorParser(log);
        
        String[] authorArr = input.split(AUTHOR_DELIMITER);
        
        List<Author> authorList = new ArrayList<Author>();
        
        for (String authorName : authorArr) {
            authorList.add(singleAuthorParser.parse(authorName));
        }
        
        return authorList;
    }

}
