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
package net.larry1123.elec.util.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is used to find what fields to use to create a config file from
 *
 * @author Larry1123
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigField {

    /**
     * Name of the field to be put into the Prop file
     *
     * @return The name for the field
     */
    String name() default "";

    /**
     * Extra Info to be given to the field ie. usage
     *
     * @return A String array if comments if any
     */
    String[] comments() default "";

    /**
     * What to delimit an array type if needed
     *
     * @return The delimiter if needed
     */
    String spacer() default "";

}
