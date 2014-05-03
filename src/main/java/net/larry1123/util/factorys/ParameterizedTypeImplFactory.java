package net.larry1123.util.factorys;

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
