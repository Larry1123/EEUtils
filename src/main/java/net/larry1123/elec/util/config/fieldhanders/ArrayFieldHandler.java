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
package net.larry1123.elec.util.config.fieldhanders;

import net.larry1123.elec.util.config.ConfigBase;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/29/2014 - 1:27 AM
 */
public abstract class ArrayFieldHandler<T> extends FieldHandler<T> {

    protected final String spacer;

    /**
     * @param field      The Field to be handled
     * @param configBase The object containing the field
     * @param fieldName  The name of the key to get from the PropertiesFile
     *
     * @throws NoSuchFieldException is thrown if the config object does not contain the given Field
     */
    @SuppressWarnings("UnusedDeclaration")
    public ArrayFieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        super(field, configBase, fieldName);

        // Lets get the Spacer
        this.spacer = (getAno().spacer().equals("")) ? "," : getAno().spacer();
    }

    /**
     * @param field      The Field to be handled
     * @param configBase The object containing the field
     *
     * @throws NoSuchFieldException is thrown if the config object does not contain the given Field
     */
    public ArrayFieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        super(field, configBase);

        // Lets get the Spacer
        this.spacer = (getAno().spacer().equals("")) ? "," : getAno().spacer();
    }

    public String getSpacer() {
        return spacer;
    }

}
