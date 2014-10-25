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
package net.larry1123.elec.util.config.fieldhanders.strings;

import com.google.common.collect.Lists;
import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.ArrayFieldHandler;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 4/29/2014 - 2:35 AM
 */
public class StringArrayListFieldHandler extends ArrayFieldHandler<ArrayList<String>> {

    public StringArrayListFieldHandler(Field field, ConfigBase configBase, String fieldName) {
        super(field, configBase, fieldName);
    }

    public StringArrayListFieldHandler(Field field, ConfigBase configBase) {
        super(field, configBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setToFile(ArrayList<String> value) {
        if (CollectionUtils.isNotEmpty(value)) {
            getPropertiesFile().setStringArray(getPropertyKey(), value.toArray(new String[value.size()]), getSpacer());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<String> getFromFile() {
        try {
            return Lists.newArrayList(getPropertiesFile().getStringArray(getPropertyKey(), getSpacer()));
        }
        catch (UtilityException utilityException) {
            return Lists.newArrayList(new String[0]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<String> getFromField() {
        try {
            return (ArrayList<String>) getField().get(getConfig());
        }
        catch (IllegalAccessException e) {
            return Lists.newArrayList(new String[0]);
        }
    }
}
