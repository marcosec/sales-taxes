package com.training.salestaxes.calculation;


import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
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
}
