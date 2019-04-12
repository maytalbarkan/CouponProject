package Main;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;

import org.apache.derby.tools.sysinfo;

import Clients.AdminFacade;
import Clients.CompanyFacade;
import Clients.CustomerFacade;
import Company.Company;
import Company.CompanyDBDAO;
import Company.Company_CouponDBDao;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import Customer.Customer_CouponDBDao;


public class Test {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.derby.jdbc.ClientDriver");



	
		
//		Database.dropCompany_CouponTable();
//		Database.dropCompanyTable();
//		Database.dropCouponTable();
//		Database.dropCustomer_CouponTable();
//		Database.dropCustomerTable();
//		Database.dropcreateExpiredCouponTable();
		
//		Database.createCustomerTable();
//		Database.createCustomer_CouponTable();
//		Database.createCompany_CouponTable();
//		Database.createCouponTable();
//		Database.createCompanyTable();
//		Database.createExpiredCouponTable();


		AdminFacade adminFacade =new AdminFacade();
		CompanyFacade companyFacade = new CompanyFacade();
		CustomerFacade customerFacade=new CustomerFacade();
		
		CustomerDBDAO customerDBDAO =new CustomerDBDAO();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	
//		CouponFacade couponFacade = new CouponFacade();	
//		CustomerFacade customerFacade= new CustomerFacade();
//		Company_CouponFacade company_CouponFacad=new Company_CouponFacade();
  
		
		
	//	Thread threads = new Thread(new ThreadsDailyExpiredCoupons());
		//threads.start();
		
		Company company1 = new Company(1234567, "Coca Cola", "1234", "cocacola@gmail.com");
		Company company2 = new Company(2345678, "Google", "4444", "google@gmail.com");
		Company company3 = new Company(3456789, "Apple", "m123", "apple@gmail.com");
		Company company4 = new Company(4567890, "Booking", "o4444", "Booking@gmail.com");
		Company company5 = new Company(5567468, "Disney", "H555", "disney@hotmail.com");	
		Company company6 = new Company(6654678, "Amazon", "H55jjj5", "amazon@hello.com");	
		Company company7 = new Company(7868885, "Pizza", "mmm", "pizza@hello.com");	
		Company company8 = new Company(6788887, "Sport NOW", "pem", "sportnow@Hello.com");		
	//	adminFacade.insertCompany(company1);
	//	adminFacade.insertCompany(company2);
	//	adminFacade.insertCompany(company3);
	//	adminFacade.insertCompany(company4);
	//	adminFacade.insertCompany(company5);
	//	adminFacade.insertCompany(company6);
	//	adminFacade.insertCompany(company7);
	//	adminFacade.insertCompany(company8);
		
	//	adminFacade.insertCompany(p1);
	//	adminFacade.removeCompany(p2);
	//	adminFacade.updateCompany(p8, "ldldld", "lkdnlkn@gmail.com");
//		adminFacade.getAllCompanys();
//		adminFacade.getCompany(4);
		
		Customer customer1= new Customer( "Johann Sebastian Bach", "kfkf99");
		Customer customer2= new Customer( "Wolfgang Amadeus Mozart", "kfkf99");
		Customer customer3 = new Customer("Ludwig van Beethoven","m777kkj");
		Customer customer4 = new Customer("Johannes Brahms", "b888k");
		Customer customer5 = new Customer("Franz Schubert", "l44kk4");
		Customer customer6 = new Customer("Frederic Chopin", "67kgkgkgk");
		Customer customer7 = new Customer("Giuseppe Verdi", "k34nrnrn");
		Customer customer8 = new Customer("Claude Debussy", "12rn");
//		adminFacade.insertCustomer(customer1);
//		adminFacade.insertCustomer(customer2);
//		adminFacade.insertCustomer(customer3);
//		adminFacade.insertCustomer(customer4);
//		adminFacade.insertCustomer(customer5);
//		adminFacade.insertCustomer(customer6);
//		adminFacade.insertCustomer(customer7);
//		adminFacade.insertCustomer(customer8);		
		
	//	adminFacade.removeCustomer(c2);
	//	c.removeCustomer(c1);
	//	adminFacade.updateCustomer(c1, "flsm");
		
	
		Coupon coupon1 = new Coupon("Fedrik 50% less", Utils.getCurrentDate(), Utils.getExpiredDate(),500, CouponType.Food, "first coupon", 5632, "image.png");
		Coupon coupon2= new Coupon("hihi 30% off", Utils.getCurrentDate(), Utils.getExpiredDate(), 400, CouponType.Health, "coupon2", 5.63, "blabla");
		Coupon coupon3= new Coupon("Blue Sky 20%off", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 400, CouponType.Sports, "coupon2", 343, "shalom");
		Coupon coupon4= new Coupon("Orange here 10%off", Utils.getCurrentDate(), Utils.getExpiredDate(), 400, CouponType.Traveling, "coupon2", 445, "gadol");
		Coupon coupon5= new Coupon("Green discounet", Utils.getCurrentDate(), Utils.getExpiredDate(), 400, CouponType.Electricity, "coupon2", 563, "lory");
		Coupon coupon6= new Coupon("Pink less for more", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 400, CouponType.Resturans, "coupon2", 55.63, "koko");
		Coupon coupon7= new Coupon("Red Rose", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 400, CouponType.Traveling, "coupon2", 56.3, "lala");
		Coupon coupon8= new Coupon("Pica Boo", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 400, CouponType.Traveling, "coupon2", 56.3, "lala");
		Coupon coupon9 = new Coupon("Only Meat", Utils.getCurrentDate(), Utils.getExpiredDateNextDay(), 9, CouponType.Resturans, "coupon9", 8.99, "steak");
		Coupon coupon10= new Coupon("Summer Sale", Utils.getCurrentDate(), Utils.getExpiredDate(), 600, CouponType.Camping, "1010", 632.58, "no");
		Coupon coupon11= new Coupon("winter Sale", Utils.getCurrentDate(), Utils.getExpiredDate(), 600, CouponType.Food, "3332", 554.58, "yes");
//		companyFacade.insertCoupon(coupon1,  company1);
//		companyFacade.insertCoupon(coupon2,  company2);
//		companyFacade.insertCoupon(coupon3,  company3);
//		companyFacade.insertCoupon(coupon4,  company4);
//		companyFacade.insertCoupon(coupon5,  company5);
//		companyFacade.insertCoupon(coupon6,  company6);
//		companyFacade.insertCoupon(coupon7,  company7);
//		companyFacade.insertCoupon(coupon8,  company8);
//		companyFacade.insertCoupon(coupon9,  company1);
//		companyFacade.insertCoupon(coupon10,  company3);

//		companyFacade.updateCoupon(coupon10, Utils.getExpiredDateNextDay(), 367);
//		CustomerDBDAO n= new CustomerDBDAO();
//		n.ifCustomerNameExists("Liran Levi");
		
//		companyFacade.getDetails(company8);
//		Company_CouponDBDao company_CouponDBDao = new Company_CouponDBDao();
//		company_CouponDBDao.getCouponsByCompanyId(1234567);
		
	
//*************************************************************************
//			ADMIN FACADE
//			adminFacade.removeCompany(company6);
//			adminFacade.updateCompany(company8, "@1112", "alklkn@gmail.com");
//	----	adminFacade.getAllCompanys();
//	----	companyDBDAO.getAllCompanys();
//			adminFacade.getCompany(company2);
//			adminFacade.removeCustomer(customer8);
//			Customer tmp = customerDBDAO.getCustomer(customer7);
			
			
//			System.out.println("Tmp is "+tmp);
//			System.out.println(customerDBDAO.getCustomer(customer7));
//*************************************************************************
//			COMPANY FACADE
//			companyFacade.insertCoupon(coupon11, company1);
//			companyFacade.removeCoupons(coupon11);
//			companyFacade.updateCoupon(coupon10, Utils.getExpiredDate(), 2222);
//			companyFacade.getDetails(company6);
//			System.out.println(companyFacade.getAllCompanyCoupon(company1));
//	0000		companyFacade.getCouponbyType(company1, CouponType.Food);	
//			System.out.println(companyFacade.getCouponbyprice(company1, 10));
			LocalDate localDate = LocalDate.now();
			localDate = localDate.plusDays(2);
	    	Date date = java.sql.Date.valueOf(localDate);
//	 000   	System.out.println(companyFacade.getCouponbyDate(company1, date));

		
//*************************************************************************
//		CUSTOMER FACADE
//		customerFacade.buyCoupon(customer6, coupon6);
//		System.out.println(customerFacade.getAllPurchasedCouponsByCustomer(customer8));	
//		System.out.println(customerFacade.getAllPurchasedCouponsByType(customer8, CouponType.Traveling));
//		System.out.println(customerFacade.getAllPurchasedCouponByPrice(customer3, 7));
		

	}}


