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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import org.sw4j.apisniffer.api.Api;

/**
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
@NotThreadSafe
public class ApiScanner {

    public void scanDirectory(@Nonnull final File folder) throws IOException {
        if (!folder.getAbsoluteFile().isDirectory()) {
            throw new IllegalArgumentException(
                new StringBuilder("The method scanFolder(File) is for")
                    .append(" scanning folders. The provided file \"")
                    .append(folder.getAbsolutePath())
                    .append("\" is no folder.")
                    .toString());
        }
        File[] files = folder.getAbsoluteFile().listFiles(new DirectoryOrClassFileFilter());
        if (files != null) {
            for (File file: files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    scanClass(new FileInputStream(file));
                }
            }
        }
    }

    private void scanClass(@Nonnull final InputStream classFile) {
    }

    public void scanJar(@Nonnull final InputStream is) throws IOException {
    }

    /**
     * Creates the API from the {@link #scanJar(java.io.InputStream) scanned jar file} or the
     * {@link #scanDirectory(java.io.File) scanned directory}.
     *
     * @return the API from the scanned files.
     */
    public Api createApi() {
        return null;
    }


    /**
     * A file filter to accept only directories or files with the suffix {@code .class}.
     */
    private static final class DirectoryOrClassFileFilter
    implements FileFilter {

        /**
         * Accepts only pathnames if it either is a directory or has the suffix {@code .class}.
         *
         * @param pathname the pathname to check.
         * @return {@code true} if the pathname is either a directory or a file with suffix
         *  {@code .class}.
         */
        @Override
        public boolean accept(final File pathname) {
            return pathname.isDirectory() ||
                pathname.getName().endsWith(".class");
        }

    }

}
