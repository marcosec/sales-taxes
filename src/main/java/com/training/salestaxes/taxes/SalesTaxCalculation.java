package com.training.salestaxes.taxes;

import com.training.salestaxes.items.Product;

public class SalesTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isExemptFromTaxes() ? 0.0d : product.getPrice() * 10 / 100;
	}
}
