package com.training.salestaxes.taxes;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculation implements TaxCalculation
{
	public double calculateTaxesOn(Product product)
	{
		return product.isImported() ? RoundingStrategy.roundUp(product.getPrice(),5) : 0d;
	}
}
