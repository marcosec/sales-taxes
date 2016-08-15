package com.training.salestaxes.basket;

import java.util.ArrayList;
import java.util.List;
import com.training.salestaxes.items.Product;
import com.training.salestaxes.taxes.ImportTaxCalculation;
import com.training.salestaxes.taxes.RoundingStrategy;
import com.training.salestaxes.taxes.SalesTaxCalculation;
import com.training.salestaxes.taxes.TaxCalculation;

public class Basket
{
	private List<BasketEntry> basketEntries;
	private List<TaxCalculation> taxCalculationStrategies;

	public Basket()
	{
		basketEntries = new ArrayList<BasketEntry>();

		taxCalculationStrategies = new ArrayList<TaxCalculation>();
		taxCalculationStrategies.add(new ImportTaxCalculation());
		taxCalculationStrategies.add(new SalesTaxCalculation());
	}

	public void addEntry(BasketEntry entry)
	{
		basketEntries.add(entry);
	}

	public List<BasketEntry> getBasketEntries()
	{
		return basketEntries;
	}

	public void setBasketEntries(List<BasketEntry> entries)
	{
		this.basketEntries = entries;
	}

	public void addEntry(List<BasketEntry> entries)
	{
		basketEntries.addAll(entries);
	}

	public double totalPrice()
	{
		double result = 0d;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			result += item.getPrice();
			for (TaxCalculation taxCalculation : taxCalculationStrategies)
			{
				result += taxCalculation.calculateTaxesOn(item);
			}
		}
		return RoundingStrategy.roundTwoDecimal(result);
	}
}
