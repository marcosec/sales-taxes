package com.training.salestaxes.calculation;

import java.math.BigDecimal;

public class RoundingStrategy
{

	public RoundingStrategy()
	{
	}

	public static double roundUp(double price, int rate)
	{
		BigDecimal salesTax = new BigDecimal(price).multiply(new BigDecimal(rate)).divide(new BigDecimal("100"));
		return applyOn(salesTax).doubleValue();
	}


	public static double roundTwoDecimal(double price)
	{
		BigDecimal bigDecimal = new BigDecimal(price);
		BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		return bigDecimal1.doubleValue();
	}


	private static BigDecimal applyOn(BigDecimal value) {
		BigDecimal divisor = new BigDecimal("0.05");
		value = value.divide(divisor);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value= value.multiply(divisor);
		return value;
	}
}
