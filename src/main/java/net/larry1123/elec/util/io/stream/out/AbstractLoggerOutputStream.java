package net.larry1123.elec.util.io.stream.out;

import net.larry1123.elec.util.logger.LoggerProxy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * This is made for use with something that will auto flush every line
 *
 * @author Larry1123
 * @since 12/3/2014 - 7:39 PM
 */
public abstract class AbstractLoggerOutputStream extends ByteArrayOutputStream implements LoggerProxy {

    @Override
    public void flush() throws IOException {
        String message = toString().trim();
        if (!message.equals("")) {
            log(message);
        }
        reset();
    }

}
