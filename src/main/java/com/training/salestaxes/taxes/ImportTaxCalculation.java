package com.training.salestaxes.taxes;

import com.training.salestaxes.items.Product;

public class ImportTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isImported() ? product.getPrice() * 5 /100 : 0d;
	}
}
