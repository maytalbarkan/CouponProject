package Company;

/**

 * 

 * @author Maytal 

 *
 */
public class Company
{
	private long id;
	private String comp_Name;
	private String password;
	private String email;
	
public Company() {
		
	}
/**

 *  empty cTor for Company

 */
	
	public Company(long id, String comp_Name, String password, String email) {
		this.id = id;
		this.comp_Name = comp_Name;
		this.password = password;
		this.email = email;
	}

	/**

	 * full cTor for the company object

	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComp_Name() {
		return comp_Name;
	}

	public void setComp_Name(String comp_Name) {
		this.comp_Name = comp_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comp_Name == null) ? 0 : comp_Name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Company other = (Company) obj;
		if (comp_Name == null) {
			if (other.comp_Name != null)
				return false;
		} else if (!comp_Name.equals(other.comp_Name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		return "Company [id=" + id + ", comp_Name=" + comp_Name + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
