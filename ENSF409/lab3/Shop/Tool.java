
/**
 * A tool held by the inventory
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class Tool {
    /**
     * unique id to identify the tool
     */
    private int id;
    /**
     * price that the tool is sold at
     */
    private double price;
    /**
     * the quantity of the tool that is currently in stock
     */
    private int quantity;
    /**
     * the id of the supplier that the tool came from
     */
    private int supplierId;
    /**
     * the supplier that the tool came from
     */
    private Supplier supplier;
    /**
     * the name of the tool
     */
    private String name;

    /**
     * Constructor for the tool
     * @param id id of tool
     * @param name name of tool
     * @param quantity quantity of tool
     * @param price price of tool
     * @param supplierId id of supplier that the tool came from
     */
    public Tool(int id, String name, int quantity, double price, int supplierId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.name = name;
    }

    /**
     * Setter for supplier of tool
     * @param supplier the supplier to be set to
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Getter for the supplier of tool
     * @return the supplier the tool came from
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Setter for tool name
     * @param name name to be set to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for tool id
     * @param id the id of the tool
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for price of tool
     * @param price price to be set to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setter for quantity of tool
     * @param quantity quantity to be set to
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Setter for id of supplier that the tool came from
     * @param supplierId id of the supplier
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * Getter for id of tool
     * @return id of tool
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for price of tool
     * @return price of tool
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for quantity of tool
     * @return quantity
     */
	public int getQuantity() {
		return quantity;
	}

	// public int getSupplierId() {
	// 	return supplierId;
	// }

    /**
     * Getter for name of tool
     * @return name of tool
     */
	public String getName() {
		return name;
	}

    /**
     * Getter for supplier id of tool
     * @return supplier id
     */
    public int getSupplierId() {
        return supplierId;
    }
    
    /**
     * Increases the quantity of tool by set amount
     * @param quantity quantity to be added onto the current quantity of tool
     */
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
    
    /**
     * Decreases the quantity of tool by set amount
     * @param quantity quantity to be subtracted onto the current quantity of tool
     */
	public void decreaseQuantity(int quantity) {
		if(this.quantity - quantity <= 0) {
			return;
		}
		else
			this.quantity -= quantity;
    }

    /**
     * Creates a String to describe to tool
     * @return the string that holds the information fo the tool
     */
    public String toString() {
        String toString = "id: " + id;
        toString += "\nname: " + name;
        toString += "\nquantity: " + quantity;
        toString += "\nprice: " + price;
        toString += "\nSupplier ID: " + supplierId;
        return toString;
    }
}