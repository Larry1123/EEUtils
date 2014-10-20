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
     *
     * @return String ID of the LoggerLevel
     */
    private static String addLoggerLevel(String levelName, String prefix) {
        String name;
        if (!prefix.equals("")) {
            name = levelName + "-" + prefix;
        }
        else {
            name = levelName;
        }
        LoggerLevels.put(name, new LoggerLevel(levelName, prefix, name));
        return name;
    }

    /**
     * This will add a Logger Level and return the name of the Level with in LoggerLevels
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     * @param logger    Logger to have Level Tied to
     *
     * @return ID of the LoggerLevel
     */
    private static String addLoggerLevel(String levelName, String prefix, EELogger logger) {
        String name;
        if (!prefix.equals("")) {
            name = logger.getName() + ":" + levelName + "-" + prefix;
        }
        else {
            name = logger.getName() + ":" + levelName;
        }
        LoggerLevel lvl = new LoggerLevel(levelName, prefix, name);
        LoggerLevels.put(name, lvl);
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
        String name;
        if (!prefix.equals("")) {
            name = levelName + "-" + prefix;
        }
        else {
            name = levelName;
        }
        if (LoggerLevels.containsKey(name)) {
            return LoggerLevels.get(name);
        }
        else {
            return LoggerLevels.get(addLoggerLevel(levelName, prefix));
        }
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param levelName Name to give the level
     * @param logger    Logger to have Level Tied to
     *
     * @return The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(String levelName, EELogger logger) {
        return getLoggerLevel(levelName, "", logger);
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     * @param logger    Logger to have Level Tied to
     *
     * @return The LoggerLevel that as been Gotten
     */
    public static LoggerLevel getLoggerLevel(String levelName, String prefix, EELogger logger) {
        String name;
        if (!prefix.equals("")) {
            name = logger.getName() + ":" + levelName + "-" + prefix;
        }
        else {
            name = logger.getName() + ":" + levelName;
        }
        if (LoggerLevels.containsKey(name)) {
            return LoggerLevels.get(name);
        }
        else {
            return LoggerLevels.get(addLoggerLevel(levelName, prefix, logger));
        }
    }

    public static LoggerLevel getLoggerLevel(Level level, Marker marker) {
        return getLoggerLevel(level.getName(), marker);
    }

    public static LoggerLevel getLoggerLevel(String level, Marker marker) {
        String name = level + "-" + marker.getName();
        if (LoggerLevels.containsKey(name)) {
            return LoggerLevels.get(name);
        }
        else {
            return LoggerLevels.get(addLoggerLevel(level, marker.getName()));
        }
    }

    /**
     * This will Remove a LoggerLevel from being able to be tracked and returned by this Level Manager
     *
     * @param name ID of the Logger to remove
     */
    public static void removeLoggerLevel(String name) {
        LoggerLevels.remove(name);
    }

    /**
     * This will Remove a LoggerLevel from being able to be tracked and returned by this Level Manager
     *
     * @param lvl Logger to remove
     */
    @Deprecated
    public static void removeLoggerLevel(LoggerLevel lvl) {
        // Point less to remove a LoggerLevel each level has an uid...
    }

}
