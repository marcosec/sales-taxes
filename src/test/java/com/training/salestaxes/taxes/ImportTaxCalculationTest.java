package com.training.salestaxes.taxes;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Medical;
import com.training.salestaxes.items.Product;

public class ImportTaxCalculationTest
{
	private ImportTaxCalculation importTaxCalculation;

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
}
