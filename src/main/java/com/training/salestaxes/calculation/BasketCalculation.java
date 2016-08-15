package com.training.salestaxes.calculation;

import java.util.ArrayList;
import java.util.List;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Product;

public class BasketCalculation
{
	private List<TaxCalculation> taxCalculationStrategies;

	public BasketCalculation(List<TaxCalculation> taxCalculationStrategies)
	{
		this.taxCalculationStrategies = taxCalculationStrategies;
	}

	public BasketCalculation()
	{
		taxCalculationStrategies = new ArrayList<TaxCalculation>();
		taxCalculationStrategies.add(new ImportTaxCalculation());
		taxCalculationStrategies.add(new SalesTaxCalculation());
	}


	public double calculateTotalPrice(List<BasketEntry> basketEntries)
	{
		double result = 0d;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			result += item.getPrice() * entry.getQuantity();
			for (TaxCalculation taxCalculation : taxCalculationStrategies)
			{
				result += taxCalculation.calculateTaxesOn(item);
			}
		}
		return RoundingStrategy.roundTwoDecimal(result);
	}
}
