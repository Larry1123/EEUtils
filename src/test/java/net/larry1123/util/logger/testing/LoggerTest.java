package net.larry1123.util.logger.testing;

import net.larry1123.util.factorys.EELoggerFactory;
import net.larry1123.util.factorys.FactoryManager;
import net.larry1123.util.logger.EELogger;
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
