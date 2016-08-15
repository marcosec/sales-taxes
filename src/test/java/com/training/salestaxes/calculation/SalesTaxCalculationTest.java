package com.training.salestaxes.calculation;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Medical;
import com.training.salestaxes.items.Product;

public class SalesTaxCalculationTest
{
	private TaxCalculation salesTaxCalculation;

	@Before
	public void setup()
	{
		salesTaxCalculation = new SalesTaxCalculation();
	}

	@Test
	public void shouldApplySalesTaxesToNotExemptItems()
	{
		Product notExemptProduct = new Product("not-exempt-product",10.0d);

		double taxValue = salesTaxCalculation.calculateTaxesOn(notExemptProduct);

		assertEquals(1.0d, taxValue, 0);
	}

	@Test
	public void shouldNotApplyAnyTaxToBooks()
	{
		Product book = new Book("exempt-product",10.0d);

		double taxValue = salesTaxCalculation.calculateTaxesOn(book);

		assertEquals(0.0d, taxValue, 0);
	}

	@Test
	public void shouldNotApplyAnyTaxToFoods()
	{
		Product food = new Food("exempt-product",10.0d);

		double taxValue = salesTaxCalculation.calculateTaxesOn(food);

		assertEquals(0.0d, taxValue, 0);
	}

	@Test
	public void shouldNotApplyAnyTaxToMedicalProducts()
	{
		Product medical = new Medical("exempt-product",10.0d);

		double taxValue = salesTaxCalculation.calculateTaxesOn(medical);

		assertEquals(0.0d, taxValue, 0);
	}

	@Test
	public void shouldRoundTaxValueToTheNearestHalf()
	{
		Product notExemptProduct = new Product("not-exempt-product",14.99d);

		double taxValue = salesTaxCalculation.calculateTaxesOn(notExemptProduct);


		assertEquals(1.50d, taxValue, 0);
	}
}
