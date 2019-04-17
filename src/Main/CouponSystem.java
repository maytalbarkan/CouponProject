package Main;

import java.sql.Connection;
import java.sql.SQLException;

import Clients.AdminFacade;
import Clients.Client;
import Clients.ClientType;
import Clients.CompanyFacade;
import Clients.CustomerFacade;
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

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

		}

		return instance;
	}

	public static Client login(String name, String password, ClientType clientType) throws Exception {

		Client client = null;

		switch (clientType) {

		case ADMIN:
			client = new AdminFacade();
			break;

		case COMPANY:
			client = new CompanyFacade();
			break;

		case CUSTOMER:
			client = new CustomerFacade();
			break;

		default:
			throw new CouponException("login failed");
		}

		client = client.login(name, password, clientType);
		
		return null;
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



