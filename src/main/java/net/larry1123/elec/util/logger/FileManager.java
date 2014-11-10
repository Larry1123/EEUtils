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

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class FileManager {

    private static final HashMap<String, UtilFileHandler> utilFileHandlers = new HashMap<String, UtilFileHandler>();
    private static final HashMap<UtilFileHandler, StreamHandler> fileHandlers = new HashMap<UtilFileHandler, StreamHandler>();
    private static EELoggerFactory eeLoggerFactory = FactoryManager.getFactoryManager().getEELoggerFactory();

    /**
     * Returns the TimeDate that should be used for files at this time
     *
     * @return String containing the current dateTime to use as the split in logging
     */
    public static String dateTime() {
        Date currentTime = null;
        String set = getDateFormatFromMilli(System.currentTimeMillis());
        try {
            currentTime = DateUtils.parseDate(set, DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            if (!(getConfig().getCurrentSplit() == null || getConfig().getCurrentSplit().equals(""))) {
                Date currentSplit = DateUtils.parseDate(getConfig().getCurrentSplit(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
                Date test;
                switch (getConfig().getSplit()) {
                    case HOUR:
                        test = DateUtils.addHours(currentTime, 1);
                        test = DateUtils.setMinutes(test, 0);
                        test = DateUtils.setSeconds(test, 0);
                        test = DateUtils.setMilliseconds(test, 0);
                        if (test.after(currentSplit)) {
                            set = getConfig().getCurrentSplit();
                        }
                        break;
                    case DAY:
                        if (!DateUtils.isSameDay(currentTime, currentSplit)) {
                            set = getConfig().getCurrentSplit();
                        }
                        break;
                    case WEEK:
                        test = DateUtils.ceiling(currentTime, Calendar.WEEK_OF_MONTH);
                        if (test.after(currentSplit)) {
                            set = getConfig().getCurrentSplit();
                        }
                        break;
                    case MONTH:
                        test = DateUtils.ceiling(currentTime, Calendar.MONTH);
                        if (test.after(currentSplit)) {
                            set = getConfig().getCurrentSplit();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        catch (ParseException ignored) {}
        getConfig().setCurrentSplit(set);
        return set.replace(":", "_");
    }

    /**
     * Makes a formatted String
     *
     * @param milli    What milli time to use
     * @return The formatted String
     */
    public static String getDateFormatFromMilli(long milli) {
        return DateFormatUtils.SMTP_DATETIME_FORMAT.format(milli);
    }

    /**
     * This will set up a Logger to have a {@link net.larry1123.elec.util.logger.UtilFileHandler}.
     *
     * @param logger  Any Java Logger you want to have a UtilFileHandler
     * @param logPath The path and Logger Name
     *
     * @throws IOException
     */
    public static void setUpLogger(Logger logger, String logPath) throws IOException {
        UtilFileHandler fileHandler = new UtilFileHandler(logPath);
        utilFileHandlers.put(logPath, fileHandler);
        logger.addHandler(fileHandler);
    }

    public static StreamHandler getHandler(UtilFileHandler utilFileHandler) throws IOException {
        StreamHandler handler;
        if (!fileHandlers.containsKey(utilFileHandler)) {
            File file = new File(utilFileHandler.getFilePattern());
            FileOutputStream fout = FileUtils.openOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            handler = new StreamHandler(bout, utilFileHandler.getFormatter());
            handler.setFilter(utilFileHandler.getFilter());
            handler.setLevel(utilFileHandler.getLevel());
            handler.setFormatter(utilFileHandler.getFormatter());
            handler.setEncoding(utilFileHandler.getEncoding());
            handler.setErrorManager(utilFileHandler.getErrorManager());
            fileHandlers.put(utilFileHandler, handler);
        }
        else {
            handler = fileHandlers.get(utilFileHandler);
        }
        if (handler == null) {
            throw new NullPointerException();
        }
        return handler;
    }

    public synchronized static void updateFileHandlers() throws IOException {
        zipUpOldLogs();
        for (UtilFileHandler fileHandler : utilFileHandlers.values()) {
            fileHandlers.remove(fileHandler);
            fileHandler.updateFileHandler();
        }
    }

    private static void zipUpOldLogs() throws IOException {
        ArrayList<File> directories = new ArrayList<File>();
        for (String filePath : utilFileHandlers.keySet()) {
            File file = new File(filePath);
            file = file.getParentFile();
            if (!directories.contains(file)) {
                directories.add(file);
            }
        }
        for (File directory : directories) {
            zipUpOldLogs(directory);
        }
    }

    private static void zipUpOldLogs(File directory) throws IOException {
        Collection<File> files = FileUtils.listFiles(directory, new String[] {getConfig().getFileType()}, false);
        long milliTime = System.currentTimeMillis();
        for (File file : files) {
            BasicFileAttributes attr = java.nio.file.Files.readAttributes(file.toPath(), BasicFileAttributes.class);
            if (milliTime > attr.creationTime().toMillis()) {
                milliTime = attr.creationTime().toMillis();
            }
        }
        File zipFile = directory.toPath().resolve(getDateFormatFromMilli(milliTime).replace(":", "_") + ".zip").toFile();
        ZipArchiveOutputStream archiveOutputStream = new ZipArchiveOutputStream(zipFile);
        for (File file : files) {
            ArchiveEntry archiveEntry = archiveOutputStream.createArchiveEntry(file, file.getName());
            FileInputStream fileInputStream = FileUtils.openInputStream(file);
            archiveOutputStream.putArchiveEntry(archiveEntry);
            IOUtils.copy(fileInputStream, archiveOutputStream);
            archiveOutputStream.closeArchiveEntry();
        }
        archiveOutputStream.close();
        for (File file : files) {
            file.delete();
        }
    }

    private static LoggerSettings getConfig() {
        return eeLoggerFactory.getLoggerSettings();
    }

}
