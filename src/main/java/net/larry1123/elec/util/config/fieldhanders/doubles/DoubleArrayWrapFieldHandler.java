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
package net.larry1123.elec.util.config.fieldhanders.doubles;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:34 AM
 */
public class DoubleArrayWrapFieldHandler extends ArrayFieldHandler<Double[]> {

    public DoubleArrayWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public DoubleArrayWrapFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Double[] value) {
        if (value.length > 0) {
            getPropertiesFile().setDoubleArray(getPropertyKey(), ArrayUtils.toPrimitive(value), getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double[] getFromFile() {
        try {
            double[] temp = getPropertiesFile().getDoubleArray(getPropertyKey(), getSpacer());
            return ArrayUtils.toObject(temp);
        }
        catch (UtilityException utilityException) {
            return new Double[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double[] getFromField() {
        try {
            return (Double[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new Double[0];
        }
    }

}
