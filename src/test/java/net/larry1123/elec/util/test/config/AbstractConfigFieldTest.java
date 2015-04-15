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

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Larry1123
 * @since 4/8/2015 - 3:36 AM
 */
public abstract class AbstractConfigFieldTest extends AbstractConfigTest {

    public AbstractConfigFieldTest(String name, String path) {
        super(name, path);
    }

    // Public

    @Test
    public void publicBooleanLoad() {
        String fieldName = FieldNames.publicBoolean.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicBooleanLoad() {
        String fieldName = FieldNames.PublicBoolean.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicByteLoad() {
        String fieldName = FieldNames.publicByte.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicByteLoad() {
        String fieldName = FieldNames.PublicByte.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicByteArrayLoad() {
        String fieldName = FieldNames.publicByteArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicByteArrayLoad() {
        String fieldName = FieldNames.PublicByteArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicByteArrayListLoad() {
        String fieldName = FieldNames.PublicByteArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicCharacterLoad() {
        String fieldName = FieldNames.publicCharacter.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicCharacterLoad() {
        String fieldName = FieldNames.PublicCharacter.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicDoubleLoad() {
        String fieldName = FieldNames.publicDouble.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicDoubleLoad() {
        String fieldName = FieldNames.PublicDouble.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicDoubleArrayLoad() {
        String fieldName = FieldNames.publicDoubleArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicDoubleArrayLoad() {
        String fieldName = FieldNames.PublicDoubleArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicDoubleArrayListLoad() {
        String fieldName = FieldNames.PublicDoubleArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicFloatLoad() {
        String fieldName = FieldNames.publicFloat.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicFloatLoad() {
        String fieldName = FieldNames.PublicFloat.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicFloatArrayLoad() {
        String fieldName = FieldNames.publicFloatArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicFloatArrayLoad() {
        String fieldName = FieldNames.PublicFloatArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicFloatArrayListLoad() {
        String fieldName = FieldNames.PublicFloatArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicLongLoad() {
        String fieldName = FieldNames.publicLong.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicLongLoad() {
        String fieldName = FieldNames.PublicLong.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicLongArrayLoad() {
        String fieldName = FieldNames.publicLongArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicLongArrayArrayLoad() {
        String fieldName = FieldNames.PublicLongArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicLongArrayListLoad() {
        String fieldName = FieldNames.PublicLongArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicIntegerLoad() {
        String fieldName = FieldNames.publicInteger.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicIntegerLoad() {
        String fieldName = FieldNames.PublicInteger.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicIntegerArrayLoad() {
        String fieldName = FieldNames.publicIntegerArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicIntegerArrayLoad() {
        String fieldName = FieldNames.PublicIntegerArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicIntegerArrayListLoad() {
        String fieldName = FieldNames.PublicIntegerArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicShortLoad() {
        String fieldName = FieldNames.publicShort.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicShortLoad() {
        String fieldName = FieldNames.PublicShort.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicShortArrayLoad() {
        String fieldName = FieldNames.publicShortArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void PublicShortArrayLoad() {
        String fieldName = FieldNames.PublicShortArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicShortArrayListLoad() {
        String fieldName = FieldNames.PublicShortArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicStringLoad() {
        String fieldName = FieldNames.PublicString.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicStringArrayLoad() {
        String fieldName = FieldNames.PublicStringArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void publicStringArrayList() {
        String fieldName = FieldNames.PublicStringArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    // Protected

    @Test
    public void protectedBoolean() {
        String fieldName = FieldNames.protectedBoolean.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedBoolean() {
        String fieldName = FieldNames.ProtectedBoolean.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedByte() {
        String fieldName = FieldNames.protectedByte.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedByte() {
        String fieldName = FieldNames.ProtectedByte.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedByteArray() {
        String fieldName = FieldNames.protectedByteArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedByteArray() {
        String fieldName = FieldNames.ProtectedByteArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedByteArrayList() {
        String fieldName = FieldNames.ProtectedByteArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedCharacter() {
        String fieldName = FieldNames.protectedCharacter.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedCharacter() {
        String fieldName = FieldNames.ProtectedCharacter.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedDouble() {
        String fieldName = FieldNames.protectedDouble.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedDouble() {
        String fieldName = FieldNames.ProtectedDouble.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedDoubleArray() {
        String fieldName = FieldNames.protectedDoubleArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedDoubleArray() {
        String fieldName = FieldNames.ProtectedDoubleArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedDoubleArrayList() {
        String fieldName = FieldNames.ProtectedDoubleArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedFloat() {
        String fieldName = FieldNames.protectedFloat.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedFloat() {
        String fieldName = FieldNames.ProtectedFloat.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedFloatArray() {
        String fieldName = FieldNames.protectedFloatArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedFloatArray() {
        String fieldName = FieldNames.ProtectedFloatArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedFloatArrayList() {
        String fieldName = FieldNames.ProtectedFloatArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedLong() {
        String fieldName = FieldNames.protectedLong.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedLong() {
        String fieldName = FieldNames.ProtectedLong.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedLongArray() {
        String fieldName = FieldNames.protectedLongArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedLongArray() {
        String fieldName = FieldNames.ProtectedLongArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedLongArrayList() {
        String fieldName = FieldNames.ProtectedLongArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedInteger() {
        String fieldName = FieldNames.protectedInteger.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedInteger() {
        String fieldName = FieldNames.ProtectedInteger.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedIntegerArray() {
        String fieldName = FieldNames.protectedIntegerArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedIntegerArray() {
        String fieldName = FieldNames.ProtectedIntegerArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedIntegerArrayList() {
        String fieldName = FieldNames.ProtectedIntegerArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedShort() {
        String fieldName = FieldNames.protectedShort.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedShort() {
        String fieldName = FieldNames.ProtectedShort.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedShortArray() {
        String fieldName = FieldNames.protectedShortArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void ProtectedShortArray() {
        String fieldName = FieldNames.ProtectedShortArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedShortArrayList() {
        String fieldName = FieldNames.ProtectedShortArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedString() {
        String fieldName = FieldNames.ProtectedString.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedStringArray() {
        String fieldName = FieldNames.ProtectedStringArray.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

    @Test
    public void protectedStringArrayList() {
        String fieldName = FieldNames.ProtectedStringArrayList.name();
        Field field = getField(fieldName);

        assertTest(fieldName, field);
    }

}
