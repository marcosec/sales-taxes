package com.training.salestaxes.calculation;

import java.math.BigDecimal;

public interface RoundingStrategy
{
	BigDecimal roundUp(BigDecimal price, int rate);
}
