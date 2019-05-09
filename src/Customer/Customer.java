package Customer;

/**

 * 

 * @author Maytal & Maayan

 *
 */

public class Customer
{
	private long id;
	private String custName;
	private String password;
	
	public Customer() {
		
	}
	//*  empty cTor for customer
	
	
	public Customer(long id, String custName, String password) {
		setId(id);
		setCustName(custName);
		setPassword(password);
	}
	//* full cTor for the customer 
	
	public Customer(String custName, String password) {
		setCustName(custName);
		setPassword(password);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + "]";
	}
	
	

}
