package Main;

import java.sql.Connection;

import Clients.AdminFacade;
import Clients.Client;
import Clients.ClientType;
import Clients.CompanyFacade;
import Clients.CustomerFacade;
import Company.CompanyDBDAO;
import Customer.CustomerDBDAO;
import Exception.CouponException;
import Threads.ThreadsDailyExpiredCoupons;

public class CouponSystem {
	
	private static CouponSystem instance;
	private static ThreadsDailyExpiredCoupons DailyTask;
	private	static Thread thread;

	
	private CouponSystem(ThreadsDailyExpiredCoupons dailyTask, Thread thread, Connection connection) {
		DailyTask = new ThreadsDailyExpiredCoupons();
		thread = new Thread(DailyTask);
		thread.start();
	}

	public static CouponSystem getInstance() throws Exception {
		if (instance == null) {
			try {
				instance = new CouponSystem(DailyTask, thread, null);
				System.out.println("CouponSystem start");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

		}

		return instance;
	}

	public static Client login(String name, String password, ClientType clientType) throws Exception {

		Client client =  null;

		switch (clientType) {

		case ADMIN:
			if(name == "admin"&& password=="1234") {
			client = new AdminFacade();
			}
			break;

		case COMPANY:
			
			if (clientType == ClientType.COMPANY) {
				CompanyDBDAO localcompanydbdao = new CompanyDBDAO();
				boolean loginSuccess = localcompanydbdao.login(name, password);
				if(loginSuccess) {
			client = new CompanyFacade();
				}}
			break;

		case CUSTOMER:
		
			if (clientType == ClientType.CUSTOMER) {
				
				CustomerDBDAO customerDBDAO = new CustomerDBDAO();
				boolean loginSuccess = customerDBDAO.login(name, password);
				if(loginSuccess) {
				client = new CustomerFacade();
				}}
				break;

		default:
			throw new CouponException("login failed");
			
		}
	
//		client = client.login(name, password, clientType);
//		System.out.println(name);
//		System.out.println(password);
//		System.out.println(clientType);
//	System.out.println(111111);
//		System.out.println(client);
		
		if(client==null) {
			
			throw new CouponException("Login failed! incorect password");
		}else {
			return client;
		}
	}
	
	
	public void shutdown() throws Exception
	{
	/*Shutdown system is a method that close all the connectionPool,
	*and stop the daily task (the expired coupon thread) 
	*/
		DailyTask.stopTask();

		try {
			ConnectionPool connectionPool = ConnectionPool.getInstance();

			try {
				connectionPool.closeAllConnections();

			} catch (Exception e) {
				throw new Exception("connection failed");
			}

		} catch (Exception e) {

			throw new Exception("shut down failed");
		}
	}	
}



