package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class StringListHolderTest {

	private StringListHolder lh = new StringListHolder(1);

	@Test
	public void testEmptyList() {

		Assert.assertTrue(lh.getStringList().isEmpty());
	}

	@Test
	public void testFillList() {
		lh.addElement("firstElement");
		lh.addElement("secondElement");

		Assert.assertFalse(lh.getStringList().isEmpty());

		Assert.assertEquals("firstElement", lh.getStringList().get(0));
		Assert.assertEquals("secondElement", lh.getStringList().get(1));
	}

}
