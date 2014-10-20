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

import com.google.common.io.Files;
import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class FileManager {

    private static final HashMap<String, FileHandler> fileHandlers = new HashMap<String, FileHandler>();
    private static final HashMap<String, UtilFileHandler> utilFileHandlers = new HashMap<String, UtilFileHandler>();
    private static EELoggerFactory eeLoggerFactory = FactoryManager.getFactoryManager().getEELoggerFactory();

    /**
     * Returns the TimeDate that should be used for files at this time
     *
     * @return String containing the current dateTime to use as the split in logging
     */
    public static String dateTime() {
        Date currentTime = null;
        String set = DateFormatUtils.SMTP_DATETIME_FORMAT.format(System.currentTimeMillis());
        try {
            currentTime = DateUtils.parseDate(set, DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        if (!(getConfig().getCurrentSplit() == null || getConfig().getCurrentSplit().equals(""))) {
            Date currentSplit;
            try {
                currentSplit = DateUtils.parseDate(getConfig().getCurrentSplit(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
            }
            catch (ParseException e) {
                getConfig().setCurrentSplit(set);
                return set.replace(":", "_");
            }

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
        getConfig().setCurrentSplit(set);
        return set.replace(":", "_");
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
        Files.createParentDirs(new File(logPath));
        UtilFileHandler fileHandler = new UtilFileHandler(logPath);
        logger.addHandler(fileHandler);
    }

    public static FileHandler getHandler(UtilFileHandler utilFileHandler) throws IOException {
        FileHandler handler = null;
        String logPath = utilFileHandler.getFilePath();
        if (!fileHandlers.containsKey(logPath)) {
            handler = new FileHandler(utilFileHandler.getFilePattern(), true);
            handler.setFilter(utilFileHandler.getFilter());
            handler.setLevel(utilFileHandler.getLevel());
            handler.setFormatter(utilFileHandler.getFormatter());
            handler.setEncoding(utilFileHandler.getEncoding());
            handler.setErrorManager(utilFileHandler.getErrorManager());
            fileHandlers.put(logPath, handler);
        }
        else {
            handler = fileHandlers.get(logPath);
        }
        if (handler == null) {
            throw new NullPointerException();
        }

        return handler;
    }

    public synchronized static void updateFileHandlers() throws IOException {
        for (UtilFileHandler fileHandler : utilFileHandlers.values()) {
            utilFileHandlers.remove(fileHandler.getFilePath());
            fileHandler.updateFileHandler();
        }
    }

    private static LoggerSettings getConfig() {
        return eeLoggerFactory.getLoggerSettings();
    }

}
