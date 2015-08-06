/*
 * Copyright (C) 2015 Uwe Plonus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sw4j.apisniffer.api;

import java.util.Collection;

/**
 * This interface represents a type (class, interface, enum, annotation) of the API.
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
public interface Type extends ApiElement {

    /**
     * Returns the members of this type.
     *
     * @return the members of this type.
     */
    Collection<Member> getMembers();

}
