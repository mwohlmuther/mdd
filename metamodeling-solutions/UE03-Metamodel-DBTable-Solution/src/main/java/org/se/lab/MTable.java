package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class MTable extends MNamedElement
{
	/*
	 * Constructor
	 */
	public MTable(String name)
	{
		super(name);
	}

	/*
	 * Reference: ---[*]-> MColumn
	 */
	private List<MColumnn> columns = new ArrayList<MColumnn>();
	public List<MColumnn> getColumns()
	{
		return columns;
	}
	public void setColumns(List<MColumnn> columns)
	{
		this.columns = columns;
	}
}
