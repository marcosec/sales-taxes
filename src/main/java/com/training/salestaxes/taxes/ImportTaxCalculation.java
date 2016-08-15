package com.training.salestaxes.taxes;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isImported() ? roundUp(product) : 0d;
	}

	private double roundUp(Product product)
	{
		BigDecimal taxValue = new BigDecimal(product.getPrice() * 5 / 100);
		BigDecimal taxValueRoundedUp = taxValue.setScale(2, BigDecimal.ROUND_HALF_UP);
		return taxValueRoundedUp.doubleValue();
	}
}
