package Customer;

import java.util.List;

import Coupon.Coupon;
import Customer.Customer;

public interface Customer_CouponDao {

	
	void insertCustomer_Coupon(long cutomerid, long couponid) throws Exception ;

	public void removebyCustomerCoupon(Customer customer) throws Exception;

	public void removebyCouponCustomer(Coupon coupon) throws Exception;

	public List<Long> getCouponsByCustomerId(long customerId) throws Exception;


}
