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

import com.google.common.collect.Lists;
import com.google.common.primitives.Shorts;
import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 4/30/2014 - 4:01 AM
 */
public class ShortArrayListFieldHandler extends ArrayFieldHandler<ArrayList<Short>> {

    public ShortArrayListFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public ShortArrayListFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(ArrayList<Short> value) {
        if (CollectionUtils.isNotEmpty(value)) {
            getPropertiesFile().setShortArray(getKey(), Shorts.toArray(value), getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Short> getFromFile() {
        if (getPropertiesFile().containsKey(getKey())) {
            return Lists.newArrayList(ArrayUtils.toObject(getPropertiesFile().getShortArray(getKey(), getSpacer())));
        }
        else {
            return Lists.newArrayList(new Short[0]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Short> getFromField() {
        try {
            return (ArrayList<Short>) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return Lists.newArrayList(new Short[0]);
        }
    }

}
