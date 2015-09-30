/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.internal.maven;

import org.xwiki.extension.Extension;
import org.xwiki.extension.repository.ExtensionRepository;

/**
 * Default implementation of {@link MavenExtension}.
 * 
 * @version $Id$
 * @since 7.3M1
 */
public class DefaultMavenExtension extends AbstractMavenExtension
{
    /**
     * @param repository the repository where this extension comes from
     * @param groupId the maven artifact group id
     * @param artifactId the maven artifact artifact id
     * @param version the maven artifact version
     * @param type the extension type
     */
    public DefaultMavenExtension(ExtensionRepository repository, String groupId, String artifactId, String version,
        String type)
    {
        super(repository, groupId, artifactId, version, type);
    }

    /**
     * Create new Maven extension descriptor by copying provided one.
     *
     * @param repository the repository where this extension comes from
     * @param extension the extension to copy
     */
    public DefaultMavenExtension(ExtensionRepository repository, Extension extension)
    {
        super(repository, extension);
    }
}
