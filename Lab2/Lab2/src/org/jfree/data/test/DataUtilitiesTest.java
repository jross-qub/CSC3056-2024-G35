package org.jfree.data.test;


import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.*;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;

public class DataUtilitiesTest 
{
	private Values2D values2D;

	@Before
	public void setUp()
	{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	@After
	public void tearDown()
	{
		values2D = null;
	}
	
	@Test
	public void testValidDataAndColumnColumnTotal()
	{
		assertEquals("Wrong sum returned. It should be 5.0", 
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testNullDataColumnTotal() 
	{
		try
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No execption thrown");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
					e.getClass().equals(InvalidParameterException.class));
		}
	}
}
