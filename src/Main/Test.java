package Main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// פתיחה של ג'רבי- קונקשיין
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		Connection con = DriverManager.getConnection(Database.getDBUrl());

//		CouponSystem.getInstance().getInstance();

//		Tables.CreateAllTables();

//		UserTest.adminTestStart();
//		UserTest.companyTestStart();
		//		UserTest.customerTest();
		
//		UserTest.adminTestUpdates();
//		usersTest.companyTestUpdates();

//		usersTest.companyTestEnd();
//		usersTest.adminTestRemove();

//		CouponSystem.getInstance().shutdown();
		
//		Tables.DropAllTables();

	
	
	}

}
