public class Tool {
    private int id;
    private double price;
    private int quantity;
    private int supplierId;
    private Supplier supplier;
    private String name;

    public Tool(int id, String name, int quantity, double price, int supplierId) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.supplierId = supplierId;
        this.name = name;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public Supplier getSupplier() {
        return supplier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

	public int getQuantity() {
		return quantity;
	}

	// public int getSupplierId() {
	// 	return supplierId;
	// }

	public String getName() {
		return name;
	}

    public int getSupplierId() {
        return supplierId;
    }
    
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public void decreaseQuantity(int quantity) {
		if(this.quantity - quantity <= 0) {
			return;
		}
		else
			this.quantity -= quantity;
    }

    public String toString() {
        String toString = "id: " + id;
        toString += "\nname: " + name;
        toString += "\nquantity: " + quantity;
        toString += "\nprice: " + price;
        toString += "\nSupplier ID: " + supplierId;
        return toString;
    }
}