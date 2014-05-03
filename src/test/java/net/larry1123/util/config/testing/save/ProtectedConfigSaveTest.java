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
package net.larry1123.util.config.testing.save;

import net.larry1123.util.config.fieldhanders.FieldHandler;
import net.larry1123.util.config.testing.TestConfigFile;
import net.larry1123.util.factorys.FactoryManager;
import net.larry1123.util.factorys.FieldHandlerFactory;
import net.visualillusionsent.utils.PropertiesFile;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 2/1/14 - 5:09 AM
 */
public class ProtectedConfigSaveTest {

    protected final String savePath = "target/tests/resources/save.cfg";
    protected PropertiesFile savePropertiesFile = new PropertiesFile(savePath);
    protected TestConfigFile configFile = createTestConfigFile(savePropertiesFile);
    protected final FieldHandlerFactory factory = FactoryManager.getFactoryManager().getMainFieldHandlerFactory();

    @Test
    public void protectedBooleanSave() {
        String fieldName = "protectedBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getBoolean(fieldName) == testField.getBoolean(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedBooleanSave() {
        String fieldName = "ProtectedBoolean";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getBoolean(fieldName) == (Boolean) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteSave() {
        String fieldName = "protectedByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getByte(fieldName) == testField.getByte(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedByteSave() {
        String fieldName = "ProtectedByte";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue((savePropertiesFile.getByte(fieldName) == (Byte) testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteArraySave() {
        String fieldName = "protectedByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedByteArraySave() {
        String fieldName = "ProtectedByteArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            byte[] testFieldValue = ArrayUtils.toPrimitive((Byte[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedByteListSave() {
        String fieldName = "protectedByteList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked
            byte[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Byte>) testField.get(configFile)).toArray(ArrayUtils.EMPTY_BYTE_OBJECT_ARRAY));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getByteArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedCharacterSave() {
        String fieldName = "protectedCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getCharacter(fieldName) == testField.getChar(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedCharacterSave() {
        String fieldName = "ProtectedCharacter";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getCharacter(fieldName) == (Character) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleSave() {
        String fieldName = "protectedDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getDouble(fieldName) == testField.getDouble(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedDoubleSave() {
        String fieldName = "ProtectedDouble";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getDouble(fieldName) == (Double) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleArraySave() {
        String fieldName = "protectedDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedDoubleArraySave() {
        String fieldName = "ProtectedDoubleArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            double[] testFieldValue = ArrayUtils.toPrimitive((Double[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedDoubleListSave() {
        String fieldName = "protectedDoubleList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            double[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Double>) testField.get(configFile)).toArray(new Double[((ArrayList<Double>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getDoubleArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatSave() {
        String fieldName = "protectedFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getFloat(fieldName) == testField.getFloat(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedFloatSave() {
        String fieldName = "ProtectedFloat";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getFloat(fieldName) == (Float) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatArraySave() {
        String fieldName = "protectedFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedFloatArraySave() {
        String fieldName = "ProtectedFloatArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            float[] testFieldValue = ArrayUtils.toPrimitive((Float[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedFloatListSave() {
        String fieldName = "protectedFloatList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            float[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Float>) testField.get(configFile)).toArray(new Float[((ArrayList<Float>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getFloatArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongSave() {
        String fieldName = "protectedLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getLong(fieldName) == testField.getLong(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedLongSave() {
        String fieldName = "ProtectedLong";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getLong(fieldName) == (Long) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongArraySave() {
        String fieldName = "protectedLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedLongArrayArraySave() {
        String fieldName = "ProtectedLongArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            long[] testFieldValue = ArrayUtils.toPrimitive((Long[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedLongListSave() {
        String fieldName = "protectedLongList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            long[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Long>) testField.get(configFile)).toArray(new Long[((ArrayList<Long>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getLongArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerSave() {
        String fieldName = "protectedInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getInt(fieldName) == testField.getInt(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedIntegerSave() {
        String fieldName = "ProtectedInteger";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getInt(fieldName) == (Integer) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerArraySave() {
        String fieldName = "protectedIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedIntegerArraySave() {
        String fieldName = "ProtectedIntegerArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            int[] testFieldValue = ArrayUtils.toPrimitive((Integer[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedIntegerListSave() {
        String fieldName = "protectedIntegerList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            int[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Integer>) testField.get(configFile)).toArray(new Integer[((ArrayList<Integer>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getIntArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortSave() {
        String fieldName = "protectedShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getShort(fieldName) == testField.getShort(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedShortSave() {
        String fieldName = "ProtectedShort";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getShort(fieldName) == (Short) testField.get(configFile));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortArraySave() {
        String fieldName = "protectedShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void ProtectedShortArraySave() {
        String fieldName = "ProtectedShortArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            short[] testFieldValue = ArrayUtils.toPrimitive((Short[]) testField.get(configFile));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedShortListSave() {
        String fieldName = "protectedShortList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            short[] testFieldValue = ArrayUtils.toPrimitive(((ArrayList<Short>) testField.get(configFile)).toArray(new Short[((ArrayList<Short>) testField.get(configFile)).size()]));
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getShortArray(fieldName), testFieldValue));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringSave() {
        String fieldName = "protectedString";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(savePropertiesFile.getString(fieldName).equals(testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringArraySave() {
        String fieldName = "protectedStringArray";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getStringArray(fieldName), testField.get(configFile)));
        }
        catch (IllegalAccessException e) {
            Assert.fail("Well seems that we could not read the field " + fieldName + " -.-");
        }
    }

    @Test
    public void protectedStringListSave() {
        String fieldName = "protectedStringList";
        Field testField = getField(configFile, fieldName, null);

        doLogic(fieldName, testField);

        try {
            //noinspection unchecked,unchecked
            String[] testFieldValue = ((ArrayList<String>) testField.get(configFile)).toArray(new String[((ArrayList<String>) testField.get(configFile)).size()]);
            Assert.assertTrue(ArrayUtils.isEquals(savePropertiesFile.getStringArray(fieldName), testFieldValue));
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

        handler.save();
        savePropertiesFile.save();
    }

    protected TestConfigFile createTestConfigFile(final PropertiesFile file) {
        return new TestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}

