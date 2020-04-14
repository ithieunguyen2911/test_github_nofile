
public class Order {
	//Variable
	private int id;
	private int custid;
	private String description;
	private int total;
	private String orderDate;
	
	//Constructor
	public Order() {
		super();
	}
	
	public Order(int id, int custid, String description, int total, String orderDate) {
		super();
		this.id = id;
		this.custid = custid;
		this.description = description;
		this.total = total;
		this.orderDate = orderDate;
	}
	
	//Getter & Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
