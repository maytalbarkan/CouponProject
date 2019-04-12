
package Clients;
import java.nio.file.WatchService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import java.util.function.LongFunction;

import Company.Company;
import Company.CompanyDBDAO;
import Company.Company_CouponDBDao;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Customer.Customer;
import Customer.CustomerDBDAO;
import Customer.Customer_CouponDBDao;
import Main.Utils;

/**
  * 
  */
 /**
  * @author Maytal & mayaan *
 */


public class AdminFacade implements Client {

	private ClientType clientType = ClientType.ADMIN;
	private static final String adminUserName = "admin";
	private static final String adminPassword = "1234";
	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	private Company_CouponDBDao company_CouponDBDao = new Company_CouponDBDao();
	private CustomerDBDAO customerDBDAO = new CustomerDBDAO();
	private LocalDate now = LocalDate.now();
	private Customer_CouponDBDao customer_CouponDBDao = new Customer_CouponDBDao();
	private CouponDBDAO coupCompanyDao = new CouponDBDAO();


	// empty cTor for companyFacade
	public AdminFacade() {

	}

	
	//****************************************************************************************************
	//COMPANY METHODS
	
	
	
		public void insertCompany(Company company) throws Exception {

			if (company != null) {

				String companyName = company.getComp_Name();

				if (companyName != null) {

					if (company.getPassword() != null) {

						if (company.getEmail() != null) {

							if (!companyDBDAO.ifCompanyNameExists(companyName)) {
							try {
									companyDBDAO.insertCompany(company);
									System.out.println("the company created");
									}
							catch (Exception e)  {
							
								System.out.println("Company Already Exists! chose a different name!"); 

							}
							companyDBDAO.insertCompany(company);
							System.out.println("the company created");
						}
					}
				}
			
	}}}
	
	public void removeCompany(Company company) throws Exception {
			companyDBDAO.removeCompany(company);
			company_CouponDBDao.removeCompany_Coupon(company);
	//		customer_CouponDBDao.removebyCouponCustomer(coupon);
		}

		public void removeCoupons(Coupon coupon) throws Exception {
			company_CouponDBDao.removeCoupons(coupon);
			
		}
		
		public void updateCompany(Company company, String password, String email) throws Exception {
			//*this method update company details without company name
			company.setPassword(password);
			company.setEmail(email);
			companyDBDAO.updateCompany(company);
		}

	
		public void getCompany(Company company) throws Exception {
		 System.out.println(company);
		}

		
		public Set<Company> getAllCompanys() throws Exception {
			//*this method calling getallcompany from caompnyDBDAO

			return companyDBDAO.getAllCompany();

		}
		
		


		//****************************************************************************************************
		//CUSTOMER METHODS
		
		public void insertCustomer(Customer customer) throws Exception {
			//*this method calling insert customer from CustomerDBDAO
			if (customer != null) {

				String custName = customer.getCustName();

				if (custName != null) {

					if (customer.getPassword() != null) {

						if (!customerDBDAO.ifCustomerNameExists(custName)) {

							try {

								customerDBDAO.insertCustomer(customer);

							} catch (Exception e) {
								System.out.println("The customer is exists! chose different name!");
								
							}
			
													}
										}
							}
			}
		}



		public void removeCustomer(Customer temp) throws Exception{
			Customer cus= new Customer();
			cus= customerDBDAO.getCustomer(temp);
			long id= temp.getId();
			System.out.println(temp);
//			customerDBDAO.removeCustomerById(id);
//			customerDBDAO.removeAllPurchasedCustomerCoupons(id);
		}


		public void updateCustomer(Customer customer, String password) throws Exception {
			//*this method calling update customer from customerDBDAO without customer name
			
			Customer customer2=new Customer();
			customer2=customerDBDAO.getCustomer(customer);
			
			customer2.setPassword(password);

			customerDBDAO.updateCustomer(customer2);
			

		}



		public void getCustomerDetails (Customer temp) throws Exception {
			
			Customer customer= new Customer();
			customer= customerDBDAO.getCustomer(temp);
			System.out.println(customer);
		

		}



		public Set<Customer> getAllCustomers() throws Exception {
			//*this method calling getAllCustomer from customerDBDAO

			return customerDBDAO.getAllCustomers();

		}


		@Override
		public void login(String user, String password, ClientType clienttype) {
			// TODO Auto-generated method stub
			
		}
		
	
}




