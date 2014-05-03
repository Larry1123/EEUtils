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
package net.larry1123.elec.util.logger.testing;

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.logger.EELogger;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * @author Larry1123
 * @since 1/30/14 - 7:33 AM
 */
public class LoggerTest {

    protected EELoggerFactory eeLoggerFactory = FactoryManager.getFactoryManager().getEELoggerFactory();

    @Test
    public void testMakingLogger() {
        eeLoggerFactory.setLoggerSettings(new TestLoggerSettings());
        Assert.assertNotNull("Failed to create Sub-Logger.", eeLoggerFactory.getLogger("EEUtilTest"));
    }

    @Test
    public void testMakingSubLogger() {
        eeLoggerFactory.setLoggerSettings(new TestLoggerSettings());
        EELogger main = eeLoggerFactory.getLogger("EEUtilTest");
        Assert.assertNotNull("Failed to create Sub-Logger.", eeLoggerFactory.getSubLogger("SubTest", main));
    }

    @Test
    public void testFileCreation() {
        eeLoggerFactory.setLoggerSettings(new TestLoggerSettings());
        EELogger makeAFile = eeLoggerFactory.getLogger("EEUtilFileTest");
        File logFile = new File(makeAFile.logPath + "." + eeLoggerFactory.getLoggerSettings().getFileType());
        Assert.assertTrue("Logger File failed to be made.", logFile.exists());
    }

    @Test
    public void testLevelFileCreation() {
        eeLoggerFactory.setLoggerSettings(new TestLoggerSettings());
        EELogger makeAFile = eeLoggerFactory.getLogger("EEUtilFileTest");
        makeAFile.addLoggerLevelWFile("LevelTest");
        File logFile = new File(makeAFile.logPath + "-LevelTest." + eeLoggerFactory.getLoggerSettings().getFileType());
        Assert.assertTrue("Level File failed to be made.", logFile.exists());
    }

}
