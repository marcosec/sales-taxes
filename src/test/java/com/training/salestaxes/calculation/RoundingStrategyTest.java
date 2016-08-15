package com.training.salestaxes.calculation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RoundingStrategyTest
{

	private RoundingStrategy roundingStrategy;

	@Before
	public void setup()
	{
		roundingStrategy = new RoundingStrategy();
	}

	@Test
	public void shouldRoundToNearestHalf_Up()
	{
		double roundedValue = roundingStrategy.roundUp(14.99d, 10);

		assertEquals(1.5d, roundedValue, 0);
	}

	@Test
	public void shouldRoundToNearestHalf_Equals()
	{
		double roundedValue = roundingStrategy.roundUp(14.5d, 10);

		assertEquals(1.45d, roundedValue, 0);
	}

	@Test
	public void shouldRoundToNearestHalf_Down()
	{
		double roundedValue = roundingStrategy.roundUp(14.23d, 10);

		assertEquals(1.4d, roundedValue, 0);
	}

	@Test
	public void shouldTruncateToTwoDecimalDigits()
	{
		double roundedValue = roundingStrategy.roundTwoDecimal(14.233333d);

		assertEquals(14.23d, roundedValue, 0);
	}

	@Test
	public void test()
	{
		double roundedValue = roundingStrategy.roundUp(11.25d, 5);

		assertEquals(0.6d, roundedValue, 0);
	}
}
