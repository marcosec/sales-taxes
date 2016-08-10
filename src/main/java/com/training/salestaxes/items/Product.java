package com.training.salestaxes.items;

public class Product
{
	private String name;
	private double price;
	private boolean imported;

	public Product(String name, double price)
	{
		this(name,price,false);
	}

	public Product(String name, double price, boolean imported)
	{
		this.name = name;
		this.price = price;
		this.imported = imported;
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

	public boolean isImported()
	{
		return imported;
	}

	public void setImported(boolean imported)
	{
		this.imported = imported;
	}
}
