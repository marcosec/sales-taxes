package com.training.salestaxes.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket
{
	private List basketEntries = new ArrayList<BasketEntry>();

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
}
