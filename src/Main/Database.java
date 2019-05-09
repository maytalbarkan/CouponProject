package Main;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


	public class Database {
		private static String DBUrl = "jdbc:derby://localhost:5555/sample;create=true";
		private static String DriverData = "org.apache.derby.jdbc.ClientDriver";
		private static Connection connection;

		
		public static String getDBUrl() {
			return DBUrl;
		}

		public static String getDriverData() {
			return DriverData;
		}


		public static void createCompanyTable() throws Exception {
//create company table
			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table Company (" + "ID bigint not null primary key, " + "COMP_NAME varchar(50) not null, "
					+ "PASSWORD varchar(50) not null, " + "EMAIL varchar(50) not null)";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Company table has been created");

			} catch (SQLException e) {
				System.out.println(e);
				throw new Exception("unable to create Company table");
			} finally {
				connection.close();
			}

		}

		public static void createCustomerTable() throws Exception {
			//create customer table
			
			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table Customer (" + "ID bigint not null primary key generated always as identity(start with 1, increment by 1),"
					+ "CUSTNAME varchar(50) not null, "
					+ "PASSWORD varchar(50) not null)";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Customer table has been created");

			} catch (SQLException e) {
				System.out.println(e);
				throw new Exception("unable to create Customer table");
			} finally {
				connection.close();
			}

		}

		public static void createCouponTable() throws Exception {
//crate coupon table
			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table Coupon (" 
			+ "ID bigint not null primary key generated always as identity(start with 1, increment by 1),"
			+ "TITLE varchar(50) not null,"
			+ "START_DATE date not null, " 
			+ "END_DATE date not null, " 
			+ "AMOUNT integer not null, "
			+ "TYPE varchar(50) not null, " 
			+ "MESSAGE varchar(50) not null, " 
			+ " PRICE float not null, "
			+ "IMAGE varchar(200) not null)";
			
			
			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Coupon table has been created");

			} catch (SQLException e) {
				System.out.println(e);
				throw new Exception("unable to create Coupon table");
			} finally {
				connection.close();
			}

		}
		
		public static void createExpiredCouponTable() throws Exception {
//crate coupon table
			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table ExpiredCoupon (" 
			+ "ID bigint not null primary key generated always as identity(start with 1, increment by 1),"
			+ "TITLE varchar(50) not null,"
			+ "START_DATE date not null, " 
			+ "END_DATE date not null, " 
			+ "AMOUNT integer not null, "
			+ "TYPE varchar(50) not null, " 
			+ "MESSAGE varchar(50) not null, " 
			+ " PRICE float not null, "
			+ "IMAGE varchar(200) not null)";
			
			
			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Expired Coupon table has been created");

			} catch (SQLException e) {
				System.out.println(e);
				throw new Exception("unable to create Expired Coupon table");
			} finally {
				connection.close();
			}

		}

		public static void createCustomer_CouponTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table Customer_Coupon (" + "Customer_ID bigint, " + "Coupon_ID bigint, "
					+ "primary key (Customer_ID, Coupon_ID))";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Customer_Coupon table has been created");

			} catch (SQLException e) {
				throw new Exception("unable to create Customer_Coupon table");
			} finally {
				connection.close();
			}

		}

		public static void createCompany_CouponTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "create table Company_Coupon (" + "Company_ID bigint, " + "Coupon_ID bigint, "
					+ "primary key (Company_ID, Coupon_ID))";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Company_Coupon table has been created");

			} catch (SQLException e) {
				throw new Exception("unable to create Company_Coupon table");
			} finally {
				connection.close();
			}
		}
		

		public static void dropCompanyTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table Company";
			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Company Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop Company Table");
			} finally {
				connection.close();
			}
		}

		public static void dropCustomerTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table Customer";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Customer Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop Customer Table");
			} finally {
				connection.close();
			}
		}

		public static void dropCouponTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table Coupon";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Coupon Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop Coupon Table");
			} finally {
				connection.close();
			}
		}

		public static void dropCustomer_CouponTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table Customer_Coupon";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Customer_Coupon Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop Customer_Coupon Table");
			} finally {
				connection.close();
			}
		}

		public static void dropCompany_CouponTable() throws Exception {

			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table Company_Coupon";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("Company_Coupon Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop Company_Coupon Table");
			} finally {
				connection.close();
			}
		}
		
		public static void  dropExpiredCouponTable() throws Exception{
			connection = DriverManager.getConnection(Database.getDBUrl());

			String sql = "drop table ExpiredCoupon";

			try (Statement statement = connection.createStatement()) {

				statement.executeUpdate(sql);

				System.out.println("ExpiredCoupon Table dropped successfully");

			} catch (SQLException e) {
				throw new Exception("unable to drop ExpiredCoupon Table");
			} finally {
				connection.close();
		}
		
	
		}
	}

