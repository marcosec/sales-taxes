package com.training.salestaxes.taxes;

import java.math.BigDecimal;

public class RoundingStrategy
{
	public RoundingStrategy()
	{

	}

	public static double roundUp(double price, int rate)
	{
		BigDecimal taxValue = new BigDecimal(price * rate / 100);
		BigDecimal taxValueRoundedUp = taxValue.setScale(2, BigDecimal.ROUND_HALF_UP);
		return taxValueRoundedUp.doubleValue();
	}
}
