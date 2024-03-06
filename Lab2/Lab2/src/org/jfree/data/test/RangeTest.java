package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tests for the Range class.
 */
public class RangeTest {

    private Range rangeObjectUnderTest;

    /**
     * Sets up the test fixture.
     *
     * @throws Exception if an error occurs during setup.
     */
    @Before
    public void setUp() throws Exception {
        rangeObjectUnderTest = new Range(-3, 5);
    }

    /**
     * Tears down the test fixture.
     *
     * @throws Exception if an error occurs during teardown.
     */
    @After
    public void tearDown() throws Exception {
        rangeObjectUnderTest = null;
    }

    /**
     * Tests the constrain method when the value is less than the lower bound.
     */
    @Test
    public void testConstrainReturnsLowerBoundWhenValueIsLessThanLowerBound() {
        assertEquals("When the value is less than the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-4), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is equal to the lower bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToLowerBound() {
        assertEquals("When the value equal to the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-3), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is one greater than the lower bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsOneGreaterThanLowerBound() {
        assertEquals("When the value is greater than the lower bound, the constrained value should be the input value",
                -2, rangeObjectUnderTest.constrain(-2), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is inside the range.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsInsideRange() {
        assertEquals("When the value inside the bounds of the range, the constrained value should be the input value",
                0.4567, rangeObjectUnderTest.constrain(0.4567), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is less than the upper bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsLessThanUpperBound() {
        assertEquals("When the value is less than the upper bound, the constrained value should be the input value",
                4, rangeObjectUnderTest.constrain(4), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is equal to the upper bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToUpperBound() {
        assertEquals("When the value equal to the upper bound, the constrained value should be the lower bound of the range",
                5, rangeObjectUnderTest.constrain(5), 0.000000001d);
    }

    /**
     * Tests the constrain method when the value is greater than the upper bound.
     */
    @Test
    public void testConstrainReturnsUpperBoundWhenValueIsGreaterThanLowerBound() {
        assertEquals("When the value is greater than the upper bound, the constrained value should be the upper bound of the range",
                5, rangeObjectUnderTest.constrain(6), 0.000000001d);
    }
}
