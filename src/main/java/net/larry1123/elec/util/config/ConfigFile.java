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
package net.larry1123.elec.util.config;

import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;

public class ConfigFile {

    /**
     * The PropertiesFile to control
     */
    protected final PropertiesFile propertiesfile;

    /**
     * The ConfigBase to base the PropertiesFile on
     */
    protected final ConfigBase config;

    /**
     * Holds a list of usable Fields
     */
    protected Field[] configFields = new Field[0];

    /**
     * Creates a ConfigFile controller for a given PropertiesFile
     * Will load data from file to ConfigBase
     *
     * @param config ConfigBase to use
     */
    public ConfigFile(ConfigBase config) {
        this.config = config;
        this.propertiesfile = config.getPropertiesFile();
        collectFields(this.config, null);
        load();
    }

    /**
     * Will search Class and super Classes to find fields for use and add them to our known field list.
     *
     * @param config    The Object to use to search
     * @param lastClass Mostly an internal PlaceHolder
     */
    protected void collectFields(ConfigBase config, Class lastClass) {
        Class currentClass = lastClass == null ? config.getClass() : lastClass.getSuperclass();
        for (Field field : currentClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(ConfigField.class)) {
                configFields = ArrayUtils.add(configFields, field);
            }
        }
        if (currentClass.getSuperclass() != null) { collectFields(config, currentClass); }
    }

    /**
     * Gets the controlled PropertiesFile
     *
     * @return PropertiesFile being controlled
     */
    public PropertiesFile getPropFile() {
        return propertiesfile;
    }

    /**
     * Updates the ConfigBase to match the current file without saving first
     */
    public void reload() {
        propertiesfile.reload();
        load();
    }

    public void load() {
        for (Field field : configFields) {
            FieldHandler<?> fieldHandler = new FieldHandlerFactory().createFieldHandler(field.getGenericType(), field, config);
            fieldHandler.load();
            fieldHandler.setComments();
        }
        // Well lets SAVE!!!
        propertiesfile.save();
    }

    /**
     * Saves data to disk if any change has been made
     */
    public void save() {
        for (Field field : configFields) {
            FieldHandler<?> fieldHandler = new FieldHandlerFactory().createFieldHandler(field.getGenericType(), field, config);
            fieldHandler.save();
            fieldHandler.setComments();
        }
        // Well lets SAVE!!!
        propertiesfile.save();
    }
}