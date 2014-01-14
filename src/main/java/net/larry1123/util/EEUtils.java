package net.larry1123.util;

import net.larry1123.util.logger.LoggerSettings;

public class EEUtils {

    private static LoggerSettings loggerSettings;

    public static void setLoggerSettings(LoggerSettings loggerSettings) {
        if (loggerSettings == null) throw new NullPointerException("LoggerSettings can not be null");
        if (EEUtils.loggerSettings == null) {
            EEUtils.loggerSettings = loggerSettings;
        }
    }

    public static LoggerSettings getLoggerSettings() {
        if (loggerSettings == null) throw new NullPointerException("LoggerSettings is null");
        return loggerSettings;
    }

}
