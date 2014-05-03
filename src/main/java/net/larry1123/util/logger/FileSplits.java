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
package net.larry1123.util.logger;

public enum FileSplits {

    NONE("None"),
    //
    DAY("Day"),
    //
    HOUR("Hour"),
    //
    MONTH("Month"),
    //
    WEEK("Week");

    private final String ths;

    FileSplits(String type) {
        ths = type;
    }

    public static FileSplits getFromString(String type) {
        for (FileSplits t : FileSplits.values()) {
            if (t.getValue().toLowerCase().equals(type.toLowerCase())) {
                return t;
            }
        }
        return NONE;
    }

    public String getValue() {
        return ths;
    }

}
