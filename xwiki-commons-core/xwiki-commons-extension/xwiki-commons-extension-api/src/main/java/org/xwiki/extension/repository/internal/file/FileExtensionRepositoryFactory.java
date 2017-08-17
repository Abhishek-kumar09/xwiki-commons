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
package org.xwiki.extension.repository.internal.file;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.extension.repository.AbstractExtensionRepositoryFactory;
import org.xwiki.extension.repository.ExtensionRepository;
import org.xwiki.extension.repository.ExtensionRepositoryDescriptor;
import org.xwiki.extension.repository.ExtensionRepositoryException;

/**
 * @version $Id$
 * @since 9.7RC1
 */
@Component
@Singleton
@Named("file")
public class FileExtensionRepositoryFactory extends AbstractExtensionRepositoryFactory
{
    @Inject
    private ComponentManager componentManager;

    @Override

    public ExtensionRepository createRepository(ExtensionRepositoryDescriptor repositoryDescriptor)
        throws ExtensionRepositoryException
    {
        File file = new File(repositoryDescriptor.getURI());

        if (!file.exists()) {
            throw new ExtensionRepositoryException("File [" + file + "] does not exist");
        }

        if (file.isDirectory()) {
            try {
                return new DirectoryFileExtensionRepository(repositoryDescriptor, file, this.componentManager);
            } catch (ComponentLookupException e) {
                throw new ExtensionRepositoryException("Failed to create repository for file [" + file + "]", e);
            }
        } else {
            // TODO: add support for zip packages
            throw new ExtensionRepositoryException("[" + file + "] is not a directory");
        }
    }
}
