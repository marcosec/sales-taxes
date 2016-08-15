package com.training.salestaxes.basket;

import org.junit.Test;

import com.training.salestaxes.items.Product;

import static org.junit.Assert.*;

public class BasketEntryTest
{

	@Test
	public void shouldSetBasketEntryBasicData()
	{
		Product product = new Product("product", 10d);
		BasketEntry entry = new BasketEntry(1, product);

		assertEquals(1, entry.getQuantity());
		assertEquals(product, entry.getProduct());
	}
}