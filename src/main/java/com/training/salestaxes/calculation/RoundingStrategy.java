package com.training.salestaxes.calculation;

import java.math.BigDecimal;

public class RoundingStrategy
{

	public RoundingStrategy()
	{
	}

	public static double roundUp(BigDecimal price, int rate)
	{
		BigDecimal salesTax = price.multiply(BigDecimal.valueOf(rate)).divide(BigDecimal.valueOf(100));
		return applyOn(salesTax).doubleValue();
	}


	public static double roundTwoDecimal(double price)
	{
		BigDecimal bigDecimal = BigDecimal.valueOf(price);
		BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal1.doubleValue();
	}


	private static BigDecimal applyOn(BigDecimal value) {
		BigDecimal divisor = BigDecimal.valueOf(0.05);
		value = value.divide(divisor);
		value = value.setScale(0,BigDecimal.ROUND_CEILING);
		value= value.multiply(divisor);
		return value;
	}
}
