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
import net.larry1123.elec.util.config.fieldhanders.bytes.*;
import net.larry1123.elec.util.config.fieldhanders.character.CharacterFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.doubles.*;
import net.larry1123.elec.util.config.fieldhanders.floats.*;
import net.larry1123.elec.util.config.fieldhanders.intergers.*;
import net.larry1123.elec.util.config.fieldhanders.longs.*;
import net.larry1123.elec.util.config.fieldhanders.shorts.*;
import net.larry1123.elec.util.config.fieldhanders.strings.StringArrayListFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.booleans.BooleanWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.character.CharacterWrapFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.strings.StringArrayFieldHandler;
import net.larry1123.elec.util.config.fieldhanders.strings.StringFieldHandler;

import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 5/2/2014 - 3:04 AM
 */
public class FactoryManager {

    protected static final FactoryManager factoryManager = new FactoryManager();

    public static FactoryManager getFactoryManager() {
        return factoryManager;
    }

    protected FieldHandlerFactory mainFieldHandlerFactory;
    protected ParameterizedTypeFactory parameterizedTypeFactory;
    protected EELoggerFactory eeLoggerFactory;

    private FactoryManager() {}

    public FieldHandlerFactory getMainFieldHandlerFactory() {
        if (mainFieldHandlerFactory == null) {
            mainFieldHandlerFactory = new FieldHandlerFactory();
            addDefaultHandlers(mainFieldHandlerFactory);
        }
        return mainFieldHandlerFactory;
    }

    public FieldHandlerFactory getNewFieldHandlerFactory() {
        return new FieldHandlerFactory();
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
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Byte.class), ByteArrayListFieldHandler.class);
        // Character
        factory.addHandler(Character.TYPE, CharacterFieldHandler.class);
        factory.addHandler(Character.class, CharacterWrapFieldHandler.class);
        // Double
        factory.addHandler(Double.TYPE, DoubleFieldHandler.class);
        factory.addHandler(Double.class, DoubleWrapFieldHandler.class);
        factory.addHandler(double[].class, DoubleArrayFieldHandler.class);
        factory.addHandler(Double[].class, DoubleArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Double.class), DoubleArrayListFieldHandler.class);
        // Float
        factory.addHandler(Float.TYPE, FloatFieldHandler.class);
        factory.addHandler(Float.class, FloatWrapFieldHandler.class);
        factory.addHandler(float[].class, FloatArrayFieldHandler.class);
        factory.addHandler(Float[].class, FloatArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Float.class), FloatArrayListFieldHandler.class);
        // Integer
        factory.addHandler(Integer.TYPE, IntegerFieldHandler.class);
        factory.addHandler(Integer.class, IntegerWrapFieldHandler.class);
        factory.addHandler(int[].class, IntegerArrayFieldHandler.class);
        factory.addHandler(Integer[].class, IntegerArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Integer.class), IntegerArrayListFieldHandler.class);
        // Long
        factory.addHandler(Long.TYPE, LongFieldHandler.class);
        factory.addHandler(Long.class, LongWrapFieldHandler.class);
        factory.addHandler(long[].class, LongArrayFieldHandler.class);
        factory.addHandler(Long[].class, LongArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Long.class), LongArrayListFieldHandler.class);
        // Short
        factory.addHandler(Short.TYPE, ShortFieldHandler.class);
        factory.addHandler(Short.class, ShortWrapFieldHandler.class);
        factory.addHandler(short[].class, ShortArrayFieldHandler.class);
        factory.addHandler(Short[].class, ShortArrayWrapFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, Short.class), ShortArrayListFieldHandler.class);
        // String
        factory.addHandler(String.class, StringFieldHandler.class);
        factory.addHandler(String[].class, StringArrayFieldHandler.class);
        factory.addHandler(getParameterizedTypeFactory().MakeParameterizedType(ArrayList.class, String.class), StringArrayListFieldHandler.class);
    }

    public ParameterizedTypeFactory getParameterizedTypeFactory() {
        if (parameterizedTypeFactory == null) {
            parameterizedTypeFactory = new ParameterizedTypeFactory();
        }
        return parameterizedTypeFactory;
    }

    public EELoggerFactory getEELoggerFactory() {
        if (eeLoggerFactory == null) {
            eeLoggerFactory = new EELoggerFactory();
        }
        return eeLoggerFactory;
    }

}
