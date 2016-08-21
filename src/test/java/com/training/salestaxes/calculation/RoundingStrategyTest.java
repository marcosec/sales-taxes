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
		BigDecimal roundedValue = roundingStrategy.roundUp(BigDecimal.valueOf(14.99), 10);

		assertEquals(0, roundedValue.compareTo(BigDecimal.valueOf(1.5d)));
	}

	@Test
	public void shouldRoundToNearestHalf_Down()
	{
		BigDecimal roundedValue = roundingStrategy.roundUp(BigDecimal.valueOf(14.21), 10);

		assertEquals(0, roundedValue.compareTo(BigDecimal.valueOf(1.45d)));
	}
}
