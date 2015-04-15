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

import org.slf4j.Marker;

import java.util.HashMap;
import java.util.logging.Level;

public class LoggerLevels {

    private final static HashMap<String, LoggerLevel> LoggerLevels = new HashMap<String, LoggerLevel>();

    /**
     * This will add a Logger Level and return the name of the Level with in LoggerLevels
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     */
    private static void addLoggerLevel(String levelName, String prefix) {
        String name = getName(levelName, prefix);
        LoggerLevels.put(name, new LoggerLevel(levelName, prefix, name));
    }

    private static String getName(String levelName, String prefix) {
        String name;
        if (!prefix.equals("")) {
            name = levelName + "-" + prefix;
        }
        else {
            name = levelName;
        }
        return name;
    }

    /**
     * Returns the Logger Level if there is one by this name or makes one
     *
     * @param name Name of LoggerLevel to get
     *
     * @return LoggerLevel The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(String name) {
        return getLoggerLevel(name, "");
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     *
     * @return The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(String levelName, String prefix) {
        String name = getName(levelName, prefix);
        if (LoggerLevels.containsKey(name)) {
            return LoggerLevels.get(name);
        }
        else {
            addLoggerLevel(levelName, prefix);
            return LoggerLevels.get(name);
        }
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param level  Name to give the level
     * @param marker The Prefix to give Messages with said given LoggerLevel
     *
     * @return The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(Level level, Marker marker) {
        return getLoggerLevel(level.getName(), marker);
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param levelName Name to give the level
     * @param marker    The Prefix to give Messages with said given LoggerLevel
     *
     * @return The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(String levelName, Marker marker) {
        return getLoggerLevel(levelName, marker.getName());
    }

    /**
     * This will Remove a LoggerLevel from being able to be tracked and returned by this Level Manager
     *
     * @param name ID of the Logger to remove
     */
    @Deprecated
    public static void removeLoggerLevel(String name) {
    }

    /**
     * This will Remove a LoggerLevel from being able to be tracked and returned by this Level Manager
     *
     * @param lvl Logger to remove
     */
    @Deprecated
    public static void removeLoggerLevel(LoggerLevel lvl) {
    }

}
