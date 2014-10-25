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
package net.larry1123.elec.util.config.fieldhanders.bytes;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/29/2014 - 4:37 AM
 */
public class ByteArrayFieldHandler extends ArrayFieldHandler<byte[]> {

    public ByteArrayFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public ByteArrayFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(byte[] value) {
        if (ArrayUtils.isNotEmpty(value)) {
            getPropertiesFile().setByteArray(getPropertyKey(), value, getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getFromFile() {
        try {
            return getPropertiesFile().getByteArray(getPropertyKey(), getSpacer());
        }
        catch (UtilityException utilityException) {
            return new byte[0];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] getFromField() {
        try {
            return (byte[]) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return new byte[0];
        }
    }

}
