package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MColumnn extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MColumnn(String name)
	{
		super(name);
	}

	
	/*
	 * Reference: ---[1]-> MType
	 */
	private MType type;
	public MType getTypes()
	{
		return type;
	}
	public void setType(MType type)
	{
		this.type = type;
	}
	
	
	/*
	 * Reference: ---[*]-> MConstraint
	 */
	private List<MConstraint> constraints = new ArrayList<MConstraint>();
	public List<MConstraint> getConstraints()
	{
		return constraints;
	}
	public void setConstraints(List<MConstraint> constraints)
	{
		this.constraints = constraints;
	}
}