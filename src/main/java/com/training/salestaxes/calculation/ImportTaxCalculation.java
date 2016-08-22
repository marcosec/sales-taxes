package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculation implements TaxCalculation
{
	private RoundingStrategy roundingStrategy = new NearestHalfRoundingStrategy();

	public BigDecimal calculateTaxesOn(Product product)
	{
		return product.isImported() ? roundingStrategy.roundUp(product.getPrice(),5) :BigDecimal.ZERO;
	}
}
