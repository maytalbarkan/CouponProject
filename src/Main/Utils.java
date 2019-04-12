package Main;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Utils {

	public static Date getCurrentDate() {
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		return date;
	}

	public static Date getExpiredDate() {
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusMonths(1);
		Date date = java.sql.Date.valueOf(localDate);
		return date;
	}
	
	
	public static Date getExpiredDateNextDay() {
    	
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(1);
    	Date date = java.sql.Date.valueOf(localDate);
    	
    	return date;
    	}

	
	public static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
    }
}