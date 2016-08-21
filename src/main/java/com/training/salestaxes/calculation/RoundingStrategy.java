package com.training.salestaxes.calculation;

import java.math.BigDecimal;

public class RoundingStrategy
{

	public static BigDecimal roundUp(BigDecimal price, int rate)
	{
		BigDecimal salesTax = price.multiply(BigDecimal.valueOf(rate)).divide(BigDecimal.valueOf(100));
		return applyOn(salesTax);
	}

	private static BigDecimal applyOn(BigDecimal value) {
		BigDecimal divisor = BigDecimal.valueOf(0.05);
		value = value.divide(divisor);
		value = value.setScale(0,BigDecimal.ROUND_CEILING);
		value= value.multiply(divisor);
		return value;
	}
}
