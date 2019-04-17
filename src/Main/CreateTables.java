package Main;

import Company.Company;
import Company.CompanyDBDAO;

public class CreateTables {


	private Database database = new Database();

	

	public CreateTables() {
		

	}


	public void CreateAllTables() throws Exception {
		//*this method calling insertcompany from caompnyDBDAO
		
		database.createCustomerTable();
		database.createCustomer_CouponTable();
		database.createCompany_CouponTable();
		database.createCouponTable();
		database.createCompanyTable();
		database.createExpiredCouponTable();
		

	}
}
