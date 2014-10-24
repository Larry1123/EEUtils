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
package net.larry1123.elec.util.test.config;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.ConfigFile;
import net.visualillusionsent.utils.PropertiesFile;
import org.junit.Test;

/**
 * @author Larry1123
 * @since 10/24/2014 - 12:45 AM
 */
public class FullConfigTest extends AbstractConfigTest {

    public FullConfigTest() {
        super("FullConfigLoadTest", "target/test-classes/FullTest.cfg");
    }

    @Test
    public void fullConfigTest() throws NoSuchMethodException {
        ConfigFile configFile = new ConfigFile(getConfigBase());
        for (FieldNames fieldNames : FieldNames.values()) {
            assertTest(fieldNames.name());
        }
        // TODO Change data, save, then retest
    }

    @Override
    protected ConfigBase createTestConfigBase(final PropertiesFile file) {
        return new FullTestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
