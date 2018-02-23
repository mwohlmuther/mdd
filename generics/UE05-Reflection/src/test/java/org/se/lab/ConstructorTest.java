package org.se.lab;

import java.lang.reflect.Constructor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest {
	private Constructor<?>[] constructors;

	@Before
	public void setup() {
		Class<User> c = User.class;
		constructors = c.getDeclaredConstructors();
		Assert.assertEquals(1, constructors.length);
	}

	@Test
	public void testInitConstructor() {
		Constructor<?> constr = constructors[0];
		Class<?>[] types = constr.getParameterTypes();
		Assert.assertEquals(3, types.length);
		Assert.assertEquals("int", types[0].getName());
		Assert.assertEquals("java.lang.String", types[1].getName());
		Assert.assertEquals("java.lang.String", types[2].getName());
	}
}
