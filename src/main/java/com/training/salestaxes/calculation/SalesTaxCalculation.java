package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class SalesTaxCalculation implements TaxCalculation
{
	private RoundingStrategy roundingStrategy = new NearestHalfRoundingStrategy();

	public BigDecimal calculateTaxesOn(Product product)
	{
		return product.isExemptFromTaxes() ? BigDecimal.ZERO : roundingStrategy.roundUp(product.getPrice(),10);
	}

}
