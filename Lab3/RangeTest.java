package org.jfree.data;

import org.jfree.data.Range;
import org.junit.*;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;

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
     * Start of tests for combine(Range range1, Range range2) method
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
     * End of tests for combine(Range range1, Range range2) method
     */
    
    /**
     * Start of tests for constrain(double value) method
     */

    @Test
    public void testConstrainReturnsLowerBoundWhenValueIsLessThanLowerBound() {
        assertEquals("When the value is less than the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-4), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToLowerBound() {
        assertEquals("When the value equal to the lower bound, the constrained value should be the lower bound of the range",
                -3, rangeObjectUnderTest.constrain(-3), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsValueWhenValueIsOneGreaterThanLowerBound() {
        assertEquals("When the value is greater than the lower bound, the constrained value should be the input value",
                -2, rangeObjectUnderTest.constrain(-2), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsValueWhenValueIsInsideRange() {
        assertEquals("When the value inside the bounds of the range, the constrained value should be the input value",
                0.4567, rangeObjectUnderTest.constrain(0.4567), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsValueWhenValueIsLessThanUpperBound() {
        assertEquals("When the value is less than the upper bound, the constrained value should be the input value",
                4, rangeObjectUnderTest.constrain(4), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsValueWhenValueIsEqualToUpperBound() {
        assertEquals("When the value equal to the upper bound, the constrained value should be the lower bound of the range",
                5, rangeObjectUnderTest.constrain(5), 0.000000001d);
    }

    @Test
    public void testConstrainReturnsUpperBoundWhenValueIsGreaterThanLowerBound() {
        assertEquals("When the value is greater than the upper bound, the constrained value should be the upper bound of the range",
                5, rangeObjectUnderTest.constrain(6), 0.000000001d);
    }
    
    /**
     * End of tests for constrain(double value) method
     */
    
    /**
     * Start of tests for expandToInclude(Range range, double value) method
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
     * End of tests for expandToInclude(Range range, double value) method
     */
    
    /**
     * Start of tests for expand(Range range, double lowerMargin, double upperMargin) method - White Box Testing
     */
    
    @Test
    public void testExpandRaisesCorrectExceptionWhenRangeIsNull() {
    	// Setup
    	Range rangeObjectToTest = null;
    	double lowerMargin = 0; 
    	double upperMargin = 5;
    	
    	//Exercise and Verify
		try
		{
			Range.expand(rangeObjectToTest, lowerMargin, upperMargin);
			fail("When range is null an exception should be thrown");
		}
		catch (Exception e)
		{
			assertTrue("When range is null an IllegalArgumentException should be thrown",
					e.getClass().equals(IllegalArgumentException.class));
		}
    }
    
    @Test
    public void testExpandToIncludeReturnsExpandedRangeWhenLowerMarginIsEqualToLowerBoundAndUpperMarginIsAboveUpperBound() {
    	// Setup
    	Range rangeObjectToTest = new Range(0, 10);
    	Range expectedRangeAfterTest = new Range(0, 11);
    	
    	//Exercise and Verify
    	assertEquals("When the lowerMargin is Equal to lowerBound and upperMargin is above UpperBound, the returned range object should have a new upperBound Equal to upperMargin",
        		expectedRangeAfterTest, Range.expand(rangeObjectToTest, 0, 11 ));
    }
    
    /**
     * End of tests for expand method
     */
   
   
    /**
     * Start of tests for getLowerBound() method
     */
    
    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenBothLowerAndUpperArePositve() {
    	// Setup
        Range range = new Range(1, 6.6);

    	//Exercise and Verify
        assertEquals("When the both lower and upper are positive, lower should be returned",
        		1, range.getLowerBound(), 0.000000001d);
    }


    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenLowerIsNegativeAndUpperisPositve() {
    	// Setup
        Range range = new Range(-1, 1);

    	//Exercise and Verify
        assertEquals("When lower is negative and upper are positive, lower should be returned",
        		-1, range.getLowerBound(), 0.000000001d);
    }

    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenBothLowerAndUpperAreNegative() {
    	// Setup
        Range range = new Range(-6.8, -1);

    	//Exercise and Verify
        assertEquals("When the both lower and upper are negative, lower should be returned",
        		-6.8, range.getLowerBound(), 0.000000001d);
    }

    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenLowerIsNegativeAndUpperisZero() {
    	// Setup
        Range range = new Range(-10, 0);

    	//Exercise and Verify
        assertEquals("When lower is negative and upper is zero, lower should be returned",
        		-10, range.getLowerBound(), 0.000000001d);
    }

    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenLowerIsZeroAndUpperisPositve() {
    	// Setup
        Range range = new Range(0, 8);

    	//Exercise and Verify
        assertEquals("When lower is zero and upper are positive, zero should be returned",
        		0, range.getLowerBound(), 0.000000001d);
    }


    @Test
    public void testGetLowerBoundReturnsLowerBoundWhenBothLowerAndUpperAreZero() {
    	// Setup
        Range range = new Range(0, 0);

    	//Exercise and Verify
        assertEquals("When the both lower and upper are zero, zero should be returned",
        		0, range.getLowerBound(), 0.000000001d);
    }

    
    /**
     * End of tests for getLowerBound() method
     */
    
    /**
     * Start of tests for hashcode() method - White Box Testing
     */
    
    @Test 
    public void testHashcodeReturnsHashcode() {
    	// Setup
   
    	//Exercise and Verify
        assertTrue("The return should be of type Int",
        		Integer.class.isInstance(rangeObjectUnderTest.hashCode()));
    }
    
    /**
     * End of tests for hashcode method
     */
    
    
    /**
     * Start of tests for intersects(double lower, double upper) method - White Box Testing
     */
    
    @Test 
    public void testIntersectsReturnsTrueWhenLowerIsBelowUpperBoundAndUpperIsAboveLowerBound() {
    	// Setup
        Double lower = -2.00;
        Double upper = 6.00;

    	//Exercise and Verify
        assertTrue("When the lower is below upper bound and upper is above lower bound, the return should be true",
        		rangeObjectUnderTest.intersects(lower, upper));
    }
    
    @Test 
    public void testIntersectsReturnsTrueWhenLowerIsEqualToLowerBoundAndUpperIsAboveLower() {
    	// Setup
        Double lower = -3.00;
        Double upper = 6.00;
        

    	//Exercise and Verify
        assertTrue("When the lower is equal to lower bound and upper is above lower bound, the return should be false",
        		rangeObjectUnderTest.intersects(lower, upper));
    }
    
    @Test 
    public void testIntersectsReturnsFalseWhenLowerIsAboveUpperBoundAndUpperIsBelowUpperBound() {
    	// Setup
        Double lower = 6.00;
        Double upper = 7.00;

    	//Exercise and Verify
        assertFalse("When the lower is above upper bound and upper is above upper bound, the return should be false",
        		rangeObjectUnderTest.intersects(lower, upper));
    }
    
    @Test 
    public void testIntersectsReturnsFalseWhenLowerIsEqualToLowerAndUpperIsBelowLowerBound() {
    	// Setup
        Double lower = -3.00;
        Double upper = -4.00;

    	//Exercise and Verify
        assertFalse("When the lower is equal to lower bound and upper is below lower bound, the return should be true",
        		rangeObjectUnderTest.intersects(lower, upper));
    }
    
    /**
     * End of tests for intersects method
     */
    
    /**
     * Start of tests for shift(Range base, double value, boolean allowZeroCrossing) method
     */
    
    @Test
    public void testShiftReturnsShiftedRangeWhenBaseAndDeltaArePositve() {
    	// Setup
        Range rangeObjectToTest = new Range(2, 6);
        Range expectedRangeAfterTest = new Range(3, 7);

    	//Exercise and Verify
        assertEquals("When the both base and delta are positive, the return should be base shifted to the right by delta", 
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, 1, false));
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseAndDeltaAreNegative() {
    	// Setup
        Range rangeObjectToTest = new Range(-7, -1);
        Range expectedRangeAfterTest = new Range(-11, -5);

    	//Exercise and Verify
        assertEquals("When the both base and delta are negative, the return should be base shifted to the left by -delta", 
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, -4, true));
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseIsAcrossZeroAndDeltaIsZero() {
    	// Setup
        Range rangeObjectToTest = new Range(-3, 4);
        Range expectedRangeAfterTest = new Range(-3, 4);

    	//Exercise and Verify
        assertEquals("When the both base is across zero and delta is zero, the return should be base unchanged",
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, 0, false));
    }
    
    @Test
    public void testShiftReturnsShiftedRangeWhenBaseIsPostiveAndDeltaIsNegativeAllowZeroCrossing() {
    	// Setup
        Range rangeObjectToTest = new Range(5, 5);
        Range expectedRangeAfterTest = new Range(-3, -3);

    	//Exercise and Verify
        assertEquals("When the base is positive and delta is negative, the return should be base shifted to the left by -delta, as allowZeroCrossing is True the new upper should NOT be zero",
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, -8, true));
    }

    @Test
    public void testShiftThrowsExceptionWhenBaseIsNullAndDeltaIsPositive() {
    	// Setup
        Range rangeObjectToTest = null;

    	//Exercise and Verify
		try
		{
			Range.shift(rangeObjectToTest, 5, false);
			fail("When the base is null and delta is positive, an exception should be thrown");
		}
		catch (Exception e)
		{
			assertTrue(String.format("Incorrect exception type thrown, should be InvalidParameterException. Type is: " + e.getClass().getCanonicalName()),
					e.getClass().equals(InvalidParameterException.class));
		}
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseIsPositiveAndDeltaIsZero() {
    	// Setup
        Range rangeObjectToTest = new Range(5, 10);
        Range expectedRangeAfterTest = new Range(5, 10);

    	//Exercise and Verify
        assertEquals("When the both base is positive and delta is zero, the return should be base unchanged",
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, 0, true));
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseIsNegativeAndDeltaIsPositiveNoAllowZeroCrossing() {
    	// Setup
        Range rangeObjectToTest = new Range(-3, -1);
        Range expectedRangeAfterTest = new Range(-1, 0);

    	//Exercise and Verify
        assertEquals("When the base is neagtive and delta is positive, the return should be base shifted to the right by delta, as allowZeroCrossing is False the new upper should be zero",
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, 2, false));
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseIsNegativeAndDeltaIsNegative() {
    	// Setup
        Range rangeObjectToTest = new Range(-5, 6);
        Range expectedRangeAfterTest = new Range(-6, 5);

    	//Exercise and Verify
        assertEquals("When the both base is positive and delta is zero, the return should be base shifted to the left by -delta",
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, -1, true));
    }

    @Test
    public void testShiftReturnsShiftedRangeWhenBaseAndDeltaArePositveNoAllowZeroCrossing() {
    	// Setup
        Range rangeObjectToTest = new Range(10, 10);
        Range expectedRangeAfterTest = new Range(13, 13);

        //Exercise and Verify
        assertEquals("When the both base and delta are positive, the return should be base shifted to the right by delta", 
        		expectedRangeAfterTest, Range.shift(rangeObjectToTest, 3, false));
    }

    @Test
    public void testShiftThrowsExceptionWhenBaseIsNullAndDeltaIsNegative() {
    	// Setup
        Range rangeObjectToTest = null;

    	//Exercise and Verify
		try
		{
			Range.shift(rangeObjectToTest, -7, true);
			fail("When the base is null and delta is negative, an exception should be thrown");
		}
		catch (Exception e)
		{
			assertTrue(String.format("Incorrect exception type thrown, should be InvalidParameterException. Type is: " + e.getClass().getCanonicalName()),
					e.getClass().equals(InvalidParameterException.class));
		}
    }
    
    /**
     * End of tests for shift method
     */
    
    
    
}
