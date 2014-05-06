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
package net.larry1123.elec.util.relection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author l4mRh4X0r
 * @author Larry1123
 * @since 4/29/2014 - 4:59 AM
 */
public class ParameterizedTypeImpl implements ParameterizedType {

    private final Type rawType;
    private final Type ownerType;
    private final Type[] typeArguments;

    public ParameterizedTypeImpl(Type rawType, Type... typeArguments) {
        this.rawType = rawType;
        this.ownerType = null;
        this.typeArguments = typeArguments;
    }

    public ParameterizedTypeImpl(Type rawType, Type ownerType, Type[] typeArguments) {
        this.rawType = rawType;
        this.ownerType = ownerType;
        this.typeArguments = typeArguments;
    }

    public Type[] getActualTypeArguments() {
        return this.typeArguments.clone();
    }

    public Type getRawType() {
        return this.rawType;
    }

    public Type getOwnerType() {
        return this.ownerType;
    }

    public boolean equals(Object o) {
        return o instanceof ParameterizedType && (rawType == null ? ((ParameterizedType) o).getRawType() == null : rawType.equals(((ParameterizedType) o).getRawType())) && (ownerType == null ? ((ParameterizedType) o).getOwnerType() == null : ownerType.equals(((ParameterizedType) o).getOwnerType())) && (Arrays.equals(typeArguments, ((ParameterizedType) o).getActualTypeArguments()));
    }
}