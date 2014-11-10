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
package net.larry1123.elec.util.test.logger;

import net.larry1123.elec.util.logger.EELogger;
import net.larry1123.elec.util.logger.FileManager;
import net.larry1123.elec.util.test.AbstractTestClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Larry1123
 * @since 1/30/14 - 7:33 AM
 */
public class LoggerTest extends AbstractTestClass {

    public LoggerTest() {
        super("LoggerTest");
    }

    @Test
    public void testMakingLogger() {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        Assert.assertNotNull("Failed to create Sub-Logger.", getEELoggerFactory().getLogger("EEUtilTest"));
    }

    @Test
    public void testMakingSubLogger() {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger main = getEELoggerFactory().getLogger("EEUtilTest");
        Assert.assertNotNull("Failed to create Sub-Logger.", getEELoggerFactory().getSubLogger(main, "SubTest"));
    }

    @Test
    public void testFileCreation() {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger makeAFile = getEELoggerFactory().getLogger("EEUtilFileTest");
        File logFile = new File(makeAFile.getLogFile() + "." + getEELoggerFactory().getLoggerSettings().getFileType());
        Assert.assertTrue("Logger File failed to be made.", logFile.exists());
    }

    /**
     * This test does not assert it just looks to see if it errors.
     * Will look into seeing if I can assert if it truly logs stuff to file.
     */
    @Test
    public void testLogs() {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getEELoggerFactory().getLogger("EEUtilLogsTest");
        eeLogger.info("This is a test! This should be logged in " + eeLogger.getLogFile() + "." + getEELoggerFactory().getLoggerSettings().getFileType());
        eeLogger.error("A fake ERROR!!", new Error());
        Assert.assertTrue(eeLogger.canFileLog());
    }

    @Test
    public void testSubLogs() {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getEELoggerFactory().getLogger("EEUtilLogsParentTest");
        eeLogger.info("This is a test! This should be logged in " + eeLogger.getLogFile() + "." + getEELoggerFactory().getLoggerSettings().getFileType());
        eeLogger.error("A fake ERROR!!", new Error());
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "SubLogger");
        eeLogger.info("This is a test of the sub-logger");
        eeLogger.error("This is the sub-logger throwing an error", new Error());
        // Lets get a little meta with this test
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "SuperSubLogger");
        eeLogger.info("This is a test of the super-sub-logger");
        eeLogger.error("This is the super-sub-logger throwing an error", new Error());
    }

    @Test
    public void testZipping() throws IOException {
        getEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getEELoggerFactory().getLogger("EEUtilZipTest");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test2");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test3");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test4");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test5");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test6");
        eeLogger = getEELoggerFactory().getSubLogger(eeLogger, "Test7");
        eeLogger.info("This is a test! This should be logged in " + eeLogger.getLogFile() + "." + getEELoggerFactory().getLoggerSettings().getFileType());
        eeLogger.error("A fake ERROR!!", new Error());
        FileManager.updateFileHandlers();
    }

}
