package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetamodelTest
{
	private MTable table;
	
	
	@Before
	public void setup()
	{
		table = new MTable("User");
		
		MColumnn id = new MColumnn("id");
		id.setType(new MType("INT"));
		id.getConstraints().add(new MConstraint("NOT NULL"));
		id.getConstraints().add(new MConstraint("PRIMARY KEY"));
		table.getColumns().add(id);
		
		MColumnn username = new MColumnn("username");
		username.setType(new MType("VARCHAR(256)"));
		username.getConstraints().add(new MConstraint("NOT NULL"));
		table.getColumns().add(username);
		
		MColumnn passwd = new MColumnn("passwd");
		passwd.setType(new MType("VARCHAR(256)"));
		passwd.getConstraints().add(new MConstraint("NOT NULL"));
		table.getColumns().add(passwd);
	}

	
	@Test
	public void testTable()
	{
		Assert.assertEquals("User", table.getName());
		Assert.assertEquals(3, table.getColumns().size());
	}

	@Test
	public void testColumnId()
	{
		MColumnn id = table.getColumns().get(0);
		
		Assert.assertEquals("id", id.getName());
		Assert.assertEquals("INT", id.getType().getName());
		Assert.assertEquals("NOT NULL", id.getConstraints().get(0).getName());
		Assert.assertEquals("PRIMARY KEY", id.getConstraints().get(1).getName());
	}	
}
