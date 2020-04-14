
import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variable
	private int id;
	private String name;
	private String sex;
	private String dob;
	
	private int total=0;

	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}

	//Constructor
	public Customer() {
		super();
	}
	
	public Customer(int id, String name, String sex, String dob,int total) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.dob = dob;
		this.total=total;
	}
	
	//Getter & Setter
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
    public String toString() {
        return new StringBuffer(" ID : ").append(this.id)
                .append(",Name : ").append(this.name).append(",Sex : ").append(this.sex).append(",Dob :").append(this.dob).toString();
    }

	
//	@Override
//	public int compareTo(Customer o) {
//		return this.name.compareTo(o.getName());
//	}
}
