package org.se.lab;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GenericHolderTestObject {

	private GenericListHolder<Object> lhObject = new GenericListHolder<>(1);
	private GenericListHolder<BigDecimal> lhBigDecimal = new GenericListHolder<>(2);

	@Test
	public void testEmptyList() {
		Assert.assertTrue(lhObject.getList().isEmpty());
		Assert.assertTrue(lhBigDecimal.getList().isEmpty());
	}

	@Test
	public void testFillObjectListWithBigDecimal() {
		lhObject.addElement(new BigDecimal(111));
		lhObject.addElement(new BigDecimal(222));

		Assert.assertFalse(lhObject.getList().isEmpty());

		// Casten der Werte ist notwendig
		BigDecimal firstValue = (BigDecimal) lhObject.getList().get(0);
		BigDecimal secondValue = (BigDecimal) lhObject.getList().get(1);

		BigDecimal sum = firstValue.add(secondValue);

		Assert.assertEquals(0, new BigDecimal(333).compareTo(sum));
	}

	@Test
	public void testFillBigDecimalListWithBigDecimal() {
		lhBigDecimal.addElement(new BigDecimal(111));
		lhBigDecimal.addElement(new BigDecimal(222));

		Assert.assertFalse(lhBigDecimal.getList().isEmpty());

		// KEIN CASTEN der Werte ist notwendig
		BigDecimal firstValue = lhBigDecimal.getList().get(0);
		BigDecimal secondValue = lhBigDecimal.getList().get(1);

		BigDecimal sum = firstValue.add(secondValue);

		Assert.assertEquals(0, new BigDecimal(333).compareTo(sum));
	}

}
