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
 * @since 6/20/2014 - 10:36 PM
 */
public class ProtectedConfigLoadTest extends AbstractConfigTest {

    public ProtectedConfigLoadTest() {
        super("ProtectedConfigLoadTest", "target/test-classes/load.cfg");
    }

    @Test
    public void protectedBooleanLoad() {
        String fieldName = FieldNames.protectedBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedBooleanLoad() {
        String fieldName = FieldNames.ProtectedBoolean.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        BooleanTest(fieldName, testField);
    }

    @Test
    public void protectedByteLoad() {
        String fieldName = FieldNames.protectedByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedByteLoad() {
        String fieldName = FieldNames.ProtectedByte.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedByteArrayLoad() {
        String fieldName = FieldNames.protectedByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedByteArrayLoad() {
        String fieldName = FieldNames.ProtectedByteArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedByteArrayListLoad() {
        String fieldName = FieldNames.ProtectedByteArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedCharacterLoad() {
        String fieldName = FieldNames.protectedCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedCharacterLoad() {
        String fieldName = FieldNames.ProtectedCharacter.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedDoubleLoad() {
        String fieldName = FieldNames.protectedDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleLoad() {
        String fieldName = FieldNames.ProtectedDouble.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedDoubleArrayLoad() {
        String fieldName = FieldNames.protectedDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedDoubleArrayLoad() {
        String fieldName = FieldNames.ProtectedDoubleArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedDoubleArrayListLoad() {
        String fieldName = FieldNames.ProtectedDoubleArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedFloatLoad() {
        String fieldName = FieldNames.protectedFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedFloatLoad() {
        String fieldName = FieldNames.ProtectedFloat.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedFloatArrayLoad() {
        String fieldName = FieldNames.protectedFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedFloatArrayLoad() {
        String fieldName = FieldNames.ProtectedFloatArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedFloatArrayListLoad() {
        String fieldName = FieldNames.ProtectedFloatArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedLongLoad() {
        String fieldName = FieldNames.protectedLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedLongLoad() {
        String fieldName = FieldNames.ProtectedLong.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedLongArrayLoad() {
        String fieldName = FieldNames.protectedLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedLongArrayLoad() {
        String fieldName = FieldNames.ProtectedLongArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedLongArrayListLoad() {
        String fieldName = FieldNames.ProtectedLongArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedIntegerLoad() {
        String fieldName = FieldNames.protectedInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerLoad() {
        String fieldName = FieldNames.ProtectedInteger.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedIntegerArrayLoad() {
        String fieldName = FieldNames.protectedIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedIntegerArrayLoad() {
        String fieldName = FieldNames.ProtectedIntegerArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedIntegerArrayListLoad() {
        String fieldName = FieldNames.ProtectedIntegerArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        IntegerArrayListTest(fieldName, testField);
    }

    @Test
    public void protectedShortLoad() {
        String fieldName = FieldNames.protectedShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedShortLoad() {
        String fieldName = FieldNames.ProtectedShort.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortTest(fieldName, testField);
    }

    @Test
    public void protectedShortArrayLoad() {
        String fieldName = FieldNames.protectedShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void ProtectedShortArrayLoad() {
        String fieldName = FieldNames.ProtectedShortArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
        ShortArrayTest(fieldName, testField);
    }

    @Test
    public void protectedShortArrayListLoad() {
        String fieldName = FieldNames.ProtectedShortArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedStringLoad() {
        String fieldName = FieldNames.ProtectedString.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedStringArrayLoad() {
        String fieldName = FieldNames.ProtectedStringArray.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    @Test
    public void protectedStringArrayListLoad() {
        String fieldName = FieldNames.ProtectedStringArrayList.name();
        Field testField = getField(getConfigBase(), fieldName);

        doLogic(fieldName, testField);
    }

    protected void doLogic(String fieldName, Field testField) {
        FieldHandler<?> handler = getFieldHandlerFactory().createFieldHandler(testField.getGenericType(), testField, getConfigBase());
        handler.load();
        try {
            assertTest(fieldName);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
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