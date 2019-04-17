package Company;

import java.util.List;
import java.util.Set;

import Company.Company;
import Coupon.Coupon;

public interface Company_CouponDao {

	void insertCompany_Coupon(Company company, Coupon coupon) throws Exception;

	void removeCompany_Coupon(Company company) throws Exception;
	
	void removeCoupons(Coupon coupon) throws Exception;
	
	public long getMaxCouponId() throws Exception;
	
	public List<Long>  getCouponsByCompanyId(long compid) throws Exception;



}
