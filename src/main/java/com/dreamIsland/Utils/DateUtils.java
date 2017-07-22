package com.dreamIsland.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {

	/**
	 *
	 *获取当前星期几
	 *@param date
	 *@return 星期
	 */
	
	//方式一使用Calendar类
	public static String getCurrentWeek(Date date){
		String[] weekDays={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		//int[] weekOfDays = {7,1,2,3,4,5,6};
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		int w=calendar.get(Calendar.DAY_OF_WEEK)-1;
		if(w<0){
			w=0;
		}
		return weekDays[w];
	}
	

	//方式二，使用simpleDateFormat格式化日期
	public static String getWeekOfDay(Date date){
		SimpleDateFormat dateFormat=new SimpleDateFormat("EEEE");
		return dateFormat.format(date);
	}
	
	/**
	 *
	 *日期格式化成 yyyy-MM-dd HH:mm:ss这样的格式
	 *@param date
	 *@return string
	 */
	
	public static String getTime(Date date){
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return dateFormat.format(date);
	}
	
	/**
	 *
	 *日期格式化成 yyyy-MM-dd HH:mm:ss这样的格式
	 *@param date
	 *@return string
	 */
	//3.Date类型转化成String类型
	public static String dateToString(Date date){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}

	/**
	 *
	 *日期格式化成 yyyy-MM-dd HH:mm:ss这样的格式
	 *@param date
	 *@return string
	 */
	//4.String日期转化成Date类型
	public static Date stringToDate(String strDate) throws ParseException{
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 *
	 *日期格式化成 yyyy-MM-dd HH:mm:ss这样的格式
	 *@param date
	 *@return string
	 */
	//5.在当前时间基础上增加/减少小时
	public static String addHour(int hour){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return simpleDateFormat.format(calendar.getTime());
	}
	
	/**
	 *
	 *日期格式化成 yyyy-MM-dd HH:mm:ss这样的格式
	 *@param date
	 *@return string
	 */
	//6.在当前时间基础上增加/减小年
	public static String reduceYear(int year){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.YEAR, year);
		return simpleDateFormat.format(calendar.getTime());
	}
	
	/**
	 * 获取两个时间的时间差
	 * @param date1
	 * @param date2
	 * @return 秒数
	 */
	public static long diffTwoDays(Date date1,Date date2){
		try {
			long diff = date1.getTime() - date2.getTime();
	        if(diff<0){
	            diff = Math.abs(diff);
	        }
			long day = diff / (24 * 60 * 60 * 1000);
			long hour = (diff / (60 * 60 * 1000) - day * 24);
			long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
			if (hour < 0) {
				hour = 0;
			}
			if (min < 0) {
				min = 0;
			}
			if (s < 0) {
				s = 0;
			}
			if (day < 0) {
				day = 0;
			}
	
			long ret = day * 24 * 3600 + hour * 3600 + min * 60 + s;
	
			return ret;

		} catch (Exception ex) {
			return 0;
		}
	}
	
	/**
	 *
	 *比较两个时间，获取较早时间
	 *@param date
	 *@return string
	 */
	public static String  getEarlyTime(Date date1,Date date2){
		 SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     /*Long diff=	date1.getTime()-date2.getTime();
		 if(diff>0){
			 return simpleDateFormat.format(date2); 
		 }else{
			 return simpleDateFormat.format(date1); 
		 }*/
	  if(date1.before(date2)){
		  return simpleDateFormat.format(date1);
	  }else{
		  return simpleDateFormat.format(date2);
	  }
	}
	
	/**
	 *
	 *比较两个时间，获取较晚时间
	 *@param date
	 *@return string
	 */
	public static String  getLaterTime(Date date1,Date date2){
		 SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   /*  Long diff=	date1.getTime()-date2.getTime();
		 if(diff>0){
			 return simpleDateFormat.format(date1); 
		 }else{
			 return simpleDateFormat.format(date2); 
		 }
	  */
		 
		 if(date1.after(date2)){
			 return simpleDateFormat.format(date1);
		 }else{
			 return simpleDateFormat.format(date2);
		 }
	}
	
	
	/**
	 *
	 *是否是闰年
	 *@param date
	 *@return string
	 */
	public static boolean isLeapYear(Date date){
	    Calendar gc = Calendar.getInstance();
		gc.setTime(date);

		int year = gc.get(Calendar.YEAR);
	    boolean isYear=false;
	    if(year%4==0 && year%100!=0 || year%400==0){
	    	isYear=true;
	    }
			return isYear;
	}
	
	/**
	 *
	 *把当前日期格式化成天
	 *
	 *@param date
	 *@return string
	 */
	public static String getCurrentDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("dd");//设置日期格式
		return df.format(date);
	}
	/**
	 *
	 *获取当前小时数（24小时制）
	 *
	 *@param date
	 *@return string
	 */
	public static String getCurrentHour(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("HH");//设置日期格式
		return df.format(date);
	}  
	
	/**
	  * 获取当前小时数
	  *
	  * @param date 日期
	  * @return 返回小时
	  */
	 public static int getHour(Date date) {
	     Calendar c = Calendar.getInstance();
	     c.setTime(date);
	     return c.get(Calendar.HOUR_OF_DAY);
	 }

	/**
	 *
	 *给日期加上天数
	 *
	 *@param date,day
	 *@return date
	 */
    public static Date addDay(Date date,int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }
    
	public static void main(String[] args) {
		System.out.println(getHour(new Date()));
	}
	
}

