package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculation implements TaxCalculation
{
	public BigDecimal calculateTaxesOn(Product product)
	{
		return product.isImported() ? RoundingStrategy.roundUp(product.getPrice(),5) :BigDecimal.ZERO;
	}
}
