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
package net.larry1123.util.config.fieldhanders;

import net.larry1123.util.config.ConfigBase;
import net.larry1123.util.config.ConfigField;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.UtilityException;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author Larry1123
 * @since 4/28/2014 - 2:33 AM
 */
public abstract class FieldHandler<T> {

    protected final Field field;
    protected final String fieldName;
    protected final ConfigBase config;
    protected final PropertiesFile propertiesFile;
    protected final ConfigField ano;
    protected T value;

    /**
     * @param field      The Field to be handled
     * @param configBase The object containing the field
     * @param fieldName  The name of the key to get from the PropertiesFile
     *
     * @throws NoSuchFieldException is thrown if the config object does not contain the given Field
     */
    @SuppressWarnings("UnusedDeclaration")
    public FieldHandler(Field field, ConfigBase configBase, String fieldName) throws NoSuchFieldException {
        this.field = field;
        // Ensure we can use the field
        this.getField().setAccessible(true);
        ano = this.getField().getAnnotation(ConfigField.class);
        this.propertiesFile = configBase.getPropertiesFile();
        this.config = configBase;
        this.fieldName = fieldName;

    }

    /**
     * @param field      The Field to be handled
     * @param configBase The object containing the field
     *
     * @throws NoSuchFieldException is thrown if the config object does not contain the given Field
     */
    public FieldHandler(Field field, ConfigBase configBase) throws NoSuchFieldException {
        this.field = field;
        // Ensure we can use the field
        this.getField().setAccessible(true);
        ano = this.getField().getAnnotation(ConfigField.class);
        this.propertiesFile = configBase.getPropertiesFile();
        this.config = configBase;
        // Lets give this thing a name
        this.fieldName = (getAno().name().equals("")) ? field.getName() : getAno().name();
    }

    public ConfigField getAno() {
        return ano;
    }

    public Field getField() {
        return field;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getConfig() {
        return config;
    }

    public PropertiesFile getPropertiesFile() {
        return propertiesFile;
    }

    /**
     * Saves to the file
     *
     * @return False if it fails.
     */
    public boolean save() {
        try {
            setToFile(getFromField());
            return true;
        }
        catch (UtilityException utilityException) {
            return false;
        }
    }

    /**
     * Load from the file.
     *
     * @return False if it fails.
     */
    public boolean load() {
        T pass;
        try {
            pass = getFromFile();
        }
        catch (UtilityException utilityException) {
            if (getFromField() == null) { return false; }
            setToFile(pass = getFromField());
        }
        return setToField(pass);
    }

    /**
     * Sets the value in the file.
     */
    public abstract void setToFile(T value);

    /**
     * Gets the value from file.
     *
     * @return The value from the file.
     */
    public abstract T getFromFile();

    /**
     * Sets the value in the field.
     *
     * @return False if it failed to set the value.
     */
    public boolean setToField(T value) {
        try {
            getField().set(getConfig(), value);
            return true;
        }
        catch (IllegalAccessException e) {
            return false;
        }
    }

    /**
     * Get the value from the field.
     *
     * @return The value from the field.
     */
    public abstract T getFromField();

    /**
     * Sets any amount of comments to the key in the file
     * Does nothing if the file does not contain the field
     */
    public void setComments() {
        if (getAno() == null) { throw new NullPointerException("Annotation can not be null when setting"); }
        // Make Exception for throwing at making
        if (!getPropertiesFile().containsKey(getFieldName())) { return; }
        if ((getAno().comments().length != 1 || !getAno().comments()[0].equals(""))) {
            getPropertiesFile().setComments(getFieldName(), getAno().comments());
        }
    }

    public Type getType() {
        return field.getGenericType();
    }

    protected Field getField(Object ob, String fieldName, Class lastClass) {
        Class currentClass = lastClass == null ? ob.getClass() : lastClass.getSuperclass();
        try {
            Field ret = currentClass.getDeclaredField(fieldName);
            ret.setAccessible(true);
            return ret;
        }
        catch (NoSuchFieldException e) {
            return getField(ob, fieldName, currentClass);
        }
        catch (NullPointerException e) {
            return null;
        }
    }

}
