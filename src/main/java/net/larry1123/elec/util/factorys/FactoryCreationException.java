package net.larry1123.elec.util.factorys;

/**
 * @author Larry1123
 * @since 4/30/2015 - 12:08 AM
 */
public class FactoryCreationException extends RuntimeException {

    public FactoryCreationException() {
        super();
    }

    public FactoryCreationException(String message) {
        super(message);
    }

    public FactoryCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactoryCreationException(Throwable cause) {
        super(cause);
    }

    protected FactoryCreationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
