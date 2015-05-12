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
package net.larry1123.elec.util.test.reflection;

import org.junit.Assert;
import net.larry1123.elec.util.test.AbstractTest;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * @author Larry1123
 * @since 4/8/2015 - 2:29 AM
 */
public class ParameterizedTypeTest extends AbstractTest {

    public ArrayList<String> test1;

    public ParameterizedTypeTest() {
        super("ParameterizedTypeTest");
    }

    @Test
    public void test1() {
        try {
            Field testField = this.getClass().getField("test1");
            ParameterizedType type = getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, String.class);
            Assert.assertTrue("The types do not match!", testField.getGenericType().equals(type));
        }
        catch (NoSuchFieldException e) {
            assumeNoThrowable("Unable to find Field?!", e);
        }
    }

    @Test
    public void test2() {
        try {
            Field testField = this.getClass().getField("test1");
            ParameterizedType type = getParameterizedTypeFactory().makeParameterizedType(ArrayList.class, Integer.class);
            Assert.assertFalse("The types matched!", testField.getGenericType().equals(type));
        }
        catch (NoSuchFieldException e) {
            assumeNoThrowable("Unable to find Field?!", e);
        }
    }

}
