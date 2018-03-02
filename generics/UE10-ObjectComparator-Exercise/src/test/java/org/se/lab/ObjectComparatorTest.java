package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.entities.Dogge;
import org.se.lab.entities.Perser;

public class ObjectComparatorTest
{
	private ObjectComparator comparator;
	
	@Before
	public void setup()
	{
		comparator = new ObjectComparatorImpl();
	}
	
	@Test
	public void testCompareDogWithCat()
	{
		String diff = comparator.findDifferences(new Dogge(), new Perser());
		
		// System.out.println(diff);
		
		Assert.assertEquals("Annotation only in Dogge: Dog\n" + 
				"Annotation only in Perser: Cat\n" + 
				"Methods: Dogge:3  Perser:4\n" + 
				"Constructors: Dogge:2  Perser:1\n", diff);
	}
	
	@Test
	public void testCompareDogWithDog()
	{
		String diff = comparator.findDifferences(new Dogge(), new Dogge());
		
		// System.out.println(diff);
		
		Assert.assertEquals("No Differences found", diff);
	}
	
	@Test
	public void testCompareDogWithAnimal()
	{
		String diff = comparator.findDifferences(new Dogge(), new org.se.lab.entities.Animal());
		
		// System.out.println(diff);
		
		Assert.assertEquals("Annotation only in Dogge: Dog\n" + 
				"Annotation only in Animal: Animal\n" + 
				"Methods: Dogge:3  Animal:0\n" + 
				"Constructors: Dogge:2  Animal:1\n", diff);
	}
}
