/*******************************************************************************
 *
 *	Copyright (C) 2008, 2009 Fujitsu Services Ltd.
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

public class AlternativeIterator extends TraceIterator
{
	private TraceIteratorList alternatives;

	public AlternativeIterator()
	{
		this.alternatives = new TraceIteratorList();
	}
	
	public void add(TraceIterator iter)
	{
		alternatives.add(iter);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		String sep = "";

		for (TraceIterator node: alternatives)
		{
			sb.append(sep);
			sb.append(node.toString());
			sep = " | ";
		}

		sb.append(")");
		return sb.toString();
	}

	@Override
	public CallSequence getNextTest()
	{
//		TestSequence tests = new TestSequence();
//
//		for (TraceIterator node: alternatives)
//		{
//			// Alternatives within an alternative are just like larger alts,
//			// so we add all the lower alts to the list...
//
//    		for (CallSequence test: node.getNextTest())
//    		{
//    			CallSequence seq = getVariables();
//    			seq.addAll(test);
//    			tests.add(seq);
//    		}
//		}
//
//		return tests;

		lastTest = alternatives.getNextTestAlternative();
		return lastTest;
	}

	@Override
	public boolean hasMoreTests()
	{
		return alternatives.hasMoreTests();
	}

	@Override
	public int count()
	{
		return alternatives.countAlternative();
	}

	@Override
	public void reset()
	{
		alternatives.reset();
	}

	@Override
	public boolean isReset()
	{
		return alternatives.isReset();
	}
}
