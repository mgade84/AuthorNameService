package logging;

import logging.AbstractLogger;
import logging.Logger.Severity;

/**
 * Logger for writing to System.out
 * @author Mikkel Gade
 */
public class SysoutLogger extends AbstractLogger{

    public SysoutLogger(Severity severity) {
        super(severity);
    }

    @Override
    protected void writeLog(Severity severity, String message) {
        System.out.println(String.format("[%s] %s", severity.name(), message));
    }

}
