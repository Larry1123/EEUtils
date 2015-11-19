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
package net.larry1123.elec.util.reflection.search.members;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;

/**
 * @author Larry1123
 * @since 1.4.0
 */
public abstract class AbstractAccessibleObjectMemberFinder<T extends Member> implements MemberFinder<T> {

    private final boolean makeAccessible;

    public AbstractAccessibleObjectMemberFinder(boolean makeAccessible) {
        this.makeAccessible = makeAccessible;
    }

    public boolean isMakeAccessible() {
        return makeAccessible;
    }

    protected void makeAccessible(AccessibleObject accessibleObject) {
        if (isMakeAccessible()) {
            accessibleObject.setAccessible(true);
        }
    }

}
