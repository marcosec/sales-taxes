package com.training.salestaxes.taxes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

		assertEquals(1.42d, roundedValue, 0);
	}
}
