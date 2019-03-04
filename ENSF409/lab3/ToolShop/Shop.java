import java.util.*;

public class Shop {
    private Inventory inventory;
    private ArrayList<Order> dailyOrders;
    private ArrayList<Supplier> suppliers;

    public Shop(Inventory inventory, ArrayList<Supplier> suppliers, ArrayList<Order> orders) {
        this.inventory = inventory;
        this.suppliers = suppliers;
        this.dailyOrders = orders;
    }

	public int buyItem(String name, int quantity) {
		Tool item = inventory.search(name);
	   	if (item == null) {
		   System.out.printf("Item does no exist!\n");
		  //OrderLine newOrder = new Order(item, quantity, )
		  //TODO: Set supplier in tool using supplier ID;
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

	public int buyItem(int id, int quantity) {
		Tool item = inventory.search(id);
	   	if (item == null) {
		   System.out.printf("Item does no exist!\n");
		  //OrderLine newOrder = new Order(item, quantity, )
		  //TODO: Set supplier in tool using supplier ID;
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
    
	public Inventory getInventory() {
		return inventory;
	}

	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	public ArrayList<Order> getDailyOrders() {
		return dailyOrders;
	}

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

	public void makeOrder(Tool tool) {
		OrderLine newOrderLine = new OrderLine(tool, 50 - tool.getQuantity(), tool.getSupplier());
		Order today;
		if(dailyOrders.isEmpty()) {
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