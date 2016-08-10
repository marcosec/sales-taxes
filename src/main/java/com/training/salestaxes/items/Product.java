package com.training.salestaxes.items;

/**
 * Created by marcosec on 10/08/16.
 */
public class Product
{
	private String name;
	private double price;
	private boolean imported;

	public Product(String name, double price)
	{
		this.name = name;
		this.price = price;
		this.imported = false;
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

	public boolean getImported()
	{
		return imported;
	}

	public boolean isImported()
	{
		return imported;
	}

	public void setImported(boolean imported)
	{
		this.imported = imported;
	}
}
