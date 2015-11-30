/*******************************************************************************
 *
 *	Copyright (c) 2010 Fujitsu Services Ltd.
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

package org.overturetool.vdmj.traces;

import java.util.List;

import org.overturetool.vdmj.lex.LexLocation;
import org.overturetool.vdmj.runtime.Context;
import org.overturetool.vdmj.typechecker.Environment;
import org.overturetool.vdmj.typechecker.NameScope;

public class TraceConcurrentExpression extends TraceCoreDefinition
{
	private static final long serialVersionUID = 1L;
	public final List<TraceDefinition> defs;

	public TraceConcurrentExpression(LexLocation location, List<TraceDefinition> defs)
	{
		super(location);
		this.defs = defs;
	}

	@Override
	public void typeCheck(Environment local, NameScope scope)
	{
		for (TraceDefinition def: defs)
		{
			def.typeCheck(local, scope);
		}
	}

	@Override
	public TraceIterator expand(Context ctxt)
	{
		ConcurrentIterator node = new ConcurrentIterator();

		for (TraceDefinition term: defs)
		{
			node.nodes.add(term.getIterator(ctxt));
		}

		return node;
	}
}
