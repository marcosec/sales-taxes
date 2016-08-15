package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class RoundingStrategy
{
	private static DecimalFormat decimalFormat;

	public RoundingStrategy()
	{
		decimalFormat = new DecimalFormat(".##");
	}

	public static double roundUp(double price, int rate)
	{
		return applyOn(price * rate / 100);
	}


	public static double roundTwoDecimal(double price)
	{
		return applyOn(price);
	}

	private static double applyOn(double val)
	{
		BigDecimal taxValue = new BigDecimal(val);
		BigDecimal taxValueRoundedUp = taxValue.setScale(2, BigDecimal.ROUND_HALF_UP);
		return taxValueRoundedUp.doubleValue();
	}
}
