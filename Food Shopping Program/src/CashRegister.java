import java.util.Scanner;
/**
*<h1>Food Checkout Program</h1>
*@author  Kevin Justich
*@version 1.0
*@since   2017-02-09
 */
public class CashRegister {
	/**
	 * This is the main method 
	 * @param args Unused.
	 * @return Nothing.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double tab; // Declaration of each of the variables used in tab
					// calculations
		double foodTab = 0;
		double otherTab = 0;
		double foodTotal;
		double otherTotal;

		Item food = new Item(); // Instantiate food and non food items
		food.setTax(1.035);

		Item other = new Item();
		other.setTax(1.070);

		boolean shopping = true; // start first while loop to add items to cart.
									// While adding items select food or not
									// food to keep separate running totals
		while (shopping != false) {

			//System.out.println("Press 1 to add a food item. Select 2 for a non-food item. If finished, please select 3. ");
			System.out.println("Would you like to add an item?");
			Scanner whatItem = new Scanner(System.in);
			String addItem = whatItem.nextLine();
			
			if (addItem.equals("yes")){
			System.out.println("Press 1 to add a food item. Select 2 for a non-food item.");
			int itemSelection = whatItem.nextInt();

			if (itemSelection == 1) {
				System.out.println("Please enter price as xx.xx");
				food.setPrice(whatItem.nextDouble());
				foodTab += food.getPrice();

			} else if (itemSelection == 2) {
				System.out.println("Please enter price as xx.xx");
				other.setPrice(whatItem.nextDouble());
				otherTab += other.getPrice();
				}

			} 
			else if (addItem.equals("no")) { // Checkout session begins
				otherTotal = (otherTab * other.getTax());
				foodTotal = (foodTab * food.getTax());
				double shoppingTotal = (otherTotal + foodTotal);
				double roundTotal = (double) Math.round(shoppingTotal * 100) / 100;
				System.out.println("Food subtotal: $" + foodTab + "\nOther items subtotal: $" + otherTab
						+ "\nTotal with tax: $" + roundTotal);

				while (shopping != false) { // Nested while loop to take
											// payments- rejecting if customer
											// pays too little
					System.out.println("\nHow much are you going to pay? xx.xx");
					Scanner requestPayment = new Scanner(System.in);
					double customerPayment = requestPayment.nextDouble();
					
					if (customerPayment >= roundTotal) {					//Calculates change starting with dollars, and applies remainders of previous denomination to the next denomination
						double change = (customerPayment - roundTotal);					
						double roundChange = (double) Math.round(change * 100) / 100;		//rounds to hundredth decimal place
						int dollars = (int) change;								// Calculates bills by truncating to int
						double remaining;
						remaining = change - dollars;
						double coinage = (remaining * 100);			//Converts to a whole number so that it can display number of each type of coin
						int quarters = (int) (coinage / 25);
						coinage %= 25;
						int dimes = (int) (coinage / 10);
						coinage %= 10;
						int nickels = (int) (coinage / 5);
						coinage %= 5;
						int pennies = (int) (coinage / 1);
						coinage %= 1;
						System.out.println("Your change is: $" + roundChange + "\n$" + dollars + " in Bills" + "\n$" + (quarters*.25) + " in Quarters = " + quarters + "\n$" + (dimes*.10) + " in Dimes = " + dimes
								+ "\n$" + (nickels*.05) + " in Nickels = " + nickels + "\n$" + (pennies*.01) + " in Pennies = " + pennies);
						shopping = false;
					} else {
						System.out.println(
								"Your payment must be equal to or greater than your total. Please enter total again");
					}

				}
			} else {
				System.out.println("That is not a valid slection");
			}
		}

	}

}