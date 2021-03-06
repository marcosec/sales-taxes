package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Product;

public class BasketCalculator implements BasketCalculation
{
	private List<TaxCalculation> taxCalculationStrategies;

	public BasketCalculator()
	{
		taxCalculationStrategies = new ArrayList<TaxCalculation>();
		taxCalculationStrategies.add(new ImportTaxCalculation());
		taxCalculationStrategies.add(new SalesTaxCalculation());
	}


	public BigDecimal calculateTotalPrice(List<BasketEntry> basketEntries)
	{
		BigDecimal result = BigDecimal.ZERO;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			BigDecimal pricePerUnit = item.getPrice().multiply(BigDecimal.valueOf(entry.getQuantity()));
			result = result.add(pricePerUnit.add(applyTaxes(item)));
		}
		return result;
	}


	public BigDecimal calculateTotalTaxes(List<BasketEntry> basketEntries)
	{
		BigDecimal result = BigDecimal.ZERO;
		for (BasketEntry entry: basketEntries)
		{
			Product item = entry.getProduct();
			result = result.add(applyTaxes(item));
		}
		return result;
	}

	public BigDecimal calculateTotalPriceForEntry(BasketEntry entry)
	{
		return entry.getProduct().getPrice().add(applyTaxes(entry.getProduct()));
	}

	private BigDecimal applyTaxes(Product item)
	{
		BigDecimal result = BigDecimal.ZERO;
		result = result.setScale(2, BigDecimal.ROUND_HALF_UP);
		for (TaxCalculation taxCalculation : taxCalculationStrategies)
		{
			result = result.add(taxCalculation.calculateTaxesOn(item));
		}
		return result;
	}

}
