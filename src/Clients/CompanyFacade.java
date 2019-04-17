package Clients;

import java.awt.Window.Type;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Company.Company;
import Company.CompanyDBDAO;
import Company.Company_CouponDBDao;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponDao;
import Coupon.CouponType;
import Customer.Customer;
import Customer.Customer_CouponDBDao;
import Main.Utils;


public class CompanyFacade implements Client {

	private ClientType clientType = ClientType.COMPANY;
	private CouponDBDAO coupCompanyDao = new CouponDBDAO();
	private CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	private Company_CouponDBDao company_CouponDBDao = new Company_CouponDBDao();
	private Customer_CouponDBDao cus_couCompany = new Customer_CouponDBDao();
	private CouponDBDAO couponDBDao = new CouponDBDAO();
	private LocalDate now = LocalDate.now();
	private Customer_CouponDBDao customer_CouponDBDao= new Customer_CouponDBDao();
	private Company company= new Company();

	// full cTor for the companyFacade
	public CompanyFacade(Company C) {
		this.company = C;
	}

	// empty cTor for companyFacade
	public CompanyFacade() {
	}

	//this method insert values to coupon table and company_coupon table
	public void insertCoupon(Coupon coupon, Company company) throws Exception {

		try {
			if (coupon.getAmount() < 1) {
				throw new Exception("Company failed to add coupon - wrong amount: 0, couponId: " + coupon.getID());
			}

			LocalDate date = Utils.convertToLocalDateViaMilisecond((Date) coupon.getEnd_date());

			if (date.isBefore(now)) {
				throw new Exception("Company failed to add coupon - the end date already passed. " + coupon.getID()
				+ "," + coupon.getEnd_date());
			}
			
			boolean bool = coupCompanyDao.ifCouponNameExists(coupon);
			
			if (bool==false) {
				
				coupCompanyDao.insertCoupon(coupon);
				long max = company_CouponDBDao.getMaxCouponId();
				coupon.setID(max);
				company_CouponDBDao.insertCompany_Coupon(company, coupon);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());

				throw new Exception("Company failed to add coupon. couponId: " + coupon.getID());
			}
		}
	
	public void removeCoupons(Coupon fofo) throws Exception {
		Coupon coupon = new Coupon();
		Coupon coco = new Coupon();
		coupon = fofo;
		coco =couponDBDao.whatCouponid(fofo);
		long id = coco.getID();
		coupon.setID(id);
		System.out.println(coupon);
		company_CouponDBDao.removeCoupons(coupon);
		customer_CouponDBDao.removebyCouponCustomer(coupon);
		
	}

	public void updateCoupon(Coupon titi , Date end_date , double price) throws Exception {
		Coupon coupon = new Coupon();
		Coupon coco = new Coupon();
		coupon = titi;

		coco =couponDBDao.whatCouponid(titi);
		long id = coco.getID();
		coupon.setID(id);
		coupon.setEnd_date(end_date);
		coupon.setPrice(price);

		coupCompanyDao.updateCoupon(coupon);
		System.out.println("the coupon " + coupon.getTitle() + " was updated");
	}

	// this method return company information
	public void  getDetails (Company company)
	{
		System.out.println(company);
	}

	public List<Coupon> getAllCompanyCoupon(Company company) throws Exception {
		
		long compId= company.getId();
				
		List<Long> companyCouponId = company_CouponDBDao.getCouponsByCompanyId(compId);

		List<Coupon> nameCoupons = new ArrayList<Coupon>();

		for (Long id : companyCouponId) {

			nameCoupons.add(couponDBDao.getCoupon(id));

		}
		return nameCoupons;
		
	}

	public List<Coupon> getCouponbyType(Company company, CouponType type) throws Exception{
	
	List<Coupon> coupons = getAllCompanyCoupon(company);
	List<Coupon> couponByType = new ArrayList<Coupon>();
	try {
	for (Coupon coupon : coupons) {
		
		if (coupon.getType().equals(type)) {
			
			couponByType.add(coupon);
		}}}
	
	catch (Exception e) {
		System.out.println(e);
	}
	
	return couponByType;
	}
	
	public List<Coupon> getCouponbyprice(Company company, double price) throws Exception{
	
		List<Coupon> coupons = getAllCompanyCoupon(company);
		List<Coupon> couponByPrice = new ArrayList<Coupon>();
		for (Coupon coupon : coupons) {

			if (coupon.getPrice() <=(price)) {

				couponByPrice.add(coupon);
			}
		}
		return couponByPrice;
		}
	
	public List<Coupon> getCouponbyDate(Company company, Date date) throws Exception{
		
		List<Coupon> coupons = getAllCompanyCoupon(company);
		List<Coupon> couponByDate = new ArrayList<Coupon>();
		try {
		for (Coupon coupon : coupons) {
			
			if (coupon.getEnd_date().equals(date) || coupon.getEnd_date().before(date)) {
					couponByDate.add(coupon);
				}
			}}
		catch (Exception e) {
		System.out.println(e);
		}
		
		return couponByDate;
		}

	@Override
	public Client login(String user, String password, ClientType clienttype) {
		return null;
	
		
	}
	}

