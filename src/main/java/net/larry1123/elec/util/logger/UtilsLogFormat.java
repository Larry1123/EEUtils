/*
 * Copyright 2014 ElecEntertainment
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.larry1123.elec.util.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

final class UtilsLogFormat extends SimpleFormatter {

    private final SimpleDateFormat dateform = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private final String linesep = System.getProperty("line.separator");

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
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
            }
            else {
                message.append(msg);
            }
        }
        else {
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
