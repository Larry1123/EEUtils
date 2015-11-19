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

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * @author Larry1123
 * @since 11/11/2014 - 4:02 AM
 */
public class LoggerDirectoryHandler {

    public class LoggerStuff {

        private final EELogger logger;
        private Path path;
        private UtilFileHandler utilFileHandler;
        private boolean setToRemove = false;

        public LoggerStuff(EELogger logger) throws IOException {
            this.logger = logger;
            path = makePathForLogger();
            utilFileHandler = new UtilFileHandler(makeFileOutputStream());
            getLogger().getFileLogger().addHandler(getUtilFileHandler());
        }

        public EELogger getLogger() {
            return logger;
        }

        public Path getPath() {
            updatePath();
            return _getPath();
        }

        public File getFile() {
            return getPath().toFile();
        }

        public void updateUtilFileHandlerOutputStream() throws IOException {
            getUtilFileHandler().setOutputStream(makeFileOutputStream());
        }

        public void closeUtilFileHandler() {
            getUtilFileHandler().close();
        }

        protected UtilFileHandler getUtilFileHandler() {
            return utilFileHandler;
        }

        protected void updatePath() {
            if (!isPathCurrent()) {
                path = makePathForLogger();
            }
        }

        protected OutputStream makeFileOutputStream() throws IOException {
            FileOutputStream fileOutputStream = FileUtils.openOutputStream(getFile());
            return new BufferedOutputStream(fileOutputStream);
        }

        /**
         * Checks if the path is not null and is in the right directory
         *
         * @return {@code true} if path is right; {@code false} if path is not current
         */
        protected boolean isPathCurrent() {
            return _getPath().startsWith(getMainLoggerPath().resolve(getMainLogger().getName()));
        }

        /**
         * Make a path object for the given logger
         *
         * @return The Path for the logger
         */
        protected Path makePathForLogger() {
            return getDirectoryPath().resolve(getLogger().getName() + "." + getConfig().getFileType());
        }

        public void setToRemove(boolean bool) {
            setToRemove = bool;
        }

        public boolean isSetToRemove() {
            return setToRemove;
        }

        public Path getCurrentPath() {
            return _getPath();
        }

        private Path _getPath() {
            return path;
        }

    }

    private final FileManager fileManager;

    private final Logger mainLogger;
    private final HashMap<Logger, LoggerStuff> loggerLoggerStuffHashMap = new HashMap<Logger, LoggerStuff>();

    public LoggerDirectoryHandler(FileManager fileManager, Logger logger) {
        this.fileManager = fileManager;
        mainLogger = logger;
    }

    /**
     * This will set up a Logger to have a StreamHandler to a file
     *
     * @param logger EELogger to have a Handler added for
     *
     * @throws IOException
     */
    public void setupLogger(EELogger logger) throws IOException {
        if (!isLoggerSetup(logger)) {
            getLoggerLoggerStuffHashMap().put(logger, new LoggerStuff(logger));
        }
        else if (getLoggerStuffForLogger(logger).isSetToRemove()) {
            getLoggerStuffForLogger(logger).setToRemove(false);
        }
    }

    public boolean isLoggerSetup(Logger logger) {
        return getLoggerLoggerStuffHashMap().containsKey(logger);
    }

    /**
     * The Path of the directory that this Object handles
     *
     * @return The path to the directory
     */
    protected Path getDirectoryPath() {
        return getMainLoggerPath().resolve(getMainLogger().getName());
    }

    /**
     * Gets the main directory for logs to be logged too.
     *
     * @return the Path for the main logging location
     */
    protected Path getMainLoggerPath() {
        return Paths.get(getConfig().getLoggerPath());
    }

    /**
     * Will Try to zip up this directory's log files
     *
     * @throws IOException
     */
    public void zipLogs() throws IOException {
        File zipFile = getDirectoryPath().resolve(getDateFormatFromMilli(System.currentTimeMillis()) + ".zip").toFile();
        ZipArchiveOutputStream archiveOutputStream = new ZipArchiveOutputStream(zipFile);

        for (LoggerStuff loggerStuff : getLoggerLoggerStuffHashMap().values()) {
            loggerStuff.closeUtilFileHandler();
            packFile(loggerStuff.getFile(), archiveOutputStream);
            if (loggerStuff.isSetToRemove()) {
                // Make sure that the file gets zipped up anyway.
                getLoggerLoggerStuffHashMap().remove(loggerStuff.getLogger());
            }
            else {
                loggerStuff.updateUtilFileHandlerOutputStream();
            }
        }
        archiveOutputStream.finish();
        archiveOutputStream.close();
    }

    protected void packFile(File file, ZipArchiveOutputStream zipArchiveOutputStream) throws IOException {
        String relative = getDirectoryPath().relativize(file.toPath()).toString();
        // Make an Entry in the archive
        ArchiveEntry archiveEntry = zipArchiveOutputStream.createArchiveEntry(file, relative);
        FileInputStream fileInputStream = FileUtils.openInputStream(file);
        zipArchiveOutputStream.putArchiveEntry(archiveEntry);
        // Copy file content into archive
        IOUtils.copy(fileInputStream, zipArchiveOutputStream);
        zipArchiveOutputStream.closeArchiveEntry();
    }

    protected LoggerSettings getConfig() {
        return getFileManager().getConfig();
    }

    /**
     * Makes a formatted String
     *
     * @param milli What milli time to use
     *
     * @return The formatted String
     */
    public String getDateFormatFromMilli(long milli) {
        return DateFormatUtils.ISO_DATETIME_FORMAT.format(milli).replace(":", File.pathSeparator);
    }

    public void removeLogger(Logger logger) {
        if (isLoggerSetup(logger)) {
            LoggerStuff loggerStuff = getLoggerStuffForLogger(logger);
            loggerStuff.closeUtilFileHandler();
            loggerStuff.setToRemove(true);
        }
    }

    public Path getCurrentPathForLogger(Logger logger) throws LoggerInternalSearchException {
        if (isLoggerSetup(logger)) {
            return getLoggerStuffForLogger(logger).getCurrentPath();
        }
        throw new LoggerInternalSearchException("Logger " + (logger != null ? logger.getName() : null) + " was not found in this LoggerDirectoryHandler!");
    }

    protected LoggerStuff getLoggerStuffForLogger(Logger logger) {
        return getLoggerLoggerStuffHashMap().get(logger);
    }

    protected FileManager getFileManager() {
        return fileManager;
    }

    protected Logger getMainLogger() {
        return mainLogger;
    }

    protected HashMap<Logger, LoggerStuff> getLoggerLoggerStuffHashMap() {
        return loggerLoggerStuffHashMap;
    }

}
