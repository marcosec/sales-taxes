package com.training.salestaxes.taxes;

import com.training.salestaxes.items.Product;

public interface TaxCalculation
{
	double calculateTaxesOn(Product product);
}
