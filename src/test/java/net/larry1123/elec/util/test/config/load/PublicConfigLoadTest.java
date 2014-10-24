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
import net.larry1123.elec.util.test.config.FieldNames;
import net.visualillusionsent.utils.PropertiesFile;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 6/20/2014 - 11:02 PM
 */
public class PublicConfigLoadTest extends AbstractConfigTest {

    public PublicConfigLoadTest() {
        super("PublicConfigLoadTest", "target/test-classes/load.cfg");
    }

    @Test
    public void publicBooleanLoad() {
        String fieldName = FieldNames.publicBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        booleanTest(fieldName, testField);
    }

    @Test
    public void PublicBooleanLoad() {
        String fieldName = FieldNames.PublicBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void publicByteLoad() {
        String fieldName = FieldNames.publicByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteTest(fieldName, testField);
    }

    @Test
    public void PublicByteLoad() {
        String fieldName = FieldNames.PublicByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteTest(fieldName, testField);
    }

    @Test
    public void publicByteArrayLoad() {
        String fieldName = FieldNames.publicByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        byteArrayTest(fieldName, testField);
    }

    @Test
    public void PublicByteArrayLoad() {
        String fieldName = FieldNames.PublicByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayTest(fieldName, testField);
    }

    @Test
    public void publicByteListLoad() {
        String fieldName = FieldNames.PublicByteArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ByteArrayListTest(fieldName, testField);
    }

    @Test
    public void publicCharacterLoad() {
        String fieldName = FieldNames.publicCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        characterTest(fieldName, testField);
    }

    @Test
    public void PublicCharacterLoad() {
        String fieldName = FieldNames.PublicCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        CharacterTest(fieldName, testField);
    }

    @Test
    public void publicDoubleLoad() {
        String fieldName = FieldNames.publicDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleTest(fieldName, testField);
    }

    @Test
    public void PublicDoubleLoad() {
        String fieldName = FieldNames.PublicDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleTest(fieldName, testField);
    }

    @Test
    public void publicDoubleArrayLoad() {
        String fieldName = FieldNames.publicDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        doubleArrayTest(fieldName, testField);
    }

    @Test
    public void PublicDoubleArrayLoad() {
        String fieldName = FieldNames.PublicDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);

        DoubleArrayTest(fieldName, testField);
    }

    @Test
    public void publicDoubleListLoad() {
        String fieldName = FieldNames.PublicDoubleArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        DoubleArrayListTest(fieldName, testField);
    }

    @Test
    public void publicFloatLoad() {
        String fieldName = FieldNames.publicFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatTest(fieldName, testField);
    }

    @Test
    public void PublicFloatLoad() {
        String fieldName = FieldNames.PublicFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatTest(fieldName, testField);
    }

    @Test
    public void publicFloatArrayLoad() {
        String fieldName = FieldNames.publicFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        floatArrayTest(fieldName, testField);
    }

    @Test
    public void PublicFloatArrayLoad() {
        String fieldName = FieldNames.PublicFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayTest(fieldName, testField);
    }

    @Test
    public void publicFloatListLoad() {
        String fieldName = FieldNames.PublicFloatArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        FloatArrayListTest(fieldName, testField);
    }

    @Test
    public void publicLongLoad() {
        String fieldName = FieldNames.publicLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longTest(fieldName, testField);
    }

    @Test
    public void PublicLongLoad() {
        String fieldName = FieldNames.PublicLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongTest(fieldName, testField);
    }

    @Test
    public void publicLongArrayLoad() {
        String fieldName = FieldNames.publicLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        longArrayTest(fieldName, testField);
    }

    @Test
    public void PublicLongArrayArrayLoad() {
        String fieldName = FieldNames.PublicLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayTest(fieldName, testField);
    }

    @Test
    public void publicLongListLoad() {
        String fieldName = FieldNames.PublicLongArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        LongArrayListTest(fieldName, testField);
    }

    @Test
    public void publicIntegerLoad() {
        String fieldName = FieldNames.publicInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerTest(fieldName, testField);
    }

    @Test
    public void PublicIntegerLoad() {
        String fieldName = FieldNames.PublicInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerTest(fieldName, testField);
    }

    @Test
    public void publicIntegerArrayLoad() {
        String fieldName = FieldNames.publicIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        integerArrayTest(fieldName, testField);
    }

    @Test
    public void PublicIntegerArrayLoad() {
        String fieldName = FieldNames.PublicIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayTest(fieldName, testField);
    }

    @Test
    public void publicIntegerListLoad() {
        String fieldName = FieldNames.PublicIntegerArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void publicShortLoad() {
        String fieldName = FieldNames.publicShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortTest(fieldName, testField);
    }

    @Test
    public void PublicShortLoad() {
        String fieldName = FieldNames.PublicShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void publicShortArrayLoad() {
        String fieldName = FieldNames.publicShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        shortArrayTest(fieldName, testField);
    }

    @Test
    public void PublicShortArrayLoad() {
        String fieldName = FieldNames.PublicShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayTest(fieldName, testField);
    }

    @Test
    public void publicShortListLoad() {
        String fieldName = FieldNames.PublicShortArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayListTest(fieldName, testField);
    }

    @Test
    public void publicStringLoad() {
        String fieldName = FieldNames.PublicString.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringTest(fieldName, testField);
    }

    @Test
    public void publicStringArrayLoad() {
        String fieldName = FieldNames.PublicStringArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayTest(fieldName, testField);
    }

    @Test
    public void publicStringListLoad() {
        String fieldName = FieldNames.PublicStringArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        StringArrayListTest(fieldName, testField);
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

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.load();
    }

}
