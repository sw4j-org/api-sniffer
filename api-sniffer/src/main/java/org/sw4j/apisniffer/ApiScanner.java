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
package org.sw4j.apisniffer;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarInputStream;
import org.sw4j.apisniffer.api.Api;

/**
 *
 * @author Uwe Plonus
 */
public class ApiScanner {

    public Api scanApi(InputStream is) throws IOException {
        JarInputStream jis = new JarInputStream(is);
        return null;
    }

}
