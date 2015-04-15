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

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.logger.EELogger;
import net.larry1123.elec.util.test.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Larry1123
 * @since 1/30/14 - 7:33 AM
 */
public class LoggerTest extends AbstractTest {

    protected EELoggerFactory eeLoggerFactory = new EELoggerFactory();

    public LoggerTest() {
        super("LoggerTest");
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
    }

    @Test
    public void testMakingLogger() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        Assert.assertNotNull("Failed to create Sub-Logger.", getTestEELoggerFactory().getLogger("EEUtilTest"));
    }

    @Test
    public void testMakingSubLogger() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger main = getTestEELoggerFactory().getLogger("EEUtilTest");
        Assert.assertNotNull("Failed to create Sub-Logger.", getTestEELoggerFactory().getSubLogger(main, "SubTest"));
    }

    @Test
    public void testFileCreation() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger makeAFile = getTestEELoggerFactory().getLogger("EEUtilFileTest");
        File logFile = new File(getTestEELoggerFactory().getLoggerSettings().getLoggerPath()).toPath().resolve(makeAFile.getName()).resolve(makeAFile.getName() + "." + getTestEELoggerFactory().getLoggerSettings().getFileType()).toFile();
        Assert.assertTrue("Logger File failed to be made.", logFile.exists());
    }

    /**
     * This test does not assert it just looks to see if it errors.
     * Will look into seeing if I can assert if it truly logs stuff to file.
     */
    @Test
    public void testLogs() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getTestEELoggerFactory().getLogger("EEUtilLogsTest");
        eeLogger.error("A fake ERROR!!", new Error());
    }

    @Test
    public void testSubLogs() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getTestEELoggerFactory().getLogger("EEUtilLogsParentTest");
        eeLogger.error("A fake ERROR!!", new Error());
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "SubLogger");
        eeLogger.info("This is a test of the sub-logger");
        eeLogger.error("This is the sub-logger throwing an error", new Error());
        // Lets _get a little meta with this test
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "SuperSubLogger");
        eeLogger.info("This is a test of the super-sub-logger");
        eeLogger.error("This is the super-sub-logger throwing an error", new Error());
    }

    @Test
    public void testZipping() {
        getTestEELoggerFactory().setLoggerSettings(new TestLoggerSettings());
        EELogger eeLogger = getTestEELoggerFactory().getLogger("EEUtilZipTest");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test2");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test3");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test4");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test5");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test6");
        eeLogger = getTestEELoggerFactory().getSubLogger(eeLogger, "Test7");
        eeLogger.error("A fake ERROR!!", new Error());

        try {
            getTestEELoggerFactory().getFileManager().updateFileHandlers();
        }
        catch (IOException e) {
            assertFailWithThrowable("Failed to update the file handlers.", e);
        }
    }

    protected EELoggerFactory getTestEELoggerFactory() {
        return eeLoggerFactory;
    }

}
