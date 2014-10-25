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
package net.larry1123.elec.util.factorys;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.EmptyFileHandler;
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author Larry1123
 * @since 4/28/2014 - 2:31 AM
 */
public class FieldHandlerFactory {

    protected final HashMap<Type, Class<? extends FieldHandler<?>>> providedHandlers = new HashMap<Type, Class<? extends FieldHandler<?>>>();

    public void addHandler(Type type, Class<? extends FieldHandler<?>> handler) {
        if (!providedHandlers.containsKey(type)) {
            providedHandlers.put(type, handler);
        }
    }

    public void removeHandler(Class<? extends FieldHandler<?>> handler) {
        if (providedHandlers.containsValue(handler)) {
            for (Type type : providedHandlers.keySet()) {
                if (providedHandlers.get(type).equals(handler)) {
                    providedHandlers.remove(type);
                }
            }
        }
    }

    public FieldHandler<?> createFieldHandler(Type type, Field field, ConfigBase configBase) {
        if (getField(configBase, field.getName(), null) == null) {
            return createEmptyFileHandler(type, field, configBase);
        }
        if (containsType(type)) {
            try {
                Class<? extends FieldHandler<?>> tClass = providedHandlers.get(rightTypeToGet(type));
                Constructor constructor = tClass.getConstructor(Field.class, ConfigBase.class);
                return (FieldHandler<?>) constructor.newInstance(field, configBase);
            }
            catch (NoSuchMethodException e) {
                return createEmptyFileHandler(type, field, configBase);
            }
            catch (InvocationTargetException e) {
                return createEmptyFileHandler(type, field, configBase);
            }
            catch (InstantiationException e) {
                return createEmptyFileHandler(type, field, configBase);
            }
            catch (IllegalAccessException e) {
                return createEmptyFileHandler(type, field, configBase);
            }
        }
        else {
            return createEmptyFileHandler(type, field, configBase);
        }
    }

    protected boolean containsType(Type type) {
        for (Type providedType : providedHandlers.keySet()) {
            if (providedType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    protected Type rightTypeToGet(Type type) {
        for (Type providedType : providedHandlers.keySet()) {
            if (providedType.equals(type)) {
                return providedType;
            }
        }
        // Did not work...
        return type;
    }

    protected FieldHandler<?> createEmptyFileHandler(Type type, Field field, ConfigBase configBase) {
        return new EmptyFileHandler(field, configBase);
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
