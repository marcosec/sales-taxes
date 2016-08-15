package com.training.salestaxes.calculation;


import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Medical;
import com.training.salestaxes.items.Product;

import static org.junit.Assert.assertEquals;

public class BasketCalculationTest
{
	private BasketCalculation basketCalculation;

	@Before
	public void setup()
	{
		basketCalculation = new BasketCalculation();
	}


	@Test
	public void shouldReturnBasketTotalPrice_input1()
	{
		Product musicCd = new Product("music cd", 14.99d);
		Product book = new Book("book", 12.49d);
		Product chocolate = new Food("chocolate bar", 0.85d);

		BasketEntry entry1 = new BasketEntry(1, musicCd);
		BasketEntry entry2 = new BasketEntry(1, book);
		BasketEntry entry3 = new BasketEntry(1, chocolate);


		assertEquals(29.83d, basketCalculation.calculateTotalPrice(Arrays.asList(entry1,entry2,entry3)), 0);
	}

	@Test
	public void shouldReturnBasketTotalTaxPrice_input1()
	{
		Product musicCd = new Product("music cd", 14.99d);
		Product book = new Book("book", 12.49d);
		Product chocolate = new Food("chocolate bar", 0.85d);

		BasketEntry entry1 = new BasketEntry(1, musicCd);
		BasketEntry entry2 = new BasketEntry(1, book);
		BasketEntry entry3 = new BasketEntry(1, chocolate);

		assertEquals(1.50d, basketCalculation.calculateTotalTaxes(Arrays.asList(entry1,entry2,entry3)), 0);
	}

	@Test
	public void shouldReturnBasketTotalPrice_input2()
	{
		Product importedChocolate = new Food("imported chocolate", 10.00d,true);
		Product importedPerfume = new Product("imported perfume", 47.50d,true);

		BasketEntry entry1 = new BasketEntry(1, importedChocolate);
		BasketEntry entry2 = new BasketEntry(1, importedPerfume);

		assertEquals(65.15d, basketCalculation.calculateTotalPrice(Arrays.asList(entry1,entry2)), 0);
	}

	@Test
	public void shouldReturnBasketTotalTaxPrice_input2()
	{
		Product importedChocolate = new Food("imported chocolate", 10.00d,true);
		Product importedPerfume = new Product("imported perfume", 47.50d,true);

		BasketEntry entry1 = new BasketEntry(1, importedChocolate);
		BasketEntry entry2 = new BasketEntry(1, importedPerfume);

		assertEquals(7.65d, basketCalculation.calculateTotalTaxes(Arrays.asList(entry1,entry2)), 0);
	}

	@Test
	public void shouldReturnBasketTotalPrice_input3()
	{
		Product importedChocolate = new Food("imported chocolate", 11.25d,true);
		Product importedPerfume = new Product("book", 27.99d,true);
		Product bottlePerfume = new Product("bottle perfume", 18.99d);
		Product pills = new Medical("headache pills", 9.75d);

		BasketEntry entry1 = new BasketEntry(1, importedChocolate);
		BasketEntry entry2 = new BasketEntry(1, importedPerfume);
		BasketEntry entry3 = new BasketEntry(1, bottlePerfume);
		BasketEntry entry4 = new BasketEntry(1, pills);

		assertEquals(74.68d, basketCalculation.calculateTotalPrice(Arrays.asList(entry1,entry2,entry3,entry4)), 0);
	}

	@Test
	public void shouldReturnBasketTotalTaxPrice_input3()
	{
		Product importedChocolate = new Food("imported chocolate", 11.25d,true);
		Product importedPerfume = new Product("book", 27.99d,true);
		Product bottlePerfume = new Product("bottle perfume", 18.99d);
		Product pills = new Medical("headache pills", 9.75d);

		BasketEntry entry1 = new BasketEntry(1, importedChocolate);
		BasketEntry entry2 = new BasketEntry(1, importedPerfume);
		BasketEntry entry3 = new BasketEntry(1, bottlePerfume);
		BasketEntry entry4 = new BasketEntry(1, pills);

		assertEquals(6.70d, basketCalculation.calculateTotalTaxes(Arrays.asList(entry1,entry2,entry3,entry4)), 0);
	}
}
