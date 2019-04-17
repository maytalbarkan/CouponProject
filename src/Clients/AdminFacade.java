
package Clients;
import java.nio.file.WatchService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.LongFunction;
import java.util.jar.Attributes.Name;

import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

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

				if ((company.getPassword() != null) && (company.getEmail() != null) && (!companyDBDAO.ifCompanyNameExists(companyName))) {

			
					try {
						companyDBDAO.insertCompany(company);
						System.out.println("the company created");
					}
					catch (Exception e)  {
						System.out.println(e);
					}
//					companyDBDAO.insertCompany(company);
//					System.out.println("the company created");
				}
			}
		}

	}
	
	public void removeCompany(Company company) throws Exception {
		
		CompanyFacade companyFacade = new CompanyFacade();
		long compid=company.getId();
		List<Long> companycoupon= company_CouponDBDao.getCouponsByCompanyId(compid);
		System.out.println(companycoupon);
	
		for (Long id : companycoupon) {
			System.out.println(id);
		//	customerDBDAO.removeAllPurchasedCustomerCoupons(id);
		
		}
			
			//company_CouponDBDao.removeCompany_Coupon(company);
			//companyDBDAO.removeCompany(company);
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

		
		public Collection <Company> getAllCompanys() throws Exception {
			//*this method calling get all company from caompnyDBDAO

			return companyDBDAO.getAllCompanys();

		}
		
		


		//****************************************************************************************************
		//CUSTOMER METHODS
		
		public void insertCustomer(Customer customer) throws Exception {
			//*this method calling insert customer from CustomerDBDAO
			String custName = customer.getCustName();
				if (custName != null && customer.getPassword() != null && customer != null) {
						
			boolean bool = customerDBDAO.ifCustomerNameExists(customer);
				
			if (bool==false) {
							try {
							customerDBDAO.insertCustomer(customer);
							
							} catch (Exception e) {
								System.out.println("The customer is exists! chose different name!");
										}
						}
						else {
							System.out.println("The customer is exists! chose different name!");
						}
			}
	}
		



		public void removeCustomer(Customer temp) throws Exception{
			Customer cus= new Customer();
			cus= customerDBDAO.getCustomer(temp);
			long id= cus.getId();
		//	customerDBDAO.removeAllPurchasedCustomerCoupons(id);
			customerDBDAO.removeCustomerById(id);
			
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
		public Client login(String user, String password, ClientType clienttype) {
			return null;
		
			
		}
}		
	





