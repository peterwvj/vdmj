/*******************************************************************************
 *
 *	Copyright (c) 2016 Fujitsu Services Ltd.
 *
 *	Author: Nick Battle
 *
 *	This file is part of VDMJ.
 *
 *	VDMJ is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	VDMJ is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with VDMJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 ******************************************************************************/

package com.fujitsu.vdmj.ast.traces;

import com.fujitsu.vdmj.lex.LexLocation;

/**
 * A class representing a trace definition.
 */
public class ASTTraceRepeatDefinition extends ASTTraceDefinition
{
    private static final long serialVersionUID = 1L;
	public final ASTTraceCoreDefinition core;
	public final long from;
	public final long to;

	public ASTTraceRepeatDefinition(LexLocation location,
		ASTTraceCoreDefinition core, long from, long to)
	{
		super(location);
		this.core = core;
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString()
	{
		return core +
			((from == 1 && to == 1) ? "" :
				(from == to) ? ("{" + from + "}") :
					("{" + from + ", " + to + "}"));
	}
}
