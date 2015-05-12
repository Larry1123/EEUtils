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

import net.larry1123.elec.util.reflection.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Larry1123
 * @since 5/2/2014 - 4:20 AM
 */
public class ParameterizedTypeFactory extends Factory {

    public ParameterizedTypeFactory() {
        this("ParameterizedTypeFactory" + System.nanoTime());
    }

    public ParameterizedTypeFactory(String name) {
        super(name);
    }

    /**
     * Creates a ParameterizedTypeImpl for the given passed types.
     * To create a ParameterizedType for <code>ArrayList<\String></code>
     * <code>MakeParameterizedType(Arraylist.class, String.class)</code>
     *
     * @param rawType The {@code Type} object representing the class or interface that declared this type.
     * @param typeArguments An array of {@code Type} objects representing the actual type arguments to this type.
     *
     * @return A ParameterizedType that will equal one created from reflection
     *
     * @deprecated {@link #makeParameterizedType(Class, Type...)}
     */
    @Deprecated
    public ParameterizedType MakeParameterizedType(Class<?> rawType, Type... typeArguments) {
        return makeParameterizedType(rawType, typeArguments);
    }

    /**
     * Creates a ParameterizedTypeImpl for the given passed types.
     * To create a ParameterizedType for <code>ArrayList<\String></code>
     * <code>MakeParameterizedType(Arraylist.class, String.class)</code>
     *
     * @param rawType The {@code Type} object representing the class or interface that declared this type.
     * @param typeArguments An array of {@code Type} objects representing the actual type arguments to this type.
     *
     * @return A ParameterizedType that will equal one created from reflection
     */
    public ParameterizedType makeParameterizedType(Class<?> rawType, Type... typeArguments) {
        return new ParameterizedTypeImpl(rawType, typeArguments);
    }

    /**
     * Creates a ParameterizedTypeImpl for the given passed types.
     * To create a ParameterizedType for <code>ArrayList<\String></code>
     * <code>MakeParameterizedType(Arraylist.class, String.class)</code>
     *
     * @param rawType The {@code Type} object representing the class or interface that declared this type.
     * @param ownerType A {@code Type} object representing the type that this type is a member of.
     * @param typeArguments An array of {@code Type} objects representing the actual type arguments to this type.
     *
     * @return A ParameterizedType that will equal one created from reflection
     *
     * @deprecated {@link #makeParameterizedType(Class, Type, Type[])}
     */
    @Deprecated
    public ParameterizedType MakeParameterizedType(Class<?> rawType, Type ownerType, Type[] typeArguments) {
        return makeParameterizedType(rawType, ownerType, typeArguments);
    }

    /**
     * Creates a ParameterizedTypeImpl for the given passed types.
     * To create a ParameterizedType for <code>ArrayList<\String></code>
     * <code>MakeParameterizedType(Arraylist.class, String.class)</code>
     *
     * @param rawType The {@code Type} object representing the class or interface that declared this type.
     * @param ownerType A {@code Type} object representing the type that this type is a member of.
     * @param typeArguments An array of {@code Type} objects representing the actual type arguments to this type.
     *
     * @return A ParameterizedType that will equal one created from reflection
     */
    public ParameterizedType makeParameterizedType(Class<?> rawType, Type ownerType, Type[] typeArguments) {
        return new ParameterizedTypeImpl(rawType, ownerType, typeArguments);
    }

}
