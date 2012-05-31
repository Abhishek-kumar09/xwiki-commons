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
package org.xwiki.diff.display;

import java.util.List;

/**
 * Extends a {@link UnifiedDiffLine} with information about word changes inside that line.
 * 
 * @param <E> the type of line content
 * @param <F> the type of line character
 * @version $Id$
 * @since 4.1RC1
 */
public class ExtendedDiffLine<E, F> extends UnifiedDiffLine<E>
{
    /**
     * The list of words that make this line.
     */
    private final List<InlineDiffWord<F>> words;

    /**
     * Creates a new line with the provided information.
     * 
     * @param line the line that is extended
     * @param words the line words
     */
    public ExtendedDiffLine(UnifiedDiffLine<E> line, List<InlineDiffWord<F>> words)
    {
        super(line.getNumber(), line.getType(), line.getContent());
        this.words = words;
    }

    /**
     * @return the list of words that make this line
     */
    public List<InlineDiffWord<F>> getWords()
    {
        return words;
    }
}
