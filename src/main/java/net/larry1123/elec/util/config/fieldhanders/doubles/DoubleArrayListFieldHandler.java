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

import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 4/30/2014 - 2:41 AM
 */
public class DoubleArrayListFieldHandler extends ArrayFieldHandler<ArrayList<Double>> {

    public DoubleArrayListFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public DoubleArrayListFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(ArrayList<Double> value) {
        if (CollectionUtils.isNotEmpty(value)) {
            getPropertiesFile().setDoubleArray(getKey(), Doubles.toArray(value), getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Double> getFromFile() {
        if (getPropertiesFile().containsKey(getKey())) {
            return Lists.newArrayList(ArrayUtils.toObject(getPropertiesFile().getDoubleArray(getKey(), getSpacer())));
        }
        else {
            return Lists.newArrayList(new Double[0]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Double> getFromField() {
        try {
            return (ArrayList<Double>) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return Lists.newArrayList(new Double[0]);
        }
    }

}
