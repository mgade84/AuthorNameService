package parsing;

/**
 * A parser interface for parsing String input for object of type T
 * @author Mikkel Gade
 * @param <T> Type of the output object
 */
public interface Parser<T> {
    
    /**
     * Parses String to object of type T
     * @param input The input String
     * @return Resulting object
     */
    public T parse(String input);
}
