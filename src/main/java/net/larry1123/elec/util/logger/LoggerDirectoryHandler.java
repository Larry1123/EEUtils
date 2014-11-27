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
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.StreamHandler;

/**
 * @author Larry1123
 * @since 11/11/2014 - 4:02 AM
 */
public class LoggerDirectoryHandler {

    protected final Logger mainLogger;
    protected final HashMap<Logger, OutputStream> loggerOutputStreamHashMap = new HashMap<Logger, OutputStream>();
    protected final HashMap<Logger, Path> loggerPathHashMap = new HashMap<Logger, Path>();
    protected final HashMap<Logger, UtilFileHandler> streamHandlerHashMap = new HashMap<Logger, UtilFileHandler>();

    public LoggerDirectoryHandler(Logger logger) {
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
        logger.getFileLogger().addHandler(getFileStreamHandlerForLogger(logger));
    }

    public StreamHandler getFileStreamHandlerForLogger(Logger logger) throws IOException {
        if (!streamHandlerHashMap.containsKey(logger)) {
            UtilFileHandler streamHandler = new UtilFileHandler(getOutputSteamForLogger(logger));
            streamHandlerHashMap.put(logger, streamHandler);
        }
        return streamHandlerHashMap.get(logger);
    }

    public OutputStream getOutputSteamForLogger(Logger logger) throws IOException {
        if (!loggerOutputStreamHashMap.containsKey(logger)) {
            loggerOutputStreamHashMap.put(logger, makeFileOutputStreamForLogger(logger));
        }
        return loggerOutputStreamHashMap.get(logger);
    }

    protected OutputStream makeFileOutputStreamForLogger(Logger logger) throws IOException {
        File file = getFileForLogger(logger);
        FileOutputStream fileOutputStream = FileUtils.openOutputStream(file);
        return new BufferedOutputStream(fileOutputStream);
    }

    public File getFileForLogger(Logger logger) {
        return getPathForLogger(logger).toFile();
    }

    public Path getPathForLogger(Logger logger) {
        updatePathForLogger(logger);
        return loggerPathHashMap.get(logger);
    }

    public void updatePathForLogger(Logger logger) {
        if (!isPathCurrent(loggerPathHashMap.get(logger))) {
            loggerPathHashMap.put(logger, makePathForLogger(logger));
        }
    }

    /**
     * Checks if the path is not null and is in the right directory
     *
     * @param path What path to check
     *
     * @return {@code true} if path is right; {@code false} if path is not current
     */
    public boolean isPathCurrent(Path path) {
        return path != null && path.startsWith(getMainLoggerPath().resolve(mainLogger.getName()));
    }

    /**
     * Make a path object for the given logger
     *
     * @param logger The logger to get a path for
     *
     * @return The Path for the logger
     */
    public Path makePathForLogger(Logger logger) {
        return getDirectoryPath().resolve(logger.getName() + "." + getConfig().getFileType());
    }

    /**
     * The Path of the directory that this Object handles
     *
     * @return The path to the directory
     */
    protected Path getDirectoryPath() {
        return getMainLoggerPath().resolve(mainLogger.getName());
    }

    /**
     * Gets the main directory for logs to be logged too.
     *
     * @return the Path for the main logging location
     */
    protected Path getMainLoggerPath() {
        return Paths.get(getConfig().getLoggerPath());
    }

    public void zipLogs() throws IOException {
        File zipFile = getDirectoryPath().resolve(getDateFormatFromMilli(System.currentTimeMillis()) + ".zip").toFile();
        ZipArchiveOutputStream archiveOutputStream = new ZipArchiveOutputStream(zipFile);
        // Collection<File> files = FileUtils.listFiles(directory, new String[] {getConfig().getFileType()}, false);
        // for (File file : files) {
        //     packFile(file, archiveOutputStream);
        // }
        for (Map.Entry<Logger, UtilFileHandler> loggerUtilFileHandlerEntry: streamHandlerHashMap.entrySet()) {
            Logger logger = loggerUtilFileHandlerEntry.getKey();
            UtilFileHandler utilFileHandler = loggerUtilFileHandlerEntry.getValue();
            // Stop the steam and make sure it is all to disk first
            utilFileHandler.close();
            File file = getFileForLogger(logger);
            packFile(file, archiveOutputStream);
            // Restart the stream
            utilFileHandler.setOutputStream(makeFileOutputStreamForLogger(logger));
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
        return FactoryManager.getFactoryManager().getEELoggerFactory().getLoggerSettings();
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

}
