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
package net.larry1123.elec.util.config.fieldhanders.floats;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.visualillusionsent.utils.UtilityException;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:50 AM
 */
public class FloatWrapFieldHandler extends FieldHandler<Float> {

    public FloatWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public FloatWrapFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Float value) {
        getPropertiesFile().setFloat(getPropertyKey(), value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float getFromFile() {
        try {
            return getPropertiesFile().getFloat(getPropertyKey());
        }
        catch (UtilityException utilityException) {
            return 0F;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float getFromField() {
        try {
            return (Float) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return 0F;
        }
    }

}
