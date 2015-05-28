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

import net.larry1123.elec.util.config.fieldhanders.booleans.BooleanFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.booleans.BooleanWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.bytes.ByteArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.bytes.ByteArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.bytes.ByteArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.bytes.ByteFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.bytes.ByteWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.character.CharacterFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.character.CharacterWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.DoubleArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.DoubleArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.DoubleArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.DoubleFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.DoubleWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.floats.FloatArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.floats.FloatArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.floats.FloatArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.floats.FloatFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.floats.FloatWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.intergers.IntegerArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.intergers.IntegerArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.intergers.IntegerArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.intergers.IntegerFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.intergers.IntegerWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.longs.LongArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.longs.LongArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.longs.LongArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.longs.LongFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.longs.LongWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.shorts.ShortArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.shorts.ShortArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.shorts.ShortArrayWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.shorts.ShortFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.shorts.ShortWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.strings.StringArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.strings.StringArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.strings.StringFieldHandler;
import net.larry1123.elec.util.logger.EELogger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Larry1123
 * @since 5/2/2014 - 3:04 AM
 */
public class FactoryManager {

    private static final FactoryManager factoryManager = new FactoryManager();

    private final HashMap<Class<? extends Factory>, HashMap<String, Factory>> factories = new HashMap<Class<? extends Factory>, HashMap<String, Factory>>();

    private FactoryManager() {
    }

    public static FactoryManager getFactoryManager() {
        return factoryManager;
    }

    /**
     * @deprecated {@link #getFieldHandlerFactory()}
     */
    @Deprecated
    public FieldHandlerFactory getMainFieldHandlerFactory() {
        return getFieldHandlerFactory();
    }

    /**
     * @deprecated {@link #get(Class, String)} get(FieldHandlerFactory.class, {@code name})
     */
    @Deprecated
    public FieldHandlerFactory getNewFieldHandlerFactory() {
        return get(FieldHandlerFactory.class, "FieldHandlerFactory" + System.nanoTime());
    }

    public FieldHandlerFactory getFieldHandlerFactory() {
        return get(FieldHandlerFactory.class, "default", new FactorySetup<FieldHandlerFactory>() {

            @Override
            public void configFactory(FieldHandlerFactory factory) {
                FactoryManager.this.addDefaultHandlers(factory);
            }

        });
    }

    public void addDefaultHandlers(FieldHandlerFactory factory) {
        // Boolean
        factory.addHandler(Boolean.TYPE, BooleanFieldHandler.class);
        factory.addHandler(Boolean.class, BooleanWrapFieldHandler.class);
        // Byte
        factory.addHandler(Byte.TYPE, ByteFieldHandler.class);
        factory.addHandler(Byte.class, ByteWrapFieldHandler.class);
        factory.addHandler(byte[].class, ByteArrayFieldHandler.class);
        factory.addHandler(Byte[].class, ByteArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Byte.class), ByteArrayListFieldHandler.class);
        // Character
        factory.addHandler(Character.TYPE, CharacterFieldHandler.class);
        factory.addHandler(Character.class, CharacterWrapFieldHandler.class);
        // Double
        factory.addHandler(Double.TYPE, DoubleFieldHandler.class);
        factory.addHandler(Double.class, DoubleWrapFieldHandler.class);
        factory.addHandler(double[].class, DoubleArrayFieldHandler.class);
        factory.addHandler(Double[].class, DoubleArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Double.class), DoubleArrayListFieldHandler.class);
        // Float
        factory.addHandler(Float.TYPE, FloatFieldHandler.class);
        factory.addHandler(Float.class, FloatWrapFieldHandler.class);
        factory.addHandler(float[].class, FloatArrayFieldHandler.class);
        factory.addHandler(Float[].class, FloatArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Float.class), FloatArrayListFieldHandler.class);
        // Integer
        factory.addHandler(Integer.TYPE, IntegerFieldHandler.class);
        factory.addHandler(Integer.class, IntegerWrapFieldHandler.class);
        factory.addHandler(int[].class, IntegerArrayFieldHandler.class);
        factory.addHandler(Integer[].class, IntegerArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Integer.class), IntegerArrayListFieldHandler.class);
        // Long
        factory.addHandler(Long.TYPE, LongFieldHandler.class);
        factory.addHandler(Long.class, LongWrapFieldHandler.class);
        factory.addHandler(long[].class, LongArrayFieldHandler.class);
        factory.addHandler(Long[].class, LongArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Long.class), LongArrayListFieldHandler.class);
        // Short
        factory.addHandler(Short.TYPE, ShortFieldHandler.class);
        factory.addHandler(Short.class, ShortWrapFieldHandler.class);
        factory.addHandler(short[].class, ShortArrayFieldHandler.class);
        factory.addHandler(Short[].class, ShortArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Short.class), ShortArrayListFieldHandler.class);
        // String
        factory.addHandler(String.class, StringFieldHandler.class);
        factory.addHandler(String[].class, StringArrayFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, String.class), StringArrayListFieldHandler.class);
    }

    public ParameterizedTypeFactory getParameterizedTypeFactory() {
        return get(ParameterizedTypeFactory.class, "default");
    }

    public EELoggerFactory getEELoggerFactory() {
        return get(EELoggerFactory.class, "default", new EELoggerFactory.EELoggerFactorySetup());
    }

    public <T extends Factory> T get(Class<? extends T> type) {
        return get(type, "default");
    }

    public <T extends Factory> T get(Class<? extends T> type, String name) {
        return get(type, name, null);
    }

    public <T extends Factory> T get(Class<? extends T> type, String name, FactorySetup<T> factorySetup) {
        if (!getFactories().containsKey(type)) {
            getFactories().put(type, new HashMap<String, Factory>());
        }
        HashMap<String, Factory> givenFactories = getFactories().get(type);

        if (!givenFactories.containsKey(name)) {
            try {
                Constructor<? extends T> constructor = type.getConstructor(String.class);
                T factory = constructor.newInstance(name);
                if (factorySetup != null) {
                    factorySetup.configFactory(factory);
                }
                givenFactories.put(name, factory);
            }
            catch (NoSuchMethodException e) {
                throw new FactoryCreationException("Unable to find Constructor in " + type, e);
            }
            catch (InvocationTargetException e) {
                throw new FactoryCreationException("An Exception happened trying to create the factory.", e);
            }
            catch (InstantiationException e) {
                throw new FactoryCreationException("The requested class can not have an instance created.", e);
            }
            catch (IllegalAccessException e) {
                throw new FactoryCreationException("Can not reach constructor.", e);
            }
        }
        return (T) givenFactories.get(name);
    }

    /**
     * Get the Logger factory that made the given {@code logger}. Will return {@link EELoggerFactory} returned from
     * {@link #getEELoggerFactory()} if the logger was not made by a factory made by this manager, or the Logger was
     * removed from the factory that made it.
     *
     * @param logger    The {@link EELogger} to find the {@link EELoggerFactory} for
     * @return The {@link EELoggerFactory} that made the {@code logger}; otherwise the {@link EELoggerFactory} from {@link #getEELoggerFactory()}
     */
    public EELoggerFactory getEELoggerFactoryForLogger(EELogger logger) {
        HashMap<String, Factory> factoryHashMap = getFactories().get(EELoggerFactory.class);
        for (Factory factory : factoryHashMap.values()) {
            if (((EELoggerFactory) factory).containsLogger(logger)) {
                return (EELoggerFactory) factory;
            }
        }
        return getEELoggerFactory();
    }

    protected HashMap<Class<? extends Factory>, HashMap<String, Factory>> getFactories() {
        return factories;
    }

}
