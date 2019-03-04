public class Supplier {
	private int id;
	private String company;
	private String address;
	private String name;

	public Supplier(int id, String company, String address, String name) {
		this. id =  id;
		this.company = company;
		this.address = address;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String contact) {
		this.company = contact;
	}
	
	
}