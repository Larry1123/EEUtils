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
import net.larry1123.elec.util.logger.FileManager;
import net.larry1123.elec.util.logger.LogSettings;
import net.larry1123.elec.util.logger.LoggerSettings;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Larry1123
 * @since 1/30/14 - 7:02 AM
 */
public class EELoggerFactory extends Factory {

    public static class EELoggerFactorySetup extends FactorySetup<EELoggerFactory> {

        private LoggerSettings loggerSettings = null;

        public EELoggerFactorySetup() {
        }

        public EELoggerFactorySetup(LoggerSettings loggerSettings) {
            setLoggerSettings(loggerSettings);
        }

        public LoggerSettings getLoggerSettings() {
            return loggerSettings;
        }

        public void setLoggerSettings(LoggerSettings loggerSettings) {
            this.loggerSettings = loggerSettings;
        }

        @Override
        public void configFactory(EELoggerFactory factory) {
            if (getLoggerSettings() != null) {
                factory.setLoggerSettings(loggerSettings);
            }
        }

    }

    private final HashMap<String, EELogger> loggers = new HashMap<String, EELogger>();

    private LoggerSettings loggerSettings = new LogSettings();
    private final FileManager fileManager = new FileManager(this);

    @Deprecated
    public EELoggerFactory() {
        this("EELoggerFactory" + System.nanoTime());
    }

    public EELoggerFactory(String name) {
        super(name);
    }

    /**
     * Gets the currently used LoggerSettings.
     *
     * @return The current LoggerSettings
     */
    public LoggerSettings getLoggerSettings() {
        if (loggerSettings == null) {
            throw new NullPointerException("LoggerSettings is null");
        }
        return loggerSettings;
    }

    /**
     * Set the LoggerSettings to use for logging.
     *
     * @param loggerSettings The LoggerSettings to set
     */
    public void setLoggerSettings(LoggerSettings loggerSettings) {
        if (loggerSettings == null) {
            throw new NullPointerException("LoggerSettings can not be null");
        }
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
        return getLogger(null, name, fileLog);
    }

    /**
     * Gets the EELogger for the given name
     *
     * @param name Name of the Logger
     * @param subName SubName of logger
     *
     * @return the EELogger for the given
     */
    public EELogger getLogger(String name, String subName) {
        return getLogger(getLogger(name), subName);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name Name of the sub-Logger
     *
     * @return The EELogger for the requested sub-Logger
     */
    public EELogger getLogger(EELogger parent, String name) {
        return getLogger(parent, name, true);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name Name of the sub-Logger
     * @param fileLog {@code true} to log to file; {@code false} to not log to file
     *
     * @return The EELogger for the requested sub-Logger
     */
    public EELogger getLogger(EELogger parent, String name, boolean fileLog) {
        EELogger logger;
        if (!containsLogger(getName(parent, name))) {
            logger = new EELogger(parent, name);
            getLoggers().put(logger.getName(), logger);
        }
        else {
            logger = getLoggers().get(getName(parent, name));
        }
        setupFileLogging(fileLog, logger);
        return logger;
    }

    /**
     * Gets the EELogger for the given name
     *
     * @param name Name of the Logger
     * @param subName SubName of logger
     *
     * @return the EELogger for the given
     *
     * @deprecated {@link EELoggerFactory#getLogger(String, String)}
     */
    @Deprecated
    public EELogger getSubLogger(String name, String subName) {
        return getLogger(name, subName);
    }

    /**
     * @param name Name of the sub-Logger
     * @param parent What EELogger to create a sub-Logger under
     *
     * @return The EELogger for the requested sub-Logger
     *
     * @deprecated {@link EELoggerFactory#getSubLogger(EELogger, String)}
     * <p/>
     * Gets the EELogger for the given name as a sub of the given parent
     */
    @Deprecated
    public EELogger getSubLogger(String name, EELogger parent) {
        return getSubLogger(parent, name);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name Name of the sub-Logger
     *
     * @return The EELogger for the requested sub-Logger
     *
     * @deprecated {@link EELoggerFactory#getLogger(EELogger, String)}
     */
    @Deprecated
    public EELogger getSubLogger(EELogger parent, String name) {
        return getLogger(parent, name);
    }

    /**
     * Gets the EELogger for the given name as a sub of the given parent
     *
     * @param parent What EELogger to create a sub-Logger under
     * @param name Name of the sub-Logger
     * @param fileLog {@code true} to log to file; {@code false} to not log to file
     *
     * @return The EELogger for the requested sub-Logger
     *
     * @deprecated {@link EELoggerFactory#getLogger(EELogger, String, boolean)}
     */
    @Deprecated
    public EELogger getSubLogger(EELogger parent, String name, boolean fileLog) {
        return getLogger(parent, name, fileLog);
    }

    public synchronized void updateFileHandlers() throws IOException {
        getFileManager().updateFileHandlers();
    }

    protected void setupFileLogging(boolean fileLog, EELogger logger) {
        getFileManager().trackLogger(logger);
        if (fileLog) {
            try {
                getFileManager().fileLog(logger);
            }
            catch (IOException e) {
                logger.error("Unable to setup file logging!", e);
            }
        }
    }

    public String getName(EELogger parent, String sub) {
        if (parent == null) {
            return getName((String) null, sub);
        }
        else {
            return getName(parent.getName(), sub);
        }
    }

    public String getName(String parent, String sub) {
        if (parent == null) {
            return sub;
        }
        else {
            return parent + "." + sub;
        }
    }

    public boolean containsLogger(EELogger logger) {
        return getLoggers().containsValue(logger);
    }

    public boolean containsLogger(String name) {
        return getLoggers().containsKey(name);
    }

    /**
     * Remove a logger from the held logger list.
     *
     * @param logger What Logger to remove
     */
    public void removeLogger(EELogger logger) {
        if (getLoggers().containsValue(logger)) {
            // Make sure that this logger was made by this factory
            if (getLogger(logger.getName()) == logger) {
                getLoggers().remove(logger.getName());
                if (getFileManager().doesLoggerFileLog(logger)) {
                    getFileManager().stopFileLog(logger);
                }
            }
        }
    }

    /**
     * Holds All EELoggers
     */
    protected HashMap<String, EELogger> getLoggers() {
        return loggers;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

}
