package com.training.salestaxes.basket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.training.salestaxes.calculation.BasketCalculation;
import com.training.salestaxes.calculation.ImportTaxCalculation;
import com.training.salestaxes.calculation.SalesTaxCalculation;


public class Basket
{
	private List<BasketEntry> basketEntries;
	private BasketCalculation basketCalculation;

	public Basket()
	{
		basketEntries = new ArrayList<BasketEntry>();

		basketCalculation = new BasketCalculation(Arrays.asList(new ImportTaxCalculation(), new SalesTaxCalculation()));
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
		return basketCalculation.calculateTotalPrice(getBasketEntries());
	}

	public BigDecimal totalTaxes()
	{
		return basketCalculation.calculateTotalTaxes(getBasketEntries());
	}

	public BigDecimal totalPriceForEntry(BasketEntry entry)
	{
		return basketCalculation.calculateTotalPriceForEntry(entry);
	}
}
