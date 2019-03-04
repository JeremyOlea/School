import java.util.*;
import java.io.*;

/**
 * A list of orders for that day
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class Order {
	/**
	 * A list of orders made throughout the day
	 */
	private ArrayList<OrderLine> orders;
	/**
	 * randomly generated id of the daily order
	 */
	private int id;

	/**
	 * The date of this order
	 */
	private Date date;

	/**
	 * Constructor for the order
	 * @param orderLine an orderline to be put into the Array
	 */
	public Order(OrderLine orderLine) {
		orders = new ArrayList<>();
		orders.add(orderLine);
		date = new Date();
		Random r = new Random(System.currentTimeMillis());
    int digits = r.nextInt(99999) + 10000;
    id = digits;
	}
	/**
	 * setter for the Order
	 * @param orders the order that it will be set to
	 */
  public void setOrders(ArrayList<OrderLine> orders) {
		this.orders = orders;
	}

	/**
	 * setter for the id of the orders
	 * @param id the id to be set to
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * getter for the orders
	 * @return the orders 
	 */
	public ArrayList<OrderLine> getOrders() {
		return orders;
	}

	/**
	 * getter for the id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Prints the most recent Order into the file "dailyOrders.txt"
	 * @param firstOrder a boolean that denotes if this was the first order of the day
	 */
  public void printOrder(Boolean firstOrder) {
		try {
			String s = "";
			String name = "";
			String supplierName = "";
			PrintWriter writer = new PrintWriter(new FileOutputStream(new File("dailyOrders.txt"), true));
			if(firstOrder) {
				s = "************************\n";
				writer.println(s);
				s = "Order ID:\t" + id;
				writer.println(s);
				writer.println("Date Ordered:\t" + date.toString());
				name = orders.get(0).getTool().getName();
				s = "\nItem description: " + name;
				writer.println(s);
				s = "Amount ordered: " + orders.get(0).getQuantity();
				writer.println(s);
				supplierName = orders.get(0).getTool().getSupplier().getName();
				s = "Supplier:\t" + supplierName;
				writer.println(s);
				s = "\n";
				writer.println(s);
			}
			else {
				name = orders.get(orders.size() - 1).getTool().getName();
				s = "\nItem description: " + name;
				writer.println(s);
				s = "Amount ordered:\t" + orders.get(orders.size() - 1).getQuantity();
				writer.println(s);
				supplierName = orders.get(orders.size() - 1).getTool().getSupplier().getName();
				s = "Supplier:\t" + supplierName;
				writer.println(s);
				s = "\n";
				writer.println(s);
			}
			writer.close();
		}
			catch(FileNotFoundException f) {
			System.out.println("File not found");
			}
		
    }
		
		/**
		 * adds a new orderline to the end of the arraylist
		 * @param orderLine the orderline that will be sent to the end of the arraylist
		 */
    public void addOrderLine(OrderLine orderLine) {
    	orders.add(orderLine);
		}
		
		/**
		* Getter for the date
	 	* @return the date
	 	*/
		public Date getDate() {
			return date;
		}
}