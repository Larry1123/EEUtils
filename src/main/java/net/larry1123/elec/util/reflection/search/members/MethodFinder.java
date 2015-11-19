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
package net.larry1123.elec.util.reflection.search.members;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Larry1123
 * @since 4/15/2015 - 3:59 AM
 */
public class MethodFinder extends AbstractAccessibleObjectMemberFinder<Method> {

    private final Class aClass;
    private final Class[] parameters;

    public MethodFinder(Class aClass) {
        this(aClass, false);
    }

    public MethodFinder(Class aClass, Class... parameters) {
        this(aClass, false, parameters);
    }

    public MethodFinder(Class aClass, boolean makeAccessible) {
        this(aClass, makeAccessible, null);
    }

    public MethodFinder(Class aClass, boolean makeAccessible, Class... parameters) {
        super(makeAccessible);
        this.aClass = aClass;
        this.parameters = parameters;
    }

    @Override
    public Method get(String name) throws MemberNotFoundException {
        try {
            return _get(name, null);
        }
        catch (NoSuchMethodException e) {
            throw new MemberNotFoundException(e);
        }
    }

    @Override
    public Method[] get(Class<? extends Annotation> annotationClass) {
        return _get(annotationClass, null);
    }

    @Override
    public Method[] get() {
        return _get(null);
    }

    protected Method _get(String name, Class lastClass) throws NoSuchMethodException {
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        if (currentClass == null) {
            // This should throw a NoSuchMethodException for get(String) to catch
            return lastClass != null ? lastClass.getDeclaredMethod(name, parameters) : null;
        }
        try {
            Method ret = currentClass.getDeclaredMethod(name, parameters);
            makeAccessible(ret);
            return ret;
        }
        catch (NoSuchMethodException e) {
            // Send this to look in the superclass if any
            return _get(name, currentClass);
        }
    }

    protected Method[] _get(Class<? extends Annotation> annotationClass, Class lastClass) {
        Method[] methods = new Method[0];
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        for (Method method : currentClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotationClass)) {
                makeAccessible(method);
                methods = ArrayUtils.add(methods, method);
            }
        }
        if (currentClass.getSuperclass() != null) {
            methods = ArrayUtils.addAll(methods, _get(annotationClass, currentClass));
        }
        return methods;
    }

    protected Method[] _get(Class lastClass) {
        Method[] methods = new Method[0];
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        for (Method method : currentClass.getDeclaredMethods()) {
            if (method.isAccessible() || isMakeAccessible()) {
                makeAccessible(method);
                methods = ArrayUtils.add(methods, method);
            }
        }
        if (currentClass.getSuperclass() != null) {
            methods = ArrayUtils.addAll(methods, _get(currentClass));
        }
        return methods;
    }

    public Class getaClass() {
        return aClass;
    }

}
