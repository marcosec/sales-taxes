package com.training.salestaxes.items;

public class Book extends Product
{
	public Book(String name, double price)
	{
		super(name, price);
	}

	public Book(String name, double price, boolean imported)
	{
		super(name, price, imported);
	}

	@Override
	public boolean isExemptFromTaxes()
	{
		return true;
	}
}
