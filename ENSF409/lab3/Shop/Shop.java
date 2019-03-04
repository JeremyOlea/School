import java.util.*;

/**
 * Shop used to buy and restock items
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class Shop {
	/**
	 * Object that holds all tools in the shop
	 */
	private Inventory inventory;
	/**
	 * ArrayList of all orders in a given day
	 */
	private ArrayList<Order> dailyOrders;
	/**
	 * ArrayList of all suppliers that have sold tools to the shop
	 */
    private ArrayList<Supplier> suppliers;

	/**
	 * Constructor for shop
	 * @param inventory holds the tools for the shop
	 * @param suppliers information from where the tools came from
	 * @param orders record of orders made by shop
	 */
    public Shop(Inventory inventory, ArrayList<Supplier> suppliers, ArrayList<Order> orders) {
        this.inventory = inventory;
        this.suppliers = suppliers;
        this.dailyOrders = orders;
    }

	/**
	 * selling an item to the user 
	 * @param name name of item being sold
	 * @param quantity quantity of item being sold
	 * @return integer that signifies if the item being sold exists or not
	 */
	public int buyItem(String name, int quantity) {
		Tool item = inventory.search(name);
	   	if (item == null) {
		   System.out.printf("Item does no exist!\n");
		   return 0;
	  	}
	   	if(item.getQuantity() >= quantity) {
			item.decreaseQuantity(quantity);
			checkStock(item.getName());
			return 1;
	   	}
	   else
	   	return -1;
		
		//dailyOrders.add(order);
	}

	/**
	 * selling an item to the user
	 * @param id id of the item being sold
	 * @param quantity quantity of item being sold
	 * @return integer that signifies if the item being sold exists or not
	 */
	public int buyItem(int id, int quantity) {
		Tool item = inventory.search(id);
	   	if (item == null) {
		   System.out.printf("Item does no exist!\n");
		   return 0;
	  	}
	   	if(item.getQuantity() >= quantity) {
			item.decreaseQuantity(quantity);  
			return 1;
	   	}
	   else
	   	return -1;
		
		//dailyOrders.add(order);
	}
	
	/**
	 * getter for inventory object
	 * @return the inventory attribute
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * getter for suppliers
	 * @return the arraylist of suppliers
	 */
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	/**
	 * getter for dailyOrders
	 * @return the arraylist of dailyOrders
	 */
	public ArrayList<Order> getDailyOrders() {
		return dailyOrders;
	}

	/**
	 * Checks the quantity of a given tool and makes a call to restock if quantity is too low
	 * @param name name of tool wanting to be checked
	 * @return the quantity of the tool
	 */
    public int checkStock(String name) {
		Tool item = inventory.search(name);
		if(item != null) {
			if(item.getQuantity() < 40) {
				makeOrder(item);
				item.increaseQuantity(50 - item.getQuantity());
			}
			return item.getQuantity();
		}
		else {
			System.out.printf("\nitem does not exist\n");
			return -1;
		}
    }

	/**
	 * Checks the quantity of a given tool and makes a call to restock if quantity is too low
	 * @param id id of tool wanting to be checked
	 * @return the quantity of the tool
	 */
	public int checkStock(int id) {
		Tool item = inventory.search(id);
		if(item != null) {
			if(item.getQuantity() < 40) {
				makeOrder(item);
				item.increaseQuantity(50 - item.getQuantity());
			}
			return item.getQuantity();
		}
		else {
			System.out.printf("\nitem does not exist\n");
			return -1;
		}

    }

	/**
	 * Increases the quantity of a tool and records it into a file
	 * @param tool the tool being retocked
	 */
	public void makeOrder(Tool tool) {
		OrderLine newOrderLine = new OrderLine(tool, 50 - tool.getQuantity(), tool.getSupplier());
		Order today;
		Date current = new Date();
		if(dailyOrders.isEmpty() || (dailyOrders.get(dailyOrders.size() - 1).getDate().getTime() / 86400000L) != (current.getTime() / 86400000L)) {
			today = new Order(newOrderLine);
			dailyOrders.add(today);
			today.printOrder(true);
		}
		else {
			today = dailyOrders.get(dailyOrders.size() - 1);
			today.addOrderLine(newOrderLine);
			today.printOrder(false);
		}
	}
    
}