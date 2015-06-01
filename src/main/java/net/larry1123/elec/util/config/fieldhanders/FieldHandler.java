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

import com.google.common.collect.Lists;
import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.ConfigField;
import net.larry1123.elec.util.properties.PropertyMeta;
import net.visualillusionsent.utils.PropertiesFile;
import net.visualillusionsent.utils.UtilityException;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Larry1123
 * @since 4/28/2014 - 2:33 AM
 */
public abstract class FieldHandler<T> extends PropertyMeta<T> {

    protected final Field field;
    protected final ConfigBase config;
    protected final ConfigField ano;

    protected FieldHandler(Field field, ConfigBase configBase, ConfigField ano, String key) {
        super(key);
        this.field = field;
        // Ensure we can use the field
        this.getField().setAccessible(true);
        this.config = configBase;
        this.ano = ano;
    }

    // Not the best constructor to call
    protected FieldHandler(Field field, ConfigBase configBase, String key) {
        this(field, configBase, field.getAnnotation(ConfigField.class), key);
    }

    protected FieldHandler(Field field, ConfigBase configBase, ConfigField ano) {
        this(field, configBase, ano, ano.name().equals("") ? field.getName() : ano.name());
    }

    /**
     * This should be the only constructor used
     *
     * @param field      The Field to be handled
     * @param configBase The object containing the field
     */
    public FieldHandler(Field field, ConfigBase configBase) {
        this(field, configBase, field.getAnnotation(ConfigField.class));
    }

    public ConfigField getAno() {
        return ano;
    }

    public Field getField() {
        return field;
    }

    @Deprecated
    public String getFieldName() {
        return getKey();
    }

    public ConfigBase getConfig() {
        return config;
    }

    public PropertiesFile getPropertiesFile() {
        return getConfig().getPropertiesFile();
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
     * Will write to file from field if it fails to find a key in file,
     * this allows for first time setup values to be set into file on loading.
     *
     * @return False if it fails, unless it saved a setup value.
     */
    public boolean load() {
        T pass;
        if (getPropertiesFile().containsKey(getKey())) {
            pass = getFromFile();
        }
        else {
            if (getFromField() == null) {
                return false;
            }
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
        if (getAno() == null) {
            throw new NullPointerException("Annotation can not be null when setting");
        }
        // Make Exception for throwing at making
        if (!getPropertiesFile().containsKey(getKey())) {
            return;
        }
        Collection<String> comments = getComments();
        if (CollectionUtils.isNotEmpty((Collection) comments)) {
            getPropertiesFile().setComments(getKey(), comments.toArray(new String[comments.size()]));
        }
    }

    public Type getType() {
        return getField().getGenericType();
    }

    @Override
    public Collection<String> getComments() {
        Collection<String> ret = Lists.newArrayList();
        if (getAno().comments().length != 1 || !getAno().comments()[0].equals("")) {
            Collections.addAll(ret, getAno().comments());
            String[] fileComments = getPropertiesFile().getComments(getKey());
            if (fileComments != null) {
                for (String fileComment : fileComments) {
                    if (!ret.contains(fileComment)) {
                        ret.add(fileComment);
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public T getValue() {
        return getFromField();
    }

}
