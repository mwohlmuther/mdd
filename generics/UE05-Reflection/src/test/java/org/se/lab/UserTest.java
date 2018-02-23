package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void testToString() {
		User u = new User(7, "wohlmuther", "*******");
		Assert.assertEquals("7,wohlmuther,*******", u.toString());
	}

}
