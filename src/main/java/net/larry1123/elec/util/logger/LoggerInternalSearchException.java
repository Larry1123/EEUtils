package net.larry1123.elec.util.logger;

/**
 * @author Larry1123
 * @since 1.4.0
 */
public class LoggerInternalSearchException extends Exception {

    public LoggerInternalSearchException() {
        super();
    }

    public LoggerInternalSearchException(String message) {
        super(message);
    }

    public LoggerInternalSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggerInternalSearchException(Throwable cause) {
        super(cause);
    }

    protected LoggerInternalSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
