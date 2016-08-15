package com.training.salestaxes.items;


public class Medical extends Product
{
	public Medical(String name, double price)
	{
		super(name,price);
	}

	public Medical(String name, double price, boolean imported)
	{
		super(name, price, imported);
	}

	@Override
	public boolean isExemptFromTaxes()
	{
		return true;
	}
}
