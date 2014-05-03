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

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Larry1123
 * @since 5/2/2014 - 4:20 AM
 */
public class ParameterizedTypeImplFactory {

    public ParameterizedType MakeTypeImpl(Class<?> rawType, Type... typeArguments) {
        return ParameterizedTypeImpl.make(rawType, typeArguments, null);
    }

    public ParameterizedType MakeTypeImpl(Class<?> rawType, Type ownerType, Type[] typeArguments) {
        return ParameterizedTypeImpl.make(rawType, typeArguments, ownerType);
    }

}
