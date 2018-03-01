package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntityValidatorTest
{
	private EntityValidator validator;
	
	@Before
	public void setup()
	{
		validator = new EntityValidatorImpl();
	}
	
	@Test
	public void testProduct() throws NoSuchFieldException, SecurityException
	{
		Boolean isValid = validator.validateEntity(Product.class);
		
		// The Product entity is valid.
		Assert.assertTrue(isValid);
	}
	
	@Test(expected=NoSuchFieldException.class)
	public void testPlant() throws NoSuchFieldException, SecurityException
	{
		Boolean isValid = validator.validateEntity(Plant.class);
		
		// The Product entity is not valid.
		Assert.assertFalse(isValid);	
	}
	
	@Test
	public void testPowerPlant() throws NoSuchFieldException, SecurityException
	{
		Boolean isValid = validator.validateEntity(PowerPlant.class);
		
		// The Product entity is not valid.
		Assert.assertFalse(isValid);	
	}
}
