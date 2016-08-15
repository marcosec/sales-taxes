package com.training.salestaxes.items;

public class Food extends Product
{
	public Food(String name, double price)
	{
		super(name,price);
	}

	public Food(String name, double price, boolean imported)
	{
		super(name, price, imported);
	}

	@Override
	public boolean isExemptFromTaxes()
	{
		return true;
	}

}
