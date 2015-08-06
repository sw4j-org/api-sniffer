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
package org.sw4j.mojo.apisniffer;

import java.io.File;
import java.io.IOException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 *
 * @author Uwe Plonus &lt;u.plonus@gmail.com&gt;
 */
@Mojo(name = "scan")
public class ScanApiMojo extends AbstractMojo {

    /**
     * The directory where compiled classes are placed.
     */
    @Parameter(defaultValue = "${project.build.outputDirectory}", required = true, readonly = true)
    private File outputDirectory;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().debug("Executing scan mojo.");
        try {
            getLog().debug(new StringBuilder("Scanning directory ")
                .append(outputDirectory.getCanonicalPath()).toString());
        } catch (IOException ioex) {
            getLog().error(new StringBuilder("Determining directory to scan not possible."));
            throw new MojoExecutionException("Determining directory to scan not possible.", ioex);
        }
    }

}
