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

import net.larry1123.elec.util.factorys.FactoryManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.logging.Level;

public class EELogger implements Logger {

    public static final LoggerLevel TRACE = LoggerLevels.getLoggerLevel("TRACE");
    public static final LoggerLevel DEBUG = LoggerLevels.getLoggerLevel("DEBUG");
    public static final LoggerLevel ERROR = LoggerLevels.getLoggerLevel("ERROR");

    protected final Logger logger;
    protected final FileLogger fileLogger;
    protected final EELogger parent;

    public EELogger(String name) {
        this((EELogger) null, name);
    }

    @Deprecated
    public EELogger(String name, String subName) {
        this(name  + "." + subName);
    }

    @Deprecated
    public EELogger(String name, String subName, boolean fileLog) {
        this(name + "." + subName);
    }

    @Deprecated
    public EELogger(String name, boolean fileLog) {
        this((EELogger) null, name);
    }

    @Deprecated
    public EELogger(EELogger parent, String name, boolean fileLog) {
        this(parent, name);
    }

    public EELogger(EELogger parent, String name) {
        this.parent = parent;
        logger = LoggerFactory.getLogger((hasParent() ? getParent().getName() + "." : "") + name);
        fileLogger = new FileLogger(getName());
        if (hasParent()) {
            getFileLogger().setParent(getParent().getFileLogger());
        }
    }

    public static LoggerLevel getTrace() {
        return TRACE;
    }

    public static LoggerLevel getDebug() {
        return DEBUG;
    }

    public static LoggerLevel getError() {
        return ERROR;
    }

    @Override
    public String getName() {
        return getLogger().getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return getLogger().isTraceEnabled();
    }

    @Override
    public void trace(String s) {
        getLogger().trace(s);
        if (isTraceEnabled()) {
            getFileLogger().log(getTrace(), s);
        }
    }

    @Override
    public void trace(String s, Object o) {
        getLogger().trace(s, o);
        if (isTraceEnabled()) {
            getFileLogger().log(getTrace(), format(s, o));
        }
    }

    @Override
    public void trace(String s, Object o, Object o2) {
        getLogger().trace(s, o, o2);
        if (isTraceEnabled()) {
            getFileLogger().log(getTrace(), format(s, o, o2));
        }
    }

    @Override
    public void trace(String s, Object... objects) {
        getLogger().trace(s, objects);
        if (isTraceEnabled()) {
            getFileLogger().log(getTrace(), format(s, objects));
        }
    }

    @Override
    public void trace(String s, Throwable throwable) {
        getLogger().trace(s, throwable);
        if (isTraceEnabled()) {
            getFileLogger().log(getTrace(), s, throwable);
        }
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return getLogger().isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String s) {
        getLogger().trace(marker, s);
        if (isTraceEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getTrace(), marker), s);
        }
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        getLogger().trace(marker, s, o);
        if (isTraceEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getTrace(), marker), format(s, o));
        }
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o2) {
        getLogger().trace(marker, s, o, o2);
        if (isTraceEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getTrace(), marker), format(s, o, o2));
        }
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        getLogger().trace(marker, s, objects);
        if (isTraceEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getTrace(), marker), format(s, objects));
        }
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        getLogger().trace(marker, s, throwable);
        if (isTraceEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getTrace(), marker), s, throwable);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return getLogger().isDebugEnabled();
    }

    @Override
    public void debug(String s) {
        getLogger().debug(s);
        if (isDebugEnabled()) {
            getFileLogger().log(getDebug(), s);
        }
    }

    @Override
    public void debug(String s, Object o) {
        getLogger().debug(s, o);
        if (isDebugEnabled()) {
            getFileLogger().log(getDebug(), format(s, o));
        }
    }

    @Override
    public void debug(String s, Object o, Object o2) {
        getLogger().trace(s, o, o2);
        if (isDebugEnabled()) {
            getFileLogger().log(getDebug(), format(s, o, o2));
        }
    }

    @Override
    public void debug(String s, Object... objects) {
        getLogger().debug(s, objects);
        if (isDebugEnabled()) {
            getFileLogger().log(getDebug(), format(s, objects));
        }
    }

    @Override
    public void debug(String s, Throwable throwable) {
        getLogger().trace(s, throwable);
        if (isDebugEnabled()) {
            getFileLogger().log(getDebug(), s, throwable);
        }
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return getLogger().isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {
        getLogger().debug(marker, s);
        if (isDebugEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getDebug(), marker), s);
        }
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        getLogger().debug(marker, s, o);
        if (isDebugEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getDebug(), marker), format(s, o));
        }
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o2) {
        getLogger().debug(marker, s, o, o2);
        if (isDebugEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getDebug(), marker), format(s, o, o2));
        }
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        getLogger().debug(marker, s, objects);
        if (isDebugEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getDebug(), marker), format(s, objects));
        }
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        getLogger().debug(marker, s, throwable);
        if (isDebugEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getDebug(), marker), s, throwable);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return getLogger().isInfoEnabled();
    }

    @Override
    public void info(String s) {
        getLogger().info(s);
        if (isInfoEnabled()) {
            getFileLogger().info(s);
        }
    }

    @Override
    public void info(String s, Object o) {
        getLogger().info(s, o);
        if (isInfoEnabled()) {
            getFileLogger().info(format(s, o));
        }
    }

    @Override
    public void info(String s, Object o, Object o2) {
        getLogger().info(s, o, o2);
        if (isInfoEnabled()) {
            getFileLogger().info(format(s, o, o2));
        }
    }

    @Override
    public void info(String s, Object... objects) {
        getLogger().info(s, objects);
        if (isInfoEnabled()) {
            getFileLogger().info(format(s, objects));
        }
    }

    @Override
    public void info(String s, Throwable throwable) {
        getLogger().info(s, throwable);
        if (isInfoEnabled()) {
            getFileLogger().log(Level.INFO, s, throwable);
        }
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return getLogger().isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {
        getLogger().info(marker, s);
        if (isInfoEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.INFO, marker), s);
        }
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        getLogger().info(marker, s, o);
        if (isInfoEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.INFO, marker), format(s, o));
        }
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o2) {
        getLogger().info(marker, s, o, o2);
        if (isInfoEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.INFO, marker), format(s, o, o2));
        }
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        getLogger().info(marker, s, objects);
        if (isInfoEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.INFO, marker), format(s, objects));
        }
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        getLogger().info(marker, s, throwable);
        if (isInfoEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.INFO, marker), s, throwable);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return getLogger().isWarnEnabled();
    }

    @Override
    public void warn(String s) {
        getLogger().warn(s);
        if (isWarnEnabled()) {
            getFileLogger().log(Level.WARNING, s);
        }
    }

    @Override
    public void warn(String s, Object o) {
        getLogger().warn(s, o);
        if (isWarnEnabled()) {
            getFileLogger().log(Level.WARNING, format(s, o));
        }
    }

    @Override
    public void warn(String s, Object... objects) {
        getLogger().warn(s, objects);
        if (isWarnEnabled()) {
            getFileLogger().log(Level.WARNING, format(s, objects));
        }
    }

    @Override
    public void warn(String s, Object o, Object o2) {
        getLogger().warn(s, o, o2);
        if (isWarnEnabled()) {
            getFileLogger().log(Level.WARNING, format(s, o, o2));
        }
    }

    @Override
    public void warn(String s, Throwable throwable) {
        getLogger().warn(s, throwable);
        if (isWarnEnabled()) {
            getFileLogger().log(Level.WARNING, s, throwable);
        }
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return getLogger().isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {
        getLogger().warn(marker, s);
        if (isWarnEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.WARNING, marker), s);
        }
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        getLogger().warn(marker, s, o);
        if (isWarnEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.WARNING, marker), format(s, o));
        }
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o2) {
        getLogger().warn(marker, s, o, o2);
        if (isWarnEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.WARNING, marker), format(s, o, o2));
        }
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        getLogger().warn(marker, s, objects);
        if (isWarnEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.WARNING, marker), format(s, objects));
        }
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        getLogger().warn(marker, s, throwable);
        if (isWarnEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(Level.WARNING, marker), s, throwable);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return getLogger().isErrorEnabled();
    }

    @Override
    public void error(String s) {
        getLogger().error(s);
        if (isErrorEnabled()) {
            getFileLogger().log(getError(), s);
        }
    }

    @Override
    public void error(String s, Object o) {
        getLogger().error(s, o);
        if (isErrorEnabled()) {
            getFileLogger().log(getError(), format(s, o));
        }
    }

    @Override
    public void error(String s, Object o, Object o2) {
        getLogger().error(s, o, o2);
        if (isErrorEnabled()) {
            getFileLogger().log(getError(), format(s, o, o2));
        }
    }

    @Override
    public void error(String s, Object... objects) {
        getLogger().error(s, objects);
        if (isErrorEnabled()) {
            getFileLogger().log(getError(), format(s, objects));
        }
    }

    @Override
    public void error(String s, Throwable throwable) {
        getLogger().error(s, throwable);
        if (isErrorEnabled()) {
            getFileLogger().log(getError(), s, throwable);
        }
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return getLogger().isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {
        getLogger().error(marker, s);
        if (isErrorEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getError(), marker), s);
        }
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        getLogger().error(marker, s, o);
        if (isErrorEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getError(), marker), format(s, o));
        }
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o2) {
        getLogger().error(marker, s, o, o2);
        if (isErrorEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getError(), marker), format(s, o, o2));
        }
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        getLogger().error(marker, s, objects);
        if (isErrorEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getError(), marker), format(s, objects));
        }
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        getLogger().error(marker, s, throwable);
        if (isErrorEnabled(marker)) {
            getFileLogger().log(getLoggerLevel(getError(), marker), s, throwable);
        }
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean traceToPasteBin(String s, Throwable throwable) {
        trace(s, throwable);
        return isTraceEnabled() && logStackTraceToPasteBin(getTrace(), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param marker    the marker data specific to this log statement
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean traceToPasteBin(Marker marker, String s, Throwable throwable) {
        trace(marker, s, throwable);
        return isTraceEnabled(marker) && logStackTraceToPasteBin(getLoggerLevel(getTrace(), marker), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean debugToPasteBin(String s, Throwable throwable) {
        trace(s, throwable);
        return isDebugEnabled() && logStackTraceToPasteBin(getDebug(), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param marker    the marker data specific to this log statement
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean debugToPasteBin(Marker marker, String s, Throwable throwable) {
        debug(marker, s, throwable);
        return isDebugEnabled(marker) && logStackTraceToPasteBin(getLoggerLevel(getDebug(), marker), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean infoToPasteBin(String s, Throwable throwable) {
        info(s, throwable);
        return isInfoEnabled() && logStackTraceToPasteBin(Level.INFO, s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param marker    the marker data specific to this log statement
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean infoToPasteBin(Marker marker, String s, Throwable throwable) {
        info(marker, s, throwable);
        return isInfoEnabled(marker) && logStackTraceToPasteBin(getLoggerLevel(Level.INFO, marker), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean warnToPasteBin(String s, Throwable throwable) {
        warn(s, throwable);
        return isWarnEnabled() && logStackTraceToPasteBin(Level.WARNING, s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param marker    the marker data specific to this log statement
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean warnToPasteBin(Marker marker, String s, Throwable throwable) {
        warn(marker, s, throwable);
        return isWarnEnabled(marker) && logStackTraceToPasteBin(getLoggerLevel(Level.WARNING, marker), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean errorToPasteBin(String s, Throwable throwable) {
        error(s, throwable);
        return isTraceEnabled() && logStackTraceToPasteBin(getError(), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     *
     * @param marker    the marker data specific to this log statement
     * @param s         the message accompanying the exception
     * @param throwable the exception (throwable) to log
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean errorToPasteBin(Marker marker, String s, Throwable throwable) {
        error(marker, s, throwable);
        return isErrorEnabled(marker) && logStackTraceToPasteBin(getLoggerLevel("ERROR", marker), s, throwable);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     * Throws with the LoggerLevel Given
     *
     * @param lvl     Object of the LoggerLevel to throw with
     * @param message Message to be Logged
     * @param thrown  Throwable Error To be logged
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean logStackTraceToPasteBin(LoggerLevel lvl, String message, Throwable thrown) {
        if (!lvl.getPrefix().isEmpty()) {
            message = "[" + lvl.getPrefix() + "] " + message;
        }
        return logStackTraceToPasteBin((Level) lvl, message, thrown);
    }

    /**
     * Will log a StackTrace and Post it on to https://paste.larry1123.net/
     * Will return true if it was able to post and false if it was not able to post
     * Throws with the Level given
     *
     * @param lvl     The Level to be thrown with
     * @param message Message to be Logged
     * @param thrown  Throwable Error To be logged
     *
     * @return {@code true} if paste was made of stackTrace; {@code false} if it failed for any reason
     */
    public boolean logStackTraceToPasteBin(Level lvl, String message, Throwable thrown) {
        if (getConfig().isPastingAllowed()) {
            EELogger eeLogger = FactoryManager.getFactoryManager().getEELoggerFactory().getSubLogger("EEUtil", "PasteBinLog");
            try {
                URL url = new URL("https://paste.larry1123.net/api/xml/create");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                String urlParameters = "data=" + "[" + lvl.getName() + "] " + message + "\n" + ExceptionUtils.getStackTrace(thrown);
                urlParameters += "&";
                String title = "[" + lvl.getName() + "] " + message;
                urlParameters += "title=" + (title.length() > 30 ? title.substring(0, 30) : title);
                urlParameters += "&";
                urlParameters += "language=Java";

                // Send post request
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(urlParameters);
                wr.flush();
                wr.close();

                if (con.getResponseCode() == 200) {
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document document = dBuilder.parse(con.getInputStream());
                    document.getDocumentElement().normalize();

                    NodeList nodeList = document.getElementsByTagName("id");
                    Node node = nodeList.item(0);
                    String id = node.getTextContent();
                    eeLogger.info("Logger " + getName() + ": https://paste.larry1123.net/" + id);
                    return true;
                }
                return false;
            }
            catch (MalformedURLException e) {
                eeLogger.error("Failed to send: Malformed", e);
                return false;
            }
            catch (IOException e) {
                eeLogger.error("Failed to send: IOException", e);
                return false;
            }
            catch (ParserConfigurationException e) {
                eeLogger.error("Failed to send: ParserConfigurationException", e);
                return false;
            }
            catch (SAXException e) {
                eeLogger.error("Failed to send: SAXException", e);
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * This is an internal convince method
     * EELogger's do not know what factory made them if any did.
     * This method calls {@link FactoryManager} to get the {@link LoggerSettings}
     * If the Logger is not tracked by a factory then this may not return the desired {@link LoggerSettings}
     */
    protected LoggerSettings getConfig() {
        return FactoryManager.getFactoryManager().getEELoggerFactoryForLogger(this).getLoggerSettings();
    }

    protected LoggerLevel getLoggerLevel(Level level, Marker marker) {
        return LoggerLevels.getLoggerLevel(level, marker);
    }

    protected LoggerLevel getLoggerLevel(String level, Marker marker) {
        return LoggerLevels.getLoggerLevel(level, marker);
    }

    protected String format(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }

    /**
     * This is the path for the log files of this logger
     *
     * @deprecated The logger no longer knows where the file is. Will try to find out may take some time use other methods please.
     */
    @Deprecated
    public String getPath() {
        try {
            LoggerDirectoryHandler loggerDirectoryHandler = FactoryManager.getFactoryManager().getEELoggerFactoryForLogger(this).getFileManager().getLoggerDirectoryHandlerForLogger(this);
            return loggerDirectoryHandler.getDirectoryPath().toString();
        }
        catch (LoggerInternalSearchException e) {
            return "";
        }
    }

    /**
     * @deprecated The logger no longer knows where the file is. Will try to find out may take some time use other methods please.
     */
    @Deprecated
    public String getLogFile() {
        try {
            LoggerDirectoryHandler loggerDirectoryHandler = FactoryManager.getFactoryManager().getEELoggerFactoryForLogger(this).getFileManager().getLoggerDirectoryHandlerForLogger(this);
            return loggerDirectoryHandler.getCurrentPathForLogger(this).toString();
        }
        catch (LoggerInternalSearchException e) {
            return "";
        }
    }

    /**
     * Gets the underlying slf4j Logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Gets the underlying jdk Logger that handles logging to files
     */
    public FileLogger getFileLogger() {
        return fileLogger;
    }

    /**
     * Get the parent logger of this Logger
     *
     * @return {@link EELogger} if this EELogger has a parent logger; {@code null} otherwise
     */
    public EELogger getParent() {
        return parent;
    }

    /**
     * Checks if this EELogger has a parent
     *
     * @return {@code true} if this EELogger has a parent; {@code false} otherwise
     */
    public boolean hasParent() {
        return getParent() != null;
    }

}
