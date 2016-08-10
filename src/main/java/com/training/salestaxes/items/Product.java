package com.training.salestaxes.items;

/**
 * Created by marcosec on 10/08/16.
 */
public class Product
{
	private String name;
	private double price;

	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getPrice()
	{
		return price;
	}
}
