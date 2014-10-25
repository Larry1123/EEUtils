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
package net.larry1123.elec.util.config.fieldhanders.booleans;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.visualillusionsent.utils.UtilityException;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/29/2014 - 3:42 AM
 */
public class BooleanWrapFieldHandler extends FieldHandler<Boolean> {

    public BooleanWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public BooleanWrapFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Boolean value) {
        getPropertiesFile().setBoolean(getPropertyKey(), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getFromFile() {
        try {
            return getPropertiesFile().getBoolean(getPropertyKey());
        }
        catch (UtilityException utilityException) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getFromField() {
        try {
            return (Boolean) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return false;
        }
    }

}
