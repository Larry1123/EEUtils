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
package net.larry1123.elec.util.test;

import net.larry1123.elec.util.factorys.EELoggerFactory;
import net.larry1123.elec.util.factorys.FactoryManager;
import net.larry1123.elec.util.factorys.FieldHandlerFactory;
import net.larry1123.elec.util.factorys.ParameterizedTypeFactory;
import net.larry1123.elec.util.logger.EELogger;

/**
 * @author Larry1123
 * @since 10/23/2014 - 8:08 PM
 */
public class AbstractTestClass {

    protected final String name;

    public AbstractTestClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FactoryManager getFactoryManager() {
        return FactoryManager.getFactoryManager();
    }

    public FieldHandlerFactory getFieldHandlerFactory() {
        return getFactoryManager().getMainFieldHandlerFactory();
    }

    public ParameterizedTypeFactory getParameterizedTypeFactory() {
        return getFactoryManager().getParameterizedTypeFactory();
    }

    public EELoggerFactory getEELoggerFactory() {
        return getFactoryManager().getEELoggerFactory();
    }

    public EELogger getLogger() {
        return getEELoggerFactory().getLogger(getName());
    }

    public EELogger getLogger(String sub) {
        return getEELoggerFactory().getSubLogger(sub, getLogger());
    }

}
