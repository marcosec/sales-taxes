package com.training.salestaxes.calculation;

import java.math.BigDecimal;
import java.util.List;
import com.training.salestaxes.basket.BasketEntry;

public interface BasketCalculation
{

	BigDecimal calculateTotalPrice(List<BasketEntry> basketEntries);

	BigDecimal calculateTotalTaxes(List<BasketEntry> basketEntries);

	BigDecimal calculateTotalPriceForEntry(BasketEntry entry);
}
