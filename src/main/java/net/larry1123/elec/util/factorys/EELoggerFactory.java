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
package net.larry1123.elec.util.factorys;

import net.larry1123.elec.util.logger.EELogger;
import net.larry1123.elec.util.logger.LogSettings;
import net.larry1123.elec.util.logger.LoggerSettings;

import java.util.HashMap;

/**
 * @author Larry1123
 * @since 1/30/14 - 7:02 AM
 */
public class EELoggerFactory {

    /**
     * Holds All EELoggers
     */
    private final HashMap<String, EELogger> loggers = new HashMap<String, EELogger>();

    protected LoggerSettings loggerSettings = new LogSettings();

    /**
     * Gets the currently used LoggerSettings.
     *
     * @return The current LoggerSettings
     */
    public LoggerSettings getLoggerSettings() {
        if (loggerSettings == null) { throw new NullPointerException("LoggerSettings is null"); }
        return loggerSettings;
    }

    /**
     * Set the LoggerSettings to use for logging.
     *
     * @param loggerSettings The LoggerSettings to set
     */
    public void setLoggerSettings(LoggerSettings loggerSettings) {
        if (loggerSettings == null) { throw new NullPointerException("LoggerSettings can not be null"); }
        this.loggerSettings = loggerSettings;
    }

    /**
     * Gets the EELogger for the given name
     *
     * @param name Name of the Logger
     *
     * @return the EELogger for the given
     */
    public EELogger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            EELogger logMan = new EELogger(name);
            loggers.put(logMan.getName(), logMan);
        }
        return loggers.get(name);
    }

    /**
     * Gets the EELogger for the given name
     *
     * @param name Name of the Logger
     * @param subName SubName of logger
     *
     * @return the EELogger for the given
     */
    public EELogger getSubLogger(String name, String subName) {
        if (!loggers.containsKey(name + "." + name)) {
            EELogger logMan = new EELogger(name, subName);
            loggers.put(logMan.getName(), logMan);
        }
        return loggers.get(name + "." + name);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param name   Name of the sub-Logger
     * @param parent What EELogger to create a sub-Logger under
     *
     * @return The EELogger for the requested sub-Logger
     */
    public EELogger getSubLogger(String name, EELogger parent) {
        if (!loggers.containsKey(parent.getName() + "." + name)) {
            EELogger logger = new EELogger(name, parent);
            loggers.put(logger.getName(), logger);
        }
        return loggers.get(parent.getName() + "." + name);
    }

    /**
     * Remove a logger from the held logger list.
     *
     * @param logger    What Logger to remove
     */
    public void removeLogger(EELogger logger) {
        if (loggers.containsValue(logger)) {
            for (String key : loggers.keySet()) {
                if (loggers.get(key) == logger) {
                    loggers.remove(key);
                }
            }
        }
    }

}
