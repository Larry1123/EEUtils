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
package net.larry1123.util.config.fieldhanders.floats;

import net.larry1123.util.config.ConfigBase;
import net.larry1123.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:56 AM
 */
public class FloatArrayWrapFieldHandler extends ArrayFieldHandler<Float[]> {

    public FloatArrayWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public FloatArrayWrapFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Float[] value) {
        float[] temp = ArrayUtils.toPrimitive(value);
        getPropertiesFile().setFloatArray(getFieldName(), temp, getSpacer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float[] getFromFile() {
        try {
            float[] temp = getPropertiesFile().getFloatArray(getFieldName(), getSpacer());
            return ArrayUtils.toObject(temp);
        }
        catch (UtilityException utilityException) {
            return new Float[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Float[] getFromField() {
        try {
            return (Float[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new Float[0];
        }
    }

}
