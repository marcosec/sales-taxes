package com.training.salestaxes.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedicalTest
{
	@Test
	public void shouldBeExemptFromTaxes()
	{
		Product product = new Medical("medical",10.0d);

		assertEquals(true, product.isExemptFromTaxes());
	}

	@Test
	public void canBeImported()
	{
		Product product = new Medical("medical",10.0d,true);

		assertEquals(true, product.isImported());
	}
}
