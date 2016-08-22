package com.training.salestaxes.printer;

import com.training.salestaxes.basket.Basket;
import com.training.salestaxes.basket.BasketEntry;

public class Cashier
{
	public String printReciptFor(Basket basket)
	{
		StringBuilder result = new StringBuilder();

		printEntryLines(basket, result);
		printTotalTaxes(basket, result);
		printTotalPrice(basket, result);

		return result.toString();
	}

	private void printTotalPrice(Basket basket, StringBuilder result)
	{
		result.append(String.format("Total: %s", basket.totalPrice()));
	}

	private void printTotalTaxes(Basket basket, StringBuilder result)
	{
		result.append(String.format("Sales Taxes: %s%n", basket.totalTaxes()));
	}

	private void printEntryLines(Basket basket, StringBuilder result)
	{
		for (BasketEntry entry: basket.getBasketEntries())
		{
			result.append(String.format("%d %s: %s%n",entry.getQuantity(), entry.getProduct().getName(), basket.totalPriceForEntry(entry)));
		}
	}
}
