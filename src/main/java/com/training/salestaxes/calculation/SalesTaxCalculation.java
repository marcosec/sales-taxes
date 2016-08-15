package com.training.salestaxes.calculation;

import com.training.salestaxes.items.Product;

public class SalesTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isExemptFromTaxes() ? 0.0d : RoundingStrategy.roundUp(product.getPrice(),10);
	}

}