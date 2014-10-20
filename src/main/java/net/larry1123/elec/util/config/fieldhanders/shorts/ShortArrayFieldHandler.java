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
package net.larry1123.elec.util.config.fieldhanders.shorts;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/30/2014 - 3:58 AM
 */
public class ShortArrayFieldHandler extends ArrayFieldHandler<short[]> {

    public ShortArrayFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public ShortArrayFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(short[] value) {
        getPropertiesFile().setShortArray(getPropertyKey(), value, getSpacer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short[] getFromFile() {
        try {
            return getPropertiesFile().getShortArray(getPropertyKey(), getSpacer());
        }
        catch (UtilityException utilityException) {
            return new short[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short[] getFromField() {
        try {
            return (short[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new short[0];
        }
    }

}
