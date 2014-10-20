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
package net.larry1123.elec.util.logger;

import java.util.logging.Level;

public class LoggerLevel extends Level {

    private static final long serialVersionUID = 912743220309496892L;
    private static int baseLvl = 10000;
    private final String id;
    private final String prefix;

    LoggerLevel(String name, String prefix, String id) {
        super(name, genLevel());
        this.prefix = prefix;
        this.id = id;
    }

    private static int genLevel() {
        return ++baseLvl;
    }

    /**
     * Get the Prefix of the Level
     *
     * @return String containing the prefix for the level
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Gets the ID that is given to this LoggerLevel so the Manager can retrieve the right Level later
     *
     * @return This Level's ID
     */
    public String getID() {
        return id;
    }

}