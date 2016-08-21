package com.training.salestaxes.basket;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Product;

public class BasketTest
{
	private Basket basket;

	@Before
	public void setup()
	{
		basket = new Basket();
	}

	@Test
	public void shouldAddItemToBasket()
	{
		Product product = new Product("generic-product", 10.0d);

		BasketEntry entry1 = new BasketEntry(1, product);

		basket.addEntry(entry1);

		assertThat(basket.getBasketEntries(), hasItem(entry1));
	}

	@Test
	public void shouldAddListOfItemsToBasket()
	{
		Product product = new Product("generic-product", 10.0d);
		Product book = new Book("book", 10.0d);

		BasketEntry entry1 = new BasketEntry(1, product);
		BasketEntry entry2 = new BasketEntry(1, book);

		basket.addEntry(Arrays.asList(entry1,entry2));

		assertThat(basket.getBasketEntries(), hasItem(entry1));
		assertThat(basket.getBasketEntries(), hasItem(entry2));
	}
}
