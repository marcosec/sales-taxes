package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import com.training.salestaxes.items.Product;

public interface TaxCalculation
{
	BigDecimal calculateTaxesOn(Product product);
}
