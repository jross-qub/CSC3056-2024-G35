package org.jfree.data.test;


import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.*;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;

public class DataUtilitiesTest 
{
	// private Values2D values2D;
	private Values2D testData2D;
	private Values2D emptyTestData2D;
	private Values2D nullTestData2D;

	@Before
	public void setUp()
	{
		// Example setUp
		// DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		// values2D = testValues;
		// testValues.addValue(1, 0, 0);
		// testValues.addValue(4, 1, 0);
		
		// Setup for our test suite
		DefaultKeyedValues2D testData = new DefaultKeyedValues2D();
		testData2D = testData;
		testData.addValue(1, 0, 0);
		testData.addValue(3.4, 0, 1);
		testData.addValue(5, 0, 2);
		testData.addValue(6.7, 0, 3);
		testData.addValue(7, 0, 4);
		testData.addValue(8, 0, 5);
		testData.addValue(11, 1, 0);
		testData.addValue(17, 1, 1);
		testData.addValue(5.5, 1, 2);
		testData.addValue(4, 1, 3);
		testData.addValue(52, 1, 4);
		testData.addValue(7.1, 1, 5);
		
		DefaultKeyedValues2D emptyTestData = new DefaultKeyedValues2D();
		emptyTestData2D = emptyTestData;
		
		DefaultKeyedValues2D nullTestData = null;
		nullTestData2D = nullTestData;

	}

	@After
	public void tearDown()
	{
		// values2D = null;
		testData2D = null;
	}
	
	// @Test
	// public void testValidDataAndColumnColumnTotal()
	// {
	// 	assertEquals("Wrong sum returned. It should be 5.0", 
	// 			5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	// }
	
	// @Test
	// public void testNullDataColumnTotal() 
	// {
	// 	try
	// 	{
	// 		DataUtilities.calculateColumnTotal(null, 0);
	// 		fail("No execption thrown");
	// 	}
	// 	catch (Exception e)
	// 	{
	// 		assertTrue("Incorrect exception type thrown",
	// 				e.getClass().equals(InvalidParameterException.class));
	// 	}
	// }
	
	/**
	 * Tests for the DataUtilities calculateColumnTotal Method
	 */
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnIsLessThanMinimum() 
	{
		try
		{
			assertEquals("Wrong sum returned. It should be 0", 0, DataUtilities.calculateColumnTotal(testData2D,-1), 0.0000001d);
		}
		catch (Exception e) 
		{
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
			fail("Exception was thrown. Expected return value equal to 0");
		}
	}
	
	@Test
	public void testCalculateColumnTotalReturnsTotalWhenColumnIsMinimumValue()
	{
		assertEquals("Wrong sum returned. It should be 12", 12, DataUtilities.calculateColumnTotal(testData2D, 0), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturnsTotalWhenColumnIsOneAboveMinimumValue()
	{
		assertEquals("Wrong sum returned. It should be 20.4", 20.4, DataUtilities.calculateColumnTotal(testData2D, 1), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturnsTotalWhenColumnIsANormalValue()
	{
		assertEquals("Wrong sum returned. It should be 10.7", 10.7, DataUtilities.calculateColumnTotal(testData2D, 3), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturnsTotalWhenColumnIsOneBelowMaximumValue()
	{
		assertEquals("Wrong sum returned. It should be 59", 59, DataUtilities.calculateColumnTotal(testData2D, 4), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturnsTotalWhenColumnIsMaximumValue()
	{
		assertEquals("Wrong sum returned. It should be 15.1", 15.1, DataUtilities.calculateColumnTotal(testData2D, 5), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnIsAboveMaximum()
	{
		try
		{
			assertEquals("Wrong sum returned. It should be 0", 0, DataUtilities.calculateColumnTotal(testData2D, 6), 0.0000001d);
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IndexOutOfBoundsException.class));
			fail("Exception was thrown. Expected return value equal to 0");
		}
		
	}
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnIsNegativeAndDataIsEmpty()
	{
		assertEquals("Wrong sum returned. It should be 0", 0, DataUtilities.calculateColumnTotal(emptyTestData2D, -1), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalReturns0WhenColumnIsPositiveAndDataIsEmpty()
	{
		assertEquals("Wrong sum returned. It should be 0", 0, DataUtilities.calculateColumnTotal(emptyTestData2D, 3), 0.0000001d);
	}
	
	@Test
	public void testCalculateColumnTotalThrowsExceptionWhenColumnIsPositiveAndDataIsNull()
	{
		try
		{
			DataUtilities.calculateColumnTotal(nullTestData2D, 3);
			fail("No exception thrown");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(IllegalArgumentException.class));
			
		}
	}
}
