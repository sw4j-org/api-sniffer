/*
 * Copyright (C) 2015 Uwe Plonus <uwe.plonus@sw4j.org>
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
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
public class ApiScannerTest {

    private ApiScanner objectToTest;

    @BeforeClass
    public void setUpClass() {
    }

    @BeforeMethod
    public void setUp() {
        objectToTest = new ApiScanner();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
        expectedExceptionsMessageRegExp = ".*target/test-classes/dummy.*")
    @Parameters("testClasses")
    public void testScanDirectoryWithFile(String testClasses) throws IOException {
        objectToTest.scanDirectory(new File(testClasses, "dummy"));
    }

    @Test
    @Parameters({"baseApiClasses",})
    public void testScanDirectory(String baseClasses) throws IOException {
        objectToTest.scanDirectory(new File("..", baseClasses));
    }

}
