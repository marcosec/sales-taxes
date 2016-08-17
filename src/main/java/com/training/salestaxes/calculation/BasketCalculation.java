package com.training.salestaxes.calculation;

import java.math.BigDecimal;
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
		BigDecimal result = BigDecimal.ZERO;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			BigDecimal pricePerUnit = BigDecimal.valueOf(item.getPrice()).multiply(BigDecimal.valueOf(entry.getQuantity()));
			result = result.add(pricePerUnit.add(applyTaxes(item)));
		}
		return result.doubleValue();
	}


	public double calculateTotalTaxes(List<BasketEntry> basketEntries)
	{
		BigDecimal result = BigDecimal.ZERO;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			result = result.add(applyTaxes(item));
		}
		return result.doubleValue();
	}

	private BigDecimal applyTaxes(Product item)
	{
		BigDecimal result = BigDecimal.ZERO;
		for (TaxCalculation taxCalculation : taxCalculationStrategies)
		{
			result = result.add(BigDecimal.valueOf(taxCalculation.calculateTaxesOn(item)));
		}
		return result;
	}
}
