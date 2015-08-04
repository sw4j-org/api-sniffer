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

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import org.sw4j.apisniffer.api.Api;

/**
 *
 * @author Uwe Plonus
 */
@NotThreadSafe
public class ApiScanner {

    public void scanFolder(@Nonnull File folder) {
        if (!folder.getAbsoluteFile().isDirectory()) {
            throw new IllegalArgumentException(
                new StringBuilder("The method scanFolder(File) is for")
                    .append(" scanning folders. The provided file \"")
                    .append(folder.getAbsolutePath())
                    .append("\" is no folder.")
                    .toString());
        }
        File[] files = folder.getAbsoluteFile().listFiles(
            new DirectoryOrClassFileFilter());
        for (File file: files) {
            if (file.isDirectory()) {
                scanFolder(file);
            } else {
                scanClass(file);
            }
        }
    }

    private void scanClass(@Nonnull File classFile) {
    }

    public void scanJar(@Nonnull InputStream is) throws IOException {
    }

    public Api createApi() {
        return null;
    }


    private static final class DirectoryOrClassFileFilter
    implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.isDirectory() ||
                pathname.getName().endsWith(".class");
        }

    }

}
