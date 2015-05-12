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
package net.larry1123.elec.util.test.config;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.reflection.search.members.FieldFinder;
import net.larry1123.elec.util.reflection.search.members.MemberNotFoundException;
import net.larry1123.elec.util.reflection.search.members.MethodFinder;
import net.larry1123.elec.util.test.AbstractTest;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 10/23/2014 - 7:21 PM
 */
public abstract class AbstractConfigTest extends AbstractTest {

    private final MethodFinder methodFinder = new MethodFinder(this.getClass(), true, String.class, Field.class);
    private final FieldFinder fieldFinder;

    private Field field;
    private String fieldName;
    private PropertiesFile propertiesFile;
    private ConfigBase configBase;

    @Before
    public void initialize() {
        fieldName = getTestName().getMethodName();
        field = getField(fieldName);
    }

    public AbstractConfigTest(String name) {
        super(name);
        try {
            propertiesFile = new PropertiesFile(getFile());
        }
        catch (IOException e) {
            assumeNoThrowableField("Unable to get the file!", e);
        }
        configBase = createTestConfigBase(getPropertiesFile());
        fieldFinder = new FieldFinder(getConfigBase().getClass(), true);
    }

    public void booleanTest(String fieldName, Field field) {
        try {
            Assert.assertTrue((getPropertiesFile().getBoolean(fieldName) == field.getBoolean(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void BooleanTest(String fieldName, Field field) {
        try {
            Assert.assertTrue((getPropertiesFile().getBoolean(fieldName) == (Boolean) field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void byteTest(String fieldName, Field field) {
        try {
            Assert.assertTrue((getPropertiesFile().getByte(fieldName) == field.getByte(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ByteTest(String fieldName, Field field) {
        try {
            Assert.assertTrue((getPropertiesFile().getByte(fieldName) == (Byte) field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void byteArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ByteArrayTest(String fieldName, Field field) {
        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ByteArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) field.get(getConfigBase())).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void characterTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getCharacter(fieldName) == field.getChar(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void CharacterTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getCharacter(fieldName) == (Character) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void doubleTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getDouble(fieldName) == field.getDouble(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void DoubleTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getDouble(fieldName) == (Double) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void doubleArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void DoubleArrayTest(String fieldName, Field field) {
        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void DoubleArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) field.get(getConfigBase())).toArray(new Double[((ArrayList<Double>) field.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void floatTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getFloat(fieldName) == field.getFloat(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void FloatTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getFloat(fieldName) == (Float) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void floatArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void FloatArrayTest(String fieldName, Field field) {
        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void FloatArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) field.get(getConfigBase())).toArray(new Float[((ArrayList<Float>) field.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void longTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getLong(fieldName) == field.getLong(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void LongTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getLong(fieldName) == (Long) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void longArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void LongArrayTest(String fieldName, Field field) {
        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void LongArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) field.get(getConfigBase())).toArray(new Long[((ArrayList<Long>) field.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void integerTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getInt(fieldName) == field.getInt(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void IntegerTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getInt(fieldName) == (Integer) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void integerArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void IntegerArrayTest(String fieldName, Field field) {
        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void IntegerArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) field.get(getConfigBase())).toArray(new Integer[((ArrayList<Integer>) field.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void shortTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getShort(fieldName) == field.getShort(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ShortTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getShort(fieldName) == (Short) field.get(getConfigBase()));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void shortArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ShortArrayTest(String fieldName, Field field) {
        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) field.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void ShortArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) field.get(getConfigBase())).toArray(new Short[((ArrayList<Short>) field.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void StringTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(getPropertiesFile().getString(fieldName).equals(field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void StringArrayTest(String fieldName, Field field) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getStringArray(fieldName), field.get(getConfigBase())));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    public void StringArrayListTest(String fieldName, Field field) {
        try {
            //noinspection unchecked, unchecked
            String[] testFieldValue = ((ArrayList<String>) field.get(getConfigBase())).toArray(new String[((ArrayList<String>) field.get(getConfigBase())).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getStringArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowableField(fieldName, illegalAccessException);
        }
    }

    protected void assertTest(String fieldName, Field field) {
        Method method = getTestMethod(fieldName);
        try {
            method.invoke(this, fieldName, field);
        }
        catch (IllegalAccessException illegalAccessException) {
            assumeNoThrowable(getName() + " could not access " + method.getName() + " test Method.", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            assumeNoThrowable(getName() + " had an error thrown trying to use the " + method.getName() + " test Method.", invocationTargetException.getCause());
        }
    }

    protected Method getTestMethod(String fieldName) {
        String methodName = fieldName + "Test";
        methodName = methodName.replace("public", "");
        methodName = methodName.replace("Public", "");
        methodName = methodName.replace("protected", "");
        methodName = methodName.replace("Protected", "");
        if (fieldName.charAt(0) == 'p') {
            methodName = (methodName.charAt(0) + "").toLowerCase() + methodName.substring(1);
        }
        try {
            return getMethodFinder().get(methodName);
        }
        catch (MemberNotFoundException e) {
            assumeNoThrowable(getName() + " does not support " + fieldName + " test. Was looking for method " + methodName + " in " + this.getClass() + " and it's superclasses. Test " + getTestName().getMethodName(), e);
            throw new Error("Throw error as this should have never been reached");
        }
    }

    protected Method getTestMethod(String methodName, Class<?> lastClass) throws NoSuchMethodException {
        Class<?> currentClass = lastClass == null ? this.getClass() : lastClass.getSuperclass();
        if (currentClass == null) {
            // This should throw a NoSuchMethodException for getTestMethod(String) to catch
            return lastClass != null ? lastClass.getDeclaredMethod(methodName, String.class, Field.class) : null;
        }
        try {
            //noinspection ConstantConditions
            Method ret = currentClass.getDeclaredMethod(methodName, String.class, Field.class);
            ret.setAccessible(true);
            return ret;
        }
        catch (NoSuchMethodException e) {
            // Send this to look in the superclass if any
            return getTestMethod(methodName, currentClass);
        }
    }

    protected Field getField(String fieldName) {
        try {
            return getFieldFinder().get(fieldName);
        }
        catch (MemberNotFoundException e) {
            assumeNoThrowableField(fieldName, e);
            throw new Error("Throw error as this should have never been reached");
        }
    }

    protected void assertFailFieldThrowable(String fieldName, Throwable throwable) {
        assertFailWithThrowable(getName() + " could not read the field " + fieldName + " from the ConfigBase " + getConfigBase().getClass().getSimpleName() + " or it's superclasses. Test " + getTestName().getMethodName(), throwable);
    }

    protected void assumeNoThrowableField(String fieldName, Throwable throwable) {
        assumeNoThrowable(getName() + " could not read the field " + fieldName + " from the ConfigBase " + getConfigBase().getClass().getSimpleName() + " or it's superclasses. Test " + getTestName().getMethodName(), throwable);
    }

    protected abstract ConfigBase createTestConfigBase(PropertiesFile file);

    protected abstract File getFile() throws IOException;

    public PropertiesFile getPropertiesFile() {
        return propertiesFile;
    }

    public ConfigBase getConfigBase() {
        return configBase;
    }

    public FieldFinder getFieldFinder() {
        return fieldFinder;
    }

    public MethodFinder getMethodFinder() {
        return methodFinder;
    }

    public Field getField() {
        return field;
    }

    public String getFieldName() {
        return fieldName;
    }

}
