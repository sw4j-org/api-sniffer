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
package org.sw4j.apisniffer.builder;

import java.util.Collection;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.sw4j.apisniffer.api.Api;
import org.sw4j.apisniffer.api.Type;

/**
 * This is a builder to create an {@link Api} object.
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
@NotThreadSafe
public final class ApiBuilder {

    /**
     * Builds an {@link Api} object.
     *
     * @return the built API object.
     */
    public Api build() {
        return null;
    }


    /**
     * A concrete implementation of the {@link Api} interface.
     */
    @Immutable
    private static final class ApiImpl implements Api {

        /**
         * Returns all types (classes, enums, interfaces, annotations) of this API.
         *
         * @return all types of this API.
         */
        @Override
        public Collection<Type> getTypes() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
