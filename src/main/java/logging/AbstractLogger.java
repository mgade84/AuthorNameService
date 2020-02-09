package logging;

import logging.Logger;

/**
 * Abstract implementation of the {@link Logger} interface
 * @author Mikkel Gade
 */
public abstract class AbstractLogger implements Logger {

    /**
     * The severity of this logger
     */
    private Severity severity;

    public AbstractLogger(Severity severity) {
        this.severity = severity;
    }

    @Override
    public void debug(String message) {
        writeLog(Severity.DEBUG, message);
    }
    
    @Override
    public void info(String message) {
        writeLog(Severity.INFO, message);
    }

    @Override
    public void warn(String message) {
        writeLog(Severity.WARNING, message);
    }

    @Override
    public void error(String message) {
        writeLog(Severity.ERROR, message);
    }
    
    @Override
    public Severity getSeverity() {
        return this.severity;
    }
    
    /**
     * Method for writing the log
     * @param severity The severity
     * @param message The message to write
     */
    protected abstract void writeLog(Severity severity, String message);

}
