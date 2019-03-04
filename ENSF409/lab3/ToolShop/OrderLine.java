public class OrderLine {
	private Tool tool;
	private int quantity;
	private Supplier supplier;

	public OrderLine (Tool tool, int quantity, Supplier supplier) {
		this.tool = tool;
		this.quantity = quantity;
		this.supplier = supplier;
	}
	
	public Tool getTool() {
		return tool;
	}
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
	
}