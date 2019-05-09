package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Company.Company_CouponDBDao;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Exception.CustomrException;
import Main.ConnectionPool;

public class Customer_CouponDBDao implements Customer_CouponDao {

	private CustomerDBDAO customerDBDAO=new CustomerDBDAO();
	private CouponDBDAO couponDBDAO=new CouponDBDAO();
	private Company_CouponDBDao company_CouponDBDao=new Company_CouponDBDao();
	
	private static Connection con;
	@Override
	public void insertCustomer_Coupon(long cutomerid, long couponid) throws CustomrException {

		Connection con;
		
		// Open a connection from the connection pool class
		try {
			con = ConnectionPool.getInstance().getConnection();
		} catch (Exception e) {
			throw new CustomrException("The Connection is faild");
		}
		// Define the Execute query
		String sql = "insert into Customer_Coupon (Customer_ID, Coupon_ID) values (?,?)";
		PreparedStatement pstmt = null;


		try  {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, cutomerid);
			pstmt.setLong(2, couponid);
			
			pstmt.executeUpdate();

			System.out.println("Customer_Coupon added.  CustomerId: " + cutomerid + " couponId: " + couponid);
		
		}catch (SQLException e) {
			throw new CustomrException("DB error -  Customer_Coupon addition failed. companyId: " + cutomerid + " couponId: " + couponid);
		}catch (Exception e) {
			throw new CustomrException(" Customer_Coupon addition failed.  CustomerId: " +cutomerid + " couponId: " + couponid);
		
		}finally {// finally block used to close resources
				try {
					if (pstmt != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CustomrException("The close connection action faild");
				}
				try {
					if (con != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CustomrException("The close connection action faild");
				}
		}
	}
	
	public void removebyCustomerCoupon(Customer customer) throws CustomrException {

		Connection con;
		
		// Open a connection from the connection pool class
		try {
			con = ConnectionPool.getInstance().getConnection();
		} catch (Exception e) {
			throw new CustomrException("The Connection is faild");
		}
		// Define the Execute query
		String remove = "DELETE FROM Customer_Coupon WHERE customer_id=?";
		PreparedStatement pstmt = null;
		

		
		try (PreparedStatement pstm1 = con.prepareStatement(remove);) {
			pstmt = con.prepareStatement(remove);
			con.setAutoCommit(false);
			pstm1.setLong(1,customer.getId());
			pstm1.executeUpdate();
			con.commit();

			System.out.println("the coupon " +"(" +customer.getId()+ ")" +  " was removed");

		} catch (SQLException e) {

			try {
				con.rollback();
			} catch (SQLException e1) {

				throw new CustomrException("Database error");
			}

			throw new CustomrException("failed to remove coupon");
		} finally {// finally block used to close resources
			try {
				if (pstmt != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new CustomrException("The close connection action faild");
			}
			try {
				if (con != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new CustomrException("The close connection action faild");
			}}

	
	}
	
	public void removebyCouponCustomer(Coupon coupon) throws CustomrException {
		Connection con;
		
		// Open a connection from the connection pool class
		try {
			con = ConnectionPool.getInstance().getConnection();
		} catch (Exception e) {
			throw new CustomrException("The Connection is faild");
		}
		// Define the Execute query
		String remove = "DELETE FROM Customer_Coupon WHERE coupon_id=?";
		PreparedStatement pstmt = null;

		
		try (PreparedStatement pstm1 = con.prepareStatement(remove);) {
			pstmt = con.prepareStatement(remove);
			con.setAutoCommit(false);
			pstm1.setLong(1,coupon.getID());
			pstm1.executeUpdate();
			con.commit();

			System.out.println("the coupon" + coupon.getID() +  " was removed");

		} catch (SQLException e) {

			try {
				con.rollback();
			} catch (SQLException e1) {

				throw new CustomrException("Database error");
			}

			throw new CustomrException("failed to remove coupon");
		} finally {
			// finally block used to close resources
			try {
				if (pstmt != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new CustomrException("The close connection action faild");
			}
			try {
				if (con != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new CustomrException("The close connection action faild");
			}

		}
	
	}
	
	
	public List<Long> getCouponsByCustomerId(long customerId) throws Exception {

		Connection con;
		
		// Open a connection from the connection pool class
		try {
			con = ConnectionPool.getInstance().getConnection();
		} catch (Exception e) {
			throw new Exception("The Connection is faild");
		}
		// Define the Execute query
		Statement statement = con.createStatement();
		String sql = "select * from Customer_Coupon where customer_Id = " + customerId;
		ResultSet rs = statement.executeQuery(sql);
		
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql);
		
		List<Long> listCouponId = new ArrayList<Long>();
		
		try  {
			while (rs.next()) {
				long coupon_Id = rs.getLong(2);
				listCouponId.add(coupon_Id);
			}
			
			return listCouponId;

		} catch (SQLException e) {

			throw new Exception();

		} finally {// finally block used to close resources
			try {
				if (pstmt != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new Exception("The close connection action faild");
			}
			try {
				if (con != null) {
					ConnectionPool.getInstance().returnConnection(con);
				}
			} catch (Exception e) {
				throw new Exception("The close connection action faild");
			}


	}
	}
	
	
	}

	
			

