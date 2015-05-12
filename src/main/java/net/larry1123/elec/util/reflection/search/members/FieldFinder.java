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
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author Larry1123
 * @since 4/15/2015 - 3:17 AM
 */
public class FieldFinder implements MemberFinder<Field> {

    private final Class aClass;
    private final boolean makeAccessible;

    public FieldFinder(Class aClass) {
        this(aClass, false);
    }

    public FieldFinder(Class aClass, boolean makeAccessible) {
        this.aClass = aClass;
        this.makeAccessible = makeAccessible;
    }

    @Override
    public Field get(String name) throws MemberNotFoundException {
        try {
            return _get(name, null);
        }
        catch (NoSuchFieldException e) {
            throw new MemberNotFoundException(e);
        }
    }

    @Override
    public Field[] get(Class<? extends Annotation> annotationClass) {
        return _get(annotationClass, null);
    }

    @Override
    public Field[] get() {
        return _get(null);
    }

    /**
     * Get an array of Fields by what type they are
     *
     * @param type    What type to get
     * @return The array of Fields, will return an empty array if none found
     */
    public Field[] get(Type type) {
        return _get(type, null);
    }

    protected Field _get(String name, Class lastClass) throws NoSuchFieldException {
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        if (currentClass == null) {
            // This should throw a NoSuchMethodException for getTestMethod(String) to catch
            return lastClass != null ? lastClass.getDeclaredField(name) : null;
        }
        try {
            Field field = currentClass.getDeclaredField(name);
            makeAccessible(field);
            return field;
        }
        catch (NoSuchFieldException e) {
            // Send this to look in the superclass if any
            return _get(name, currentClass);
        }
    }

    protected Field[] _get(Class<? extends Annotation> annotationClass, Class lastClass) {
        Field[] fields = new Field[0];
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        for (Field field : currentClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotationClass)) {
                makeAccessible(field);
                fields = ArrayUtils.add(fields, field);
            }
        }
        if (currentClass.getSuperclass() != null) {
            fields = ArrayUtils.addAll(fields, _get(annotationClass, currentClass));
        }
        return fields;
    }

    protected Field[] _get(Class lastClass) {
        Field[] fields = new Field[0];
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        for (Field field : currentClass.getDeclaredFields()) {
            if (field.isAccessible() || isMakeAccessible()) {
                makeAccessible(field);
                fields = ArrayUtils.add(fields, field);
            }
        }
        if (currentClass.getSuperclass() != null) {
            fields = ArrayUtils.addAll(fields, _get(currentClass));
        }
        return fields;
    }

    protected Field[] _get(Type type, Class lastClass) {
        Field[] fields = new Field[0];
        Class currentClass = lastClass == null ? getaClass() : lastClass.getSuperclass();
        for (Field field : currentClass.getDeclaredFields()) {
            if (field.getGenericType().equals(type)) {
                makeAccessible(field);
                fields = ArrayUtils.add(fields, field);
            }
        }
        if (currentClass.getSuperclass() != null) {
            fields = ArrayUtils.addAll(fields, _get(currentClass));
        }
        return fields;
    }

    protected void makeAccessible(AccessibleObject field) {
        if (isMakeAccessible()) {
            field.setAccessible(true);
        }
    }

    public Class getaClass() {
        return aClass;
    }

    public boolean isMakeAccessible() {
        return makeAccessible;
    }

}
