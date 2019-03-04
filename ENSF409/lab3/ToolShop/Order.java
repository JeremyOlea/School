import java.util.*;
import java.io.*;

public class Order {
  private ArrayList<OrderLine> orders;
	private int id;

	public Order(OrderLine orderLine) {
		orders = new ArrayList<>();
		orders.add(orderLine);
		Random r = new Random(System.currentTimeMillis());
    int digits = r.nextInt(99999) + 10000;
    id = digits;
	}
  public void setOrders(ArrayList<OrderLine> orders) {
		this.orders = orders;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<OrderLine> getOrders() {
		return orders;
	}

	public int getId() {
		return id;
	}
    
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
				writer.println("Date Ordered:\t");
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
    
    public void addOrderLine(OrderLine order) {
    	orders.add(order);
    }
    
    // public void generateId() {
    // 	Random r = new Random(System.currentTimeMillis());
    // 	int digits = r.nextInt(99999) + 10000;
    // 	setId(digits);
    // }
}