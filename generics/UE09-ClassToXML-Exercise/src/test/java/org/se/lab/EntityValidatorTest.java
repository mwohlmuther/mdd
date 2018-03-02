package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EntityValidatorTest
{
	private XMLGenerator xmlgen;
	
	@Before
	public void setup()
	{
		xmlgen = new XMLGeneratorImpl();
	}
	
	@Test
	public void testXMLGeneration()
	{
		String xmlRepresentation = xmlgen.generateXML(ImplementedClass.class);
		
		System.out.println(xmlRepresentation);
		
		// The order of the Methods can differ, so we test with contains :-)
		Assert.assertTrue(xmlRepresentation.contains("<package name=\"org.se.lab\">"));
		Assert.assertTrue(xmlRepresentation.contains("  <class name=\"ImplementedClass\">"));
		Assert.assertTrue(xmlRepresentation.contains("  <method name=\"calculateSum\">"));
		Assert.assertTrue(xmlRepresentation.contains("    <param type=\"int\">"));
		Assert.assertTrue(xmlRepresentation.contains("    <param type=\"int\">"));
		Assert.assertTrue(xmlRepresentation.contains("    <param type=\"int\">"));
		Assert.assertTrue(xmlRepresentation.contains("  </method>"));
		Assert.assertTrue(xmlRepresentation.contains("  <method name=\"getIds\">"));
		Assert.assertTrue(xmlRepresentation.contains("  </method>"));
		Assert.assertTrue(xmlRepresentation.contains("  <method name=\"setMyString\">"));
		Assert.assertTrue(xmlRepresentation.contains("    <param type=\"java.lang.String\">"));
		Assert.assertTrue(xmlRepresentation.contains("  </method>"));
		Assert.assertTrue(xmlRepresentation.contains("  <method name=\"getMyString\">"));
		Assert.assertTrue(xmlRepresentation.contains("  </method>"));
		Assert.assertTrue(xmlRepresentation.contains("</class>"));
		Assert.assertTrue(xmlRepresentation.contains("</package>"));
	}
}
