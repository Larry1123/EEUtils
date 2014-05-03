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

import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;
import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 4/29/2014 - 4:45 AM
 */
public class ByteArrayListFieldHandler extends ArrayFieldHandler<ArrayList<Byte>> {

    public ByteArrayListFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);
    }

    public ByteArrayListFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(ArrayList<Byte> value) {
        getPropertiesFile().setByteArray(getFieldName(), Bytes.toArray(value), getSpacer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Byte> getFromFile() {
        try {
            return Lists.newArrayList(ArrayUtils.toObject(getPropertiesFile().getByteArray(getFieldName(), getSpacer())));
        }
        catch (UtilityException utilityException) {
            return Lists.newArrayList(new Byte[0]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Byte> getFromField() {
        try {
            return (ArrayList<Byte>) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return Lists.newArrayList(new Byte[0]);
        }
    }

}
