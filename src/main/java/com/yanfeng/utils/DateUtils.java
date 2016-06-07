package com.yanfeng.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtils {

	/**
	 * 获取当天0时时间（eg: 2015-09-01 00:00:00）
	 * 
	 * @return
	 */
	public static Date getStartTimeOfToday() {
		return getStartTime(new Date());
	}

	/**
	 * 获取指定日期的0时时间（eg: 2015-09-01 00:00:00）
	 * 
	 * @return
	 */
	public static Date getStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * 判断日期时间格式是否合法
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static boolean isDateFormatLegal(String dateStr, String format){
		if(StringUtils.isBlank(dateStr) || StringUtils.isBlank(format)){
			return false;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			simpleDateFormat.parse(dateStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 获取指定日期的0时时间（eg: 2015-09-01 00:00:00）
	 * 
	 * @return
	 */
	public static Date getStartTimeOfNextDay() {
		return getStartTimeOfGivenDay(1);
	}
	
	/**
	 * 获取指定日期的0时时间（eg: 2015-09-01 00:00:00）
	 * 
	 * @return
	 */
	public static Date getStartTimeOfGivenDay(int daysAfterToday) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, daysAfterToday);
		return getStartTime(cal.getTime());
	}

	/**
	 * 获取指定日期的0时时间（eg: 2015-09-01 00:00:00）
	 * 
	 * @return
	 */
	public static Date getStartTimeOfGivenDay(Date date, int daysAfter) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, daysAfter);
		return getStartTime(cal.getTime());
	}
	
	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static long getDateDiff(Date startTime, Date endTime) {
		if (startTime == null || endTime == null) {
			throw new IllegalArgumentException("startTime/stopTime不能为空");
		}
		startTime = getStartTime(startTime);
		long start = startTime.getTime();
		long stop = endTime.getTime();
		long dayDuration = 24 * 60 * 60 * 1000;
		return (stop - start) / dayDuration;
	}

	public static String formatDate(Date date, String formatter) {
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat(formatter);
			return format.format(date);
		}
		return null;
	}


	public static Date parse(String date) throws ParseException {
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				return format.parse(date);
		}
		return null;
	}
	
	public static Date addDay(Date date, int day)   {
		if(date == null){
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.DATE,  day);
		return cal.getTime();
	}

	public static Date getZeroDate(Date date) {
		if (date == null) {
			return date;
		}
		Date zero = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		try {
			zero = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return zero;
	}
	
	public static String format(Date date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	public static Date getYesterday(Date date) {
		if (date == null) {
			return date;
		}
		Date yesterday = null;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.DATE, -1);
		yesterday = cal.getTime();
		return yesterday;
	}
	
	public static Date getYesterdayZero(Date date) {
		if (date == null) {
			return date;
		}
		Date yesterday = null;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.DATE, -1);
		yesterday = cal.getTime();
		return getZeroDate(yesterday);
	}
	
	public static Date AddYears(Date date, int count) {
		if (date == null) {
			return date;
		}
		Date nextYear = null;
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(Calendar.YEAR, count);
		cal.add(Calendar.DATE, -1);
		nextYear = cal.getTime();
		return nextYear;
	}


	public static String getMonth(Date date){
		Assert.notNull(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(date);
		
	}
	public static void main(String[] args){
//			Calendar cal = Calendar.getInstance();
//			cal.add(Calendar.YEAR, 1);
//			cal.add(Calendar.DATE, -1);
//			Date date = cal.getTime();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			final String day = sdf.format(date);
//			System.out.print(day);

		    Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
		    cal.add(Calendar.MONTH, -5);
			Date date = cal.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			final String day = sdf.format(date);
			System.out.print(day);
    }
	
	public static String getGMTDate(){
	    Date d=new Date();
        DateFormat format=new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z",Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(d);
	}

}
