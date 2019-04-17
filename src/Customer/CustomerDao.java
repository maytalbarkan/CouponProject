package Customer;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Set;

/**
 * @author Maytal 

 */

	public interface CustomerDao {
//* this interface are methods that we wan to implement in customerdbda 
		
			void insertCustomer(Customer customer) throws Exception;
			//* method that can insert a customer to the DB

			void updateCustomer(Customer customer) throws Exception;
			//* method that can update a customer from the DB

			Set<Customer> getAllCustomers() throws Exception;
			//* method that can retrieve a customer from the DB by id
			
		  Customer getCustomer(Customer customer) throws Exception;
			//* method that can retrieve all customers from the DB 
	
		  public boolean ifCustomerNameExists(Customer cust) throws Exception;
			//*method that check if customer exists
			
			 Customer extractCustomerFromResultSet1(ResultSet result) throws Exception;
			
			 Collection<Customer> getAllCustomer() throws Exception;
			 
			 void removeCustomerById(long id) throws Exception;
			 
			 void removePurchasedCustomerCoupons(long id) throws Exception;
}
