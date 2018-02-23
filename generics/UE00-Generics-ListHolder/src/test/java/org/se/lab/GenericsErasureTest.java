package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GenericsErasureTest {

	@Test
	public void testInstanceOf() {
		List<Integer> intHolder = new ArrayList<Integer>();
		List<String> stringHolder = new ArrayList<String>();

		Assert.assertTrue(intHolder instanceof List);
		Assert.assertTrue(stringHolder instanceof List);
	}

	@Test
	public void testInstanceOfExplaination() {
		List<Integer> intHolder = new ArrayList<Integer>();
		List<String> stringHolder = new ArrayList<String>();

		/**
		 * Generics are implemented by erasure because the types Holder<E> and Holder<T>
		 * are represented at run-time by the same type, Holder.
		 */

		Assert.assertTrue(intHolder instanceof List);
		Assert.assertTrue(stringHolder instanceof List);

		System.out.println(intHolder.getClass().getName());
		System.out.println(stringHolder.getClass().getName());

		Assert.assertTrue(intHolder instanceof ArrayList<?>);
	}

}
