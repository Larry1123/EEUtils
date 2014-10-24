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
package net.larry1123.elec.util.test.config.save;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.larry1123.elec.util.test.config.AbstractConfigTest;
import net.larry1123.elec.util.test.config.FieldNames;
import net.visualillusionsent.utils.PropertiesFile;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 2/1/14 - 5:09 AM
 */
public class ProtectedConfigSaveTest extends AbstractConfigTest {

    public ProtectedConfigSaveTest() {
        super("ProtectedConfigSaveTest", "target/tests/resources/save.cfg");
    }

    @Test
    public void protectedBooleanSave() {
        String fieldName = FieldNames.protectedBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        booleanTest(fieldName, testField);
    }

    @Test
    public void ProtectedBooleanSave() {
        String fieldName = FieldNames.ProtectedBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void protectedByteSave() {
        String fieldName = FieldNames.protectedByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteSave() {
        String fieldName = FieldNames.ProtectedByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteTest(fieldName, testField);
    }

    @Test
    public void protectedByteArraySave() {
        String fieldName = FieldNames.protectedByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteArraySave() {
        String fieldName = FieldNames.ProtectedByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayTest(fieldName, testField);
    }

    @Test
    public void protectedByteListSave() {
        String fieldName = FieldNames.ProtectedByteArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedCharacterSave() {
        String fieldName = FieldNames.protectedCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        characterTest(fieldName, testField);
    }

    @Test
    public void ProtectedCharacterSave() {
        String fieldName = FieldNames.ProtectedCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        CharacterTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleSave() {
        String fieldName = FieldNames.protectedDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleSave() {
        String fieldName = FieldNames.ProtectedDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleArraySave() {
        String fieldName = FieldNames.protectedDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleArraySave() {
        String fieldName = FieldNames.ProtectedDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleListSave() {
        String fieldName = FieldNames.ProtectedDoubleArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedFloatSave() {
        String fieldName = FieldNames.protectedFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatSave() {
        String fieldName = FieldNames.ProtectedFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatTest(fieldName, testField);
    }

    @Test
    public void protectedFloatArraySave() {
        String fieldName = FieldNames.protectedFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatArraySave() {
        String fieldName = FieldNames.ProtectedFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayTest(fieldName, testField);
    }

    @Test
    public void protectedFloatListSave() {
        String fieldName = FieldNames.ProtectedFloatArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedLongSave() {
        String fieldName = FieldNames.protectedLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongSave() {
        String fieldName = FieldNames.ProtectedLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongTest(fieldName, testField);
    }

    @Test
    public void protectedLongArraySave() {
        String fieldName = FieldNames.protectedLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongArraySave() {
        String fieldName = FieldNames.ProtectedLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayTest(fieldName, testField);
    }

    @Test
    public void protectedLongListSave() {
        String fieldName = FieldNames.ProtectedLongArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerSave() {
        String fieldName = FieldNames.protectedInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerSave() {
        String fieldName = FieldNames.ProtectedInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerArraySave() {
        String fieldName = FieldNames.protectedIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerArraySave() {
        String fieldName = FieldNames.ProtectedIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerListSave() {
        String fieldName = FieldNames.ProtectedIntegerArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedShortSave() {
        String fieldName = FieldNames.protectedShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortTest(fieldName, testField);
    }

    @Test
    public void ProtectedShortSave() {
        String fieldName = FieldNames.ProtectedShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void protectedShortArraySave() {
        String fieldName = FieldNames.protectedShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedShortArraySave() {
        String fieldName = FieldNames.ProtectedShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayTest(fieldName, testField);
    }

    @Test
    public void protectedShortListSave() {
        String fieldName = FieldNames.ProtectedShortArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedStringSave() {
        String fieldName = FieldNames.ProtectedString.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringTest(fieldName, testField);
    }

    @Test
    public void protectedStringArraySave() {
        String fieldName = FieldNames.ProtectedStringArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayTest(fieldName, testField);
    }

    @Test
    public void protectedStringListSave() {
        String fieldName = FieldNames.ProtectedStringArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayListTest(fieldName, testField);
    }

    @Override
    protected ConfigBase createTestConfigBase(final PropertiesFile file) {
        return new TestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.save();
        getPropertiesFile().save();
    }

}

