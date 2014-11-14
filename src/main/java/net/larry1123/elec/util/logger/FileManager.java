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
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class FileManager {

    private static EELoggerFactory eeLoggerFactory = FactoryManager.getFactoryManager().getEELoggerFactory();
    private static HashMap<EELogger, LoggerDirectoryHandler> loggerDirectoryHandlerHashMap = new HashMap<EELogger, LoggerDirectoryHandler>();
    private static HashSet<LoggerDirectoryHandler> directoryHandlerHashSet = new HashSet<LoggerDirectoryHandler>();

    public static long getSplitTime() {
        long set = System.currentTimeMillis();
        try {
            Date currentTime = DateUtils.parseDate(getDateFormatFromMilli(System.currentTimeMillis()), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
            Date currentSplit = DateUtils.parseDate(getDateFormatFromMilli(getConfig().getCurrentSplit()), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern());
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
                case NONE:
                default:
                    set = 0;
                    break;
            }
        }
        catch (ParseException e) {
            set = 0;
        }
        return set;
    }

    public static void updateSplit() {
        if (isSplitng()) {
            if (isNotCurrent()) {
                getConfig().setCurrentSplit(getSplitTime());
            }
        }
        else {
            getConfig().setCurrentSplit(0);
        }
    }

    /**
     * Makes a formatted String
     *
     * @param milli What milli time to use
     *
     * @return The formatted String
     */
    public static String getDateFormatFromMilli(long milli) {
        return DateFormatUtils.SMTP_DATETIME_FORMAT.format(milli);
    }

    public static void trackLogger(EELogger logger) {
        if (!loggerDirectoryHandlerHashMap.containsKey(logger)) {
            if (logger.hasParent()) {
                EELogger parent = logger.getParent();
                if (!loggerDirectoryHandlerHashMap.containsKey(parent)) {
                    trackLogger(parent);
                }
                LoggerDirectoryHandler directoryHandler = loggerDirectoryHandlerHashMap.get(parent);
                loggerDirectoryHandlerHashMap.put(logger, directoryHandler);
            }
            else {
                LoggerDirectoryHandler loggerDirectoryHandler = new LoggerDirectoryHandler(logger);
                directoryHandlerHashSet.add(loggerDirectoryHandler);
                loggerDirectoryHandlerHashMap.put(logger, loggerDirectoryHandler);
            }
        }
    }

    public static void fileLog(EELogger logger) throws IOException {
        trackLogger(logger);
        LoggerDirectoryHandler directoryHandler = loggerDirectoryHandlerHashMap.get(logger);
        directoryHandler.setupLogger(logger);
    }

    public synchronized static void updateFileHandlers() throws IOException {
        for (LoggerDirectoryHandler directoryHandler : directoryHandlerHashSet) {
            directoryHandler.zipLogs();
        }
    }

    public static boolean isSplitng() {
        return !getConfig().getSplit().equals(FileSplits.NONE);
    }

    public static boolean hasCurrentSplit() {
        return getConfig().getCurrentSplit() != 0;
    }

    public static boolean isNotCurrent() {
        return isSplitng() && !hasCurrentSplit() && getConfig().getCurrentSplit() == getSplitTime();
    }

    private static LoggerSettings getConfig() {
        return eeLoggerFactory.getLoggerSettings();
    }

}
