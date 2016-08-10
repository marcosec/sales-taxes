package com.training.salestaxes.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProductTest
{
	@Test
	public void shouldSetProductBasicInfo_name_price()
	{
		Product product = new Product("book",10.0d);

		assertEquals("book", product.getName());
		assertEquals(10.0d, product.getPrice(),0);
	}

	@Test
	public void shouldSetProductBasicInfo_importedIsFalseByDefault()
	{
		Product product = new Product("book",10.0d);

		assertEquals(false, product.isImported());
	}

	@Test
	public void shouldSetProductBasicInfo_importedProducts()
	{
		Product product = new Product("book",10.0d,true);

		assertEquals("book", product.getName());
		assertEquals(10.0d, product.getPrice(),0);
		assertEquals(true, product.isImported());
	}

	@Test
	public void shouldSetProductBasicInfo_exemptFromTaxesIsFalseByDefault()
	{
		Product product = new Product("book",10.0d);

		assertEquals(false, product.isExemptFromTaxes());
	}

	@Test
	public void shouldSetProductBasicInfo_exemptFromTaxesProducts()
	{
		Product product = new Product("book",10.0d,true,true);

		assertEquals(true, product.isExemptFromTaxes());
	}
}
