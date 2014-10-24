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
package net.larry1123.elec.util.test.config.load;

import net.larry1123.elec.util.config.ConfigBase;
import net.larry1123.elec.util.config.fieldhanders.FieldHandler;
import net.larry1123.elec.util.test.config.AbstractConfigTest;
import net.visualillusionsent.utils.PropertiesFile;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 6/20/2014 - 10:36 PM
 */
public class ProtectedConfigLoadTest extends AbstractConfigTest {

    public ProtectedConfigLoadTest() {
        super("ProtectedConfigLoadTest", "target/test-classes/load.cfg");
    }

    @Test
    public void protectedBooleanLoad() {
        String fieldName = "protectedBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        booleanTest(fieldName, testField);
    }

    @Test
    public void ProtectedBooleanLoad() {
        String fieldName = "ProtectedBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void protectedByteLoad() {
        String fieldName = "protectedByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteLoad() {
        String fieldName = "ProtectedByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteTest(fieldName, testField);
    }

    @Test
    public void protectedByteArrayLoad() {
        String fieldName = "protectedByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedByteArrayLoad() {
        String fieldName = "ProtectedByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayTest(fieldName, testField);
    }

    @Test
    public void protectedByteListLoad() {
        String fieldName = "protectedByteList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedCharacterLoad() {
        String fieldName = "protectedCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        characterTest(fieldName, testField);
    }

    @Test
    public void ProtectedCharacterLoad() {
        String fieldName = "ProtectedCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        CharacterTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleLoad() {
        String fieldName = "protectedDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleLoad() {
        String fieldName = "ProtectedDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleArrayLoad() {
        String fieldName = "protectedDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleArrayLoad() {
        String fieldName = "ProtectedDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayTest(fieldName, testField);
    }

    @Test
    public void protectedDoubleListLoad() {
        String fieldName = "protectedDoubleList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedFloatLoad() {
        String fieldName = "protectedFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatLoad() {
        String fieldName = "ProtectedFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatTest(fieldName, testField);
    }

    @Test
    public void protectedFloatArrayLoad() {
        String fieldName = "protectedFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedFloatArrayLoad() {
        String fieldName = "ProtectedFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayTest(fieldName, testField);
    }

    @Test
    public void protectedFloatListLoad() {
        String fieldName = "protectedFloatList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedLongLoad() {
        String fieldName = "protectedLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongLoad() {
        String fieldName = "ProtectedLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongTest(fieldName, testField);
    }

    @Test
    public void protectedLongArrayLoad() {
        String fieldName = "protectedLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedLongArrayLoad() {
        String fieldName = "ProtectedLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayTest(fieldName, testField);
    }

    @Test
    public void protectedLongListLoad() {
        String fieldName = "protectedLongList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerLoad() {
        String fieldName = "protectedInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerLoad() {
        String fieldName = "ProtectedInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerArrayLoad() {
        String fieldName = "protectedIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerArrayTest(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerArrayLoad() {
        String fieldName = "ProtectedIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayTest(fieldName, testField);
    }

    @Test
    public void protectedIntegerListLoad() {
        String fieldName = "protectedIntegerList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedShortLoad() {
        String fieldName = "protectedShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortTest(fieldName, testField);
    }

    @Test
    public void ProtectedShortLoad() {
        String fieldName = "ProtectedShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void protectedShortArrayLoad() {
        String fieldName = "protectedShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortArray(fieldName, testField);
    }

    @Test
    public void ProtectedShortArrayLoad() {
        String fieldName = "ProtectedShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArray(fieldName, testField);
    }

    @Test
    public void protectedShortListLoad() {
        String fieldName = "protectedShortList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedStringLoad() {
        String fieldName = "protectedString";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringTest(fieldName, testField);
    }

    @Test
    public void protectedStringArrayLoad() {
        String fieldName = "protectedStringArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayTest(fieldName, testField);
    }

    @Test
    public void protectedStringListLoad() {
        String fieldName = "protectedStringList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayList(fieldName, testField);
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.load();
    }

    @Override
    protected ConfigBase createTestConfigBase(final PropertiesFile file) {
        return new LoadingTestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
    }

}
