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
        return getLogger(name, true);
    }

    /**
     * Gets the EELogger for the given name
     *
     * @param name Name of the Logger
     * @param fileLog {@code true} to log to file; {@code false} to not log to file
     *
     * @return the EELogger for the given
     */
    public EELogger getLogger(String name, boolean fileLog) {
        EELogger logger;
        if (!loggers.containsKey(name)) {
            logger = new EELogger(name, fileLog);
            loggers.put(logger.getName(), logger);
        }
        else {
            logger = loggers.get(name);
        }
        setupFileLogging(fileLog, logger);
        return logger;
    }

    /**
     * @deprecated {@link EELoggerFactory#getSubLogger(EELogger, String)}
     *
     * Gets the EELogger for the given name
     *
     * @param name    Name of the Logger
     * @param subName SubName of logger
     *
     * @return the EELogger for the given
     */
    @Deprecated
    public EELogger getSubLogger(String name, String subName) {
        if (!loggers.containsKey(getName(name, subName))) {
            EELogger logMan = new EELogger(name, subName);
            loggers.put(logMan.getName(), logMan);
        }
        return loggers.get(getName(name, subName));
    }

    /**
     * @deprecated {@link EELoggerFactory#getSubLogger(EELogger, String)}
     *
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param name   Name of the sub-Logger
     * @param parent What EELogger to create a sub-Logger under
     *
     * @return The EELogger for the requested sub-Logger
     */
    @Deprecated
    public EELogger getSubLogger(String name, EELogger parent) {
        return getSubLogger(parent, name);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name   Name of the sub-Logger
     *
     * @return The EELogger for the requested sub-Logger
     */
    public EELogger getSubLogger(EELogger parent, String name) {
        return getSubLogger(parent, name, true);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name   Name of the sub-Logger
     * @param fileLog {@code true} to log to file; {@code false} to not log to file
     *
     * @return The EELogger for the requested sub-Logger
     */
    public EELogger getSubLogger(EELogger parent, String name, boolean fileLog) {
        EELogger logger;
        if (!loggers.containsKey(getName(parent, name))) {
            logger = new EELogger(parent, name, fileLog);
            loggers.put(logger.getName(), logger);
        }
        else {
            logger = loggers.get(getName(parent, name));
        }
        setupFileLogging(fileLog, logger);
        return logger;
    }

    protected void setupFileLogging(boolean fileLog, EELogger logger) {
        if (fileLog && !logger.canFileLog()) {
            logger.turnOnFileLog();
        }
    }

    protected String getName(EELogger parent, String sub) {
        return getName(parent.getName(), sub);
    }

    protected String getName(String parent, String sub) {
        return parent + "." + sub;
    }

    /**
     * Remove a logger from the held logger list.
     *
     * @param logger What Logger to remove
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
