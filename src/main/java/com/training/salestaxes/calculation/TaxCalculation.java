package com.training.salestaxes.calculation;

import com.training.salestaxes.items.Product;

public interface TaxCalculation
{
	double calculateTaxesOn(Product product);
}
