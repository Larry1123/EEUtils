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
package net.larry1123.elec.util.test;

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.larry1123.elec.util.factorys.ParameterizedTypeFactory;
import net.larry1123.elec.util.logger.EELogger;
import net.larry1123.elec.util.logger.LoggerSettings;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import java.io.IOException;

/**
 * @author Larry1123
 * @since 10/23/2014 - 8:08 PM
 */
public class AbstractTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public TestName testName = new TestName();

    private static LoggerSettings testLoggerSettings = new TestLoggerSettings();

    protected final String name;

    public AbstractTest(String name) {
        this.name = name;
        try {
            getTemporaryFolder().create();
        }
        catch (IOException e) {
            assumeNoThrowable("Error creating Temporary Folder!", e);
        }
        getFactoryManager().get(EELoggerFactory.class, "default", new EELoggerFactory.EELoggerFactorySetup(testLoggerSettings));
    }

    public String getName() {
        return name;
    }

    public FactoryManager getFactoryManager() {
        return FactoryManager.getFactoryManager();
    }

    public FieldHandlerFactory getFieldHandlerFactory() {
        return getFactoryManager().getFieldHandlerFactory();
    }

    public ParameterizedTypeFactory getParameterizedTypeFactory() {
        return getFactoryManager().getParameterizedTypeFactory();
    }

    public EELoggerFactory getEELoggerFactory() {
        return getFactoryManager().get(EELoggerFactory.class, "default");
    }

    public EELogger getLogger() {
        return getEELoggerFactory().getLogger(getName(), true);
    }

    public EELogger getLogger(String sub) {
        return getEELoggerFactory().getSubLogger(getLogger(), sub, true);
    }

    protected void assertFailWithThrowable(String message, Throwable throwable) {
        getLogger().error(message, throwable);
        Assert.fail(message);
    }

    protected void assumeNoThrowable(String message, Throwable throwable) {
        getLogger().error(message, throwable);
        Assume.assumeNoException(message, throwable);
    }

    public TemporaryFolder getTemporaryFolder() {
        return temporaryFolder;
    }

    public TestName getTestName() {
        return testName;
    }

}
