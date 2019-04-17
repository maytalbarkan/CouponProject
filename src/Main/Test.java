package Main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;
import Clients.AdminFacade;
import Clients.Client;
import Clients.ClientType;
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
import Exception.CouponException;
import Threads.ThreadsDailyExpiredCoupons;


public class Test {

	public static void main(String[] args) throws Exception  {

		
			Class.forName("org.apache.derby.jdbc.ClientDriver");
	

		

//			Database.dropCouponTable();
//			Database.dropCompanyTable();
//			Database.dropCompany_CouponTable();
//			Database.dropCustomer_CouponTable();
//			Database.dropCustomerTable();
//			Database.dropcreateExpiredCouponTable();
//
//
//			Database.createCustomerTable();
//			Database.createCustomer_CouponTable();
//			Database.createCompany_CouponTable();
//			Database.createCouponTable();
//			Database.createCompanyTable();
//			Database.createExpiredCouponTable();


		AdminFacade adminFacade =new AdminFacade();
		CompanyFacade companyFacade = new CompanyFacade();
		CustomerFacade customerFacade=new CustomerFacade();
		
		CustomerDBDAO customerDBDAO =new CustomerDBDAO();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();

// COMPANYS		
		Company company1 = new Company(1234567, "Coca Cola", "1234", "cocacola@gmail.com");
		Company company2 = new Company(2345678, "Google", "4444", "google@gmail.com");
		Company company3 = new Company(3456789, "Apple", "m123", "apple@gmail.com");
		Company company4 = new Company(4567890, "Booking", "o4444", "Booking@gmail.com");
		Company company5 = new Company(5567468, "Disney", "H555", "disney@hotmail.com");	
		Company company6 = new Company(6654678, "Amazon", "H55jjj5", "amazon@hello.com");	
		Company company7 = new Company(7868885, "Pizza", "mmm", "pizza@hello.com");	
		Company company8 = new Company(6788887, "Sport NOW", "pem", "sportnow@Hello.com");
		Company company9 = new Company(7899998, "AddNow", "eddss", "sklk@addnow.com");
//		adminFacade.insertCompany(company1);
//		adminFacade.insertCompany(company2);
//		adminFacade.insertCompany(company3);
//		adminFacade.insertCompany(company4);
//		adminFacade.insertCompany(company5);
//		adminFacade.insertCompany(company6);
//		adminFacade.insertCompany(company7);
//		adminFacade.insertCompany(company8);
//		adminFacade.insertCompany(company9);

		
		Customer customer1= new Customer( "Johbakjsdfhjksfdstian Bach", "kfkf99");
		Customer customer2= new Customer( "Wolfgang Amadeus Mozart", "kfkf99");
		Customer customer3 = new Customer("Ludwig van Beethoven","m777kkj");
		Customer customer4 = new Customer("Johannes Brahms", "b888k");
		Customer customer5 = new Customer("Franz Schubert", "l44kk4");
		Customer customer6 = new Customer("Frederic Chopin", "67kgkgkgk");
		Customer customer7 = new Customer("Giuseppe Verdi", "k34nrnrn");
		Customer customer8 = new Customer("Claude Debussy", "12rn");
		Customer customer9 = new Customer("Cjdnjdjdlaude Debussy", "12rnjfsdiisudffioj");
//		adminFacade.insertCustomer(customer1);
//		adminFacade.insertCustomer(customer2);
//		adminFacade.insertCustomer(customer3);
//		adminFacade.insertCustomer(customer4);
//		adminFacade.insertCustomer(customer5);
//		adminFacade.insertCustomer(customer6);
//		adminFacade.insertCustomer(customer7);
//		adminFacade.insertCustomer(customer8);		
//		adminFacade.insertCustomer(customer9);	
		
//System.out.println(	customerDBDAO.ifCustomerNameExists(customer1));
	
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
//		companyFacade.insertCoupon(coupon9,  company9);
//		companyFacade.insertCoupon(coupon10,  company1);
//		companyFacade.insertCoupon(coupon11,  company1);

		
		Company_CouponDBDao company_CouponDBDao= new Company_CouponDBDao();
//		company_CouponDBDao.getMaxCouponId();
		
//		companyFacade.updateCoupon(coupon10, Utils.getExpiredDateNextDay(), 367);
//		CustomerDBDAO n= new CustomerDBDAO();
//		n.ifCustomerNameExists("Liran Levi");
		
//		companyFacade.getDetails(company8);
//		Company_CouponDBDao company_CouponDBDao = new Company_CouponDBDao();
//		company_CouponDBDao.getCouponsByCompanyId(1234567);
		
	
//*************************************************************************
//			ADMIN FACADE
 //		adminFacade.insertCompany(company7);
//		adminFacade.removeCompany(company7);
//			adminFacade.updateCompany(company9, "@1119992", "alklkn@gmail.com");
//			adminFacade.getCompany(company9);
//			System.out.println(adminFacade.getAllCompanys());
//			adminFacade.insertCustomer(customer8);
//		customerDBDAO.ifCustomerNameExists(customer1);
//	----	companyDBDAO.getAllCompanys();
//			adminFacade.getCompany(company2);
//		adminFacade.removeCustomer(customer1);
//		adminFacade.updateCustomer(customer3, "@777777");
//		adminFacade.getCustomerDetails(customer3);
//		System.out.println(adminFacade.getAllCustomers());
			
	
//*************************************************************************
//			COMPANY FACADE
//			companyFacade.insertCoupon(coupon3, company8);
//			companyFacade.removeCoupons(coupon4);
//			companyFacade.updateCoupon(coupon1, Utils.getExpiredDate(), 2222);
//			companyFacade.getDetails(company6);
//			System.out.println(companyFacade.getAllCompanyCoupon(company1));
//00		System.out.println(companyFacade.getCouponbyType(company1, CouponType.Food));	
//			System.out.println(companyFacade.getCouponbyprice(company1, 10));
			LocalDate localDate = LocalDate.now();
			localDate = localDate.plusDays(2);
	    	Date date = java.sql.Date.valueOf(localDate);
//    	System.out.println(companyFacade.getCouponbyDate(company1, date));

		
//*************************************************************************
//		CUSTOMER FACADE
//		customerFacade.buyCoupon(customer1, coupon6);
//		System.out.println(customerFacade.getAllPurchasedCouponsByCustomer(customer1));	
//--		System.out.println(customerFacade.getAllPurchasedCouponsByType(customer2, CouponType.Traveling));
//		System.out.println(customerFacade.getAllPurchasedCouponByPrice(customer3, 7));
		

//*************************************************************************
	//    	public static void main(String[] args) {
	    		
	    		//	CouponSystem.getInstance().start();
	    			
	    			
	    			
	    		//	CouponSystem.getInstance().stop();
	    		}

//	    		public static AdminFacade getInstance() {
//	    			// TODO Auto-generated method stub
//	    			return null;
//	    		}

//	    	}
//	    	  String name;
//
//	          String password;
//
//	          Client client;
//
//	          ClientType type = Client.ClientType.ADMIN;
//
//	          Set<Company> companies;
//
//	          Company testCompany;
//
//	          Customer testCostumer;
//
//	          AdminFacade admin;
//
//
//
//	          Company abc=new Company();
//
//	          abc.setComp_Name("abc");
//
//	          abc.setEmail("abc@abc.abc");
//
//	          abc.setPassword("abcabc");
//
//
//
//	          Coupon coupon=new Coupon();
//
//	          coupon.setTitle("Free Java project");
//
//	          coupon.setStart_date(Utils.getCurrentDate());
//
//	          try {
//
//	              coupon.setEnd_date(Utils.getExpiredDate());
//
//	          } catch (CouponException e) {
//
//	              e.printStackTrace();
//
//	          }
//
//	          coupon.setAmount(1);
//
//	          coupon.setType(CouponType.Camping);
//
//	          coupon.setMessage("Want a 100% free coupon system project?");
//
//	          coupon.setPrice(0.01);
//
//	          coupon.setImage("http://www.imagevine.com/info/images/100-coup.gif");
//
//
//
//	          try{
//
//	              System.out.println( "you have "+ConnectionPool.getInstance().avilabelConnections()+" available connections");
//
//	          }catch (Throwable e){
//
//	              System.out.println(e.getMessage());
//
//	          }
//	    	
//	    	
//	    	//****Admin Test****//
//
//
//
//	        //(1) bad login//
//
//	        name= "admin";
//
//	        password="12348";
//
//	        System.out.println("(1) checking bad login as admin:");
//
//	        try{
//
//	            client=CouponSystem.getInstance().login(name,password,type);
//
//	        }catch (CouponException e){
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//
//
//	        name= "admin";
//
//	        password="1234";
//
//
//
//
//
//	        try {
//
//	            // (2)get Admin facade
//
//	            client=CouponSystem.getInstance().login(name,password,type);
//
//	            admin=(AdminFacade)client;
//
//
//
//	            // (3) print a costumer
//
////	            testCostumer=admin.getCostumer(1);
//
////	            System.out.println("(3)\nget costumer:\n"+testCostumer);
//
//
//
//	            // (4) print all companies
//
//	            companies=admin.getAllCompanys();
//
//	            System.out.println("(4)\nlist of companies:\n"+companies+"\nEnd of (4)");
//
//
//
//	            // (5) print a company
//
//	          //  testCompany=admin.getCompany(10);
//
//	          //  System.out.println("(5)\nget company:\n"+testCompany+"\nEnd of (5)");
//
//
//
//	            // (6) create a company
//
//	         //   admin.createCompany(abc);
//
//	           // abc=admin.getCompany(40); //the ID is set at the company creation in intervals of 10. so in order to get the company id i need to pull it back from server. Alternatively i can just set it to 40, but this is safer.
//
//
//
//	            // (7) checking the company was added
//
//	            companies=admin.getAllCompanys();
//
//	            System.out.println("(7)\nlist of companies:\n"+companies+"\nEnd of list(7)");
//
//	            // (8) remove company
//
//	            abc=admin.getCompany(60);
//
//	            admin.removeCompany(abc);
//
//	            System.out.println("(8)\ncompany removed");
//
//	            companies=admin.getAllCompanys();
//
//	            System.out.println("list of companies after removal:\n"+companies+"\nEnd of list(8)");
//
//	            //recreate the company for later use.
//
//	            admin.createCompany(abc);
//
//	        } catch (CouponException e) {
//
//	            e.printStackTrace();
//
//	        }
//
//	        client=null;
//
//
//
//	        //*** Company test****///
//
//	        name="Around the World";
//
//	        password="superman1";
//
//	        type= Client.ClientType.COMPANY;
//
//
//
//	        try{
//
//	            // (9) bad login as company
//
//	            System.out.println("(9)\nbad login as company:");
//
//	            client=CouponSystem.getInstance().login(name,password,type);
//
//	            CompanyFacade companyFacade=(CompanyFacade)client;
//
//	        }catch (CouponException e){
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//
//
//	        try{
//
//	            // (10) login as company abc (the new company)
//
//	            System.out.println("(10)\nlogin as company abc:");
//
//	            client=CouponSystem.getInstance().login(abc.getCompName(),abc.getPassword(),type);
//
//	            CompanyFacade companyFacade=(CompanyFacade)client;
//
//
//
//	            // (11) create coupon
//
//	            companyFacade.CreateCoupon(coupon);
//
//	            System.out.println("(11)\ncoupon created:");
//
//	            System.out.println(companyFacade.getAllCoupons());
//
//
//
//	            //(12) remove coupon of other company
//
//	            System.out.println("(12)\nremove false coupon:");
//
//	            Coupon falseCoup=new Coupon();
//
//	            falseCoup.setId((long)1);
//
//	            try {
//
//	                companyFacade.removeCoupon(falseCoup);
//
//	            }catch (CouponException e){
//
//	                System.out.println(e.getMessage());
//
//	            }
//
//
//
//	            // (13) remove coupon
//
//	            System.out.println("(13)\nremove coupon:");
//
//	            companyFacade.removeCoupon(coupon);
//
//	            System.out.println("remove succeeded");
//
//
//
//	            //recreate coupon for next tests
//
//	            companyFacade.CreateCoupon(coupon);
//
//	            //(14) update coupon to expire
//
//	            System.out.println("(14)\nupdate coupon to expire:");
//
//	            try {
//
//	                companyFacade.updateCoupon(coupon, LocalDate.now());
//
//	            }catch (CouponException e){
//
//	                System.out.println(e.getMessage());
//
//	            }
//
//	            //(15) update coupon expire date
//
//	            System.out.println("(15)\nupdate coupon:");
//
//	            companyFacade.updateCoupon(coupon,LocalDate.of(2016,3,20));
//
//	            System.out.println("coupon updated");
//
//
//
//	            //(16) update price of a coupon
//
//	            System.out.println("(16)\nupdate coupon price:");
//
//	            companyFacade.updateCoupon(coupon,11.11);
//
//	            System.out.println("price updated");
//
//
//
//	            //(17) list of coupons (a company with more than one coupon)
//
//	            name="Around the World";
//
//	            password="superman";
//
//	            type= Client.ClientType.COMPANY;
//
//	            client=CouponSystem.getInstance().login(name,password,type);
//
//	            CompanyFacade tempComp=(CompanyFacade)client;
//
//	            client=null;
//
//	            System.out.println("(17)\nlist of all coupons of a company:");
//
//	            System.out.println(tempComp.getAllCoupons()+"\nEnd of list(17)");
//
//
//
//	        }catch (CouponException e){
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//
//
//	        //*** Costumer test****///
//
//	        name="Han Solo";
//
//	        password="Falcon";
//
//	        type= Client.ClientType.COSTUMER;
//
//
//
//	        try{
//
//	            // (18) bad login as costumer
//
//	            System.out.println("(18)\nbad login as costumer:");
//
//	            client=CouponSystem.getInstance().login(name,password+"1",type);
//
//	        }catch (CouponException e){
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//
//
//	        try{
//
//	            //(19) login as costumer:
//
//	            System.out.println("(19)\n login as costumer:");
//
//	            client=CouponSystem.getInstance().login(name,password,type);
//
//	            CostumerFacade costumerFacade=(CostumerFacade)client;
//
//
//
//	            //(20) get coupons by type
//
//	            CouponType Ctype=CouponType.ELECTRICITY;
//
//	            Set<Coupon> Cset=costumerFacade.getCouponbyType(Ctype);
//
//	            System.out.println("(20)\nAvailable coupons by type:\n"+Cset+"\nEnd of list (20)");
//
//
//
//	            //(21) get all coupons
//
//	            Cset=costumerFacade.getAllCoupons();
//
//	            System.out.println("(21)\nAvailable coupons:\n"+Cset+"\nEnd of list (21)");
//
//
//
//	            //(22) buy a coupon
//
//	            costumerFacade.buyCoupon((long) 8);
//
//
//
//	            //(23) see costumer coupons
//
//	            Cset=costumerFacade.getCostumerCoupons();
//
//	            System.out.println("(23)\npurchased Coupons:\n"+Cset+"\nEnd of list (23)");
//
//
//
//	            //(24) see costumer coupons by type
//
//	            Cset=costumerFacade.getCouponHistoryByType(Ctype);
//
//	            System.out.println("(24)\npurchased Coupons with type "+Ctype+":\n"+Cset+"\nEnd of list (23)");
//
//
//
//	            //(25)see available coupons by price:
//
//	            double price=20;
//
//	            Cset=costumerFacade.getCouponByPrice(price);
//
//	            System.out.println("(25)\navailable Coupons up to "+price+":\n"+Cset+"\nEnd of list (25)");
//
//
//
//	            //(26) buy coupons with amount 0:
//
//	            try {
//
//	                System.out.println("(26)\nTry to buy a coupon with amount 0");
//
//	                costumerFacade.buyCoupon(8);
//
//	            }catch (CouponException e){
//
//	                System.out.println(e.getMessage());
//
//	            }
//
//
//
//	            //(27) buy the same coupon twice:
//
//	            try{
//
//	                System.out.println("(27)\nbuy a coupon one already have:");
//
//	                costumerFacade.buyCoupon(2);
//
//	            }catch (CouponException e){
//
//	                System.out.println(e.getMessage());
//
//	            }
//
//
//
//	            //(28) coupon by price that a costumer has:
//
//	            System.out.println("(28)\nFilter ones coupons up to the price of "+price+":");
//
//	            Cset=costumerFacade.getCouponHistorybyPrice(price);
//
//	            System.out.println(Cset);
//
//
//
//	        }catch (CouponException e){
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//
//
//
//
//
//
//	        // (29) returning the DB to its initial situation for next run (not part of the test)
//
//	        try {
//
//	            System.out.println("\nEnd of Test");
//
//	            System.out.println("***********");
//
//	            System.out.println("retrieving DB to its initial condition");
//
//	            System.out.println("login as admin");
//
//	            client=CouponSystem.getInstance().login("admin","1234", Client.ClientType.ADMIN);
//
//	            admin=(AdminFacade)client;
//
//	            abc.setId((long)40);
//
//	            admin.removeCompany(abc);
//
//	        } catch (CouponException e) {
//
//	            e.printStackTrace();
//
//	        }
//
//
//
//	        try {
//
//	            CouponSystem.getInstance().shutdown();
//
//	        } catch (CouponException e) {
//
//	            System.out.println(e.getMessage());
//
//	        }
//
//	        System.out.println("cya!");
//
//	    }
//
//
//
//	}
//
//

	    	
	    	
	    	
}


