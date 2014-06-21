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
package net.larry1123.elec.util.config.testing.load;

import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.larry1123.elec.util.config.testing.LoadingTestConfigFile;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 6/20/2014 - 10:36 PM
 */
public class ProtectedConfigLoadTest {

    protected final String loadPath = "target/test-classes/load.cfg";
    protected PropertiesFile loadPropertiesFile = new PropertiesFile(loadPath);
    protected LoadingTestConfigFile configFile = createTestConfigFile(loadPropertiesFile);
    protected final FieldHandlerFactory factory = FactoryManager.getFactoryManager().getMainFieldHandlerFactory();

    @Test
    public void protectedBooleanLoad() {
        String fieldName = "protectedBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getBoolean(fieldName) == testField.getBoolean(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedBooleanLoad() {
        String fieldName = "ProtectedBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getBoolean(fieldName) == (Boolean) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteLoad() {
        String fieldName = "protectedByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getByte(fieldName) == testField.getByte(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedByteLoad() {
        String fieldName = "ProtectedByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((loadPropertiesFile.getByte(fieldName) == (Byte) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteArrayLoad() {
        String fieldName = "protectedByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedByteArrayLoad() {
        String fieldName = "ProtectedByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteListLoad() {
        String fieldName = "protectedByteList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) testField.get(configFile)).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedCharacterLoad() {
        String fieldName = "protectedCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getCharacter(fieldName) == testField.getChar(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedCharacterLoad() {
        String fieldName = "ProtectedCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getCharacter(fieldName) == (Character) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleLoad() {
        String fieldName = "protectedDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getDouble(fieldName) == testField.getDouble(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedDoubleLoad() {
        String fieldName = "ProtectedDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getDouble(fieldName) == (Double) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleArrayLoad() {
        String fieldName = "protectedDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedDoubleArrayLoad() {
        String fieldName = "ProtectedDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleListLoad() {
        String fieldName = "protectedDoubleList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) testField.get(configFile)).toArray(new Double[((ArrayList<Double>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatLoad() {
        String fieldName = "protectedFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getFloat(fieldName) == testField.getFloat(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedFloatLoad() {
        String fieldName = "ProtectedFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getFloat(fieldName) == (Float) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatArrayLoad() {
        String fieldName = "protectedFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedFloatArrayLoad() {
        String fieldName = "ProtectedFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatListLoad() {
        String fieldName = "protectedFloatList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) testField.get(configFile)).toArray(new Float[((ArrayList<Float>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongLoad() {
        String fieldName = "protectedLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getLong(fieldName) == testField.getLong(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedLongLoad() {
        String fieldName = "ProtectedLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getLong(fieldName) == (Long) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongArrayLoad() {
        String fieldName = "protectedLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedLongArrayArrayLoad() {
        String fieldName = "ProtectedLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongListLoad() {
        String fieldName = "protectedLongList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) testField.get(configFile)).toArray(new Long[((ArrayList<Long>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerLoad() {
        String fieldName = "protectedInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getInt(fieldName) == testField.getInt(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedIntegerLoad() {
        String fieldName = "ProtectedInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getInt(fieldName) == (Integer) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerArrayLoad() {
        String fieldName = "protectedIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedIntegerArrayLoad() {
        String fieldName = "ProtectedIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerListLoad() {
        String fieldName = "protectedIntegerList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) testField.get(configFile)).toArray(new Integer[((ArrayList<Integer>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortLoad() {
        String fieldName = "protectedShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getShort(fieldName) == testField.getShort(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedShortLoad() {
        String fieldName = "ProtectedShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getShort(fieldName) == (Short) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortArrayLoad() {
        String fieldName = "protectedShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedShortArrayLoad() {
        String fieldName = "ProtectedShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortListLoad() {
        String fieldName = "protectedShortList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) testField.get(configFile)).toArray(new Short[((ArrayList<Short>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringLoad() {
        String fieldName = "protectedString";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(loadPropertiesFile.getString(fieldName).equals(testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringArrayLoad() {
        String fieldName = "protectedStringArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getStringArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringListLoad() {
        String fieldName = "protectedStringList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            String[] testFieldValue = ((ArrayList<String>) testField.get(configFile)).toArray(new String[((ArrayList<String>) testField.get(configFile)).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(loadPropertiesFile.getStringArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
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

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = factory.createFieldHandler(testField.getGenericType(), testField, configFile);

        handler.load();
    }

    protected LoadingTestConfigFile createTestConfigFile(final PropertiesFile file) {
        return new LoadingTestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
