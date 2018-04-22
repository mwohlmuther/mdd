package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.entity.User;

public class CreateInsertGeneratorTest
{
	private Visitor visitor;
	private User user;
	
	
	@Before
	public void setup()
	{
	    visitor = new CreateInsertGenerator();

		user = new User();
		user.setAge(1);
		user.setGender("m");
		user.setUsername("Horst");
	}
	
	
	@Test
	public void testGenerateSQL() throws Exception
	{
		String sqlInsert = visitor.visitUser(user);
		System.out.println(sqlInsert);
	}
}
