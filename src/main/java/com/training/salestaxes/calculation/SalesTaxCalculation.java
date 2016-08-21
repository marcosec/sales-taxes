package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class SalesTaxCalculation implements TaxCalculation
{
	public BigDecimal calculateTaxesOn(Product product)
	{
		return product.isExemptFromTaxes() ? BigDecimal.ZERO : RoundingStrategy.roundUp(product.getPrice(),10);
	}

}
