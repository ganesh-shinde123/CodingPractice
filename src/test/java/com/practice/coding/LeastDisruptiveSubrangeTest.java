package com.practice.coding;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ganesh Shinde
 *
 */
public class LeastDisruptiveSubrangeTest {

	private LeastDisruptiveSubrange leastDisruptiveSubrange;

	@Before
	public void init() {
		leastDisruptiveSubrange = new LeastDisruptiveSubrange();
	}

	@Test
	public void testGetLeastDisruptiveSubrangeIndexWithLessLengthReplacement() {
		int[] original = new int[] { 1, 2, 3, 4, 5 };
		int[] replacement = new int[] { 3, 5, 3 };
		assertEquals(2, leastDisruptiveSubrange.getLeastDisruptiveSubrangeIndex(original, replacement));
	}

	@Test
	public void testGetLeastDisruptiveSubrangeIndexWithEqualLengthReplacement() {
		int[] original = new int[] { 1, 2, 3, 4, 5 };
		int[] replacement = new int[] { 3, 5, 3, 4, 5 };
		assertEquals(0, leastDisruptiveSubrange.getLeastDisruptiveSubrangeIndex(original, replacement));
	}

	@Test
	public void testGetLeastDisruptiveSubrangeIndexWithGreaterLengthReplacement() {
		int[] original = new int[] { 1, 2, 3, 4, 5 };
		int[] replacement = new int[] { 3, 5, 3, 4, 5, 6 };
		assertEquals(-1, leastDisruptiveSubrange.getLeastDisruptiveSubrangeIndex(original, replacement));
	}

	@Test
	public void testGetLeastDisruptiveSubrangeIndexWithRandomReplacement() {
		int[] original = new int[] { 2, 5, 9, 1, -3, 40, 2, 19 };
		int[] replacement = new int[] { 10, -3, 39 };
		assertEquals(3, leastDisruptiveSubrange.getLeastDisruptiveSubrangeIndex(original, replacement));

		original = new int[] { 2, 5, 9, 1, -3, 10, -3, 39 };
		replacement = new int[] { 10, -3, 39 };
		assertEquals(5, leastDisruptiveSubrange.getLeastDisruptiveSubrangeIndex(original, replacement));
	}

}
