package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;
import static org.junit.Assert.*;

public class RangeTest {

	private Range rangeObjectUnderTest;

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",
					0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
	}
}
