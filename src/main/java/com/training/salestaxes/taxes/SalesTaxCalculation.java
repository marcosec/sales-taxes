package com.training.salestaxes.taxes;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class SalesTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isExemptFromTaxes() ? 0.0d : roundUp(product);
	}

	private double roundUp(Product product)
	{
		BigDecimal taxValue = new BigDecimal(product.getPrice() * 10 / 100);
		BigDecimal taxValueRoundedUp = taxValue.setScale(2, BigDecimal.ROUND_HALF_UP);
		return taxValueRoundedUp.doubleValue();
	}
}
