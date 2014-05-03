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

import java.util.HashMap;

@SuppressWarnings("WeakerAccess")
public class LoggerLevels {

    private final static HashMap<String, LoggerLevel> LoggerLevels = new HashMap<String, LoggerLevel>();

    /**
     * This will add a Logger Level and return the name of the Level with in LoggerLevels
     *
     * @param levelName Name to give the level
     *
     * @return String ID of the LoggerLevel
     */
    private static String addLoggerLevel(String levelName) {
        return addLoggerLevel(levelName, "");
    }

    /**
     * This will add a Logger Level and return the name of the Level with in LoggerLevels
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     *
     * @return String ID of the LoggerLevel
     */
    private static String addLoggerLevel(String levelName, String prefix) {
        String name = levelName + "-" + prefix;
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
        if (LoggerLevels.containsKey(name)) {
            return LoggerLevels.get(name);
        }
        else {
            return LoggerLevels.get(addLoggerLevel(name));
        }
    }

    /**
     * Makes or returns a LoggerLevel
     *
     * @param levelName Name to give the level
     * @param prefix    The Prefix to give Messages with said given LoggerLevel
     *
     * @return The LoggerLevel that as been Gotten
     */
    @SuppressWarnings("UnusedDeclaration")
    public static LoggerLevel getLoggerLevel(String levelName, String prefix) {
        String name = levelName + "-" + prefix;
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
    public static void removeLoggerLevel(LoggerLevel lvl) {
        removeLoggerLevel(lvl.getID());
    }

}
