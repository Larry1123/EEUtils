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
package net.larry1123.elec.util.config.fieldhanders.intergers;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 3:27 AM
 */
public class IntegerArrayWrapFieldHandler extends ArrayFieldHandler<Integer[]> {

    public IntegerArrayWrapFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public IntegerArrayWrapFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(Integer[] value) {
        if (ArrayUtils.isNotEmpty(value)) {
            getPropertiesFile().setIntArray(getKey(), ArrayUtils.toPrimitive(value), getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer[] getFromFile() {
        if (getPropertiesFile().containsKey(getKey())) {
            return ArrayUtils.toObject(getPropertiesFile().getIntArray(getKey(), getSpacer()));
        }
        else {
            return new Integer[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer[] getFromField() {
        try {
            return (Integer[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new Integer[0];
        }
    }

}
