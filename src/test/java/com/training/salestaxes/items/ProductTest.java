package com.training.salestaxes.items;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest
{
	@Test
	public void shouldSetProductBasicInfo_name_price()
	{
		Product product = new Product("book",10.0);

		assertEquals("book", product.getName());
		assertEquals(BigDecimal.valueOf(10.0), product.getPrice());
	}

	@Test
	public void shouldSetProductBasicInfo_importedIsFalseByDefault()
	{
		Product product = new Product("book",10.0);

		assertEquals(false, product.isImported());
	}

	@Test
	public void shouldSetProductBasicInfo_importedProducts()
	{
		Product product = new Product("book",10.0,true);

		assertEquals("book", product.getName());
		assertEquals(BigDecimal.valueOf(10.0), product.getPrice());
		assertEquals(true, product.isImported());
	}
}
