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
package net.larry1123.elec.util.config.fieldhanders.strings;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/29/2014 - 2:17 AM
 */
public class StringArrayFieldHandler extends ArrayFieldHandler<String[]> {

    public StringArrayFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public StringArrayFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(String[] value) {
        if (ArrayUtils.isNotEmpty(value)) {
            getPropertiesFile().setStringArray(getKey(), value, getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getFromFile() {
        if (getPropertiesFile().containsKey(getKey())) {
            return getPropertiesFile().getStringArray(getKey(), getSpacer());
        }
        else {
            return new String[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getFromField() {
        try {
            return (String[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new String[0];
        }
    }

}
