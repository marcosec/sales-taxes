package com.training.salestaxes.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FoodTest
{
	@Test
	public void shouldBeExemptFromTaxes()
	{
		Product product = new Food("food",10.0d);

		assertEquals(true, product.isExemptFromTaxes());
	}

	@Test
	public void canBeImported()
	{
		Product product = new Food("book",10.0d,true);

		assertEquals(true, product.isImported());
	}
}
