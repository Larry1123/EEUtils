package net.larry1123.util.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

final class UtilsLogFormat extends SimpleFormatter {

    private final SimpleDateFormat dateform = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss");
    private final String linesep = System.getProperty("line.separator");

    /**
     * {@inheritDoc}
     */
    @Override
    public final String format(LogRecord rec) {

        Level level = rec.getLevel();
        String msg = rec.getMessage();

        StringBuilder message = new StringBuilder();
        message.append(dateform.format(rec.getMillis())).append(" ");

        if (level instanceof LoggerLevel) {
            LoggerLevel handle = (LoggerLevel) level;
            if (!handle.getPrefix().equals("")) {
                message.append("[").append(handle.getPrefix()).append("] ").append(msg);
            } else {
                message.append(msg);
            }
        } else {
            message.append("[").append(level.getName()).append("] ").append(rec.getMessage());
        }

        message.append(linesep);
        if (rec.getThrown() != null) {
            StringWriter stringwriter = new StringWriter();
            rec.getThrown().printStackTrace(new PrintWriter(stringwriter));
            message.append(stringwriter.toString());
        }
        return message.toString();
    }
}
