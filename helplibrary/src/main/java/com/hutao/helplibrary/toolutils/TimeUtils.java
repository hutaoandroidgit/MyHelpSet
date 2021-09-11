package com.hutao.helplibrary.toolutils;

import android.annotation.SuppressLint;
import com.hutao.helplibrary.log.OsduiLog;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 负责相关时间功能转换处理
 * @author guoquan
 *
 */
public class TimeUtils {
	public static String stryyyy;
	public static String strMM;
	public static String strdd;
	public static String strday;
	public static String strhour;
	public static String strmin;
	public static String strsecond;
	private final static String TAG = "TimeUtils";
	public final static String SPLIT_BACK_SLANT = "/";
	public final static String SPLIT_BAR = "-";

	public static String  TimeToStrng( long nTime ){ 
		Date currentTime = new Date( nTime );
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;  
	} 
	
	public static String  TimeToStringYYMMDDHHMMSS( long nTime ){ 
		Date currentTime = new Date( nTime );
		SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = mFormatter.format(currentTime);
		return dateString;
	}

	public static String  TimeToStringYYMMDDHHMM( long nTime ){
		Date currentTime = new Date( nTime * 1000);
		SimpleDateFormat mFormatter = new SimpleDateFormat("yyyy/MM/dd      HH:mm");
		String dateString = mFormatter.format(currentTime);
		return dateString;
	}

	public static String  TimeToString( long nTime ){ 
		Date currentTime = new Date( nTime * 1000);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;  
	} 
	
	public static String  TimeToStrngYYYYMMDDHHMM( long nTime ){ 
		Date currentTime = new Date( nTime * 1000);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(currentTime);
		return dateString;  
	}
	
	public static String  TimeToStrngHHMM( long nTime ){ 
		Date currentTime = new Date( nTime * 1000);
		SimpleDateFormat formatter = new SimpleDateFormat("HH : mm");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+0"));
		String dateString = formatter.format(currentTime);
		return dateString;  
	}
	public static String  TimeToStrngHHMMSSYYYYMMDD( long nTime ){ 
		Date currentTime = new Date( nTime );
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss    yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;  
	}
	public static String  TimeToStringHHMMSS( long nTime ){
		Date currentTime = new Date( nTime );
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;  
	}
	
	public static String  TimeToStringYMDHMS( long nTime ){ 
		Date currentTime = new Date( nTime );
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dateString = formatter.format(currentTime);
		return dateString;  
	}

	public static String timeToStringHM(long time){
		Date currentTime = new Date(time);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String timeParse(long duration) {
		String time = "";

		long minute = duration / 60;
		long second = duration % 60;

		if (minute < 10) {
			time += "0";
		}
		time += minute + ":";

		if (second < 10) {
			time += "0";
		}
		time += second;

		return time;
	}
	public static String timeParsehms(long duration) {
		String time = "";
		long hour = duration / 3600;
		long minute = (duration % 3600) / 60;
		long second = (duration % 3600) % 60;
		if (hour < 10) {
			time += "0";
		}
		time += hour + ":";
		if (minute < 10) {
			time += "0";
		}
		time += minute + ":";

		if (second < 10) {
			time += "0";
		}
		time += second;
		return time;
	}

	public static long getNowTime()
	{
		Date currentTime = new Date();
		return currentTime.getTime() & 0xFFFFFFFFL;
	}
   
	
	public static String getNowTimeStr()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");       
		Date curDate = new Date(System.currentTimeMillis());//获取当前时间       
		String str = formatter.format(curDate);       
		return str;
	}
	

    //当前时间转化字符串
	public static String getTime2String(){
		Calendar calendar = Calendar.getInstance();
		String str = String.valueOf(calendar.get(Calendar.YEAR)+"-"+getString0add(calendar.get(Calendar.MONTH) + 1)+"-"+getString0add(calendar.get(Calendar.DAY_OF_MONTH))
				+"T24:00:00+08:00");
		return str;
	}
	
	private static String getString0add(byte bt) {
		// TODO Auto-generated method stub
		String str = bt+"";
		if(bt < 10){
			str = "0"+bt;
		}
		return str;
	}
	private static String getString0add(int bt) {
		// TODO Auto-generated method stub
		String str = bt+"";
		if(bt < 10){
			str = "0"+bt;
		}
		return str;
	}


	public static String TimeToDayString(long nTime) {
		// TODO Auto-generated method stub
		Date currentTime = new Date( nTime );
		SimpleDateFormat formatter = new SimpleDateFormat("HH : mm : ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	
	public static long getCurSystemTime()
	{
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		long curMilliSecond = date.getTime();
		OsduiLog.mtuiErrorLog("TimeUtils", "curMilliSecond" + curMilliSecond);
		
		return curMilliSecond;
	}
	

	@SuppressLint("SimpleDateFormat")
	public static String getCurDateTime() {
		long curTime = System.currentTimeMillis();
		Date currentDateTime = new Date( curTime );
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentDateTime);
		return dateString;
	}
	
	@SuppressLint("SimpleDateFormat")
	public static String getDateTime() {
		long curTime = System.currentTimeMillis();
		Date currentDateTime = new Date( curTime );
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentDateTime);
		return dateString;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		 Date currentTime = new Date();
		 OsduiLog.mtuiHintLog(TAG,  TimeToStrng(currentTime.getTime()) );

	}
	/**
	 * 自定义日志格式，规避format耗时较大
	 * @param split
	 * @return
	 */
	public static String TimeToString(String split)
	{
		 StringBuffer strBuf = new StringBuffer();
		 Calendar cal=Calendar.getInstance();//使用日历类  
		 
		 int year = cal.get(Calendar.YEAR);
		 combineStr(year,strBuf).append(split);
		 int month = cal.get(Calendar.MONTH)+1;
		 combineStr(month,strBuf).append(split);
		 int day = cal.get(Calendar.DAY_OF_MONTH);
		 combineStr(day,strBuf).append(" ");
		 int hour = cal.get(Calendar.HOUR_OF_DAY);
		 combineStr(hour,strBuf).append(":");
		 int minute = cal.get(Calendar.MINUTE);
		 combineStr(minute,strBuf).append(":");
		 int second = cal.get(Calendar.SECOND);
		 combineStr(second,strBuf).append(",");
		 int millisecond = cal.get(Calendar.MILLISECOND);
		 combineStr(millisecond,strBuf);
		 
		 return strBuf.toString();
	}
	private static StringBuffer combineStr(int value,StringBuffer strBuf)
	{
		 
		 if(value <10)
		 {
			 strBuf.append("0");
		 }
		 strBuf.append(value);
		 return strBuf;
	}
	
	/**
	 * 获取ISO8601:2000格式时间
	 * @return 2019-06-20T03:00:00+08:00
	 * @author kangdi
	 */
	public static String getDateFromISO8601(){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ" ,Locale.US);
		StringBuffer isoTimeBuf = new StringBuffer(sdf.format(new Date()));
		return isoTimeBuf.insert(22, ":").toString();
	}
	
	/**
	 * 获取ISO8601:2000格式当天的最后一刻时间
	 * @return 2019-06-20T23:59:59+08:00
	 */
	public static String getDayLastTimeFromISO8601(){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ" ,Locale.US);
		StringBuffer isoTimeBuf = new StringBuffer(sdf.format(new Date()));
		isoTimeBuf.insert(22, ":").replace(11, 19, "24:00:00");
		return isoTimeBuf.toString();
	}

	/**
	 * 是否是昨天
	 */
	public static boolean isYesterday(String dateStr, SimpleDateFormat sdf) {
		sdf.applyPattern("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date date2 = new Date(System.currentTimeMillis());
		date2.setHours(0);
		date2.setMinutes(0);
		date2.setSeconds(0);
		int tmp = 86400000;

		long day1 = date.getTime() / tmp;
		long day2 = date2.getTime() / tmp;

		if (day2-day1 == 1) {
			return true;
		} else {
			return false;
		}
	}
}