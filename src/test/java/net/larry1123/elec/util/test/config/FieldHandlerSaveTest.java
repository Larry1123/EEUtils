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
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.visualillusionsent.utils.PropertiesFile;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 2/1/14 - 5:09 AM
 */
public class FieldHandlerSaveTest extends AbstractConfigFieldTest {

    public FieldHandlerSaveTest() {
        super("FieldHandlerSaveTest", "target/tests/FieldHandlerSaveTest.cfg");
    }

    @Override
    protected void assertTest(String fieldName, Field field) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(field.getGenericType(), field, getConfigBase());
        handler.save();
        getPropertiesFile().save();

        super.assertTest(fieldName, field);
    }

    @Override
    protected ConfigBase createTestConfigBase(final PropertiesFile file) {
        return new SavingTestConfigBase() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}

