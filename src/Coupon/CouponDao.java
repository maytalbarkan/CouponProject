package Coupon;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import Main.Database;

public interface CouponDao {


	void insertCoupon(Coupon coupon) throws Exception;
	
	void removeCoupon(Coupon coupon) throws Exception;
	
	void updateCoupon(Coupon coupon) throws Exception;

	public boolean ifCouponNameExists(Coupon coupon) throws Exception;
	
	Coupon whatCouponid(Coupon coupon) throws Exception ;
	
	Coupon getCoupon(long id) throws Exception;
	
	Set<Coupon> getAllCoupons() throws Exception;

	void insertExpiredCoupon(Coupon coupon) throws Exception;

	ExpiredCoupon getexpiredCoupon(long id) throws Exception;

	public Set<ExpiredCoupon> getAllExpiredCoupon() throws Exception;




		}


	
	
