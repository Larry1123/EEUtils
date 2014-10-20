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

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Larry1123
 * @since 10/19/2014 - 3:36 AM
 */
public class FileLogger extends Logger {

    public FileLogger(String name) {
        super(name, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void log(LogRecord logRecord) {
        Level level = logRecord.getLevel();
        if (!isLoggable(level)) {
            return;
        }
        if (getFilter() != null && !getFilter().isLoggable(logRecord)) {
            return;
        }
        StringBuilder message = new StringBuilder();
        if (level instanceof LoggerLevel) {
            LoggerLevel handle = (LoggerLevel) level;
            if (!handle.getPrefix().isEmpty()) {
                message.append("[").append(handle.getPrefix()).append("] ");
            }
        }
        message.append("[").append(getName()).append("] ").append(logRecord.getMessage());
        logRecord.setMessage(message.toString());
        for (Handler handler : getHandlers()) {
            handler.publish(logRecord);
        }
    }

}
