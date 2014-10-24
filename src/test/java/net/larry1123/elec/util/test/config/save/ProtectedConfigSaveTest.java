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
        String fieldName = "protectedBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        booleanTest(fieldName, testField);
    }

    @Test
    public void ProtectedBooleanSave() {
        String fieldName = "ProtectedBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void protectedByteSave() {
        String fieldName = "protectedByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteSave() {
        String fieldName = "ProtectedByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteTest(fieldName, testField);
    }

    @Test
    public void protectedByteArraySave() {
        String fieldName = "protectedByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteArraySave() {
        String fieldName = "ProtectedByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayTest(fieldName, testField);
    }

    @Test
    public void protectedByteListSave() {
        String fieldName = "protectedByteList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedCharacterSave() {
        String fieldName = "protectedCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        characterTest(fieldName, testField);
    }

    @Test
    public void ProtectedCharacterSave() {
        String fieldName = "ProtectedCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        CharacterTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleSave() {
        String fieldName = "protectedDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleSave() {
        String fieldName = "ProtectedDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleArraySave() {
        String fieldName = "protectedDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleArraySave() {
        String fieldName = "ProtectedDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleListSave() {
        String fieldName = "protectedDoubleList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedFloatSave() {
        String fieldName = "protectedFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatSave() {
        String fieldName = "ProtectedFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatTest(fieldName, testField);
    }

    @Test
    public void protectedFloatArraySave() {
        String fieldName = "protectedFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatArraySave() {
        String fieldName = "ProtectedFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayTest(fieldName, testField);
    }

    @Test
    public void protectedFloatListSave() {
        String fieldName = "protectedFloatList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedLongSave() {
        String fieldName = "protectedLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongSave() {
        String fieldName = "ProtectedLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongTest(fieldName, testField);
    }

    @Test
    public void protectedLongArraySave() {
        String fieldName = "protectedLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongArraySave() {
        String fieldName = "ProtectedLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayTest(fieldName, testField);
    }

    @Test
    public void protectedLongListSave() {
        String fieldName = "protectedLongList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerSave() {
        String fieldName = "protectedInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerSave() {
        String fieldName = "ProtectedInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerArraySave() {
        String fieldName = "protectedIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerArraySave() {
        String fieldName = "ProtectedIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerListSave() {
        String fieldName = "protectedIntegerList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedShortSave() {
        String fieldName = "protectedShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortTest(fieldName, testField);
    }

    @Test
    public void ProtectedShortSave() {
        String fieldName = "ProtectedShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void protectedShortArraySave() {
        String fieldName = "protectedShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortArray(fieldName, testField);
    }

    @Test
    public void ProtectedShortArraySave() {
        String fieldName = "ProtectedShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArray(fieldName, testField);
    }

    @Test
    public void protectedShortListSave() {
        String fieldName = "protectedShortList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedStringSave() {
        String fieldName = "protectedString";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringTest(fieldName, testField);
    }

    @Test
    public void protectedStringArraySave() {
        String fieldName = "protectedStringArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayTest(fieldName, testField);
    }

    @Test
    public void protectedStringListSave() {
        String fieldName = "protectedStringList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayList(fieldName, testField);
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

