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

import java.util.logging.Logger;

public interface LoggerSettings {

    /**
     * Gets the current Log Path
     *
     * @return Current Log Path
     */
    public String getLoggerPath();

    /**
     * Sets the Path for loggers
     * Will not change the location of Loggers that are running as it is but will move new ones
     *
     * @param path Local Path to place Log files
     */
    public void setLoggerPath(String path);

    /**
     * Returns if the Logger is allowed to send info to https://paste.larry1123.net/
     *
     * @return true is allowed false not allowed
     */
    public boolean isPastingAllowed();

    /**
     * Sets if the Logger is allowed to send info to https://paste.larry1123.net/
     *
     * @param state True if allowed, false if not
     */
    public void setPastingAllowed(boolean state);

    /**
     * Get the Settings for how to Split Log Files
     *
     * @return Current setting
     */
    public FileSplits getSplit();

    /**
     * Set the Setting for how to split log files.
     */
    public void setFileSplit(FileSplits fileSplit);

    /**
     * Gets the Currently set time stamp for Log files if Splitting is enabled
     * May be null if it has not been used
     *
     * @return Currently used timestamp
     */
    public String getCurrentSplit();

    /**
     * To be used by Logger Only Do not Change
     *
     * @param current Set the current Split files are logging with
     */
    public void setCurrentSplit(String current);

    /**
     * Get what to set the File Type as
     *
     * @return String of the file type to use
     */
    public String getFileType();

    /**
     * Set the type of time to log to
     * ie. "log" for a .log0
     *
     * @param type String to use as the file extension
     */
    public void setFileType(String type);

    /**
     * Get the Parent to set to for all Loggers
     *
     * @return Logger to use to set as Parent
     */
    public Logger getParentLogger();

    /**
     * Set the Parent to set for all Loggers
     *
     * @param logger The Logger to be used
     */
    public void setParentLogger(Logger logger);

}
