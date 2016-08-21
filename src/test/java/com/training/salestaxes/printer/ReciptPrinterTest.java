package com.training.salestaxes.printer;


import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.training.salestaxes.basket.Basket;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Product;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReciptPrinterTest
{
	private ReciptPrinter printer;

	@Before
	public void setup()
	{
		printer = new ReciptPrinter();
	}

	@Test
	public void shouldPrintRecipt_input1()
	{
		Product musicCd = new Product("music cd", 14.99d);
		Product book = new Book("book", 12.49d);
		Product chocolate = new Food("chocolate bar", 0.85d);

		BasketEntry entry1 = new BasketEntry(1, musicCd);
		BasketEntry entry2 = new BasketEntry(1, book);
		BasketEntry entry3 = new BasketEntry(1, chocolate);

		Basket basket = new Basket();
		basket.addEntry(Arrays.asList(entry1,entry2,entry3));

		String recipt = printer.printReciptFor(basket);

		assertThat(recipt, containsString("1 music cd: 16.49"));
		assertThat(recipt, containsString("1 book: 12.49"));
		assertThat(recipt, containsString("1 chocolate bar: 0.85"));
		assertThat(recipt, containsString("Sales Taxes: 1.50"));
		assertThat(recipt, containsString("Total: 29.83"));

	}
}
