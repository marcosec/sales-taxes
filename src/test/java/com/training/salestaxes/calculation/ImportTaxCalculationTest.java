package com.training.salestaxes.calculation;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculationTest
{
	private TaxCalculation importTaxCalculation;

	@Before
	public void setup()
	{
		importTaxCalculation = new ImportTaxCalculation();
	}

	@Test
	public void shouldApplyTaxesToImportedItems()
	{
		Product importedProduct = new Product("imported-product",10.0d,true);

		double taxValue = importTaxCalculation.calculateTaxesOn(importedProduct);

		assertEquals(0.5d, taxValue, 0);
	}

	@Test
	public void shouldNotApplyTaxToNotImportedItems()
	{
		Product notImportedProduct = new Book("not-imported-product",10.0d);

		double taxValue = importTaxCalculation.calculateTaxesOn(notImportedProduct);

		assertEquals(0.0d, taxValue, 0);
	}

	@Test
	public void shouldRoundTaxValueToTheNearestHalf()
	{
		Product importedProduct = new Book("imported-product",10.99d,true);

		double taxValue = importTaxCalculation.calculateTaxesOn(importedProduct);

		assertEquals(0.55d, taxValue, 0);
	}
}
