package com.training.salestaxes.items;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookTest
{
	@Test
	public void shouldBeExemptFromTaxes()
	{
		ShopItem product = new Book("book",10.0d);

		assertEquals(true, product.isExemptFromTaxes());
	}
}