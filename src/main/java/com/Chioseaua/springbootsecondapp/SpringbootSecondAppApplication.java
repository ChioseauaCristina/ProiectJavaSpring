package com.Chioseaua.springbootsecondapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSecondAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecondAppApplication.class, args);

		/*Scanner scanner = null;
		try {
			scanner = new Scanner(new FileReader("src/Products.txt"));
			scanner.useDelimiter(",");
			while(scanner.hasNextLine()) {

				String product = scanner.next();
				scanner.skip(scanner.delimiter());
				String numProducts = scanner.nextLine();
				int numberProducts = Integer.parseInt(numProducts);
				System.out.println("product: " + product + " number of products: " + numberProducts);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}*/

		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addCartItem("paine", 4);
		shoppingCart.addCartItem("lapte", 21);
		shoppingCart.viewCartDetails();
	}

}
