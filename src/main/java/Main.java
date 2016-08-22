import java.util.Arrays;
import com.training.salestaxes.basket.Basket;
import com.training.salestaxes.basket.BasketEntry;
import com.training.salestaxes.items.Book;
import com.training.salestaxes.items.Food;
import com.training.salestaxes.items.Medical;
import com.training.salestaxes.items.Product;
import com.training.salestaxes.printer.Cashier;

public class Main
{
	public static void main(String[] args)
	{
		Cashier cashier = new Cashier();

		System.out.println("******* CASE 1 ********");
		Basket basket1 = new Basket();

		Product musicCd = new Product("music cd", 14.99d);
		Product book = new Book("book", 12.49d);
		Product chocolate = new Food("chocolate bar", 0.85d);

		basket1.addEntry(Arrays.asList(entry(musicCd), entry(book), entry(chocolate)));

		System.out.println(cashier.printReciptFor(basket1));


		System.out.println("******* CASE 2 ********");
		Basket basket2 = new Basket();

		Product importedChocolate = new Food("imported chocolate", 10.00d,true);
		Product importedPerfume = new Product("imported perfume", 47.50d,true);

		basket2.addEntry(Arrays.asList(entry(importedChocolate),entry(importedPerfume)));


		System.out.println(cashier.printReciptFor(basket2));

		System.out.println("******* CASE 3 ********");
		Basket basket3 = new Basket();

		importedChocolate = new Food("imported chocolate", 11.25d,true);
		importedPerfume = new Product("imported perfume", 27.99d,true);
		Product bottlePerfume = new Product("bottle perfume", 18.99d);
		Product pills = new Medical("headache pills", 9.75d);
		basket3.addEntry(Arrays.asList(entry(importedChocolate),entry(importedPerfume),entry(bottlePerfume),entry(pills)));


		System.out.println(cashier.printReciptFor(basket3));

	}

	private static BasketEntry entry(Product musicCd)
	{
		return new BasketEntry(1, musicCd);
	}
}
