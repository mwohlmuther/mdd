package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.junit.Test;
import org.se.lab.Company;
import org.se.lab.Version;

public class AnnotationsTest
{
	@Test
	public void testVersionFromClass()
	{
		Class<Company> user = Company.class;
		
		Annotation a = user.getAnnotations()[0];		
		assertEquals("org.se.lab.Version", a.annotationType().getName());
	}

	
	@Test
	public void testVersionFromObject()
	{
		Company user = new Company(7, "FH Joanneum");
		
		Annotation a = user.getClass().getAnnotation(Version.class);
		assertEquals("org.se.lab.Version", a.annotationType().getName());
	}

	
	@Test
	public void testVersionElements()
	{
		Company user = new Company(7, "FH Joanneum");
		
		AnnotatedElement type = user.getClass();
		assertTrue(type.isAnnotationPresent(Version.class));
		
		int major = type.getAnnotation(Version.class).major();
		int minor = type.getAnnotation(Version.class).minor();
		int bugfix = type.getAnnotation(Version.class).bugfix();
			
		System.out.println(user.getClass().getName() + " in Version " 
				+ major + "." + minor + "." + bugfix);		

		assertEquals(2, major);
		assertEquals(3, minor);
		assertEquals(17, bugfix);	
	}
}
