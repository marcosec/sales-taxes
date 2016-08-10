package com.training.salestaxes.items;

public class Product
{
	private String name;
	private double price;
	private boolean imported;
	private boolean exemptFromTaxes;

	public Product(String name, double price)
	{
		this(name,price,false,false);
	}

	public Product(String name, double price, boolean imported)
	{
		this(name,price,imported,false);
	}

	public Product(String name, double price, boolean imported, boolean exempt)
	{
		this.name = name;
		this.price = price;
		this.imported = imported;
		this.exemptFromTaxes = exempt;
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

	public boolean isExemptFromTaxes()
	{
		return exemptFromTaxes;
	}

	public void setExemptFromTaxes(boolean exemptFromTaxes)
	{
		this.exemptFromTaxes = exemptFromTaxes;
	}
}
