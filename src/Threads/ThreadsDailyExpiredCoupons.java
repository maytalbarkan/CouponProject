package Threads;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Main.Utils;



public class ThreadsDailyExpiredCoupons implements Runnable {
	private boolean quit = false;
	private LocalDate now = LocalDate.now();
	private static int SECONDS = 10000*60*24*60;
	private CouponDBDAO couponDBDao = new CouponDBDAO();
	
	public void DailyExpiredCoupons() throws Exception {
		
		Set<Coupon> set = couponDBDao.getAllCoupons();

		for (Coupon c : set) {
			
			LocalDate date= Utils.convertToLocalDateViaMilisecond((Date) c.getEnd_date());

			try {
				
				if (date.isBefore(now)) {
					couponDBDao.insertExpiredCoupon(c);
					couponDBDao.removeCoupon(c);
				
				}
				
				
			}catch (Exception e) {
				System.out.println(e);			}
		}
		System.out.println("there is no more expired coupon");
	}

	public synchronized void run() {
		while (!quit) {
			try {
				this.DailyExpiredCoupons();
				Thread.sleep(SECONDS);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void stopTask() {
		quit = true;
		System.out.println("auto task stop");
	}
}