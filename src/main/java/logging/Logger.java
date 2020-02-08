package logging;

/**
 * Interface for logging
 * @author Mikkel Gade
 */
public interface Logger {
    
    /**
     * Severity of log messages for use in implementations.
     */
    public enum Severity {DEBUG, INFO, WARNING, ERROR}
    
    /**
     * Log debug message
     * @param message The debug message
     */
    public void debug(String message);
    
    /**
     * Log info message
     * @param message The info message
     */
    public void info(String message);
    
    /**
     * Log warning message
     * @param message The warning message
     */
    public void warn(String message);
    
    /**
     * Log error message
     * @param message The error message
     */
    public void error(String message);
    
    /**
     * Returns the severity of this logger
     * @return The severity of this logger
     */
    public Severity getSeverity();

}
