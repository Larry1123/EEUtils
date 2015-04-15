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

/**
 * @author Larry1123
 * @since 10/24/2014 - 12:45 AM
 */
public class ConfigLoadTest extends AbstractConfigFieldTest {

    protected final ConfigFile configFile;

    public ConfigLoadTest() {
        super("ConfigLoadTest", "target/test-classes/ConfigLoadTest.cfg");
        configFile = new ConfigFile(getConfigBase());
    }

    @Override
    protected ConfigBase createTestConfigBase(final PropertiesFile file) {
        return new LoadingTestConfigBase() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
