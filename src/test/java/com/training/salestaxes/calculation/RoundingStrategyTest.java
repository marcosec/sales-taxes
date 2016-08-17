package com.training.salestaxes.calculation;

import java.math.BigDecimal;

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
		double roundedValue = roundingStrategy.roundUp(BigDecimal.valueOf(14.99), 10);

		assertEquals(1.5d, roundedValue, 0);
	}

	@Test
	public void shouldRoundToNearestHalf_Down()
	{
		double roundedValue = roundingStrategy.roundUp(BigDecimal.valueOf(14.21), 10);

		assertEquals(1.45d, roundedValue, 0);
	}

	@Test
	public void shouldTruncateToTwoDecimalDigits_halfDown()
	{
		double roundedValue = roundingStrategy.roundTwoDecimal(14.233333d);

		assertEquals(14.23d, roundedValue, 0);
	}

	@Test
	public void shouldTruncateToTwoDecimalDigits_halfUp()
	{
		double roundedValue = roundingStrategy.roundTwoDecimal(14.23854d);

		assertEquals(14.24d, roundedValue, 0);
	}
}
