/**
 * The supplier that sells a tool to the shop
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class Supplier {
	/**
	 * Id of the supplier
	 */
	private int id;
	/**
	 * Company of the supplier
	 */
	private String company;
	/**
	 * Address of the supplier
	 */
	private String address;
	/**
	 * Name of the supplier
	 */
	private String name;

	/**
	 * Constructor of the supplier
	 * @param id id of supplier
	 * @param company company of supplier
	 * @param address address of supplier
	 * @param name name of supplier
	 */
	public Supplier(int id, String company, String address, String name) {
		this. id =  id;
		this.company = company;
		this.address = address;
		this.name = name;
	}
	
	/**
	 * Getter for id of supplier
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for the id for the supplier
	 * @param id id to be set to
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Getter for name of the supplier
	 * @return the name of the supplier
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for the name of the supplier
	 * @param name name to be set to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for address of the supplier
	 * @return the address of the supplier
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for the address of the supplier
	 * @param address address of the supplier
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for the company of the supplier
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * Setter for company of the supplier
	 * @param company company to be set to
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}