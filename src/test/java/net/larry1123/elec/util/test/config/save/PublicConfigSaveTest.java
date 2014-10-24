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
 * @since 1/31/14 - 9:33 AM
 */
@SuppressWarnings("WeakerAccess")
public class PublicConfigSaveTest extends AbstractConfigTest {

    public PublicConfigSaveTest() {
        super("PublicConfigSaveTest", "target/tests/resources/save.cfg");
    }

    @Test
    public void publicBooleanLoad() {
        String fieldName = "publicBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        booleanTest(fieldName, testField);
    }

    @Test
    public void PublicBooleanLoad() {
        String fieldName = "PublicBoolean";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void publicByteLoad() {
        String fieldName = "publicByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteTest(fieldName, testField);
    }

    @Test
    public void PublicByteLoad() {
        String fieldName = "PublicByte";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteTest(fieldName, testField);
    }

    @Test
    public void publicByteArrayLoad() {
        String fieldName = "publicByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteArrayTest(fieldName, testField);
    }

    @Test
    public void PublicByteArrayLoad() {
        String fieldName = "PublicByteArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayTest(fieldName, testField);
    }

    @Test
    public void publicByteListLoad() {
        String fieldName = "publicByteList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayListTest(fieldName, testField);
    }

    @Test
    public void publicCharacterLoad() {
        String fieldName = "publicCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        characterTest(fieldName, testField);
    }

    @Test
    public void PublicCharacterLoad() {
        String fieldName = "PublicCharacter";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        CharacterTest(fieldName, testField);
    }

    @Test
    public void publicDoubleLoad() {
        String fieldName = "publicDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleTest(fieldName, testField);
    }

    @Test
    public void PublicDoubleLoad() {
        String fieldName = "PublicDouble";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleTest(fieldName, testField);
    }

    @Test
    public void publicDoubleArrayLoad() {
        String fieldName = "publicDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleArrayTest(fieldName, testField);
    }

    @Test
    public void PublicDoubleArrayLoad() {
        String fieldName = "PublicDoubleArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);

        DoubleArrayTest(fieldName, testField);
    }

    @Test
    public void publicDoubleListLoad() {
        String fieldName = "publicDoubleList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayListTest(fieldName, testField);
    }

    @Test
    public void publicFloatLoad() {
        String fieldName = "publicFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatTest(fieldName, testField);
    }

    @Test
    public void PublicFloatLoad() {
        String fieldName = "PublicFloat";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatTest(fieldName, testField);
    }

    @Test
    public void publicFloatArrayLoad() {
        String fieldName = "publicFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatArrayTest(fieldName, testField);
    }

    @Test
    public void PublicFloatArrayLoad() {
        String fieldName = "PublicFloatArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayTest(fieldName, testField);
    }

    @Test
    public void publicFloatListLoad() {
        String fieldName = "publicFloatList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayListTest(fieldName, testField);
    }

    @Test
    public void publicLongLoad() {
        String fieldName = "publicLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longTest(fieldName, testField);
    }

    @Test
    public void PublicLongLoad() {
        String fieldName = "PublicLong";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongTest(fieldName, testField);
    }

    @Test
    public void publicLongArrayLoad() {
        String fieldName = "publicLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longArrayTest(fieldName, testField);
    }

    @Test
    public void PublicLongArrayArrayLoad() {
        String fieldName = "PublicLongArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayTest(fieldName, testField);
    }

    @Test
    public void publicLongListLoad() {
        String fieldName = "publicLongList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayListTest(fieldName, testField);
    }

    @Test
    public void publicIntegerLoad() {
        String fieldName = "publicInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerTest(fieldName, testField);
    }

    @Test
    public void PublicIntegerLoad() {
        String fieldName = "PublicInteger";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerTest(fieldName, testField);
    }

    @Test
    public void publicIntegerArrayLoad() {
        String fieldName = "publicIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerArrayTest(fieldName, testField);
    }

    @Test
    public void PublicIntegerArrayLoad() {
        String fieldName = "PublicIntegerArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayTest(fieldName, testField);
    }

    @Test
    public void publicIntegerListLoad() {
        String fieldName = "publicIntegerList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void publicShortLoad() {
        String fieldName = "publicShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortTest(fieldName, testField);
    }

    @Test
    public void PublicShortLoad() {
        String fieldName = "PublicShort";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void publicShortArrayLoad() {
        String fieldName = "publicShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortArray(fieldName, testField);
    }

    @Test
    public void PublicShortArrayLoad() {
        String fieldName = "PublicShortArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArray(fieldName, testField);
    }

    @Test
    public void publicShortListLoad() {
        String fieldName = "publicShortList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayListTest(fieldName, testField);
    }

    @Test
    public void publicStringLoad() {
        String fieldName = "publicString";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringTest(fieldName, testField);
    }

    @Test
    public void publicStringArrayLoad() {
        String fieldName = "publicStringArray";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayTest(fieldName, testField);
    }

    @Test
    public void publicStringListLoad() {
        String fieldName = "publicStringList";
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayList(fieldName, testField);
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.save();
        getPropertiesFile().save();
    }

    protected TestConfigFile createTestConfigFile(final PropertiesFile file) {
        return new TestConfigFile() {

            @Override
            public PropertiesFile getPropertiesFile() {
                return file;
            }
        };
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
}
