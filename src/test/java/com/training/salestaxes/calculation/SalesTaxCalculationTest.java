package com.training.salestaxes.calculation;


import java.math.BigDecimal;

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

		BigDecimal taxValue = salesTaxCalculation.calculateTaxesOn(notExemptProduct);

		assertEquals(0, taxValue.compareTo(BigDecimal.ONE));
	}

	@Test
	public void shouldNotApplyAnyTaxToBooks()
	{
		Product book = new Book("exempt-product",10.0d);

		BigDecimal taxValue = salesTaxCalculation.calculateTaxesOn(book);

		assertEquals(0, taxValue.compareTo(BigDecimal.ZERO));
	}

	@Test
	public void shouldNotApplyAnyTaxToFoods()
	{
		Product food = new Food("exempt-product",10.0d);

		BigDecimal taxValue = salesTaxCalculation.calculateTaxesOn(food);

		assertEquals(0, taxValue.compareTo(BigDecimal.ZERO));
	}

	@Test
	public void shouldNotApplyAnyTaxToMedicalProducts()
	{
		Product medical = new Medical("exempt-product",10.0d);

		BigDecimal taxValue = salesTaxCalculation.calculateTaxesOn(medical);

		assertEquals(0, taxValue.compareTo(BigDecimal.ZERO));
	}

	@Test
	public void shouldRoundTaxValueToTheNearestHalf()
	{
		Product notExemptProduct = new Product("not-exempt-product",14.99d);

		BigDecimal taxValue = salesTaxCalculation.calculateTaxesOn(notExemptProduct);


		assertEquals(0, taxValue.compareTo(BigDecimal.valueOf(1.50d)));
	}
}
