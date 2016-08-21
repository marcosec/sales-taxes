package com.training.salestaxes.calculation;


import java.math.BigDecimal;

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

		BigDecimal taxValue = importTaxCalculation.calculateTaxesOn(importedProduct);

		assertEquals(0, taxValue.compareTo(BigDecimal.valueOf(0.5d)));
	}

	@Test
	public void shouldNotApplyTaxToNotImportedItems()
	{
		Product notImportedProduct = new Book("not-imported-product",10.0d);

		BigDecimal taxValue = importTaxCalculation.calculateTaxesOn(notImportedProduct);

		assertEquals(0, taxValue.compareTo(BigDecimal.ZERO));
	}

	@Test
	public void shouldRoundTaxValueToTheNearestHalf()
	{
		Product importedProduct = new Book("imported-product",10.99d,true);

		BigDecimal taxValue = importTaxCalculation.calculateTaxesOn(importedProduct);

		assertEquals(0, taxValue.compareTo(BigDecimal.valueOf(0.55d)));
	}
}
