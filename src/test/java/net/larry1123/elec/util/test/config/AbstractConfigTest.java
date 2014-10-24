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
import net.larry1123.elec.util.config.ConfigField;
import net.larry1123.elec.util.test.AbstractTestClass;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 10/23/2014 - 7:21 PM
 */
public abstract class AbstractConfigTest extends AbstractTestClass {

    private final String path;
    private final PropertiesFile propertiesFile;
    private final ConfigBase configBase;

    public AbstractConfigTest(String name, String path) {
        super(name);
        this.path = path;
        propertiesFile = new PropertiesFile(getPath());
        configBase = createTestConfigBase(getPropertiesFile());
    }

    public void assertFailFieldError(String fieldName) {
        Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
    }

    public void booleanTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue((getPropertiesFile().getBoolean(fieldName) == testField.getBoolean(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void BooleanTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue((getPropertiesFile().getBoolean(fieldName) == (Boolean) testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void byteTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue((getPropertiesFile().getByte(fieldName) == testField.getByte(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ByteTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue((getPropertiesFile().getByte(fieldName) == (Byte) testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void byteArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ByteArrayTest(String fieldName, Field testField) {
        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ByteArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) testField.get(getConfigBase())).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void characterTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getCharacter(fieldName) == testField.getChar(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void CharacterTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getCharacter(fieldName) == (Character) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void doubleTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getDouble(fieldName) == testField.getDouble(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void DoubleTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getDouble(fieldName) == (Double) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void doubleArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void DoubleArrayTest(String fieldName, Field testField) {
        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void DoubleArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) testField.get(getConfigBase())).toArray(new Double[((ArrayList<Double>) testField.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void floatTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getFloat(fieldName) == testField.getFloat(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void FloatTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getFloat(fieldName) == (Float) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void floatArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void FloatArrayTest(String fieldName, Field testField) {
        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void FloatArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) testField.get(getConfigBase())).toArray(new Float[((ArrayList<Float>) testField.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void longTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getLong(fieldName) == testField.getLong(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void LongTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getLong(fieldName) == (Long) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void longArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void LongArrayTest(String fieldName, Field testField) {
        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void LongArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) testField.get(getConfigBase())).toArray(new Long[((ArrayList<Long>) testField.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void integerTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getInt(fieldName) == testField.getInt(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void IntegerTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getInt(fieldName) == (Integer) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void integerArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void IntegerArrayTest(String fieldName, Field testField) {
        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void IntegerArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) testField.get(getConfigBase())).toArray(new Integer[((ArrayList<Integer>) testField.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void shortTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getShort(fieldName) == testField.getShort(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ShortTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getShort(fieldName) == (Short) testField.get(getConfigBase()));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void shortArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ShortArrayTest(String fieldName, Field testField) {
        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) testField.get(getConfigBase()));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void ShortArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) testField.get(getConfigBase())).toArray(new Short[((ArrayList<Short>) testField.get(getConfigBase())).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void StringTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(getPropertiesFile().getString(fieldName).equals(testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void StringArrayTest(String fieldName, Field testField) {
        try {
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getStringArray(fieldName), testField.get(getConfigBase())));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    public void StringArrayListTest(String fieldName, Field testField) {
        try {
            //noinspection unchecked,unchecked
            String[] testFieldValue = ((ArrayList<String>) testField.get(getConfigBase())).toArray(new String[((ArrayList<String>) testField.get(getConfigBase())).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(getPropertiesFile().getStringArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            assertFailFieldError(fieldName);
        }
    }

    protected void assertTest(String fieldName) throws NoSuchMethodException {
        Field field = getField(getConfigBase(), fieldName);
        Type type = field.getGenericType();
        Method method = getTestMethod(fieldName);
        method.setAccessible(true);
        try {
            method.invoke(this, fieldName, field);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected Method getTestMethod(String fieldName) throws NoSuchMethodException {
        Class abstractConfigTestClass = AbstractConfigTest.class;
        String methodName = fieldName + "Test";
        methodName = methodName.replace("public", "");
        methodName = methodName.replace("Public", "");
        methodName = methodName.replace("protected", "");
        methodName = methodName.replace("Protected", "");
        if (fieldName.charAt(0) == 'p') {
            methodName = (methodName.charAt(0) + "").toLowerCase() + methodName.substring(1);
        }
        return abstractConfigTestClass.getDeclaredMethod(methodName, String.class, Field.class);
    }

    protected Field getField(Object ob, String fieldName) {
        return getField(ob, fieldName, null);
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
            Assert.fail("Can't get field, " + fieldName + ", from ConfigBase!");
            return null;
        }
    }

    protected ArrayList<Field> getFields() {
        return getFields(configBase.getClass());
    }

    protected ArrayList<Field> getFields(Class thisClass) {
        ArrayList<Field> fields = new ArrayList<Field>();
        while (thisClass != null) {
            for (Field field : thisClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(ConfigField.class)) {
                    fields.add(field);
                }
            }
            thisClass = thisClass.getSuperclass();
        }
        return fields;
    }

    protected abstract ConfigBase createTestConfigBase(PropertiesFile file);

    public String getPath() {
        return path;
    }

    public PropertiesFile getPropertiesFile() {
        return propertiesFile;
    }

    public ConfigBase getConfigBase() {
        return configBase;
    }

}
