package org.se.lab;

public class MType extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MType(String name)
	{
		super(name);
	}

	@Override
	public String toSql()
	{
		return getName();
	}
}
