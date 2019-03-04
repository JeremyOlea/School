/**
 * A single order of a tool from the shop
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class OrderLine {
	/**
	 * the tool that was bought and is being recorded
	 */
	private Tool tool;
	/**
	 * the quantity of the tool that was bought
	 */
	private int quantity;
	/**
	 * the supplier that the tool came from
	 */
	private Supplier supplier;

	/**
	 * Constructor for that OrderLine
	 * @param tool the tool that was bought
	 * @param quantity quantity of tool that was bought
	 * @param supplier supplier where tool was bought from
	 */
	public OrderLine (Tool tool, int quantity, Supplier supplier) {
		this.tool = tool;
		this.quantity = quantity;
		this.supplier = supplier;
	}
	
	/**
	 * Getter for tool
	 * @return the tool
	 */
	public Tool getTool() {
		return tool;
	}
	/**
	 * Setter for tool
	 * @param tool the tool
	 */
	public void setTool(Tool tool) {
		this.tool = tool;
	}
	/**
	 * Getter for quantity of tool
	 * @return the quantity of the tool
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * Setter for quantity of the tool
	 * @param quantity quantity to be set to
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Getter for supplier fo tool
	 * @return the supplier of the tool
	 */
	public Supplier getSupplier() {
		return supplier;
	}

	/**
	 * Setter for the supplier of the tool
	 * @param supplier the supplier
	 */

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}