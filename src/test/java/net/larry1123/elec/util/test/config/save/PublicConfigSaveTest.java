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
 * @since 1/31/14 - 9:33 AM
 */
public class PublicConfigSaveTest extends AbstractConfigTest {

    public PublicConfigSaveTest() {
        super("PublicConfigSaveTest", "target/tests/resources/save.cfg");
    }

    @Test
    public void publicBooleanSave() {
        String fieldName = FieldNames.publicBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicBooleanSave() {
        String fieldName = FieldNames.PublicBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicByteSave() {
        String fieldName = FieldNames.publicByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicByteSave() {
        String fieldName = FieldNames.PublicByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicByteArraySave() {
        String fieldName = FieldNames.publicByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicByteArraySave() {
        String fieldName = FieldNames.PublicByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicByteArrayListSave() {
        String fieldName = FieldNames.PublicByteArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicCharacterSave() {
        String fieldName = FieldNames.publicCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicCharacterSave() {
        String fieldName = FieldNames.PublicCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicDoubleSave() {
        String fieldName = FieldNames.publicDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicDoubleSave() {
        String fieldName = FieldNames.PublicDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicDoubleArraySave() {
        String fieldName = FieldNames.publicDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicDoubleArraySave() {
        String fieldName = FieldNames.PublicDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);

    }

    @Test
    public void publicDoubleArrayListSave() {
        String fieldName = FieldNames.PublicDoubleArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicFloatSave() {
        String fieldName = FieldNames.publicFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicFloatSave() {
        String fieldName = FieldNames.PublicFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicFloatArraySave() {
        String fieldName = FieldNames.publicFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicFloatArraySave() {
        String fieldName = FieldNames.PublicFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicFloatArrayListSave() {
        String fieldName = FieldNames.PublicFloatArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicLongSave() {
        String fieldName = FieldNames.publicLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicLongSave() {
        String fieldName = FieldNames.PublicLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicLongArraySave() {
        String fieldName = FieldNames.publicLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicLongArrayArraySave() {
        String fieldName = FieldNames.PublicLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicLongArrayListSave() {
        String fieldName = FieldNames.PublicLongArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicIntegerSave() {
        String fieldName = FieldNames.publicInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicIntegerSave() {
        String fieldName = FieldNames.PublicInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicIntegerArraySave() {
        String fieldName = FieldNames.publicIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicIntegerArraySave() {
        String fieldName = FieldNames.PublicIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicIntegerArrayListSave() {
        String fieldName = FieldNames.PublicIntegerArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicShortSave() {
        String fieldName = FieldNames.publicShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicShortSave() {
        String fieldName = FieldNames.PublicShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicShortArraySave() {
        String fieldName = FieldNames.publicShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void PublicShortArraySave() {
        String fieldName = FieldNames.PublicShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicShortArrayListSave() {
        String fieldName = FieldNames.PublicShortArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicStringSave() {
        String fieldName = FieldNames.PublicString.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicStringArraySave() {
        String fieldName = FieldNames.PublicStringArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void publicStringArrayListSave() {
        String fieldName = FieldNames.PublicStringArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.save();
        getPropertiesFile().save();
        try {
            assertTest(fieldName);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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
