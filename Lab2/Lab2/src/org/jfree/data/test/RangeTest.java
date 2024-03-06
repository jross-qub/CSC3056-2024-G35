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
     * Start of tests for combine method
     */
    
    @Test
    public void testCombineReturnsRange1WhenRange2IsNull() {
    	// Setup
    	Range range1 = new Range(2,6);
    	
    	//Exercise and Verify
        assertEquals("When the input for range2 is null, the returned range should be equal to range1",
        		range1, Range.combine(range1, null));
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenRange1IsNegativeAndRange2IsPositive() {
    	// Setup
    	Range range1 = new Range(-7,-1);
    	Range range2 = new Range(3,3);
    	Range expectedRangeAfterTest = new Range(-7, 3);
    	
    	//Exercise and Verify
    	try {
    		assertEquals("When both a negative and a positive range are input, the returned range object should be expaned to include all values from both",
            		expectedRangeAfterTest, Range.combine(range1, range2));
    	} catch (IllegalArgumentException e) {
    		fail("Exception was thrown. Expected return value is unchanged range object. Error message:" + e.getMessage());
    	}
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenBothRangesAcrossZero() {
    	// Setup
    	Range range1 = new Range(-3,4);
    	Range range2 = new Range(-8,1);
    	Range expectedRangeAfterTest = new Range(-8, 4);
    	
    	//Exercise and Verify
        assertEquals("When both ranges have positive and negative values, the returned range object should be expaned to include all values from both",
        		expectedRangeAfterTest, Range.combine(range1, range2));
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenRange1IsPostiveAndRange2IsAcrossZero() {
    	// Setup
    	Range range1 = new Range(5,5);
    	Range range2 = new Range(-6,-2);
    	Range expectedRangeAfterTest = new Range(-6, 5);
    	
    	//Exercise and Verify
        assertEquals("When range1 is positive and range2 has both positve and negative values, the returned range object should be expaned to include all values from both",
        		expectedRangeAfterTest, Range.combine(range1, range2));
    }
    
    @Test
    public void testCombineReturnsRange2WhenRange1IsNull() {
    	// Setup
    	Range range2 = new Range(2,6);
    	
    	//Exercise and Verify
        assertEquals("When the input for range1 is null, the returned range should be equal to range2",
        		range2, Range.combine(null, range2));
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenRange1IsPositiveAndRange2IsNegative() {
    	// Setup
    	Range range1 = new Range(5,10);
    	Range range2 = new Range(-5,-3);
    	Range expectedRangeAfterTest = new Range(-5, 10);
    	
    	//Exercise and Verify
        assertEquals("When both a negative and a positive range are input, the returned range object should be expaned to include all values from both",
        		expectedRangeAfterTest, Range.combine(range1, range2));
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenRange1IsNegativeAndRange2IsAcrossZero() {
    	// Setup
    	Range range1 = new Range(-3,-1);
    	Range range2 = new Range(-2,16);
    	Range expectedRangeAfterTest = new Range(-3, 16);
    	
    	//Exercise and Verify
    	try {
    		assertEquals("When range1 is negative and range2 has both positve and negative values, the returned range object should be expaned to include all values from both",
            		expectedRangeAfterTest, Range.combine(range1, range2));
    	} catch (IllegalArgumentException e) {
    		fail("Exception was thrown. Expected return value is unchanged range object. Error message:" + e.getMessage());
    	}
    }

    @Test
    public void testCombineReturnsExpanedRangeWhenRange1IsAcrossZeroAndRange2IsPositive() {
    	// Setup
    	Range range1 = new Range(-5,6);
    	Range range2 = new Range(3,4);
    	Range expectedRangeAfterTest = new Range(-5, 6);
    	
    	//Exercise and Verify
    	try {
    		assertEquals("When range1 has both positve and negative values and range2 is positive, the returned range object should be expaned to include all values from both",
            		expectedRangeAfterTest, Range.combine(range1, range2));
    	} catch (IllegalArgumentException e) {
    		fail("Exception was thrown. Expected return value is unchanged range object. Error message:" + e.getMessage());
    	}
    }
    
    @Test
    public void testCombineReturnsExpanedRangeWhenBothRangesArePositive() {
    	// Setup
    	Range range1 = new Range(10, 10);
    	Range range2 = new Range(5,5);
    	Range expectedRangeAfterTest = new Range(5, 10);
    	
    	//Exercise and Verify
        assertEquals("When both ranges have positive values, the returned range object should be expaned to include all values from both",
        		expectedRangeAfterTest, Range.combine(range1, range2));
    }
    
    /**
     * End of tests for combine method
     */
    
    /**
     * Start of tests for constrain method
     */

    /**
     * TC1 - Tests the constrain method when the value is less than the lower bound.
     */
    @Test
    public void testConstrainReturnsLowerBoundWhenValueIsLessThanLowerBound() {
        assertEquals("When the value is less than the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-4), 0.000000001d);
    }

    /**
     * TC2 - Tests the constrain method when the value is equal to the lower bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToLowerBound() {
        assertEquals("When the value equal to the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-3), 0.000000001d);
    }

    /**
     * TC3 - Tests the constrain method when the value is one greater than the lower bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsOneGreaterThanLowerBound() {
        assertEquals("When the value is greater than the lower bound, the constrained value should be the input value",
                -2, rangeObjectUnderTest.constrain(-2), 0.000000001d);
    }

    /**
     * TC4 - Tests the constrain method when the value is inside the range.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsInsideRange() {
        assertEquals("When the value inside the bounds of the range, the constrained value should be the input value",
                0.4567, rangeObjectUnderTest.constrain(0.4567), 0.000000001d);
    }

    /**
     * TC5 - Tests the constrain method when the value is less than the upper bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsLessThanUpperBound() {
        assertEquals("When the value is less than the upper bound, the constrained value should be the input value",
                4, rangeObjectUnderTest.constrain(4), 0.000000001d);
    }

    /**
     * TC6 - Tests the constrain method when the value is equal to the upper bound.
     */
    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToUpperBound() {
        assertEquals("When the value equal to the upper bound, the constrained value should be the lower bound of the range",
                5, rangeObjectUnderTest.constrain(5), 0.000000001d);
    }

    /**
     * TC7 - Tests the constrain method when the value is greater than the upper bound.
     */
    @Test
    public void testConstrainReturnsUpperBoundWhenValueIsGreaterThanLowerBound() {
        assertEquals("When the value is greater than the upper bound, the constrained value should be the upper bound of the range",
                5, rangeObjectUnderTest.constrain(6), 0.000000001d);
    }
    
    /**
     * End of tests for constrain method
     */
    
    /**
     * Start of tests for expandToInclude method
     */
    
    @Test
    public void testExpandToIncludeReturnsExpandedRangeWhenValueIsLessThanLowerBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(2,6);
    	Range expectedRangeAfterTest = new Range(1,6);

    	
    	//Exercise and Verify
        assertEquals("When the value is less than lower bound, the returned range object should have a new lower bound equal to value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 1));
    }
    
    @Test
    public void testExpandToIncludeReturnsUnchangedRangeWhenValueIsEqualToLowerBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(-7, 11);
    	Range expectedRangeAfterTest = new Range(-7, 11);
    	
    	//Exercise and Verify
    	try {
    		assertEquals("When the value is equal to lower bound, the returned range object should be unchanged",
            		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, -7));
    	} catch (IllegalArgumentException e) {
    		fail("Exception was thrown. Expected return value is unchanged range object. Error message:" + e.getMessage());
    	}
        
    }
    
    @Test
    public void testExpandToIncludeReturnsUnchangedRangeWhenValueIsGreaterThenLowerBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(-3, 4);
    	Range expectedRangeAfterTest = new Range(-3, 4);
    	
    	//Exercise and Verify
        assertEquals("When the value is greater than lower bound, the returned range object should be unchanged",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, -2));
    }
    
    @Test
    public void testExpandToIncludeReturnsExpandedRangeWhenValueIsTypicalAndGreater() {
    	// Setup
    	Range rangeObjectToTest = new Range(5, 5);
    	Range expectedRangeAfterTest = new Range(5, 10);
    	
    	//Exercise and Verify
        assertEquals("When the value is outside the range, the returned range object should be expaned to include the value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 10));
    }
    
    @Test
    public void testExpandToIncludeReturnsARangeOfValueWhenRangeIsNull() {
    	// Setup
    	Range rangeObjectToTest = null;
    	Range expectedRangeAfterTest = new Range(1, 1);
    	
    	//Exercise and Verify
        assertEquals("When the range is null, the returned range object should be have lower and upper equal to value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 1));
    }
    
    @Test
    public void testExpandToIncludeReturnsUnchangedRangeWhenValueIsLessThanUpperBund() {
    	// Setup
    	Range rangeObjectToTest = new Range(5, 10);
    	Range expectedRangeAfterTest = new Range(5, 10);
    	
    	//Exercise and Verify
        assertEquals("When the value is one less than upper bound, the returned range object should be unchanged",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 9));
    }
    
    @Test
    public void testExpandToIncludeReturnsUnchangedRangeWhenValueIsEqualToUpperBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(-3, -1);
    	Range expectedRangeAfterTest = new Range(-3, -1);
    	
    	//Exercise and Verify
    	assertEquals("When the value is equal to upper bound, the returned range object should be unchanged",
            	expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, -1));
    }
    
    @Test
    public void testExpandToIncludeReturnsExpandedRangeWhenValueIsGreaterThanUpperBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(-5,6);
    	Range expectedRangeAfterTest = new Range(-5,7);

    	
    	//Exercise and Verify
        assertEquals("When the value is greater than upper bound, the returned range object should have a new upper bound equal to value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 7));
    }
    
    @Test
    public void testExpandToIncludeReturnsExpandedRangeWhenValueIsTypicalAndLess() {
    	// Setup
    	Range rangeObjectToTest = new Range(10, 10);
    	Range expectedRangeAfterTest = new Range(1, 10);
    	
    	//Exercise and Verify
        assertEquals("When the value is outside the range, the returned range object should be expaned to include the value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, 1));
    }
    
    @Test
    public void testExpandToIncludeReturnsARangeOfValueWhenRangeIsNullAndValueIsNegative() {
    	// Setup
    	Range rangeObjectToTest = null;
    	Range expectedRangeAfterTest = new Range(-7, -7);
    	
    	//Exercise and Verify
        assertEquals("When the range is null, the returned range object should be have lower and upper equal to value",
        		expectedRangeAfterTest, Range.expandToInclude(rangeObjectToTest, -7));
    }
    
    /**
     * End of tests for expandToInclude method
     */
   
}
