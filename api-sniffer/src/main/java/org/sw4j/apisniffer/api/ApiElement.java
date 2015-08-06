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

/**
 * This interface represents a named API element.
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
public interface ApiElement {

    /**
     * Returns the name of the API element.
     *
     * @return 
     */
    CharSequence getName();

    /**
     * Returns the modifiers of the API element.
     *
     * @return the modifiers.
     * @see java.lang.reflect.Modifier
     */
    int getModifiers();

}
