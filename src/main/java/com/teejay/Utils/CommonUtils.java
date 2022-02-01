package com.teejay.Utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

	/**
	 * @return String currentDate
	 */
	public static String getCurrentDate() {
		Date current = new Date();
		Format f = new SimpleDateFormat("MM/dd/yy");
		String currentDate = f.format(current);
		return currentDate;
	}
	
	/**
	 * @return String currentDate
	 */
	public static String getCurrentDateTime() {
		Date current = new Date();
		Format f = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		String currentDate = f.format(current);
		return currentDate;
	}
	
	/**
	 * @param startDate
	 * @param EndDate
	 * @return
	 * @throws ParseException
	 */
	public static int getDateDiff(String startDate, String EndDate) throws ParseException {
		Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(startDate);  
		Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(EndDate);  
		long difference_In_Time = date2.getTime() - date1.getTime();
		long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time);
		return (int) difference_In_Days;
		
	}
}
