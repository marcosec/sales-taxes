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
		double val = price * rate / 100;
		return applyOn(val);
	}


	public static double roundTwoDecimal(double price)
	{
		return Math.floor(price * 100) / 100.0;
	}

	private static double applyOn(double val)
	{
		return Math.round(val * 20) / 20.0;
	}
}
