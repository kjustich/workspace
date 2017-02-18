/**
 * This class creates the blueprint for each item to hold both an associated tax and price. *
 * @author Kevin Justich 
 * @version 1.0
 * @since   2017-02-09
 */

public class Item {
	
private double price;
private double tax;

/**
 * Accesses the instantiated price for the item
 * @return price 
 */
public double getPrice() {
	return price;
}
/**
 * Sets the price for each instance of an item. Will be a double entered through scanner entry.
 * @param price
 */
public void setPrice(double price) {
	this.price = price;
}
/**
 * Accesses the instantiated tax for the item
 * @return tax
 */
public double getTax() {
	return tax;
}
/**
 * Sets the tax for each instance of an item. Will be a double.
 * @param tax
 */
public void setTax(double tax) {
	this.tax = tax;
}

}
