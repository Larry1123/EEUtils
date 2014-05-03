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
package net.larry1123.util.logger;

import java.util.LinkedList;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class UtilFilter implements Filter {

    private final LinkedList<LoggerLevel> allowed = new LinkedList<LoggerLevel>();
    private boolean all = false;

    /**
     * Adds a LoggerLevel to be reported to this Log File!
     *
     * @param lvl What Level to add
     */
    public void addLogLevel(LoggerLevel lvl) {
        allowed.add(lvl);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLoggable(LogRecord rec) {

        if (all) {
            return true;
        }

        Level level = rec.getLevel();

        if (level instanceof LoggerLevel) {
            LoggerLevel handle = (LoggerLevel) level;
            if (allowed.contains(handle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Will allow all Levels to be Logged to the log file
     *
     * @param state true to enable logging everything false to disable logging everything
     */
    public void setLogAll(boolean state) {
        all = state;
    }

    /**
     * Disallows a Level from being able to log into the Log File
     *
     * @param lvl Level to stop logging
     */
    public void removeLogLevel(LoggerLevel lvl) {
        allowed.remove(lvl);
    }

}
