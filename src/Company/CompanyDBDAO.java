package Company;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Exception.CompanyException;
import Main.ConnectionPool;
import Main.Database;

/**

 * this class is implements from CompanyDao  

 * @author Maytal & Maayan

 *

 */

public class CompanyDBDAO implements CompanyDao {

	
		private static Connection con;
		
		//this method can insert a company to the DB
		public void insertCompany(Company company) throws CompanyException {
			
			Connection con;
			
			// Open a connection from the connection pool class
			try {
				con = ConnectionPool.getInstance().getConnection();
			} catch (Exception e) {
				throw new CompanyException("The Connection is faild");
			}
			// Define the Execute query

			String sql = "INSERT INTO Company (ID, COMP_NAME, PASSWORD,EMAIL)  VALUES(?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement(sql);
				con = DriverManager.getConnection(Database.getDBUrl());
				pstmt.setLong(1, company.getId());
				pstmt.setString(2, company.getComp_Name());
				pstmt.setString(3, company.getPassword());
				pstmt.setString(4, company.getEmail());
				pstmt.executeUpdate();

				System.out.println("Company created" + company.toString());

			} catch (SQLException e) {
				System.out.println(e);
				throw new CompanyException("Company creation failed");
					
			}	finally {
				// finally block used to close resources
			
					try {
						if (pstmt != null) {
							ConnectionPool.getInstance().returnConnection(con);
						}
					} catch (Exception e) {
						throw new CompanyException("The close connection action faild");
					}
					try {
						if (con != null) {
							ConnectionPool.getInstance().returnConnection(con);
						}
					} catch (Exception e) {
						throw new CompanyException("The close connection action faild");
					}}
		}

		//method that can remove a company from the DB
		@Override
		public void removeCompany(Company company) throws CompanyException {
			
			Connection con;
			
			// Open a connection from the connection pool class
			try {
				con = ConnectionPool.getInstance().getConnection();
			} catch (Exception e) {
				throw new CompanyException("The Connection is faild");
			}
			// Define the Execute query
			String remove = "DELETE FROM Company WHERE id=?";
			PreparedStatement pstmt = null;
					

			try  {
				pstmt = con.prepareStatement(remove);	
				con.setAutoCommit(false);
				pstmt.setLong(1, company.getId());
				pstmt.executeUpdate();
				con.commit();
				
				System.out.println("the company " + company.getComp_Name()+ " " +company.getId()+ " was removed");

			} catch (SQLException e) {

				try {
					con.rollback();
				} catch (SQLException e1) {

					throw new CompanyException("Database error");
				}

				throw new CompanyException("failed to remove company");
			} finally {// finally block used to close resources
				try {
					if (pstmt != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
				try {
					if (con != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
		}}

		//method that can update a company from the DB
		public void updateCompany(Company company) throws CompanyException {

			Connection con;
			
			// Open a connection from the connection pool class
			try {
				con = ConnectionPool.getInstance().getConnection();
			} catch (Exception e) {
				throw new CompanyException("The Connection is faild");
			}
			// Define the Execute query
			String sql = "UPDATE Company " + " SET comp_name='" + company.getComp_Name() + "', password='" + company.getPassword()+
					"', email='" + company.getEmail() + "' WHERE ID=" + company.getId();
			
			PreparedStatement pstmt = null;
			

			try (Statement stm = con.createStatement()) {
				pstmt = con.prepareStatement(sql);
				con = DriverManager.getConnection(Database.getDBUrl());	
				stm.executeUpdate(sql);
				
				System.out.println("the company " + company.getComp_Name()+ company.getId()+ " was updated");

			} catch (SQLException e) {

				throw new CompanyException("update Company failed");

			} finally {
			// finally block used to close resources
				try {
					if (pstmt != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
				try {
					if (con != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}

			}
		}

		//method that can retrieve a company from the DB by id
		public void getCompany(long id) throws CompanyException {
			
			Connection con;
			
			// Open a connection from the connection pool class
			try {
				con = ConnectionPool.getInstance().getConnection();
			} catch (Exception e) {
				throw new CompanyException("The Connection is faild");
			}
			// Define the Execute query
			String sql = "SELECT * FROM Company WHERE ID=" + id;
			PreparedStatement pstmt = null;
			
		
		
			Company company= new Company();

			try (Statement stm = con.createStatement()) {
				pstmt = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery(sql);
				rs.next();

				company.setId(rs.getLong(1));
				company.setComp_Name(rs.getString(2));
				company.setPassword(rs.getString(3));
				company.setEmail(rs.getString(4));
				System.out.println(company);
			}
			
			catch (SQLException e) {

				throw new CompanyException("unable to get company data");

			} finally {// finally block used to close resources
				try {
					if (pstmt != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
				try {
					if (con != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
			}
		}

		//method that print all company's list
		@SuppressWarnings("finally")
		public Collection<Company> getAllCompanys() throws CompanyException {
				
				Connection con;
				
				// Open a connection from the connection pool class
				try {
					con = ConnectionPool.getInstance().getConnection();
				} catch (Exception e) {
					throw new CompanyException("The Connection is faild");
				}
				// Define the Execute query
				String sql = "SELECT * FROM Company";
				PreparedStatement pstmt = null;
			
				List <Company> companyList = new ArrayList<>();
				
				try {
					pstmt = con.prepareStatement(sql);
					ResultSet resultSet = pstmt.executeQuery();
					while (resultSet.next()) {
						Company company = extractCompanyFromResultSet1(resultSet);
						companyList.add(company);
					}
				} catch (SQLException e) {
					System.out.println(e);
					throw new Exception("cannot get Product data");
				} finally {// finally block used to close resources
					try {
						if (pstmt != null) {
							ConnectionPool.getInstance().returnConnection(con);
						}
					} catch (Exception e) {
						throw new CompanyException("The close connection action faild");
					}
					try {
						if (con != null) {
							ConnectionPool.getInstance().returnConnection(con);
						}
					} catch (Exception e) {
						throw new CompanyException("The close connection action faild");
					}
				return companyList;
			}
			}
		
		

		@SuppressWarnings("finally")
		@Override
		public boolean ifCompanyNameExists(String name) throws CompanyException {
			Connection con;
			
			// Open a connection from the connection pool class
			try {
				con = ConnectionPool.getInstance().getConnection();
			} catch (Exception e) {
				throw new CompanyException("The Connection is faild");
			}
			// Define the Execute query
			String sql = "SELECT ID FROM Company WHERE COMP_NAME = ? ";
			PreparedStatement pstmt = null;
			
			
			try {	
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {

					System.out.println("The company is existed chose difrent company");;

				}
			} catch (SQLException e) {
			System.out.println(e);
			} finally {// finally block used to close resources
				try {
					if (pstmt != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
				try {
					if (con != null) {
						ConnectionPool.getInstance().returnConnection(con);
					}
				} catch (Exception e) {
					throw new CompanyException("The close connection action faild");
				}
		
			return false;

			}
		}
	
		public Company extractCompanyFromResultSet1(ResultSet result) throws Exception {
			Company company=new Company();
			company.setId(result.getLong("ID"));
			company.setComp_Name(result.getString("COMP_NAME"));
			company.setPassword(result.getString("PASSWORD"));
			company.setEmail(result.getString("EMAIL"));
			return company;
		}	

		
		}


